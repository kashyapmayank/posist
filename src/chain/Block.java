package noobchain;

import java.util.Date;

public class Block {
	
	public String Value;
	public String previousHash; 
	private String data; //our data will be a simple message.
	private Date timeStamp; //as number of milliseconds since 1/1/1970.
	private int nodeNumer;
	private String nodeId;
	private String referenceNodeId;
	private String childReferenceNodeId;
	private String genesisReferenceNodeId;
	
	//Block Constructor.  
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}
	
	//Calculate new hash based on blocks contents
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				Integer.toString(nodeNumer) + 
				data+referenceNodeId+childReferenceNodeId+genesisReferenceNodeId
				);
		return calculatedhash;
	}
	
	//Increases nonce value until hash target is reached.
	public void mineBlock(int difficulty) {
		String target = StringUtil.getDificultyString(difficulty); //Create a string with difficulty * "0" 
		while(!hashValue.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block : " + hashValue);
	}
	
}
