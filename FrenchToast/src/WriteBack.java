
public class WriteBack {

	private static String toBeWritten;
	private static int destReg;
	private static boolean RegWrite;

	public void WriteBack() {
		if (this.isRegWrite()) {
			if (this.destReg == 0) {
				System.out.println("The register with index 0 is reserved for only having the value 0");
			} else {
				ControlUnit.getRegFile().registers[this.destReg].data = this.toBeWritten;
				System.out.println("The data is written in register number: " + this.destReg);
				System.out
						.println("The data to be writted is: " + ControlUnit.getRegFile().registers[this.destReg].data);
			}
		}
	}

	public static String getToBeWritten() {
		return toBeWritten;
	}

	public static void setToBeWritten(String toBeWritten) {
		WriteBack.toBeWritten = toBeWritten;
	}

	public static int getDestReg() {
		return destReg;
	}

	public static void setDestReg(int destReg) {
		WriteBack.destReg = destReg;
	}

	public static boolean isRegWrite() {
		return RegWrite;
	}

	public static void setRegWrite(boolean regWrite) {
		RegWrite = regWrite;
	}

}
