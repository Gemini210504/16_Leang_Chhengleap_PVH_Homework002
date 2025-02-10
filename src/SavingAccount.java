import java.util.Random;

public class SavingAccount implements Account{
    private static final Random random = new Random();
    private int accountNumber;
    private String userName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private double balance;
    private double rate;
    Display display;

    public SavingAccount(String userName, String dateOfBirth, String gender, String phoneNumber) {
        this.accountNumber= random.nextInt(1000000000);
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.balance =0;
        this.rate = 0.05;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    double total;
    @Override
    public Account deposit(double amount) {
        if (amount > 0) {
            if(amount<200) {
                balance += amount;
                total=balance;
//            rate= rate * balance;
//            total=rate+balance;
                System.out.println("                 Saving Account                       ");
                System.out.println("Received        :                         $ " + amount);
                System.out.println("Total balance    :                         $ " + total);
                System.out.println("=============================================================");
                System.out.println("Withdraw successful!");
            }else{
                balance += amount;
                rate= rate * balance;
                total=rate+balance;
//                balance +=amount*rate;
                System.out.println("                 Saving Account                       ");
                System.out.println("Received        :                         $ " + amount);
                System.out.println("Total balance    :                         $ " + total);
                System.out.println("=============================================================");
                System.out.println("Withdraw successful!");
            }
        } else {
            System.out.println("Invalid deposit amount. It must be positive!");
        }
        return null;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && total >= amount) {
            total -= amount;
            System.out.println("                 Saving Account                       ");
            System.out.println("Withdraw        :                         $ "+amount);
            System.out.println("Total Amount    :                         $ "+total);
            System.out.println("=============================================================");
            System.out.println("Withdraw successful!");
        } else {
            System.out.println("No balance in saving account or invalid amount.");
        }
    }

    @Override
    public void transfer(double amount, Account targetAccount) {
        if (amount > 0 && total >= amount) {
            total -= amount;
            targetAccount.deposit(amount);
            System.out.println("Transferred $" + amount + " from your Saving account to the target account.");
        } else {
            System.out.println("No balance in saving account or invalid transfer amount.");
        }
    }

    @Override
    public void displayAccount() {
        System.out.println("======= Saving Account Information =======");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Username: " + userName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Balance: $" + total);
        System.out.println("============================================");
    }
}
