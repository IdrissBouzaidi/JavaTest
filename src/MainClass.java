public class MainClass {
    public static void main(String[] args) {
        long accountId = 10;
        AccountService accountService = new AccountServiceImpl(accountId);
        accountService.deposit(1000);
        accountService.withdraw(100);
        accountService.deposit(20);
        accountService.withdraw(10);
        accountService.deposit(200000);
        accountService.deposit(1560000);
        accountService.printStatement();
    }
}