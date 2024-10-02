import java.util.*; 
public class Railfence_cipher_decrypt{ 
public static void main(String[]args){ 
Scanner scn=new Scanner(System.in); 
System.out.println("enter encrypted data:"); 
String encryptedData=scn.nextLine(); 
System.out.println("enter the number of rails:"); 
int numrails=scn.nextInt(); 
String decryptedData=getdecryptedData(encryptedData,numrails); 
System.out.println("decrypted data :"+ decryptedData); 
} 
static String getdecryptedData(String data ,int numrails){ 
char[]decryptedData=new char[data.length()]; 
int n=0; 
for(int k=0;k<numrails;k++){ int index=k; 
boolean down=true; 
while(index<data.length()){ 
decryptedData[index]=data.charAt(n++); 
if(k== 0|| k==numrails-1){ index+=2*(numrails-1);
 }
  else if(down){ index+=2*(numrails-k-1); 
down=!down; 
} 
else{ index+=2*k;
 down=!down;
 } 
} 

}

 return new String(decryptedData);
 }

}