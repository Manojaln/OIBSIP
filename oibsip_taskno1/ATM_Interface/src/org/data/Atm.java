package org.data;
import java.util.*;

public class Atm {
private static HashMap<String, User> users = new HashMap<>();
    
    static {
        users.put("user1", new User("Manoj", "0512"));
        users.put("user2", new User("Alan", "2004"));
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        User currentUser = users.get(userId);
        if (currentUser == null) {
            System.out.println("User not found!");
            return;
        } 

        
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        User currentUserPin = users.get(userId);
        
        
        if (!currentUserPin.validatePin(pin)) {
            System.out.println("Invalid PIN!");
            return ;
        }
        
        System.out.println("Login Successful!");
        showMenu(currentUser, scanner);
    } 

    private static void showMenu(User user, Scanner scanner) {
        BankAccount account = user.getBankAccount();
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ATMOperation.showTransactionHistory(account);
                    break;
                case 2:
                    ATMOperation.withdraw(account, scanner);
                    break;
                case 3:
                    ATMOperation.deposit(account, scanner); 
                    break;
                case 4:
                    System.out.print("Enter recipient user ID: ");
                    scanner.nextLine();  // consume newline
                    String recipientId = scanner.nextLine();
                    if (!users.containsKey(recipientId)) {
                        System.out.println("Recipient not found!");
                        break;
                    }
                    ATMOperation.transfer(account, users.get(recipientId).getBankAccount(), scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
