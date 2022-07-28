import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.*;
public class babyBlockChain {
    

   public static  ArrayList<Block> block = new ArrayList<Block>();
   
 public  HashMap<Account,Integer> coinDb = new HashMap<Account,Integer>();
 ArrayList<Transaction> txDatabase;
 public int faucetVote=20;

 
   public static Boolean validateBlock(Block current, Block previous){
  
        for(int i=1;i<block.size();i++){
         current =block.get(i);
         previous =block.get(i-1);
          if (!current.hashOfBlock.equals(current.blockHash())){
             System.out.println("wrong hash");
                  return false;
            }
          if (!previous.hashOfBlock.equals(current.prevHash)){
             System.out.println("wrong hash");
                  return false;
           }

            	 }

         
    System.out.println("Block validated");
   return true;
}   

public static Block initBlock ( ){
  //genesis block
  

 
  Account init1 = new Account() ;
  Account init2 = new Account() ;
  PrivateKey priv = init1.voteWallet.getPrivate();
  byte[] msg= init1.ID.getBytes();
 byte[] sign = Signatures.GenerateSignature(msg, priv);
 init1.updateBalance(1);
 init2.updateBalance(1);
 Operation test = new Operation(init1, init2, 1, sign);
Operation initOp = test.createOperation();
 Transaction genTrans = new Transaction( );
 genTrans.ID = "0";
 genTrans.operation = initOp;
 
 genTrans.operations.add(0,  genTrans.operation);
 
Block genesisBlock = new Block("0");
genesisBlock.transactions.add(0,genTrans.createTransaction());

genesisBlock.hashOfBlock = genesisBlock.hashOfBlock;
   return genesisBlock.createBlock();
   
}


// public static void main(String[] args) {
 
//   Block b0= initBlock();
//   block.add(0, b0);

//   Block block1 = new Block(b0.hashOfBlock);
 
//   block.add(1, block1);
  
//   System.out.println(block.get(0).prevHash);
//   System.out.println( block.get(0).hashOfBlock);
//   System.out.println(block.get(1).prevHash ); System.out.println(block.get(1).hashOfBlock );
  
   
// }

}
