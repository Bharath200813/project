import java.util.ArrayList;
import java.util.Scanner;

class DigitalWallet {
    private String userName;
    private double balance;
    private ArrayList<String> history;

    
    DigitalWallet(String name) {
        this.userName = name;
        this.balance = 0.0;
        this.history = new ArrayList<>();
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add("Deposited: ₹" + amount);
            System.out.println("Amount Deposited Successfully!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Withdrawn: ₹" + amount);
            System.out.println("Amount Withdrawn Successfully!");
        } else {
            System.out.println("Insufficient Balance or Invalid Amount!");
        }
    }

    
    public void transfer(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Transferred: ₹" + amount);
            System.out.println("Money Transferred Successfully!");
        } else {
            System.out.println("Transaction Failed!");
        }
    }

    
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

   
    public void showHistory() {
        System.out.println("\n Transaction History:");
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String h : history) {
                System.out.println(h);
            }
        }
    }

    
    public void displayUser() {
        System.out.println("\n User: " + userName);
    }
}


public class WalletApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        DigitalWallet wallet = new DigitalWallet(name);

        int choice;

        do {
            wallet.displayUser();

            System.out.println("\n===== DIGITAL WALLET MENU =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Transfer Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    wallet.deposit(deposit);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    wallet.withdraw(withdraw);
                    break;

                case 3:
                    System.out.print("Enter amount to transfer: ");
                    double transfer = sc.nextDouble();
                    wallet.transfer(transfer);
                    break;

                case 4:
                    wallet.checkBalance();
                    break;

                case 5:
                    wallet.showHistory();
                    break;

                case 6:
                    System.out.println("Thank you for using Digital Wallet!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}