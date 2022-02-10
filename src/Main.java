import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WordListHelper.init();

        GuessWord g = new GuessWord();

        //Index

        //TODO Build CLI UI

        g.doesNotContain(new Character[]{'c','r','a', 's','o','w'});
        g.doesContain(new Character[]{'n','e','d'});
//        g.putIndex('o', 1);
//        g.putIndex('n', 4);
        g.putIndex('n',1);
        g.putIndex('d',2);
        g.putWrongLetterPlacement('n', new int[]{3,2});
        g.putWrongLetterPlacement('e', new int[]{0,4,1});
        g.putWrongLetterPlacement('d', new int[]{3});


        //front
        //bring



        ArrayList<String>  words = g.getWord();
        System.out.println("Possible Words ::: " + words.size());

        System.out.println(words);


    }
}
