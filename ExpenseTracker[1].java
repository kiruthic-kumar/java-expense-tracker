import java.util.*;

public class ExpenseTracker {
    static ArrayList<Transaction> history = new ArrayList<>();
    static double balance = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. View History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter income source: ");
                    String incomeDesc = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double incomeAmt = sc.nextDouble();
                    balance += incomeAmt;
                    history.add(new Transaction("Income", incomeDesc, incomeAmt));
                    System.out.println("✅ Income added.");
                    break;

                case 2:
                    System.out.print("Enter expense description: ");
                    String expenseDesc = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double expenseAmt = sc.nextDouble();
                    if (expenseAmt > balance) {
                        System.out.println("❌ Not enough balance!");
                    } else {
                        balance -= expenseAmt;
                        history.add(new Transaction("Expense", expenseDesc, expenseAmt));
                        System.out.println("✅ Expense added.");
                    }
                    break;

                case 3:
                    System.out.println("💼 Current Balance: ₹" + balance);
                    break;

                case 4:
                    System.out.println("--- Transaction History ---");
                    for (Transaction t : history) {
                        System.out.println(t);
                    }
                    break;

                case 5:
                    System.out.println("👋 Exiting... Bye!");
                    return;

                default:
                    System.out.println("⚠️ Invalid choice.");
            }
        }
    }
}