import java.util.ArrayList;

public class Transaction{
	static public String ID;  
	static public  int nonce;
	ArrayList <Operation> operations = new  ArrayList<Operation>();
	Operation operation;
	 
	public Transaction createTransaction(  ) {
		nonce=0;
		if(operation == null ) {
			 System.out.println("Null operation object");
				return null;
		 
		} else{
        nonce++;
		 operations.add(operation);
		 Transaction transaction =new Transaction();
		 ID= Hash.hash_sha256( Integer.toString(nonce) + operation );
			return transaction;
		}
		 
	
	}
}
