package babyblockchain;

import java.security.KeyPair;

public class Account{

  int balance =1;
  String ID;
  KeyPair voteWallet;
  // in my case ,i don't really need a list of wallet address , i only need one because u can only vote once ,only one transaction that sends one vote to the candidate
  keyPairs template = new keyPairs();
 void getAccount(){

  try {
    voteWallet = template.keys();
  } catch (Exception e) {
  System.out.println("Unknown error has ccured");
  }

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
