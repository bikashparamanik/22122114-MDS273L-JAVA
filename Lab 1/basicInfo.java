import java.util.Scanner;
public class basicInfo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Collecting basic user details
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        
        input.nextLine(); 
        
        System.out.print("Enter your gender (m/f): ");
        char gender = input.nextLine().charAt(0);
        
        System.out.print("Enter your state: ");
        String state = input.nextLine();
        
        // Displaing user details
        System.out.println("\nName: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + ((gender == 'm') ? "MALE" : "FEMALE"));
        System.out.println("State: " + state);
        
        // Checking if user is from the southern region of India
        switch(state.toLowerCase()) {
            case "andhra pradesh":
            case "telangana":
            case "karnataka":
            case "tamil nadu":
            case "kerala":
            case "pondicherry":
                System.out.println("\nThe student is from the southern states of India.");
                break;
            default:
                break;
        }
    }
}
    

    