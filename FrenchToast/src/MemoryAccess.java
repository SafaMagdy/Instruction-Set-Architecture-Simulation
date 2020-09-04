
public class MemoryAccess {
	private static String pc;
	private static String dataStored;
	private static int index;
	private static String toBeWritten;
	private static int destReg;
	private static boolean RegWrite;
	private static boolean MemRead;
	private static boolean MemWrite;
	private static boolean MemToReg;
	private static String rt_rd;
	private static String aluRes;

	public void MemAccess() {
		String memoryWordRead = "don't care";
		String RegWrite = "X";
		if (this.RegWrite) {
			RegWrite = "1";
		} else {
			RegWrite = "0";
		}
		String MemToReg = "X";
		if (this.MemToReg) {
			MemToReg = "1";
		} else {
			MemToReg = "0";
		}
		if (this.isMemWrite()) {
			// write in cache and data memory
			if (this.index < 1023) {
				ControlUnit.getDataMem().datablocks[this.index] = this.dataStored;
				ControlUnit.getCache().cacheWrite(this.index, this.dataStored);
				// System.out.println("The index where data should be stored at in the data
				// memory is: " + this.index);
				// System.out.println("the data stored is: " + this.dataStored);
			} else {
				System.out.println("the size of data memory is 1024 and the index needed exceeds the size");
			}

		} else if (this.isMemRead()) {
			String data = ControlUnit.getCache().cacheRead(this.index);
			this.toBeWritten = data;
			memoryWordRead = data;
		}
		System.out.println("ALU result: " + this.aluRes);
		System.out.println("memory word read: " + memoryWordRead);
		System.out.println("rt/rd field: " + this.rt_rd);
		System.out.println("WB controls: MemToReg: " + MemToReg + "," + " RegWrite: " + RegWrite);
		ControlUnit.getMemWritePip().setDestReg(this.destReg);
		ControlUnit.getMemWritePip().getToBeWritten().data = this.toBeWritten;
		ControlUnit.getMemWritePip().setRegWrite(this.RegWrite);

	}

	public static String getPc() {
		return pc;
	}

	public static void setPc(String pc) {
		MemoryAccess.pc = pc;
	}

	public static String getDataStored() {
		return dataStored;
	}

	public static void setDataStored(String dataStored) {
		MemoryAccess.dataStored = dataStored;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		MemoryAccess.index = index;
	}

	public static String getToBeWritten() {
		return toBeWritten;
	}

	public static void setToBeWritten(String toBeWritten) {
		MemoryAccess.toBeWritten = toBeWritten;
	}

	public static int getDestReg() {
		return destReg;
	}

	public static void setDestReg(int destReg) {
		MemoryAccess.destReg = destReg;
	}

	public static boolean isRegWrite() {
		return RegWrite;
	}

	public static void setRegWrite(boolean regWrite) {
		RegWrite = regWrite;
	}

	public static boolean isMemRead() {
		return MemRead;
	}

	public static void setMemRead(boolean memRead) {
		MemRead = memRead;
	}

	public static boolean isMemWrite() {
		return MemWrite;
	}

	public static void setMemWrite(boolean memWrite) {
		MemWrite = memWrite;
	}

	public static String getRt_rd() {
		return rt_rd;
	}

	public static void setRt_rd(String rt_rd) {
		MemoryAccess.rt_rd = rt_rd;
	}

	public static String getAluRes() {
		return aluRes;
	}

	public static void setAluRes(String aluRes) {
		MemoryAccess.aluRes = aluRes;
	}

	public static boolean isMemToReg() {
		return MemToReg;
	}

	public static void setMemToReg(boolean memToReg) {
		MemToReg = memToReg;
	}

}
