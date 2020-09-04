
public class DataMemory {

	String[] datablocks;

	public DataMemory() {
		this.datablocks = new String[1024];
		for (int i = 0; i < this.datablocks.length; i++) {
			this.datablocks[i] = "00000000000000000000000000000000";
		}
	}

}
