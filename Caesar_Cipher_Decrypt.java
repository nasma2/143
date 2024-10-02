import java.util.*; public class Caesar_Cipher_Decrypt{
     public static void main(String[] args) { 
Scanner sc = new Scanner(System.in);
 System.out.println("Input the ciphertext message:");
 String ciphertext = sc.nextLine();
 System.out.println("Enter the shift value:");
 int shift = sc.nextInt(); 
String decryptMessage = "";
 char alphabet;
 for (int i = 0; i < ciphertext.length(); i++) {
 alphabet = ciphertext.charAt(i); 
 if (alphabet >= 'a' && alphabet <= 'z') {
 alphabet = (char) (alphabet - shift);
 if (alphabet < 'a') {
 alphabet = (char) (alphabet + 'z' - 'a' + 1);
 }
  decryptMessage = decryptMessage + alphabet; 
}
 else if (alphabet >= 'A' && alphabet <= 'Z') {
alphabet = (char) (alphabet - shift); 
if (alphabet < 'A') {
 alphabet = (char) (alphabet + 'Z' - 'A' + 1); 
}
 decryptMessage = decryptMessage + alphabet; 
} 
else {
 decryptMessage = decryptMessage + alphabet;
 }
 
 
}
 System.out.println("Decrypted message: " + decryptMessage);


}

 }
