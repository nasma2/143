import java.util.Scanner; 

public class PlayfairCipherDecryption{ 

 private static final char[][] MATRIX = new char[5][5];
 public static void main(String[] args) { 

 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter the key: "); 
 String key = scanner.nextLine().toUpperCase(); 

 
 key = key.replaceAll("J", "I");
 System.out.print("Enter the ciphertext: ");
 String ciphertext = scanner.nextLine().toUpperCase(); 

 String decryptedText = decrypt(ciphertext, key); 
 System.out.println("Decrypted Text: " + decryptedText); 
 System.out.println("Reference Table:");

 printMatrix();
 } 
 public static String decrypt(String ciphertext, String key) { 
 generateMatrix(key);

 StringBuilder decryptedText = new StringBuilder(); 

 for (int i = 0; i < ciphertext.length(); i += 2) {

 char first = ciphertext.charAt(i);
 char second = ciphertext.charAt(i + 1);
 int[] firstPos = findPosition(first);
 int[] secondPos = findPosition(second); 

 if (firstPos[0] == secondPos[0]) {
decryptedText.append(MATRIX[firstPos[0]][(firstPos[1] + 4) % 5]);
decryptedText.append(MATRIX[secondPos[0]][(secondPos[1] + 4) % 5]); 
 }
  else if (firstPos[1] == secondPos[1]) {
decryptedText.append(MATRIX[(firstPos[0] + 4) % 5][firstPos[1]]);
decryptedText.append(MATRIX[(secondPos[0] + 4) % 5][secondPos[1]]); 
 }
  else {
decryptedText.append(MATRIX[firstPos[0]][secondPos[1]]); 
decryptedText.append(MATRIX[secondPos[0]][firstPos[1]]); 
 } 

 } 

 return decryptedText.toString(); 
 } 
 private static void generateMatrix(String key) { 
 String keyWithoutDuplicates = removeDuplicates(key.replaceAll("J", "I") + "ABCDEFGHIKLMNOPQRSTUVWXYZ");

 int index = 0;

 for (int i = 0; i < 5; i++) {

    for (int j = 0; j < 5; j++) {

   MATRIX[i][j] = keyWithoutDuplicates.charAt(index++); 
    } 
    } 
    } 

    private static String removeDuplicates(String input) {

    StringBuilder result = new StringBuilder(); 

    for (int i = 0; i < input.length(); i++) {

    char c = input.charAt(i); 
    if (result.indexOf(String.valueOf(c)) == -1) {
   result.append(c); 
    } 

    } 
    return result.toString(); 
    } 
    private static void printMatrix() {
    for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
   System.out.print(MATRIX[i][j] + " ");
    } 
    System.out.println(); 
    } 

    } 
    private static int[] findPosition(char c) {
    int[] position = new int[2]; 

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
       if (MATRIX[i][j] == c) {
       position[0] = i; 
       position[1] = j; 
       return position; 
       } 
        } 
        } 
        return position; 
        } 
       }



       
   
