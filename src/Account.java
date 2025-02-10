public interface Account {
    Account deposit(double amount);
    void withdraw (double amount);
    void transfer(double amount, Account targetAccount);
    void displayAccount();
}
