

public class Main {
    public static void main(String[] args) {
        String message = "we found a treasure!";

        StringBuffer encryptedText = new StringBuffer();

        for(int i = 0; i<message.length(); i++){
            char c = message.charAt(i);

            if(c >='a' && c <= 'z'){
                encryptedText.append(funForEncrypt(c));

            }else{
                encryptedText.append(c);
            }
        }
        System.out.println(encryptedText);




    }
    private static char funForEncrypt(char letter){
        return (char)('a' + ('z'-letter));
    }

}
