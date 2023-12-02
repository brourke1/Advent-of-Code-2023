import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PowerOfCubes{
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


    public static int powerOfCubes(String[] cubeArr){
        int min_red = 0;
        int min_blue = 0;
        int min_green = 0;
        String[] colors;
        for(int i = 0; i < cubeArr.length; i++){
            colors = cubeArr[i].split(",");
            for(int j = 0; j < colors.length; j++){
                if(identifyColor(colors[j]) == Color.RED){
                    if(getDigits(colors[j]) > min_red){
                        min_red = getDigits(colors[j]);
                    }
                }
                if(identifyColor(colors[j]) == Color.BLUE){
                    if(getDigits(colors[j]) > min_blue){
                        min_blue = getDigits(colors[j]);
                    }
                }
                if(identifyColor(colors[j]) == Color.GREEN){
                    if(getDigits(colors[j]) > min_green){
                        min_green = getDigits(colors[j]);
                    }
                } 
            }
        }
        System.out.println(min_red + ", " + min_blue + ", " + min_green);
        return min_blue * min_green * min_red;
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
                System.out.print(game + ": ");
                //System.out.println(powerOfCubes(colorsArr));
                sum += powerOfCubes(colorsArr);
            }
            System.out.println("Sum: " + sum);        
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        
    }
}