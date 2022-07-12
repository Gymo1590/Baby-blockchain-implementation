
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
public class Signatures {
    private static final String
        ALGO
        = "SHA256withRSA";

     static   keyPairs gymo = new keyPairs();
    public static byte[] GenerateSignature(
        byte[] input,
       PrivateKey key )
        throws Exception
    {
        key =gymo.keys().getPrivate();
        Signature signature
            = Signature.getInstance(
                ALGO); 
        signature.initSign( key);
        signature.update(input);
        return signature.sign();
    }
  
  
   
 
    public static boolean VerifySignature(
        byte[] input,
        byte[] signatureToVerify,
       PublicKey key)
        throws Exception
    {
        key = gymo.keys().getPublic();
        Signature signature
            = Signature.getInstance(
               ALGO);
        signature.initVerify( key);
        signature.update(input);
        return signature
            .verify(signatureToVerify);
    }
   
}

    
