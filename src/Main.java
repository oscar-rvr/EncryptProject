
import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String target = "";
        String message = "";
        int key;



        target = scan.nextLine();



        message = scan.nextLine();
        key = scan.nextInt();
        scan.nextLine();

        StringBuilder ciphertext = new StringBuilder();
        ciphertext = processMessage(message, key, target.equals("enc"));


        System.out.println(ciphertext);






    }

    private static char funEncryptLetter(char letter, int key) {
        return (char) ('a' + (letter - 'a' + key) );
    }

    private static char funDecryptLetter(char letter, int key) {
        return (char) ('a' + (letter - 'a' - key));
    }

    private static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static StringBuilder processMessage(String message, int key, boolean isEncrypt) {
        StringBuilder resultText = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            char proccessedChar;
            if (isEncrypt) {
                proccessedChar = funEncryptLetter(c, key);
            } else {
                proccessedChar = funDecryptLetter(c, key);
            }
            resultText.append(proccessedChar);

        }
        return resultText;
    }

}