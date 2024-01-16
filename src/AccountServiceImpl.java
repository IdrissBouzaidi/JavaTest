import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    //Une clé unique pour chaque compte
    private long accountId;
    //Pour chaque ajout/retirage, au lieu de modifier sur la valeur totale de la somme d'argent, j'ai choisit de sauvegarder cette somme, tout en jouter à chaque fois une nouvelle état.
    private List<AccountStatus> allStatus;

    public AccountServiceImpl(Long accountId) {
        this.accountId = accountId;
        this.allStatus = new ArrayList<>();//Ici, on peut la considérer come étant vide, mais dans un cas réel, ce champ va être récupéré à partir de l'id (accoundId).
    }

    @Override
    public void deposit(int amount) {
        int balance;
        if(this.allStatus.size() == 0)
            balance = amount;//Si c'est la première fois où on dépose l'argent, alors es deux valeurs vont être égaux (ce qu'on ajoute égale  notre somme).
        else //Sinon, notre somme va égale à la dernière somme, tout en ajoutant ce nouveau ajout.
            balance = allStatus.get(allStatus.size()-1).getBalance() + amount;
        AccountStatus accountStatus = new AccountStatus(accountId, amount, balance);
        this.allStatus.add(accountStatus);
    }

    @Override
    public void withdraw(int amount) {
        if(this.allStatus.size() == 0) { //On ne peut pas retirer d'argent si on n'a pas encore déposé d'argent.
            System.out.println("Vous n'avez pas d'argent pour pouvoir le retirer");
            return;
        }
        int balance = allStatus.get(allStatus.size()-1).getBalance() - amount;
        if(balance < 0) { //On ne peut pas retirer une somme qui est plus grande que ce qu'on possède dans notre compte.
            System.out.println("Vous n'avez pas assez d'argent pour pouvoir retirer cette somme. La somme qui vous reste est : " + (balance + amount));
            return;
        }
        AccountStatus accountStatus = new AccountStatus(accountId, - amount, balance);
        this.allStatus.add(accountStatus);
    }

    @Override
    public void printStatement() {
        System.out.println("Date       || Amount  || Balance");
        for(AccountStatus status : this.allStatus) {
            String dateString = Help.convertDateToString(status.getDate());
            //J'ai ajouté cette méthode parce qu'il faut régler le problème de la longueur des numéros (il faut que les numérosoccupent tous un même longueur opur que les `||` voient tous verticales.
            String amountString = Help.convertToStringAnfRespoctSpaces(status.getAmount(), 7);
            String balanceString = Help.convertToStringAnfRespoctSpaces(status.getBalance(), 7);
            System.out.println(dateString + " || " + amountString + " || " + balanceString);
        }
    }
}