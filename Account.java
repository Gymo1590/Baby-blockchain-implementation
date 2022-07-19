package babyblockchain;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Account{

 private int balance =1;
  String ID ;
  KeyPair voteWallet;
  // in my case ,i don't really need a list of wallet address , i only need one because u can only vote once ,only one transaction that sends one vote to the candidate
  keyPairs template = new keyPairs();
 KeyPair getAccount(){

  try {
    voteWallet = template.keys();
 
  } catch (Exception e) {
  System.out.println("Unknown error has ccured");
  }
  return voteWallet;
 }

 public int updateSendBalance(int balance) {
    return this.balance - balance;
 }
 public int updateReceiveBalance(int balance) {
  return this.balance + balance;
}
public int getBalance() {
    return balance;
}
public byte[] signData()  {
	ID=Hash.hash_sha256(getAccount().getPublic().toString()+Integer.toString(balance));
	  Signatures tempo = new Signatures();
	return   tempo.GenerateSignature( ID.getBytes(), getAccount().getPrivate());
	
	
	
	
}

 
}
