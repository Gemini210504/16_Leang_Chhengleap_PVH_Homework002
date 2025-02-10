import java.util.Random;

public class CheckingAccount implements Account{
    private static final Random random = new Random();
    private int accountNumber;
    private String userName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private double balance;

    String reset = "\u001B[0m";
    String red = "\u001B[31m";
    String blue = "\u001B[34m";
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
    SavingAccount savingAccount;
    @Override
    public Account deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\n                 Checking Account                       ");
            System.out.println(blue+"Received            :                         $ "+amount+""+reset);
            System.out.println(blue+"Total Amount        :                         $ "+balance+""+reset);

            System.out.println(blue+"\n>>> Deposit successful! <<<\n"+reset);


        } else {
            System.out.println(red+"Deposit amount must be positive!"+reset);
        }
        return null;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(blue+"              Withdraw from Checking Account                       "+reset);
            System.out.println(blue+"Received            :                         $ "+amount+""+reset);
            System.out.println(blue+"Total balance       :                         $ "+balance+""+reset);

            System.out.println(blue+"\n >>> Withdraw successful! <<<\n"+reset);


        } else {
            System.out.println(red+"No balance in checking account or invalid amount."+reset);
        }
    }

    @Override
    public void transfer(double amount, Account targetAccount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            targetAccount.deposit(amount);
            System.out.println("\n                   Transferred Checking                         ");
            System.out.println(blue+"Transferred         :                       $"+amount+""+reset);
            System.out.println(blue+"From                : Checking Account with ID    : "+getAccountNumber()+""+reset);
            System.out.println(blue+"To                  :   Saving Account with ID    : "+((SavingAccount) targetAccount).getAccountNumber()+""+reset);

        } else {
            System.out.println(red+"No balance in checking account or invalid transfer amount."+reset);
        }
    }

    @Override
    public void displayAccount() {
        System.out.println("======= Checking Account Information =======");
        System.out.println(blue+"Account Type  : Checking Account"+reset);
        System.out.println(blue+"Account Number: " + accountNumber+""+reset);
        System.out.println(blue+"Username: " + userName+""+reset);
        System.out.println(blue+"Date of Birth: " + dateOfBirth+""+reset);
        System.out.println(blue+"Gender: " + gender+""+reset);
        System.out.println(blue+"Phone Number: " + phoneNumber+""+reset);
        System.out.println(blue+"Balance: $" + balance+""+reset);
        System.out.println("\n");
    }

}
