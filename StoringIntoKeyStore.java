import java.io.FileOutputStream; 
import java.security.KeyStore;

import javax.crypto.SecretKey; 
import javax.crypto.spec.SecretKeySpec;

public class StoringIntoKeyStore {
     public static void main(String[] args)throws Exception {
         //create a new keyStore object 
         KeyStore keyStore = KeyStore.getInstance("JCEKS");
          keyStore.load(null, null); //No existing keystore, intial keystore, initial empty
           //Creating yje SecretKey object
            SecretKey mySecretKey = new 
            SecretKeySpec("myPassword".getBytes(),"DSA");
             //creating SecretKeyEntry with password protection
              KeyStore.ProtectionParameter protectionParam = new
               KeyStore.PasswordProtection("changeit".toCharArray()); 
               KeyStore.SecretKeyEntry secretKeyEntry = new
                KeyStore.SecretKeyEntry(mySecretKey); 
                //custom path for thee keystore file
                 String keystoreFilePath =
                  "C:\\Users\\Nasma\\Desktop\\Key_KeyStore\\Key.jceks";
                   //adding file name
                    //adding the secret key entry to key store
                     keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam); 
                     //store the keystore to the custom file path 
                     FileOutputStream fos = new FileOutputStream(keystoreFilePath);
                      keyStore.store(fos, "changeit".toCharArray());
                       System.out.println("Secret key stored in "+ keystoreFilePath); 
                    }
                 }