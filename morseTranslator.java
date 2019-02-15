import java.util.Scanner;
public class morseTranslator
{
    static Scanner in = new Scanner(System.in);
// to store word collection which can be accessed by all methods. Static helps make it usable by all easily
    static String [] wordsCollection = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0"};
// to store morse code collection which can be accessed by all methods. Static helps make it usable by all easily
    static String[] morseCollection = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.","....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
            ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};
// to convert from morse code too word
    public  static String morseToWord(String morse)
    {
        String toWord = "";
        String []temp = morse.split("   ");// to remove spaces and store in a string array
        for(String blah : temp) {
            for(String blah2 : blah.split(" ")) {
                    for (int n = 0; n < morseCollection.length; n++)
                    {
                        if (blah2.equals(morseCollection[n])) {
                            // the method equals is better to use than == (which wont work properly).
                            toWord += wordsCollection[n];// store data
                        }
                    }
            }
            toWord += " ";// to create space for next word
        }
        return toWord;
    }
// to convert from english to morse code
    public static String WordToMorse(String word)
    {
        String toMorse = "";
        String []temp = word.split(" ");// done to remove all spaces between a sentence and
        // store all words in string arrays for easier acccess
        for(String blah : temp)
        {
            for(int f = 0;f < blah.length();f++) {
                for (int n = 0; n < morseCollection.length; n++) {
                    if (blah.substring(f, f + 1).equals(wordsCollection[n])){
                        // you could convert the string to char and then compare it instead of using substring
                        // but both would get same results and it just adds another statement for the application to execute
                        // could also use equalsIgnoreCase but i already converted everything to lower case
                        toMorse += morseCollection[n]+" ";// store data
                    }
                }
            }
            toMorse += "   ";// to create proper space for next morse code word
        }
        return toMorse;
    }

    public static void main(String[] args)
    {
        String temp;// is used to convert the english sentence to lower case
        String word;
        String morse;
        System.out.println("Please enter a sentence to be converted into Morse Code: ");
        temp = in.nextLine();
        word = temp.toLowerCase();
        String d = WordToMorse(word);// done to store result can also just use print method and not store it anywhere
        System.out.println(d);
        System.out.println("Please enter a morse code(use 3 spaces for next word): ");
        morse = in.nextLine();
        String z = morseToWord(morse);// done to store result can also just use print method and not store it anywhere
        System.out.println(z);
    }
}
