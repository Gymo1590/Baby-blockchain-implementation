 

import java.util.ArrayList;
 

public class Block {
	
	public String hashOfBlock;
	public String prevHash; 
	
	public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
 
	public int nonce;
	public  Block( String previousHash ){
       
		this.prevHash=previousHash;
	};	 
	public Block createBlock(   ) {
		Block newBlock = new Block(prevHash );
	 if (blockVerify() == false){
		System.out.println("failed block verification");
        return null;
		
	 }else{
		
		newBlock.hashOfBlock = blockHash();
		newBlock.prevHash = prevHash;

	 }
		//  System.out.println("check block cretaio" +newBlock==null);
	 return  newBlock;

	 }


	 //this will verify  the block
     public Boolean blockVerify(){
    
		for(int j=0; j <this.transactions.size();j++){
	
					
			if((this.transactions == null )) {
		
			 System.out.println("cant add an empty transaction");
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



 
