import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WordListHelper.init();

        GuessWord g = new GuessWord();

//        g.doesContain('r');
//        g.putWrongLetterPlacement('r', new int[]{1,2,0,3});
//        g.putWrongLetterPlacement('u', new int[]{2});
//        g.doesNotContain('c');
//        g.doesNotContain('a');
//        g.doesNotContain('n');
//        g.doesNotContain('e');
//        g.doesNotContain('a');
//        g.doesNotContain('y');
//        g.doesNotContain('l');
//        g.doesNotContain('f');
//        g.doesNotContain('i');
//        g.doesNotContain('t');
//        g.doesNotContain('s');
//        g.putPlacement('u',1);
//        g.doesNotContain('r');
//        g.doesNotContain('y');



//        Boolean x = GuessWord.wordContainsChars("stocks", new Character[]{'s', 't', 'o','k'});
//        Boolean y = GuessWord.containsRightIndex("Stock",new Character[]{'s', null, 'o', null, null});
//        System.out.println(x);
//        System.out.println(y);

        //stock

//        g.doesContain(new char[]{'r', 'a', 'n'});



        g.doesNotContain(new Character[]{'c','a','e','m','u'});
        g.doesContain(new Character[]{'r','n'});
        g.putIndex('o', 1);
        g.putIndex('n', 4);
        g.putWrongLetterPlacement('r', new int[]{1,2,3});
        g.putWrongLetterPlacement('n', new int[]{3});

        //front
        //bring



        ArrayList<String>  words = g.getWord();
        System.out.println("Possible Words ::: " + words.size());

        System.out.println(words);


    }
}
