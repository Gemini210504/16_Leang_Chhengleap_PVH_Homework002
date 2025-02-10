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

    String reset = "\u001B[0m";
    String red = "\u001B[31m";
    String blue = "\u001B[34m";

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
    @Override
    public Account deposit(double amount) {
        if (amount > 0) {
            if(amount<200) {
                balance += amount;
                System.out.println("\n");
                System.out.println("\n                 Saving Account                       ");
                System.out.println(blue+"Received            :                         $ " + amount+""+reset);
                System.out.println(blue+"Total balance       :                         $ " + balance+""+reset);

                System.out.println(blue+"\n >>> Deposit successful! <<<\n"+reset);


            }else{
                balance += amount;
                double interest = balance * rate;
                balance += interest;
                System.out.println("\n");
                System.out.println("\n                 Saving Account                       ");
                System.out.println(blue+"Received            :                         $ " + amount+""+reset);
                System.out.println(blue+"Total balance       :                         $ " + balance+""+reset);
                System.out.println(blue+"\n >>> Deposit successful! <<<\n"+reset);


            }
        } else {
            System.out.println(red+"Invalid deposit amount. It must be positive!"+reset);
        }
        return null;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= (0.8 * balance) && balance >= amount) {
            balance -= amount;
            System.out.println("\n                 Withdraw from Saving Account                       ");
            System.out.println(blue+"Withdraw            :                         $ "+amount+""+reset);
            System.out.println(blue+"Total Amount        :                         $ "+balance+""+reset);

            System.out.println(blue+"\n >>> Withdraw successful! <<<\n"+reset);


        } else if (amount > (0.8*balance)){
            System.out.println(red+"Cannot withdraw $"+amount+". At lease "+(balance-(0.8*balance))+" must remain in the account."+reset);
        }else{
            System.out.println(red+"No balance in saving account or invalid amount."+reset);
        }

    }

    @Override
    public void transfer(double amount, Account targetAccount) {

        if (amount > 0 && balance >= amount) {
            balance -= amount;
            targetAccount.deposit(amount);
            System.out.println("\n                   Transferred Checking                         ");
            System.out.println(blue+"Transferred         :                       $"+amount+""+reset);
            System.out.println(blue+"From                : Saving Account with ID  : "+getAccountNumber()+""+reset);
            System.out.println(blue+"To                  : Checking Account with ID    : "+((CheckingAccount) targetAccount).getAccountNumber()+""+reset);

        } else {
            System.out.println(red+"No balance in saving account or invalid transfer amount."+reset);
        }
    }

    @Override
    public void displayAccount() {
        System.out.println("======= Saving Account Information ========");
        System.out.println(blue+"Account Type  : Saving Account"+reset);
        System.out.println(blue+"Account Number: " + accountNumber+""+reset);
        System.out.println(blue+"Username: " + userName+""+reset);
        System.out.println(blue+"Date of Birth: " + dateOfBirth+""+reset);
        System.out.println(blue+"Gender: " + gender+""+reset);
        System.out.println(blue+"Phone Number: " + phoneNumber+""+reset);
        System.out.println(blue+"Balance: $" + balance+""+reset);
        System.out.println("\n");
    }
}
