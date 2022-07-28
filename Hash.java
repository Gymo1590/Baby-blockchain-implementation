 
 
import java.security.MessageDigest;
 
 

public class Hash {

    public static String hash_sha256(String msg){
   try {
    MessageDigest digest =MessageDigest.getInstance("SHA-256");
    byte[] myhash =digest.digest(msg.getBytes("UTF-8"));
    StringBuffer  hexa =new StringBuffer();
    for(int i=0; i <myhash.length; i++){

        String hexaCode = Integer.toHexString(0xff & myhash[i]);
        if(hexaCode.length() ==1 )hexa.append('0');
        hexa.append(hexaCode);
    }
    return hexa.toString();

   } catch (Exception e) {
   throw new RuntimeException(e);
   }    
	}

  
	
    
}
