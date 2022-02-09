import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class WordListHelper {

    static ArrayList<String> Words = new ArrayList<>();

    public static void init(){
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\ardad\\IdeaProjects\\Wordle\\src\\words.txt"));
            while (sc.hasNextLine()) {
                Words.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Collections.sort(Words);
    }





}
