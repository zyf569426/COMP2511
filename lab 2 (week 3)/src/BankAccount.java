/**
 * This class represents a customer bank account.
 *
 * @author Kane Walter
 * @invariant balance >= 0
 * @invariant 0 <= withdrawnToday <= 800
 *
 */
public class BankAccount {
    private int balance;
    private int withdrawn;

    /**
     * Constructor for BankAccount objects.
     *
     * @postcondition balance >= 0
     * @postcondition 0 <= withdrawn <= 800
     */
    public BankAccount() {
        this.balance = 800;
        this.withdrawn = 0;
    }

    /**
     * Deposit money into bank account.
     *
     * @param         amount Amount of money to deposit
     * @precondition  amount > 0
     * @postcondition balance = balance + amount
     */
    public void deposit(int amount) {
        balance += amount;
    }

    /**
     * Withdraw money from bank account.
     *
     * @param         amount Amount of money to withdraw
     * @precondition  amount > 0
     * @postcondition balance = balance - amount
     * @return        true/false depending on whether withdrawal
     *                succeeded.
     */
    public boolean withdraw(int amount) {
        boolean limit = (amount + withdrawn <= 800) ? true : false;
        boolean valid = (balance - amount >= 0) ? true : false;

        if (limit && valid) {
            balance -= amount;
            withdrawn += amount;
            return true;
        }
        return false;
    }
}
