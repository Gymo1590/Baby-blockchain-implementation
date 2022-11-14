 
import java.security.KeyPair;
import java.security.PrivateKey;
public class Account{

 private int vote;
KeyPair voteWallet = keyPairs.keys();
String ID = calculateHash();
 
 public void updateBalance(int balance) {
 this.vote =balance;
}
public int getBalance() {
    return vote;
}

public static byte[] signData(PrivateKey key, String msg)  {
	
	return   Signatures.GenerateSignature( msg.getBytes(), key);

}

private  String calculateHash(){
   String value = "";
	try {
		value = Hash.hash_sha256(
				voteWallet.getPublic().toString()
					);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return value;
}
 
}
