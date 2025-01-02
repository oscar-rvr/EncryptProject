
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
