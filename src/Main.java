import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Display display = new Display();
        String menu;
        do {
            System.out.println("============================== Online Banking System ===========================");
            System.out.println("[1]. Create Account");
            System.out.println("[2]. Deposit Money");
            System.out.println("[3]. Withdraw Money");
            System.out.println("[4]. Transfer Money");
            System.out.println("[5]. Display Account Information");
            System.out.println("[6]. Delete Account");
            System.out.println("[7]. Exit");
            System.out.println("================================================================================");
            System.out.print("Choose your option: ");
            menu = sc.nextLine();
            switch (menu) {
                case "1": {
                    display.createAccount();
                    break;
                }
                case "2": {
                    display.depositMoney();
                    break;
                }
                case "3": {
                    display.withdrawMoney();
                    break;
                }
                case "4": {
                    display.transferMoney();
                    break;
                }
                case "5": {
                    display.displayAccountInformation();
                    break;
                }
                case "6": {
                    display.deleteAccount();
                    break;

                }
                case "7": {
                    System.out.println(display.red + "Exiting..." + display.reset);
                    break;
                }
                default:
                    System.out.println(display.red + "Invalid option, please try again." + display.reset);
            }
        }while (!menu.equals("8"));

    }
}