import java.util.Scanner;
public class menuDriven{
    public static void main(String[] args){  
        Scanner scan = new Scanner(System.in);
        int ch;
        String name = "";
        String val = "";
        int i;
        String[] names = new String [1024];
        i = -1;
            do{
                System.out.println("---------Menu--------");
                System.out.println("1. Add a name to the array");
                System.out.println("2. Search for a name");
                System.out.println("3. Remove a name");
                System.out.println("4. Show all names");
                System.out.println("5. Exit the program");
                System.out.print("Choose any one option to perform : ");                
                ch = scan.nextInt();
                switch(ch){
                case 1:
                     i = i+1;
                     System.out.print("Enter the name you want to add: ");
                    name = scan.next(); 
                    for(int j=0;j<=i;j++){
                     val = names[j];
                    if(i != 0 && val == name){
                     System.out.println(name + " This name is already exists in the array.");
                     i = i-1;
                     break;
                     }
                     else{
                     names[i] = name;
                    break;
                    }
                    }
                    System.out.println("");
                    break;
                case 2:
                    String reply="no";
                     System.out.print("Enter the name you want to search : ");
                     name = scan.next();
                     for(int j=0;j<=i;j++){
                    if(names[j].compareTo(name) == 0){
                    System.out.println(" Congrates! This name is exists in the array at index number " + i);
                     reply = "yes";
                     break;                                
                    }
                    }
                    if(reply == "no"){
                    System.out.println(name + " Sorry! This name does not exist in the array.");
                    }                            
                    System.out.println("");
                     break;
                case 3:
                    System.out.print("Enter a name  you want to remover from the array: ");
                    name = scan.next();
                     for(int j=0;j<=i;j++){
                    if(names[j].compareTo(name) == 0){
                     System.out.println(name + "exists in the array at index  " + i + " And its deleted.");
                    names[j] = ""; 
                     break;
                     }
                     }
                    System.out.println("");
                    break;
                case 4:
                    for(int j=0;j<=i;j++){
                    System.out.println("["+j+"]: "+ names[j]);
                    }
                     System.out.println("");
                     break; 
                    }
            }while(ch!= 5);
    }
}

