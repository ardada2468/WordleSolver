import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WordListHelper.init();

        GuessWord g = new GuessWord();

        //Index

        //TODO Build CLI UI

        g.doesContain(new Character[]{'c','a','e'});
        g.putIndex('c', 0);

        g.putWrongLetterPlacement('a', new int[]{1,2});
        g.putWrongLetterPlacement('e', new int[]{3,4});

        g.doesNotContain(new Character[]{'r','n','s'});

//        g.doesNotContain(new Character[]{'c','r','a','n'});
//        g.doesContain(new Character[]{'e','s','l'});
//        g.putIndex('e', 4);
//        g.putIndex('o', 1);
////        g.putIndex('r',1);
////        g.putIndex('n',3);
//        g.putWrongLetterPlacement('s', new int[]{2});
////        g.putWrongLetterPlacement('e', new int[]{0,4,1});
////        g.putWrongLetterPlacement('d', new int[]{3});


        //front
        //bring



        ArrayList<String>  words = g.getWord();
        System.out.println("Possible Words ::: " + words.size());

        System.out.println(words);


    }
}
