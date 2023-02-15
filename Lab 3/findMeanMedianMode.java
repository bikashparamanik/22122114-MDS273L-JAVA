import java.util.Scanner;

import javax.swing.SortOrder;

public class findMeanMedianMode {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] arr = getArray(sc);
        
        while (true) {
            showMenu();
            int choice = sc.nextInt();
            // Here it will call the appropriate function based on the user's choice.
            switch (choice) {
                case 1:
                    System.out.printf("Mean: %.2f\n", calculateMean(arr));
                    break;
                case 2:
                    System.out.printf("Median: %.2f\n", calculateMedian(arr));
                    break;
                case 3:
                    System.out.printf("Mode: %d\n", calculateMode(arr));
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("opps!, Invalid choice.");
            }
        }
    }
      
    public static int[] getArray(Scanner sc) {
        System.out.print("Enter the length of the array: "); // Collect the integer array from the user
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Enter the element %d: ", i + 1);
            arr[i] = sc.nextInt();
        }
        return arr;
    }
     // Here it's going to Present a menu of options to the user.
    public static void showMenu() {
        System.out.println("1. Calculate Mean");
        System.out.println("2. Calculate Median");
        System.out.println("3. Calculate Mode");
        System.out.println("4. Exit");
        System.out.print("Select  your choice from the menu: ");
    }
    
    // Function to calculate the mean of an integer array

    public static double calculateMean(int[] arr) {
        double sum = 0;
     for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
  }
  return sum / arr.length;
    }

    // Function to calculate the median of an integer array

    public static double calculateMedian(int[] arr) {
        
        int med = arr.length / 2;
        if (arr.length % 2 == 0) {
            return (double) (arr[med - 1] + arr[med]) / 2;
        } else {
            return (double) arr[med];
        }
    }
    // Function to calculate the mode of an integer array

    public static int calculateMode(int[] arr) {
        int mode = arr[0];
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                mode = arr[i];
                maxCount = count;
            }
        }
        return mode;
    }
}
    
        
