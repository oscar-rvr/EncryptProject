import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//Original message
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        int key = scan.nextInt();
        //Stringbuilder for create cipherText;
        StringBuilder ciphertext =   new StringBuilder();

        for (int i  = 0; i<message.length();  i++){
            char c = message.charAt(i);

            //validation of lowercase letters
            if(c>= 'a' && c<= 'z'){
                char encryptedChar = funEncryptLetter(c,key);
                ciphertext.append(encryptedChar);//add cipher letter
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