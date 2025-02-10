import java.util.Scanner;

public class Display {
    Scanner sc = new Scanner(System.in);
    String reset = "\u001B[0m";
    String red = "\u001B[31m";
    String blue = "\u001B[34m";
    CheckingAccount checkingAccounts;
    SavingAccount savingAccounts ;

    public void createAccount(){
        while (true) {
            System.out.println("============================== Creating Account ===========================");
            System.out.println("[1]. Checking Account");
            System.out.println("[2]. Saving Account");
            System.out.println("[3]. Back");
            System.out.println("===========================================================================");
            System.out.print(blue + "What type of account do you want to create? : " + reset);
            String creating = sc.nextLine().trim();
            switch (creating) {
                case "1":
                    if(checkingAccounts==null) {
                        checkingAccounts = (CheckingAccount) addAccount("Checking");
                        checkingAccounts.getAccountNumber();
                    }
                    else{
                        System.out.println(red+"You already have checking account!"+reset);
                    }
                    break;
                case "2":
                    if(savingAccounts==null) {
                        savingAccounts = (SavingAccount) addAccount("Saving");
                        savingAccounts.getAccountNumber();
                    }
                    else{
                        System.out.println(red+"You already have saving account!"+reset);
                    }

                    break;
                case "3":
                    System.out.println(blue+"🙏 Thank you for visiting our bank! ❤️"+reset);
                    return;
                default:
                    System.out.println(red+"Invalid choice! Please enter 1, 2, or 3."+reset);
            }
        }
    }

    public Account addAccount(String accountType){
        System.out.println("============================== " + accountType + " Account Information ===========================");
        String  username, birth, gender, numPhone;
        while (true) {
            System.out.print("=> Enter Username: ");
            username = sc.nextLine().trim();
            if (username.matches("^[a-zA-Z\\s]+$")) {
                break;
            }
            System.out.println(red+"You can only use letters! Please enter again."+reset);
        }

        int presentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        while (true) {
            System.out.print("=> Enter date of birth (dd-mm-yyyy): ");
            birth = sc.nextLine().trim();
            if (birth.matches("^([0-9]{2}-[0-9]{2}-[0-9]{4})$")) {
                String[] years = birth.split("-");
                int day = Integer.parseInt(years[0]);
                int month = Integer.parseInt(years[1]);
                int birthYear = Integer.parseInt(years[2]);
                if (day <= 31 && month <= 12 && (presentYear- birthYear) >= 16) {
                    break;
                }
            }
            System.out.println(red+"Invalid format (User must be have above 15 years old)! Please enter again (dd-mm-yyyy)."+reset);
        }

        while (true) {
            System.out.print("=> Enter gender (Male/Female/Other): ");
            gender = sc.nextLine().trim().toLowerCase();
            if (gender.equals("male") || gender.equals("female") || gender.equals("other")) {
                gender = gender.substring(0, 1).toUpperCase() + gender.substring(1);
                break;
            }
            System.out.println(red+"Invalid gender! Please enter 'Male', 'Female', or 'Other'."+reset);
        }

        while (true) {
            System.out.print("=> Enter phone number: ");
            numPhone = sc.nextLine().trim();
            if (numPhone.matches("^0[0-9]{8,9}$")) {
                break;
            }
            System.out.println(red+"Invalid phone number! It must start with '0' and be 8-9 digits long."+reset);
        }

        System.out.println(blue+"\n✅ "+accountType+" Created Successfully ❤️😊"+reset);
        if (accountType.equals("Checking")) {
            return new CheckingAccount( username, birth, gender, numPhone);
        } else {
            return new SavingAccount( username, birth, gender, numPhone);
        }
    }

    public void depositMoney(){
        String deposit;
        double amount;
        do{
            System.out.println("============================== Deposit Money ===========================");
            System.out.println("[1]. Checking Account");
            System.out.println("[2]. Saving Account");
            System.out.println("[3]. Back");
            System.out.println("===========================================================================");
            System.out.print(blue+"What type of account do you want to deposit into? : "+reset);
            deposit = sc.nextLine();
            switch (deposit){
                case "1":
                    if (checkingAccounts == null) {
                        System.out.println(red + "No Checking Account found. Please create one first." + reset);
                        break;
                    }
                    System.out.print("=> Enter money to deposit: ");
                    amount = sc.nextDouble();
                    sc.nextLine();
                    checkingAccounts.deposit(amount);

                    break;
                case "2":
                    if (savingAccounts == null) {
                        System.out.println(red + "No Saving Account found. Please create one first." + reset);
                        break;
                    }
                    System.out.print("=> Enter money to deposit: ");
                    amount = sc.nextDouble();
                    sc.nextLine();
                    savingAccounts.deposit(amount);
                    break;
                case "3":
                    System.out.println(blue + "Thank you for using our service ❤️😊" + reset);
                    return;
                default:
                    System.out.println(red + "Invalid choice! Please enter 1, 2, or 3." + reset);
            }
        }while (!deposit.equals("3"));
    }


