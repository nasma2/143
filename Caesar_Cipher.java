import java.util.Scanner; 
public class Caesar_Cipher
 { public static StringBuffer encrypt(String text, int s) { 
    StringBuffer result = new StringBuffer(); 
    for (int i = 0; i < text.length(); i++) {
         char ch = text.charAt(i); 
         if (Character.isUpperCase(ch)) {
             ch = (char) (((int) ch + s - 65) % 26 + 65); 
            } else if (Character.isLowerCase(ch)) {
                 ch = (char) (((int) ch + s - 97) % 26 + 97); 
                } result.append(ch);
             }
              return result;
             }
              public static void main(String[] args) {
                 Scanner sc = new Scanner(System.in);
                  System.out.println("Enter the Text: ");
                   String text = sc.nextLine(); 
                   System.out.println("Enter the shift value: "); 
                   int s = sc.nextInt();
                    System.out.println("Text: " + text);
                     System.out.println("Shift: " + s); 
                     System.out.println("Cipher: " + encrypt(text, s)); 
                     sc.close(); 
                    } 
                }