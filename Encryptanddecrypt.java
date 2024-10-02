import java.util.*; 
public class Encryptanddecrypt { 
int numRails; 
public Encryptanddecrypt(int numRails) { 
this.numRails = numRails; 
} 
String getDecryptedData(String data) { 
char[] decrypted = new char[data.length()]; 
int n = 0; 
for (int k = 0; k < numRails; k++) { 
int index = k; 
boolean down = true; 
while (index < data.length()) { 
// System.out.println(k + " " + index+ " "+ n ); 
decrypted[index] = data.charAt(n++); 
if (k == 0 || k == numRails - 1) { 
index = index + 2 * (numRails - 1); 
} else if (down) { 
index = index + 2 * (numRails - k - 1); 
down = !down; 
} else { 
index = index + 2 * k; 
down = !down; 
} 
} 
} 
return new String(decrypted); 
} 
String getEncryptedData(String data) { 
char[] encrypted = new char[data.length()]; 
int n = 0; 
for (int k = 0; k < numRails; k++) { 
int index = k; 
boolean down = true; 
while (index < data.length()) { 
// System.out.println(k + " " + index+ " "+ n ); 
encrypted[n++] = data.charAt(index); 
if (k == 0 || k == numRails - 1) { 
index = index + 2 * (numRails - 1);
 
} else if (down) { 
index = index + 2 * (numRails - k - 1); 
down = !down; 
} else { 
index = index + 2 * k; 
down = !down; 
} 
} 
} 
return new String(encrypted); 
} 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
 
// Get text input from the user 
System.out.print("Enter the text to encrypt: "); 
String data = sc.nextLine(); 
// Get the number of rails from the user 
System.out.print("Enter the number of rails: "); 
int numRails = sc.nextInt(); 
Encryptanddecrypt railFenceCipher = new Encryptanddecrypt(numRails); 
String encrypted = railFenceCipher.getEncryptedData(data); 
System.out.println("Encrypted Text: " + encrypted); 
String decrypted = railFenceCipher.getDecryptedData(encrypted); 
System.out.println("Decrypted Text: " + decrypted); 
} 
}
