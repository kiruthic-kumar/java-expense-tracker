public class Transaction {
    String type; // "Income" or "Expense"
    String description;
    double amount;

    public Transaction(String type, String description, double amount) {
        this.type = type;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + " - " + description + ": ₹" + amount;
    }
}