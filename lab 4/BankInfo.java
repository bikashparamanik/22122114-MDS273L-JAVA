import java.util.Scanner;
public class BankInfo{
    static Scanner sc = new Scanner(System.in);
    static public class customer{
    int i = -1;
    String cust_Name;
    int cust_acc_no;
    int amount;
    int[] previous_amount= new int[100];
    int[] current_amount= new int[100];
    int [] deposit_amount = new int[100];
    int [] Withdraw_amount= new int[100];
    
    public void customer_details(){
        System.out.println("Enter customer name: ");
        cust_Name=sc.next();
        cust_acc_no=22122114;
    }
    public void deposit_amount(){
        System.out.println("Please Enter the amount you want to deposit: ");
        int balance = sc.nextInt();
        i+=1;
        previous_amount[i]=amount;
        deposit_amount[i]=balance;
        amount=amount+balance;
        current_amount[i]=amount;
    }
    public void Withdraw_amount(){
        System.out.println("Please Enter the amount you want to withdraw:  ");
        int withdraw=sc.nextInt();
        if(withdraw<=amount){
            i+=1;
            Withdraw_amount[i]=withdraw;
            previous_amount[i]=amount;
            amount=amount-withdraw;
            current_amount[i]=amount;
            deposit_amount[i]=0;
        }else{
            System.out.println("Oh ho!! Withdrawal unsuccessful. Insufficient balance.");
        }
    }
    public void transaction_details(){
        System.out.println(" Your Transactions History: ");
        System.out.println("Previous Amount | Withdrawl Amount   |  Deposit amount  |   current Amount");
        for(int j=0; j<=i;j++){

            System.out.println(previous_amount[j] +"                    "+ Withdraw_amount[j] +"                    "+ deposit_amount[j] + "                           "+ current_amount[j]);

        }
    }
    public void account_summary(){
        System.out.println("\n Customer Name: "+ cust_Name+ "\n Customer Account Number: "+ cust_acc_no+ " Customer Current Balance: "+ amount);

    }
}
    public static void main(String[] args) {
        customer cus = new customer();
        int ch=0;
        do{
            System.out.println("\t========== Menu ==============");
            System.out.println("\t|  [1] Customer Details         |");
            System.out.println("\t|  [2] Deposit Money         |");
            System.out.println("\t|  [3] Withdraw Money        |");
            System.out.println("\t|  [4] Transactions Details        |");
            System.out.println("\t|  [5] Account Summary         |");
            System.out.println("\t|  [6] Exit             |");
            System.out.println("\t========================");
            ch=sc.nextInt();
            if(ch==1){
                cus.customer_details();
            } else if(ch==2){
                cus.deposit_amount();
            }else if(ch==3){
                cus.Withdraw_amount(); 
            }else if(ch==4){
                cus.transaction_details();
            }else if(ch==5){
                cus.account_summary();
            }else
            System.out.println("Good Bye! Thank you...");
            } while(ch!=6);
        }

    }


    

