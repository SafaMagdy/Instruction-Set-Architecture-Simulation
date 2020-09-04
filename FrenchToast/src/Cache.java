
public class Cache {

	private static CacheBlocks[] blocks;

	public Cache() {
		this.blocks = new CacheBlocks[16];
		for (int i = 0; i < 16; i++) {
			this.blocks[i] = new CacheBlocks();
			this.blocks[i].index = i;
		}
	}

	public void cacheWrite(int memAddress, String data) {
		int ind = memAddress % 16;
		int ta = memAddress / 16;
		this.blocks[ind].data = data;
		this.blocks[ind].setValidBit(true);
	}

	public String cacheRead(int memAddress) {
		String result = "";
		int ind = memAddress % 16;
		int ta = memAddress / 16;
		if (this.blocks[ind].validBit && this.blocks[ind].tag == ta) {
			result = this.blocks[ind].data;
		}else {
			this.blocks[ind].setValidBit(true);
			this.blocks[ind].tag = ta;
			this.blocks[ind].data = ControlUnit.getDataMem().datablocks[memAddress];
		}
		return result;
	}

}
