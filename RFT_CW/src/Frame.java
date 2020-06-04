
public class Frame {

	// int size; //size of the payload
	int sq; // sequence number
	FrameType type; // segment type
	String payload; // data
	int last; // last segment?
	int checksum; // checksum

	public Frame(int sq, FrameType type, String payload, int last, int checksum) {

		this.sq = sq;
		this.type = type;
		this.payload = payload;
		this.last = last;
		this.checksum = checksum;

	};
	
	public Frame(int sq, FrameType type, int last) {

		this.sq = sq;
		this.type = type;
		this.last = last;

	};
	
	public int generateCSum() {
		
		return 0;
		
	}

}
