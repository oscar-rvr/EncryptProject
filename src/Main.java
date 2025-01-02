
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        int key = scan.nextInt();

        StringBuilder ciphertext =   new StringBuilder();

        for (int i  = 0; i<message.length();  i++){
            char c = message.charAt(i);


            if(c>= 'a' && c<= 'z'){
                char encryptedChar = funEncryptLetter(c,key);
                ciphertext.append(encryptedChar);
            }else{
                ciphertext.append(c);
            }


        }


        System.out.println(ciphertext);

    }
    private static char funEncryptLetter ( char letter,int key){
        return (char) ('a' + (letter - 'a' + key)%26);
    }

}