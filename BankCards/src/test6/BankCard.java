package test6;

abstract class BankCard {
    protected double balance;

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract boolean pay(double amount);

    public abstract void getAvailableFunds();
}



