import java.util.*;
import java.io.*;
import java.util.Arrays;
public class csvFileReader {
    static int nrow = -1;

    public static void Mean(String[][] data){
        double setosa_spl_ln = 0;
        double setosa_spl_wth = 0;
        double setosa_ptl_ln = 0;
        double setosa_ptl_wth = 0;
        double versicolor_spl_ln = 0;
        double versicolor_spl_wth = 0;
        double versicolor_ptl_ln = 0;
        double versicolor_ptl_wth = 0;
        double virginica_spl_ln  = 0;
        double virginica_spl_wth = 0;
        double virginica_ptl_ln = 0;
        double virginica_ptl_wth = 0;

        for(int i = 1; i <= 50; i++){
            setosa_spl_ln +=  Double.parseDouble(data[i][1]);
            setosa_spl_wth +=  Double.parseDouble(data[i][2]);
            setosa_ptl_ln +=  Double.parseDouble(data[i][3]);
            setosa_ptl_wth +=  Double.parseDouble(data[i][4]);
        }
        for(int i = 51; i <= 100; i++){
            versicolor_spl_ln +=  Double.parseDouble(data[i][1]);
            versicolor_spl_wth +=  Double.parseDouble(data[i][2]);
            versicolor_ptl_ln +=  Double.parseDouble(data[i][3]);
            versicolor_ptl_wth +=  Double.parseDouble(data[i][4]);
        }
        for(int i = 101; i <= 150; i++){
            virginica_spl_ln +=  Double.parseDouble(data[i][1]);
            virginica_spl_wth +=  Double.parseDouble(data[i][2]);
            virginica_ptl_ln +=  Double.parseDouble(data[i][3]);
            virginica_ptl_wth +=  Double.parseDouble(data[i][4]);
        }
        
        System.out.println("..................Mode................");   
        System.out.println("Setosa: ");
        System.out.println(data[0][1] + ": " + setosa_spl_ln/50);
        System.out.println(data[0][2] + ": " + setosa_spl_wth/50);
        System.out.println(data[0][3] + ": " + setosa_ptl_ln/50);
        System.out.println(data[0][4] + ": " + setosa_ptl_wth/50 + "\n");
        System.out.println("versicolor: ");
        System.out.println(data[0][1] + ": " + versicolor_spl_ln/50);
        System.out.println(data[0][2] + ": " + versicolor_spl_wth/50);
        System.out.println(data[0][3] + ": " + versicolor_ptl_ln/50);
        System.out.println(data[0][4] + ": " + versicolor_ptl_wth/50 + "\n");
        System.out.println("virginica: ");
        System.out.println(data[0][1] + ": " + virginica_spl_ln/50);
        System.out.println(data[0][2] + ": " + virginica_spl_wth/50);
        System.out.println(data[0][3] + ": " + virginica_ptl_ln/50);
        System.out.println(data[0][4] + ": " + virginica_ptl_wth/50 + "\n");       
        
    }

    static void Median(double[] spl_ln, double[] spl_wth, double[] ptl_ln, double[] ptl_wth){   

        
        if(50 % 2 == 0){
            System.out.println("sepalLength= "+spl_ln[((50/2)+1 + (50/2))/2]);
            System.out.println("sepalWidth= "+spl_wth[((50/2)+1 + (50/2))/2]);
            System.out.println("petalLength= "+ptl_ln[((50/2)+1 + (50/2))/2]);
            System.out.println("PetalWidth= "+ptl_wth[((50/2)+1 + (50/2))/2] + "\n");
        } 

    }

    public static void Mode(double[] spl_ln, double[] spl_wth, double[] ptl_ln, double[] ptl_wth){
        System.out.println("sepalLength: "+ MaxFrequency(spl_ln));
        System.out.println("sepalWidth: "+ MaxFrequency(spl_wth));
        System.out.println("petalLength: "+ MaxFrequency(ptl_ln));
        System.out.println("PetalWidth: "+ MaxFrequency(ptl_wth) + "\n");
    }

    public static double MaxFrequency(double[] arr){
        HashMap<Double, Integer> count = new HashMap<>();
        for(double num : arr){
            if(!count.containsKey(num)){
                count.put(num, 1);
            }
            else{
                count.put(num, count.get(num) + 1);
            }
        }

        int max = 0;
        double key = 0;
        for(double num : arr){
            if(count.get(num) > max){
                max = count.get(num);
                key = num;
            }
        }

        return key;

    }

    public static void Max(double[] spl_ln, double[] spl_wth, double[] ptl_ln, double[] ptl_wth){
        
        System.out.println("sepalLength: "+ spl_ln[spl_ln.length - 1]);
        System.out.println("sepalWidth: "+ spl_wth[spl_ln.length - 1]);
        System.out.println("petalLength: "+ ptl_ln[spl_ln.length - 1]);
        System.out.println("PetalWidth: "+ ptl_wth[spl_ln.length - 1] + "\n");
    }

    public static void Min(double[] spl_ln, double[] spl_wth, double[] ptl_ln, double[] ptl_wth){
        
        System.out.println("sepalLength: "+ spl_ln[1]);
        System.out.println("sepalWidth: "+ spl_wth[1]);
        System.out.println("petalLength: "+ ptl_ln[1]);
        System.out.println("PetalWidth: "+ ptl_wth[1] + "\n");
    }


