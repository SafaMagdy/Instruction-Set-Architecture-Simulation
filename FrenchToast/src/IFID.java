
public class IFID {

	private static Register instruction;
	private static String pc;

	public IFID() {
		this.instruction = new Register("P_IFID", "stores data in IFID pipelined stage", "Specific");
	}

	public void transfer() {
		ControlUnit.getDecode().setInstruction(this.instruction.data);
		ControlUnit.getDecode().setPc(this.pc);
	}

	public static Register getInstruction() {
		return instruction;
	}

	public static void setInstruction(Register instruction) {
		IFID.instruction = instruction;
	}

	public static String getPc() {
		return pc;
	}

	public static void setPc(String pc) {
		IFID.pc = pc;
	}

}
