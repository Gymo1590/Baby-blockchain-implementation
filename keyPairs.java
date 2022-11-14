import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class keyPairs{
   static  PublicKey publicKey ;
 static   PrivateKey privKey ;
   public static KeyPair keys()  {
    SecureRandom secureRandom
    = new SecureRandom();
      KeyPairGenerator keyPairGen;
      KeyPair pair = null;
      try {
        keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048, secureRandom); 
         pair = keyPairGen.generateKeyPair();
      } catch (NoSuchAlgorithmException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
     return pair;
   }
  
 
     
}
