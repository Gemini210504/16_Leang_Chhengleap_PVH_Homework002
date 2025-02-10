import java.util.Random;

public class CheckingAccount implements Account{
    private static final Random random = new Random();
    private int accountNumber;
    private String userName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private double balance;


    public CheckingAccount(String userName, String dateOfBirth, String gender, String phoneNumber) {
        this.accountNumber= random.nextInt(1000000000);
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.balance = 0;
    }
    public double getBalance() {
        return balance;
    }


    public int getAccountNumber() {
        return accountNumber;
    }
    @Override
    public Account deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("                 Checking Account                       ");
            System.out.println("Received        :                         $ "+amount);
            System.out.println("Total Amount    :                         $ "+balance);
            System.out.println("============================================================");
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Deposit amount must be positive!");
        }
        return null;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("                 Checking Account                       ");
            System.out.println("Received        :                         $ "+amount);
            System.out.println("Total balance    :                         $ "+balance);
            System.out.println("=============================================================");
            System.out.println("Withdraw successful!");
        } else {
            System.out.println("No balance in checking account or invalid amount.");
        }
    }

    @Override
    public void transfer(double amount, Account targetAccount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            targetAccount.deposit(amount);
            System.out.println("Transferred $" + amount + " from your Checking account to the target account.");
        } else {
            System.out.println("No balance in checking account or invalid transfer amount.");
        }
    }

    @Override
    public void displayAccount() {
        System.out.println("======= Checking Account Information =======");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Username: " + userName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("============================================");
    }

}
