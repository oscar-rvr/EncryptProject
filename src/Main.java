import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//Original message
        Scanner scan = new Scanner(System.in);
        String target="";
        String message="";
        int key;


        while(true){
            target=scan.nextLine();

            if(target.equals("enc") || target.equals("dec")){

                message = scan.nextLine();
                key = scan.nextInt();
                scan.nextLine();
                //Stringbuilder for create cipherText;
                StringBuilder ciphertext =   new StringBuilder();
                ciphertext=processMessage(message,key, target.equals("enc"));


                System.out.println(ciphertext);
            }



        }







    }
    private static char funEncryptLetter ( char letter,int key){
        return (char) ('a' + (letter - 'a' + key)%26);
    }

    private static char funDecryptLetter(char letter, int key){
        return (char) ('a' +(letter  -  'a' - key)%26);
    }
    private static boolean isLowerCase(char c){
        return c>= 'a' && c<='z';
    }

    private static StringBuilder processMessage(String message, int key, boolean isEncrypt){
        StringBuilder resultText = new StringBuilder();
        for(int i = 0; i<message.length(); i++){
            char c = message.charAt(i);
            if(isLowerCase(c)){
                char proccessedChar;
                        if(isEncrypt){
                            proccessedChar=funEncryptLetter(c,key);
                        }else{
                            proccessedChar=funDecryptLetter(c,key);
                        }
                        resultText.append(proccessedChar);
            }else{
                resultText.append(c);
            }
        }
        return resultText;
    }

}