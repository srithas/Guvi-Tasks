// Question 1.3
// Purpose: Create Class Account with data memebers as Balance. 2 constructors and perform tasks

class Account{
    double balance;
    int accountNum;

    // Constructor with no argument
    public Account(){
        this.balance = 0.0;
        this.accountNum = 0;
    }

    // Constructor with 2 arguments
    public Account(int accountNum, double ogBalance){
        this.accountNum = accountNum;
        this.balance = ogBalance;
    }

    // Method to deposit the amount to the account
    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    // Method to withdraw the amount from the account
    public void withdraw(double amount){
        if (amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
        else{
            System.out.println("Withdrawn: $" + amount);
            System.out.println("Insufficient Balance");
        }
    }

    // Method to display the Balance
    public void display(){
        System.out.println("Account Number: " + accountNum + " | Balance: $" + balance);
    }

    public static void main(String[] args){
        Account account1 = new Account();
        account1.display();

        Account account2 = new Account(123, 1000.0);
        account2.display();

        account2.deposit(500.0);
        account2.display();

        account2.withdraw(200.0);
        account2.display();

        account2.withdraw(2000.0);
        account2.display();
    }



}