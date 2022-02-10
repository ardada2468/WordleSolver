/**
 * Built and Developed by Arnav Dadarya
 * Built and Developed by Arnav Dadarya
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GuessWord {
    Character[] IndexedWord = new Character[5];
    Character[] CharsInWord = new Character[5];
    ArrayList<Character> CharsNotInWord = new ArrayList<>();
    HashMap <Character, int[]> WrongPlaces = new HashMap<>();

    int index = 0;
    
    public GuessWord() {

    }

    public void doesContain(Character x){
        CharsInWord[index] = x;
        index++;
    }

    public void doesContain(Character[] x){

        for (int i = 0; i < x.length; i++) {
            CharsInWord[index] = x[i];
            index++;
        }

    }


    public void doesNotContain(Character x){
        CharsNotInWord.add(x);
    }

    public void doesNotContain(Character[] x){
        for (int i = 0; i < x.length; i++) {
            CharsNotInWord.add(x[i]);

        }
    }



    public void putIndex(Character x, int index){
        CharsInWord[this.index] = x;
        IndexedWord[index] = x;
        this.index++;
    }

    public void putWrongLetterPlacement(Character x, int[] index){
       WrongPlaces.put(x, index);
    }

    /**
     * Returns a boolean value depending on wether the word contains those values
     * @param Word the word we want to search
     * @param chars the chars we want to check for
     * @return
     */

    public static boolean wordContainsChars(String Word, Character[] chars){
        Boolean doesContain = false;

        for (int i = 0; i < getNotNullIndex(chars).length; i++) {
            doesContain =  Word.contains(chars[i].toString());
            if(!doesContain){
                return false;
            }
        }
        return doesContain;
    }

    /**
     * Returns a boolean value depending on wether a word contains correct letters in the wrong index
     * @param Word the word that we want to see contains the wrong indexed words
     * @return
     */


    public boolean wordContainsWrongIndexedChars(String Word){
        Boolean doesContain = false;

        for (int i = 0; i < WrongPlaces.size(); i++) {

            char x = (char) WrongPlaces.keySet().toArray()[i];

            for (int j = 0; j < WrongPlaces.get(x).length; j++) {
                doesContain = Word.toCharArray()[WrongPlaces.get(x)[j]] == x;
                if(doesContain){
                    return true;
                }
            }
        }

        return doesContain;
    }


    /**
     * Returns a boolean value depending on if a word has letters in the right indexes
     * @param Word the word that we want to see contains the right indexed words
     * @param chars the chars that we want to check for
     * @return
     */
    public static boolean containsRightIndex(String Word, Character[] chars){
        boolean rightIndex = true;
        for (int notNullIndex : getNotNullIndex(chars)) {
            rightIndex = Word.toCharArray()[notNullIndex] == chars[notNullIndex];
            if (!rightIndex){
                return false;
            }
//            System.out.println(Word.toCharArray()[notNullIndex] + " :: " + chars[notNullIndex]);
        }
        return rightIndex;
    }

    /**
     * Returns the Indexes of a array that are not null
     * @param chars the char[] that we want to find the not null indexes for
     * @return
     */

    public static int[] getNotNullIndex(Character[] chars){
        ArrayList<Integer> index = new ArrayList<Integer>();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != null) {
                index.add(i);
            }
        }
        int[] indexes = new int[index.size()];

//        System.out.println(index);
        for (int i = 0; i < index.size(); i++) {
            indexes[i] = index.get(i);
        }

        return indexes;
    }



    /**
     * Returns a Charachter array which contains the charachters that should not be in the word
     * @return
     */

    public Character[] getNoCharsArray(){
        Character[] chars = new Character[CharsNotInWord.size()];
        for (int i = 0; i < CharsNotInWord.size(); i++) {
            chars[i] = CharsNotInWord.get(i);
        }

        return chars;
    }

    /**
     * Checks to see if a word contains a letter that should not be in the word
     * @param letters
     * @param Word
     * @return
     */
    public static boolean cointainsWrongLetter(Character[] letters, String Word){
        boolean contains = false;
        for (int i = 0; i < letters.length; i++) {
            contains = Word.contains(letters[i].toString());
            if(contains){
                return true;
            }
        }
        return false;
    }


    /**
     * Returns the List of plausible words
     * @return
     */
    public ArrayList<String> getWord(){
        ArrayList<String> possibleWords = new ArrayList<>();
//        System.out.println(Arrays.toString(CharsInWord) + " ::  ");
        for (int i = 0; i < WordListHelper.Words.size(); i++) {

            String CurrentWord = WordListHelper.Words.get(i);

            Boolean doesContain = wordContainsChars(CurrentWord, CharsInWord);

            Boolean rightIndex = containsRightIndex(CurrentWord, IndexedWord);

            Boolean containsWrongIndexedChars = wordContainsWrongIndexedChars(CurrentWord);

            Boolean containsWrongChars = cointainsWrongLetter(getNoCharsArray(), CurrentWord);

            if((!containsWrongIndexedChars) && rightIndex && doesContain && (!containsWrongChars)){
                possibleWords.add(CurrentWord);
            }


        }
        getLetters(nullIndex(), possibleWords);
        System.out.println("Best Guess :: " + getBestWord(possibleWords));
        return possibleWords;
    }


    /**
     * Gets the null indexes in the array
     * @return
     */
    public int[] nullIndex(){
        ArrayList <Integer> Index = new ArrayList();
        for (int i = 0; i < IndexedWord.length; i++) {
            if(IndexedWord[i] == null){
                Index.add(i);
            }
        }

        int [] ints = new int[Index.size()];
        for (int i = 0; i < Index.size(); i++) {
            ints[i] = Index.get(i);
        }
        return ints;
    }


    /**
     * Gets the occurence of each letter in the unkown indexes
     * @param indexes
     * @param words
     * @return
     */
    public Map<Character, Integer> getLetters(int[] indexes, ArrayList<String > words){
        ArrayList<Character> chars = new ArrayList<>();
        Map<Character, Integer> Occurence = new HashMap<>();

        for (int i = 0; i < words.size(); i++) {

            String word = words.get(i);
            Character[] characters = new Character[indexes.length];

            for (int k = 0; k < indexes.length; k++) {
                characters[k] = word.toCharArray()[indexes[k]];
                if(Occurence.get(characters[k]) == null){
                    Occurence.put(characters[k],1);
                }else {
                    Occurence.put(characters[k], Occurence.get(characters[k])+1);
                }
            }

        }

        for (int i = 0; i < CharsInWord.length; i++) {
            if(Occurence.containsKey(CharsInWord[i])){
                Occurence.remove(CharsInWord[i]);
            }
        }

        System.out.println(Occurence);
        return Occurence;
    }

    public String getBestWord(ArrayList<String> Letters) {
        Map<Character, Integer> chars = getLetters(nullIndex(), Letters);
        int highScore = 0;
        String highScoreWord = "";

        for (int i = 0; i < Letters.size(); i++) {
            String Word = Letters.get(i);
            char[] wordArr = Word.toCharArray();
            int score = 0;
            for (char c : wordArr) {
                if (chars.get(c) != null) {
                    score += chars.get(c);
                }
            }
            if (highScore < score) {
                highScore = score;
                highScoreWord = Word;
            }
        }

        System.out.println("High Score --> " + highScoreWord + " :: " + highScore);
        return highScoreWord;


    }



}
