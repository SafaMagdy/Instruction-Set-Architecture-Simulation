
public class EXMEM {
	private static String pc;
	private static Register dataStored;
	private static int index;
	private static Register toBeWritten;
	private static int destReg;
	private static boolean RegWrite;
	private static boolean MemRead;
	private static boolean MemWrite;
	private static boolean MemToReg;
	private static String rt_rd;
	private static String aluRes;

	public EXMEM() {
		this.dataStored = new Register("P_EXMEM dataStored", "stores data in EXMEM pipelined stage", "Specific");
		this.toBeWritten = new Register("P_EXMEM toBeWritten", "stores data in EXMEM pipelined stage", "Specific");
	}

	public void transfer() {
		ControlUnit.getMemAccess().setDataStored(this.dataStored.data);
		ControlUnit.getMemAccess().setPc(this.pc);
		ControlUnit.getMemAccess().setIndex(this.index);
		ControlUnit.getMemAccess().setToBeWritten(this.toBeWritten.data);
		ControlUnit.getMemAccess().setDestReg(this.destReg);
		ControlUnit.getMemAccess().setMemRead(this.MemRead);
		ControlUnit.getMemAccess().setMemWrite(this.MemWrite);
		ControlUnit.getMemAccess().setRegWrite(this.RegWrite);
		ControlUnit.getMemAccess().setMemToReg(this.MemToReg);
		ControlUnit.getMemAccess().setRt_rd(this.rt_rd);
		ControlUnit.getMemAccess().setAluRes(this.aluRes);

	}

	public static String getPc() {
		return pc;
	}

	public static void setPc(String pc) {
		EXMEM.pc = pc;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		EXMEM.index = index;
	}

	public static int getDestReg() {
		return destReg;
	}

	public static void setDestReg(int destReg) {
		EXMEM.destReg = destReg;
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

	public static Register getDataStored() {
		return dataStored;
	}

	public static void setDataStored(Register dataStored) {
		EXMEM.dataStored = dataStored;
	}

	public static Register getToBeWritten() {
		return toBeWritten;
	}

	public static void setToBeWritten(Register toBeWritten) {
		EXMEM.toBeWritten = toBeWritten;
	}

	public static String getRt_rd() {
		return rt_rd;
	}

	public static void setRt_rd(String rt_rd) {
		EXMEM.rt_rd = rt_rd;
	}

	public static String getAluRes() {
		return aluRes;
	}

	public static void setAluRes(String aluRes) {
		EXMEM.aluRes = aluRes;
	}

	public static boolean isMemToReg() {
		return MemToReg;
	}

	public static void setMemToReg(boolean memToReg) {
		MemToReg = memToReg;
	}

}
