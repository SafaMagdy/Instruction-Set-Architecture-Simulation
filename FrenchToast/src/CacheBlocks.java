
public class CacheBlocks {
	public boolean validBit;
	public int tag;
	public int index;
	public String data;
	
	public CacheBlocks() {
		this.validBit = false;
		this.tag = 0;
		this.index = 0;
		this.data = "00000000000000000000000000000000";
	}

	public boolean isValidBit() {
		return validBit;
	}

	public void setValidBit(boolean validBit) {
		this.validBit = validBit;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
