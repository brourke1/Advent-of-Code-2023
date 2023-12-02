import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class calibration{
    public static char firstDigit(String s){
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                return s.charAt(i);
            }
        }
        return 'a';
    }
    public static char lastDigit(String s){
        for(int i = s.length() - 1; i >= 0; i--){
            if(Character.isDigit(s.charAt(i))){
                return s.charAt(i);
            }
        }
        return 'a';
    }
    public static void main(String[] args){

        int sum = 0;
        String calsums = "";
        String currLine = "";

        try {File f = new File("input.txt");
            Scanner scnr = new Scanner(f);
            while(scnr.hasNextLine()){
                currLine = scnr.nextLine();
                calsums = String.valueOf(firstDigit(currLine)) + String.valueOf(lastDigit(currLine));
                sum += Integer.parseInt(calsums);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        System.out.println(sum);
    }
}