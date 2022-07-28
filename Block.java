 

import java.util.ArrayList;
 

public class Block {
	
	public String hashOfBlock;
	public String prevHash; 
	
	public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
 
	public int nonce;
	public  Block( String previousHash){

		this.prevHash=previousHash;
	};	 
	public Block createBlock( ) {
		Block newBlock = new Block(prevHash);
	 if (blockVerify() == false){
	 }else{
		
		newBlock.transactions = transactions;
		newBlock.hashOfBlock = blockHash();
		newBlock.prevHash = prevHash;

	 }
		 
	 return  newBlock;

	 }
	 //this will verify  the block
     public Boolean blockVerify(){
    
		for(int j=0; j <this.transactions.size();j++){
	
					
			if((this.transactions == null )) {
		
			 System.out.println("cant add an empty transaction");
			 return false;
			 } 
			   else if( this.transactions.get(j).createTransaction()==null){
					System.out.println("empty transaction cant be added to the block!");
				return false;
	   
				 } 
				 else if(this.transactions.get(j).operation.sender.getBalance() ==0){
				   // sender can only have null or 1 vote value .if its zero means he/she already voted so the vote value was set to 0
				   return false;
				 }
				 else if(this.transactions.get(j).ID == this.transactions.get(j-1).ID){
	
				 System.out.println("Conflicting transactions!!");
				 return false;
				 }
			 }
		return true;
	   }





	public String blockHash() {
		nonce=2;
		String calculatedhash = Hash.hash_sha256( 
            prevHash +
				 transactions.get(0). toString()+
				Integer.toString(nonce) 
				 
				);
		return calculatedhash;
	}
}



 
