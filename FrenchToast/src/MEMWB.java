
public class MEMWB {
	private static Register toBeWritten;
	private static int destReg;
	private static boolean RegWrite;

	public MEMWB() {
		this.toBeWritten = new Register("P_MEMWB toBeWritten", "stores data in MEMWB pipelined stage", "Specific");
	}

	public void transfer() {
		ControlUnit.getWriteB().setDestReg(this.destReg);
		ControlUnit.getWriteB().setToBeWritten(this.toBeWritten.data);
		ControlUnit.getWriteB().setRegWrite(this.RegWrite);
	}

	public static Register getToBeWritten() {
		return toBeWritten;
	}

	public static void setToBeWritten(Register toBeWritten) {
		MEMWB.toBeWritten = toBeWritten;
	}

	public static int getDestReg() {
		return destReg;
	}

	public static void setDestReg(int destReg) {
		MEMWB.destReg = destReg;
	}

	public static boolean isRegWrite() {
		return RegWrite;
	}

	public static void setRegWrite(boolean regWrite) {
		RegWrite = regWrite;
	}

}
