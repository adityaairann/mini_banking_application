import java.util.*;

public class BankApp{
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        BankAccount bank = new BankAccount("Aditya", "01");
        bank.ShowMenu();
    }
}

    class BankAccount{
        int balance;
        int previousTransaction;
        String CustomerName;
        String CustomerID;

        BankAccount(String CName, String CID){
            CustomerName = CName;
            CustomerID = CID;

        }
        void deposit(int amount){
            if(amount != 0){
                balance = balance+amount;
                previousTransaction = amount;
            }
        }
        void withdraw(int amount){
            if(amount != 0){
                balance = balance-amount;
                previousTransaction = -amount;
            }
        }
        void getPrevTrans(){
            if(previousTransaction > 0){
                System.out.println("Depoited: "+previousTransaction);
            }
            else if(previousTransaction < 0){
                System.out.println("Withdrawn: "+Math.abs(previousTransaction));
            }
            else{
                System.out.println("NO transaction occoured");
            }
        }
        void ShowMenu(){
            char option = '\0';
            Scanner inp = new Scanner(System.in);

            System.out.println("Your ID: "+CustomerID);
            System.out.println();
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Wihdraw");
            System.out.println("D. PRevious Transaction");
            System.out.println("E. Exit");

            do{
                System.out.println("Enter the option");
                System.out.println();
                option = inp.next().charAt(0);
                Character.toUpperCase(option);
                switch (option) {
                    case 'A':
                        System.out.println("Balance is: "+balance);
                        break;

                        case 'B':
                        System.out.println("Enter the amount to deposit: ");
                        int amount = inp.nextInt();
                        deposit(amount);
                        System.out.println();
                        break;

                        case 'C':
                        System.out.println("Enter the amount to withdraw: ");
                        int amount_2 = inp.nextInt();
                        withdraw(amount_2);
                        System.out.println();
                        break;

                        case 'D':
                        System.out.println("Previous Transaction: ");
                        getPrevTrans();
                        System.out.println();
                        break;

                        case 'E':
                        System.out.println();
                        break;

                    default:
                    System.out.println("Invalid Option");
                        break;
                }
            }while(option != 'E');
        }

    }
