import java.io.*;
import java.util.*;
// import java.Arrays

public class TextFileReader{
    public static int[] vowels(String[] arr){
        int[] v_count = new int[5];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length(); j++){
                switch(arr[i].charAt(j)){
                    case 'a':
                    v_count[0] += 1;
                    break;
                    case 'e':
                    v_count[1] += 1;
                    break;
                    case 'i':
                    v_count[2] += 1;
                    break;
                    case 'o':
                    v_count[3] += 1;
                    break;
                    case 'u':
                    v_count[4] += 1;
                    break;

                    case 'A':
                    v_count[0] += 1;
                    break;
                    case 'E':
                    v_count[1] += 1;
                    break;
                    case 'I':
                    v_count[2] += 1;
                    break;
                    case 'O':
                    v_count[3] += 1;
                    break;
                    case 'U':
                    v_count[4] += 1;
                    break;
                }

            }

        }
        return v_count;
        // System.out.println("a: "+a+"\ne: "+e);
    }

    public static int[] digit(String[] arr){
        int[] d_count = new int[10];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length(); j++){
                switch(arr[i].charAt(j)){
                    case '0':
                        d_count[0] += 1;
                        break;
                    case '1':
                        d_count[1] += 1;
                        break;
                    case '2':
                        d_count[2] += 1;
                        break;
                    case '3':
                        d_count[4] += 1;
                        break;
                    case '5':
                        d_count[5] += 1;
                        break;
                    case '6':
                        d_count[6] += 1;
                        break;
                    case '7':
                        d_count[7] += 1;
                        break;
                    case '8':
                        d_count[8] += 1;
                        break;
                    case '9':
                        d_count[9] += 1;
                        break;
                }
            }
        }

        // System.out.println("0: "+d_count[0] + " , 1:" + d_count[1]);
        return d_count;
        
    }

    public static void top_5(String[] arr){
        int[] count = new int[5];
    }


    public static void main(String args[]){
        try{
            File file = new File("text.txt");
            Scanner read = new Scanner(file);
            String txt = "";
            while(read.hasNextLine()){
                txt += read.nextLine();
            }

            
            String[] arr = new String[10000];
            arr = txt.split(" ");
    
            int[] v_count = vowels(arr);
            System.out.println("a:"+v_count[0]+", e:"+v_count[1]+", i:"+v_count[2]+", o:"+v_count[3]+", u:"+v_count[4]);

            int[] d_count = digit(arr);
            System.out.println("0: "+d_count[0] + "\n" + "1: "+d_count[1] + "\n" + "2: "+d_count[2] + "\n" + "3: "+d_count[3] + "\n" + "4: "+d_count[4] + "\n" + "5: "+d_count[5] + "\n" +
            "6: "+d_count[6] + "\n" + "7: "+d_count[7] + "\n" + "8: "+d_count[8] + "\n" + "9: "+d_count[9] );




        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}



    

