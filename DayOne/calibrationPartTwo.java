import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class calibrationPartTwo{

    public static String[] validDigits = new String[]{
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine"
    };

    public static int getArraySize(String[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == null){
                return sum;
            }
            sum++;
        }
        return sum;
    }
    public static String[] matchingDigits(String s){
        String[] output = new String[9];
        int index = 0;
        for(int i = 0; i < validDigits.length; i++){
            if(s.length() <= validDigits[i].length()){
                if(validDigits[i].substring(0,s.length()).equals(s)){
                    output[index] = validDigits[i];
                    index++;
                }
            }
        }
        return output;
    }
    public static boolean wordInArray(String[] arr,int arrSize, String s){
        for(int i = 0; i < arrSize; i++){
            if(arr[i].equals(s)){
                return true;
            }
        }
        return false;
    }
    public static String findWordDigits(String s){
        int i = 0;
        int j = 0;
        int arrSize = 0;
        String[] strs = new String[9];
        while(i < s.length()){
            strs = matchingDigits(s.substring(i, i + 1));
            arrSize = getArraySize(strs);
            while(arrSize > 0 && j <= s.length()){
                if(wordInArray(strs, arrSize, s.substring(i, j))){
                    return s.substring(i, j) + i;
                }
                j++;
            }
            i++;
            j = i;
        }
        return null;
    }
    public static char wordToDigit(String s){
        HashMap<String, Character> convert = new HashMap<String, Character>();
        for(int i = 1; i < 10; i++){
            convert.put(validDigits[i -1], (char)(i+'0'));
        }
        return convert.get(s);
    }
    public static char firstDigit(String s){

        String word = "";
        char c = 'a';
        char digit = 'a';
        int digitIndex = 100;
        int wordIndex = 100;
        int split = 0;

        for(int i = 0; i < s.length(); i++){

            if(Character.isDigit(s.charAt(i))){
                digitIndex = i;
                digit = s.charAt(i);
                break;
            }
        }

        word = findWordDigits(s);
        if(word != null){
            for(int i = 0; i < word.length(); i++){
                if(Character.isDigit(word.charAt(i)) && split == 0){
                    split = i;
                }
            }
            //System.out.println(word);
            wordIndex = Integer.parseInt(word.substring(split));
            word = word.substring(0, split);
            //System.out.println(word + ", " + wordIndex);
            c = wordToDigit(word);
        }

        
        if(digitIndex < wordIndex){
            return digit;
        }
        else{
            return c;
        }
    }
    public static char lastDigit(String s){
        
        String word = "";
        char c = 'a';
        char digit = 'a';
        int digitIndex = -1;
        int wordIndex = -1;
        int split = 0;
        int flipIndex = -1;

        for(int i = s.length() - 1; i >= 0; i--){

            if(Character.isDigit(s.charAt(i))){
                digitIndex = i;
                digit = s.charAt(i);
                break;
            }
        }
        for(int i = s.length() - 1; i >= 0; i--){
            if(findWordDigits(s.substring(i)) != null){
                word = findWordDigits(s.substring(i));
                wordIndex = i;
                break;
            }
        }
        if(word != ""){
            for(int i = 0; i < word.length(); i++){
                if(Character.isDigit(word.charAt(i)) && split == 0){
                    split = i;
                }
            }
            //System.out.println(word);
            //wordIndex = Integer.parseInt(word.substring(split));
            word = word.substring(0, split);
            //System.out.println(word + ", " + wordIndex);
            c = wordToDigit(word);
        }

        System.out.println(word);
        if(digitIndex > wordIndex){
            return digit;
        }
        else{
            return c;
        }
    }
    public static void main(String[] args){
    //"9sixthree3three"
        //lastDigit("gsntbddbnone4cjqjmspzcsxmvvthreefive");
    
        int sum = 0;
        String calsums = "";
        String currLine = "";

        try {File f = new File("input.txt");
            Scanner scnr = new Scanner(f);
            while(scnr.hasNextLine()){
                
                currLine = scnr.nextLine();
                calsums = String.valueOf(firstDigit(currLine)) + String.valueOf(lastDigit(currLine));
                sum += Integer.parseInt(calsums);
                System.out.println(currLine + ", " + calsums);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        System.out.println(sum);
        
    }
    
}