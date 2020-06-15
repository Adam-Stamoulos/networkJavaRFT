package structures;
import java.io.Serializable;

import types.FrameType;

public class Segment implements Serializable{

	// int size; //size of the payload
	int sq; // sequence number
	FrameType type; // segment type
	String payload; // data
	public int getSq() {
		return sq;
	}

	public void setSq(int sq) {
		this.sq = sq;
	}

	public FrameType getType() {
		return type;
	}

	public void setType(FrameType type) {
		this.type = type;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getChecksum() {
		return checksum;
	}

	public void setChecksum(int checksum) {
		this.checksum = checksum;
	}

	int last; // last segment?
	int checksum; // checksum

	public Segment(int sq, FrameType type, String payload, int last, int checksum) {

		this.sq = sq;
		this.type = type;
		this.payload = payload;
		this.last = last;
		this.checksum = checksum;

	};
	
	public Segment(int sq, FrameType type, int last) {

		this.sq = sq;
		this.type = type;
		this.last = last;

	};
	
	public int generateCSum() {
		
		return 0;
		
	}

}