    static String[][] CSVReader_fun(){
        String[][] data = new String[200][6];
        try{
            File file = new File("Iris.csv");
            Scanner read = new Scanner(file);
            String[] line = new String[20];

            
            int j = -1;

            while(read.hasNextLine()){
                nrow++;
                line = read.nextLine().split(",");
                for(int k = 0; k < 6; k++){
                    data[nrow][++j] = line[k];
                    }
                j = -1; 
                
                }
            
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            return data;
            
        }
        
    
    public static void main(String args[]){
        String[][] data = CSVReader_fun();
        String[][] setosa = new String[50][5];

        Mean(data);               

        // logic for creating a sorted.
        double[] setosa_spl_ln = new double[51];
        double[] setosa_spl_wth = new double[51];
        double[] setosa_ptl_ln = new double[51];
        double[] setosa_ptl_wth = new double[51];
        double[] versicolor_spl_ln = new double[51];
        double[] versicolor_spl_wth = new double[51];
        double[] versicolor_ptl_ln = new double[51];
        double[] versicolor_ptl_wth = new double[51];
        double[] virginica_spl_ln = new double[51];
        double[] virginica_spl_wth = new double[51];
        double[] virginica_ptl_ln = new double[51];
        double[] virginica_ptl_wth = new double[51];

        int j = -1;
        for(int i = 1; i <= 50 ; i++){
            j++;
            setosa_spl_ln[j] = Double.parseDouble(data[i][1]);
            setosa_spl_wth[j] = Double.parseDouble(data[i][2]);
            setosa_ptl_ln[j] = Double.parseDouble(data[i][3]);
            setosa_ptl_wth[j] = Double.parseDouble(data[i][4]);
        }
        j = -1;
        for(int i = 51; i <= 100 ; i++){
            j++;
            versicolor_spl_ln[j] = Double.parseDouble(data[i][1]);
            versicolor_spl_wth[j] = Double.parseDouble(data[i][2]);
            versicolor_ptl_ln[j] = Double.parseDouble(data[i][3]);
            versicolor_ptl_wth[j] = Double.parseDouble(data[i][4]);
            
        }
        j = -1;
        for(int i = 101; i <= 150 ; i++){
            j++;
            virginica_spl_ln[j] = Double.parseDouble(data[i][1]);
            virginica_spl_wth[j] = Double.parseDouble(data[i][2]);
            virginica_ptl_ln[j] = Double.parseDouble(data[i][3]);
            virginica_ptl_wth[j] = Double.parseDouble(data[i][4]);
            
        }
        
        Arrays.sort(setosa_spl_ln);
        Arrays.sort(setosa_spl_wth);
        Arrays.sort(setosa_ptl_ln);
        Arrays.sort(setosa_ptl_wth);
        Arrays.sort(versicolor_spl_ln);
        Arrays.sort(versicolor_spl_wth);
        Arrays.sort(versicolor_ptl_ln);
        Arrays.sort(versicolor_ptl_wth);
        Arrays.sort(virginica_spl_ln);
        Arrays.sort(virginica_spl_wth);
        Arrays.sort(virginica_ptl_ln);
        Arrays.sort(virginica_ptl_wth);

        
        System.out.println(".........................Median..........................");
        System.out.println("Setosa: ");
        Median(setosa_spl_ln, setosa_spl_wth, setosa_ptl_ln, setosa_ptl_wth);
        System.out.println("versicolor: ");
        Median(versicolor_spl_ln, versicolor_spl_wth, versicolor_ptl_ln, versicolor_ptl_wth);
        System.out.println("virginica: ");
        Median(virginica_spl_ln, virginica_spl_wth, virginica_ptl_ln, virginica_ptl_wth);

        System.out.println(".........................Mode........................");
        System.out.println("Setosa: ");
        Mode(setosa_spl_ln, setosa_spl_wth, setosa_ptl_ln, setosa_ptl_wth);
        System.out.println("Versicolor: ");
        Mode(versicolor_spl_ln, versicolor_spl_wth, versicolor_ptl_ln, versicolor_ptl_wth);
        System.out.println("Virginica: ");
        Mode(virginica_spl_ln, virginica_spl_wth, virginica_ptl_ln, virginica_ptl_wth);

        System.out.println("........................Min........................");
        System.out.println("Setosa: ");
        Min(setosa_spl_ln, setosa_spl_wth, setosa_ptl_ln, setosa_ptl_wth);
        System.out.println("Versicolor: ");
        Min(versicolor_spl_ln, versicolor_spl_wth, versicolor_ptl_ln, versicolor_ptl_wth);
        System.out.println("Virginica: ");
        Min(virginica_spl_ln, virginica_spl_wth, virginica_ptl_ln, virginica_ptl_wth);

        System.out.println("............................Max......................");
        System.out.println("Setosa: ");
        Max(setosa_spl_ln, setosa_spl_wth, setosa_ptl_ln, setosa_ptl_wth);
        System.out.println("versicolor: ");
        Max(versicolor_spl_ln, versicolor_spl_wth, versicolor_ptl_ln, versicolor_ptl_wth);
        System.out.println("virginica: ");
        Max(virginica_spl_ln, virginica_spl_wth, virginica_ptl_ln, virginica_ptl_wth);
    }
}