    public void withdrawMoney(){
        String withdraw;
        do{
            System.out.println("============================== Withdraw Money ===========================");
            System.out.println("[1]. Checking Account");
            System.out.println("[2]. Saving Account");
            System.out.println("[3]. Back");
            System.out.println("===========================================================================");
            System.out.print(blue+"What type of account do you want to withdraw from? : "+reset);
            withdraw = sc.nextLine();
            switch (withdraw){
                case "1":
                    if (checkingAccounts == null) {
                        System.out.println(red + "No Checking Account found. Please create one first." + reset);
                        break;
                    }
                    System.out.print("=> Enter money to withdraw: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    checkingAccounts.withdraw(amount);
                    break;
                case "2":
                    if (savingAccounts == null) {
                        System.out.println(red + "No Saving Account found. Please create one first." + reset);
                        break;
                    }
                    System.out.print("=> Enter money to withdraw: ");
                    amount = sc.nextDouble();
                    sc.nextLine();
                    savingAccounts.withdraw(amount);
                    break;
                case "3":
                    System.out.println(blue + "Thank you for using our service ❤️😊" + reset);
                    return;
                default:
                    System.out.println(red + "Invalid choice! Please enter 1, 2, or 3." + reset);
                    break;
            }
        }while (!withdraw.equals(3));

    }

    public void transferMoney(){
        String transfer;
        do{
            System.out.println("============================== Transfer Money ===========================");
            System.out.println("[1]. Checking Account -> Saving Account");
            System.out.println("[2]. Saving Account   -> Checking Account");
            System.out.println("[3]. Back");
            System.out.println("===========================================================================");
            System.out.print(blue+"What is your choice? : "+reset);
            transfer = sc.nextLine();
            switch (transfer){
                case "1":
                    if (checkingAccounts == null) {
                        System.out.println(red + "No Checking Account found. Please create one first." + reset);
                        break;
                    }
                    System.out.print("=> Enter money to transfer into saving : ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    checkingAccounts.transfer(amount, savingAccounts);
                    break;
                case "2":
                    if (savingAccounts == null) {
                        System.out.println(red + "No Saving Account found. Please create one first." + reset);
                        break;
                    }
                    System.out.print("=> Enter money to transfer: ");
                    amount = sc.nextDouble();
                    sc.nextLine();
                    savingAccounts.transfer(amount,checkingAccounts);
                    break;
                case "3":
                    System.out.println(blue + "Thank you for using our service ❤️😊" + reset);
                    return;
                default:
                    System.out.println(red + "Invalid choice! Please enter 1, 2, or 3." + reset);
                    break;
            }
        }while (!transfer.equals(3));

    }

    public void displayAccountInformation() {
        if (checkingAccounts == null && savingAccounts == null) {
            System.out.println("No account found. Please create an account first.");
            return;
        }

        if (checkingAccounts != null) {
            checkingAccounts.displayAccount();
        }
        if (savingAccounts != null) {
            savingAccounts.displayAccount();
        }
    }

    public void deleteAccount() {
        System.out.print("=> Enter account type to delete [1.Checking account, 2.Saving account]: ");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1: {
                if (checkingAccounts == null) {
                    System.out.println(red + "No Checking account to delete!" + reset);
                    return;
                }

                if (savingAccounts != null && checkingAccounts.getBalance() > 0) {
                    System.out.print(blue + "You have $" + checkingAccounts.getBalance() + " in your Checking account. Transfer to Saving account before deleting? (yes/no): " + reset);
                    String confirmTransfer = sc.nextLine().toLowerCase();
                    if (confirmTransfer.equals("yes")) {
//                        savingAccounts.deposit(checkingAccounts.getBalance());
                        checkingAccounts.transfer(checkingAccounts.getBalance(),savingAccounts);
                        System.out.println(blue + "Transferred $" + checkingAccounts.getBalance() + " to your Saving account." + reset);
                    }
                }

                System.out.print(blue + "Are you sure you want to delete your Checking account? (yes/no): " + reset);
                String confirmDelete = sc.nextLine().toLowerCase();
                if (confirmDelete.equals("yes")) {
                    checkingAccounts = null;
                    System.out.println(blue + "Checking account deleted successfully!" + reset);
                } else {
                    System.out.println(blue + "Deletion canceled." + reset);
                }
                break;
            }
            case 2: {
                if (savingAccounts == null) {
                    System.out.println(red + "No Saving account to delete!" + reset);
                    return;
                }

                if (checkingAccounts != null && savingAccounts.getBalance() > 0) {
                    System.out.print(blue + "You have $" + savingAccounts.getBalance() + " in your Saving account. Transfer to Checking account before deleting? (yes/no): " + reset);
                    String confirmTransfer = sc.nextLine().trim().toLowerCase();
                    if (confirmTransfer.equals("yes")) {
//                        checkingAccounts.deposit(savingAccounts.getBalance());
                        savingAccounts.transfer(savingAccounts.getBalance(), checkingAccounts);
                        System.out.println(blue + "Transferred $" + savingAccounts.getBalance() + " to your Checking account." + reset);
                    }
                }

                System.out.print(blue + "Are you sure you want to delete your Saving account? (yes/no): " + reset);
                String confirmDelete = sc.nextLine().trim().toLowerCase();
                if (confirmDelete.equals("yes")) {
                    savingAccounts = null;
                    System.out.println(blue + "Saving account deleted successfully!" + reset);
                } else {
                    System.out.println(red + "Deletion canceled." + reset);
                }
                break;
            }
            default:
                System.out.println(red + "Invalid option! Please enter 1 or 2." + reset);
        }
    }


}
