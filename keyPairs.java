import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class keyPairs{
   static  PublicKey publicKey ;
 static   PrivateKey privKey ;
   public KeyPair keys() throws Exception{
    SecureRandom secureRandom
    = new SecureRandom();
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      keyPairGen.initialize(2048, secureRandom);  
      KeyPair pair = keyPairGen.generateKeyPair();
     return pair;
   }
  
 
     
}