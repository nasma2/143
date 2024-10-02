import java.util.*;
 public class Railfence_cipher{
 public static void main(String[]args){ 
Scanner scn=new Scanner(System.in); 
System.out.println("enter the text :"); 
String plaintext=scn.nextLine(); 
System.out.println("enter the key :"); 
int numrails=scn.nextInt(); 
String encryptedText=getEncryptedData(plaintext, numrails); 
System.out.println("encrypted text :"+encryptedText); 
} 
static String getEncryptedData(String data,int numrails)
{ 
char[]encryptedText=new char[data.length()]; 
int n=0; 
for(int k=0;k<numrails;k++){ 
int index=k; 
boolean down=true; 
while(index<data.length()){ 
encryptedText[n++]=data.charAt(index); 
if(k==0 || k==numrails-1){ index+=2*(numrails-1); 
} 
else if(down){
index+=2*(numrails-k-1);
down=!down;
} 
else{ index+=2*k;
down=!down; 
}

}

}
return new String(encryptedText);
}
}