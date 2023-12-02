import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cubes{
    public static int max_red = 12;
    public static int max_green = 13;
    public static int max_blue = 14;

    enum Color {
        RED,
        GREEN,
        BLUE,
        BLACK
    }

    public static Color identifyColor(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'r'){
                return Color.RED;
            }
            else if(s.charAt(i) == 'b'){
                return Color.BLUE;
            }
            else if(s.charAt(i) == 'g'){
                return Color.GREEN;
            }

        }
        return Color.BLACK;
    }

    public static int getDigits(String s){
        String output = "";
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                output += s.charAt(i);
            }
        }
        return Integer.parseInt(output);
    }

    public static boolean tooManyCubes(String[] arr){
        String[] color;
        for(int i = 0; i < arr.length; i++){
            color = arr[i].split(",");
            for(int j = 0; j < color.length; j++){
                if(identifyColor(color[j]) == Color.RED){
                    if(getDigits(color[j]) > max_red){
                        return true;
                    }
                }
                if(identifyColor(color[j]) == Color.BLUE){
                    if(getDigits(color[j]) > max_blue){
                        return true;
                    }
                }
                if(identifyColor(color[j]) == Color.GREEN){
                    if(getDigits(color[j]) > max_green){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args){


        
        String line;
        String game;
        String num;
        String colors;
        String[] colorsArr;
        int sum = 0;
        try{
            File f = new File("input.txt");
            Scanner scnr = new Scanner(f);

            while(scnr.hasNextLine()){
                line = scnr.nextLine();
                game = line.split(":")[0];
                colors = line.split(":")[1];
                num = game.split(" ")[1];
                colorsArr=colors.split(";");
                if(!tooManyCubes(colorsArr)){
                    sum += Integer.parseInt(num);
                }
                System.out.println(game + ": " + tooManyCubes(colorsArr));
                
            }
            System.out.println(sum);        
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        
    }
}