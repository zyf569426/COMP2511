/**
 * Sub class of BankAccount that represents an Internet account.
 *
 * @invariant balance >= 0
 * @invariant 0 <= withdrawn <= 800
 *
 * @author Kane Walter
 *
 */
public class InternetAccount extends BankAccount {
    private int withdrawNum;

    /**
     * Constructor for InternetAccount objects
     *
     * @postcondition 0 <= withdrawNum <= 10
     */
    public InternetAccount() {
        super();
        this.withdrawNum = 0;
    }

    /**
     * Deposit money into an an Internet account.
     *
     * @param         amount Amount of money to deposit
     * @precondition  amount > 0
     * @postcondition balance = balance + amount
     */
    @Override
    public void deposit(int amount) {
        super.deposit(amount);
    }

    /**
     * Withdraw money from an Internet account.
     *
     * @param         amount Amount of money to withdraw
     * @precondition  amount > 0
     * @postcondition balance = balance - amount
     * @postcondition 0 < withdrawNum <= 10
     * @return        true/false depending on whether withdrawal was
     *                successful
     */
    @Override
    public boolean withdraw(int amount) {
        if (withdrawNum < 10 && super.withdraw(amount) == true) {
            withdrawNum++;
            return true;
        }
        return false;

    }
}
