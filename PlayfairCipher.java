import java.util.Scanner; 

public class PlayfairCipher {

 private static final char[][] MATRIX = new char[5][5];

 public static void main(String[] args) { 
 Scanner scanner = new Scanner(System.in);

 System.out.print("Enter the key: "); 
 String key = scanner.nextLine().toUpperCase(); 

 System.out.print("Enter the plaintext: ");
 String plaintext = scanner.nextLine().toUpperCase(); 

 key = key.replaceAll("J", "I");
 plaintext = plaintext.replaceAll("J", "I");
 String encryptedText = encrypt(plaintext, key);

 System.out.println("Encrypted Text: " + encryptedText); 
 System.out.println("Reference Table:");
 printMatrix();

 } 

 public static String encrypt(String plaintext, String key) { 
 generateMatrix(key);
 plaintext = preprocess(plaintext); 
 StringBuilder encryptedText = new StringBuilder(); 

 for (int i = 0; i < plaintext.length(); i += 2) {

 char first = plaintext.charAt(i);
 char second = (i + 1 < plaintext.length()) ? plaintext.charAt(i + 1) : 'X' ;
 int[] firstPos = findPosition(first);
 int[] secondPos = findPosition(second); 

 if (firstPos[0] == secondPos[0]) {

encryptedText.append(MATRIX[firstPos[0]][(firstPos[1] + 1) % 5]);
encryptedText.append(MATRIX[secondPos[0]][(secondPos[1] + 1) % 5]); 

 } 
 else if (firstPos[1] == secondPos[1]) {
encryptedText.append(MATRIX[(firstPos[0] + 1) % 5][firstPos[1]]);
encryptedText.append(MATRIX[(secondPos[0] + 1) % 5][secondPos[1]]); 

 }
  else {
encryptedText.append(MATRIX[firstPos[0]][secondPos[1]]); 
encryptedText.append(MATRIX[secondPos[0]][firstPos[1]]); 
 } 
 }

 return encryptedText.toString(); 
 } 
 private static void generateMatrix(String key) { 

 key = key.replaceAll("J", "I");

 String keyWithoutDuplicates = removeDuplicates(key + "ABCDEFGHIKLMNOPQRSTUVWXYZ");
 int index = 0; 
 for (int i = 0; i < 5; i++) {
 for (int j = 0; j < 5; j++) {
MATRIX[i][j] = keyWithoutDuplicates.charAt(index++); 
 } 
 } 
 } 
 private static void printMatrix() {
 for (int i = 0; i < 5; i++) {
 for (int j = 0; j < 5; j++) {
System.out.print(MATRIX[i][j] + " ");
 } 
 System.out.println(); 
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
    private static String preprocess(String text) {

    return text.replaceAll("[^a-zA-Z]", "").toUpperCase();
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