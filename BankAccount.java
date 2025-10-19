/**
 * BankAccount stores balance and tracks total deposits, withdrawals, and interest.
 * Uses a monthly interest rate derived from an APR percentage.
 *
 * @author WanhongHe
 * @version v1.0
 * @since 2025-10-18
 */
public class BankAccount {

    // instance vars per UML
    private double balance;        //updated based on monthly deposits, withdraw, and interest
    private double deposit;        //tracks total amount deposited over the months
    private double withdraw;       //tracks total amount withdrawn over the months
    private double interest;       //tracks total interest over the months
    private double monthlyIntRate; //monthly vs annual (APR) rate.  Users provide APR

    // set monthlyIntRate to 0.044/12 (monthly vs annual interest rate). Java sets all others to 0
    public BankAccount() {
        this.monthlyIntRate = 0.044 / 12.0;
        this.balance = 0.0;
        this.deposit = 0.0;
        this.withdraw = 0.0;
        this.interest = 0.0;
    }

    // divide intRate by 100, then by 12 to set monthlyIntRate
    public BankAccount(int inBalance, double intRate) {
        this.balance = inBalance;
        this.deposit = 0.0;
        this.withdraw = 0.0;
        this.interest = 0.0;
        this.monthlyIntRate = (intRate / 100.0) / 12.0;
    }

    // divide intRate by 100, then by 12 to set monthlyIntRate
    public BankAccount(double inBalance, double intRate) {
        this.balance = inBalance;
        this.deposit = 0.0;
        this.withdraw = 0.0;
        this.interest = 0.0;
        this.monthlyIntRate = (intRate / 100.0) / 12.0;
    }

    public void makeDeposit(double add) {
        this.balance += add;
        this.deposit += add;
    }

    public void makeDeposit(int add) {
        makeDeposit((double) add);
    }

    public void makeWithdraw(double sub) {
        this.balance -= sub;
        this.withdraw += sub;
    }

    public void makeWithdraw(int sub) {
        makeWithdraw((double) sub);
    }

    //Do not include negative interest.  If balance is greater than 0, calculate interest
    public void calcInterest() {
        if (this.balance > 0.0) {
            double addInt = this.balance * this.monthlyIntRate;
            this.balance += addInt;
            this.interest += addInt;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public double getDeposit() {
        return this.deposit;
    }

    public double getWithdraw() {
        return this.withdraw;
    }

    public double getInterest() {
        return this.interest;
    }
}

