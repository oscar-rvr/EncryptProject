import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//valores predeterminados
        String mode = "enc";
        int key = 0;
        String data = "";
        String outFile=null;
        //Revisar los argumentos del  arreglo args[]

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];//Si  encontramos -mode el siguiente argumento es el modo
            } else if (args[i].equals("-key")) {
                try {
                    key = Integer.parseInt(args[i + 1]);


                } catch (NumberFormatException e) {
                    System.out.println("Error: key value must be a number");
                    return;
                }
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
            }else if(args[i].equals("-in") && data.isEmpty()){
                //espeeramos leer el archivo
                data=readFromFile(args[i+1]);
                System.out.println(data);
                if(data  ==  null){
                    System.out.println("Error; input file does not exist");
                    return;

                }
            }else if(args[i].equals("-out")){
                outFile=args[i+1];
            }
        }
        if(data.isEmpty() && outFile == null){
            System.out.println("Error; no input data provided or filename");
            return;
        }









            if(mode.equals("enc") || mode.equals("dec")){



                StringBuilder ciphertext =   new StringBuilder();
                ciphertext=processMessage(data,key, mode.equals("enc"));



                if(outFile!=null){
                    writeToFile(outFile,ciphertext.toString());
                }else{
                    System.out.println(ciphertext);
                }
            }












    }
    private static char funEncryptLetter ( char letter,int key){
        return (char) ('a' + (letter - 'a' + key)%26);
    }

    private static char funDecryptLetter(char letter, int key){
        return (char) ('a' +(letter  -  'a' - key + 26 )%26);
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

    private static String readFromFile(String filename){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder content = new StringBuilder();
            String line;
            while((line =reader.readLine()) != null){
                content.append(line).append("\n");
            }
            reader.close();
            return content.toString();
        }catch (IOException e){
            return null;
        }
    }

    private static void writeToFile(String filename ,String content){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error: unable to write to file-> "+filename);
        }
    }
}

