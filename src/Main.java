import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {

//        GuessWord g = new GuessWord();

        //Index

        //TODO Build CLI UI
//        long previousTime = System.currentTimeMillis();
//
////        g.doesContain(new Character[]{'c','a','e'});
////        g.putIndex('c', 0);
////
////        g.putWrongLetterPlacement('a', new int[]{1,2});
////        g.putWrongLetterPlacement('e', new int[]{3,4});
//
//        g.doesContain(new Character[]{});
//        g.putIndex('a',2);
//        g.putIndex('e',4);
//        g.putIndex('s', 3);
//        g.doesNotContain(new Character[]{'c','r','n','l','t','p','h'});
//        g.putWrongLetterPlacement('s', new int[]{0});
//
//
//
//
//
//        ArrayList<String>  words = g.getWord();
//        System.out.println("Possible Words ::: " + words.size());
//        System.out.println(words);
//
//
//        long currentTime = System.currentTimeMillis();
//        double elapsedTime = (currentTime - previousTime) / 1000.0;
//        System.out.println("Time in seconds :: " + elapsedTime);

        WordListHelper.init();

        Scanner sc  = new Scanner(System.in);
        boolean run = true;
        GuessWord guesser = new GuessWord();
        println("Welcome to Wordle Solver :: Built by Arnav Dadarya");

        while (run){
            println("Enter a the guess in the format :: {c,r,a,n,e} : {b,g,y,g,y}");
            print("Input: ");
            String input = sc.nextLine();
            if(input == "reset"){
                guesser = new GuessWord();
                println("Reset Sucessfull");
                break;
            }
            String[] splitStr = input.replace("{","").replace("}", "").split(":");
            println(Arrays.toString(splitStr));

            long prev = System.currentTimeMillis();
            String[] Letters = splitStr[0].split(",");
            String[] Color = splitStr[1].split(",");

            println(Arrays.toString(Letters));
            println(Arrays.toString(Color));
//{c,r,a,n,e}:{b,y,y,b,b}
            for (int i = 0; i < Color.length; i++) {
                String CurrentColor = Color[i];
                Character letter = Letters[i].toCharArray()[0];
//                println(CurrentColor);
                if(CurrentColor.equals("b")){
                    guesser.doesNotContain(letter);
                    println(letter + " :: is not contained");
                }else if(CurrentColor.equals("y")){
                    guesser.doesContain(letter);
                    guesser.putWrongLetterPlacement(letter,new int[]{i});
                    println(letter + " :: is wrongly Placed");
                }else if(CurrentColor.equals("g")){
                    guesser.putIndex(letter, i);
                    println(letter + " :: is right");

                }else {
                    System.out.println("Error");
                }
            }

            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<String> x = guesser.getWord();
            double elapsed = (currentTimeMillis - prev) / 1000.0;
            System.out.println("Time in seconds :: " + elapsed);
//            System.out.println(guesser.getBestWord(x));

        }


    }

    public  static void print(String x){
        System.out.print(x);
    }

    public static void println(String x){
        System.out.println(x);
    }


}
