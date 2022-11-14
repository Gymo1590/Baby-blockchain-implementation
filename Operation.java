  
 
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Base64;

public class Operation{
	public Account sender;  
	public Account reciepient; 
	public int vote; 
	public byte[] signature; 
	PublicKey pubkey ;
	PublicKey candPubkey;
	byte[] msg;
	 
	public Operation(Account voter, Account candidate, int vote,  byte[] signature) {
		this.sender = voter;
		this.reciepient =candidate;
		this.vote = vote;
		this.signature = signature;
        this.msg = voter.ID.getBytes();
		this.candPubkey=candidate.voteWallet.getPublic();
		this.pubkey=voter.voteWallet.getPublic();
		
	}
	 
	// in the main java method we will create a signature using voter privatekey and also we will set the value of the vote to 1 for testing purposes

   public Operation createOperation(){
    if(!verifyOperation() == true){
    
	System.out.println("Operation failed");
   

	return null;

	}else{
       
	  int remainder=	sender.getBalance() -vote;
	  reciepient.updateBalance(vote);
	  sender.updateBalance(remainder);
      Operation output = new Operation(this.sender, this.reciepient, vote, signature);
      
	  System.out.println(output);

		return output;

	}
	
   }
	public boolean verifyOperation() {
		boolean verify = Signatures.VerifySignature(msg, signature, pubkey);
		if(verify==false){
         System.out.println("verification failed, cannot vote!!");
          return false;
		}
		if(sender.getBalance() <1 || sender.getBalance()>1){
          System.out.println("Invalid account value");
		  System.out.println(sender.getBalance() );
		  return false;
		}
		if(vote<1 || vote>1){
			System.out.println("Invalid vote");
			return false;
		}
		return true;

}
}
 
