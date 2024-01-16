import java.util.Date;

class AccountStatus {
    private long accountId;
    private Date date;
    private int amount;
    private int balance;

    public AccountStatus(long accountId, int amount, int balance) {
        this.accountId = accountId;
        this.date = new Date();
        this.amount = amount;
        this.balance = balance;
    }

    public Date getDate() {
        return this.date;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getBalance() {
        return this.balance;
    }
}