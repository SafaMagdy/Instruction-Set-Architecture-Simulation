
public class InstructionMemory {
	private static String[] instructions;
	private static Register programCounter;

	public InstructionMemory() {
		this.instructions = new String[1024];
		this.programCounter = new Register("pc", "stores pc", "specific");
	}

	public void load(Program p) {
		for (int i = 0; i < p.inst.size(); i++) {
			this.instructions[i] = p.inst.get(i);
			ControlUnit.getToBeFetched().add(p.inst.get(i));
		}
		System.out.println("instructions are loaded into instruction memory");
	}

	public static String[] getInstructions() {
		return instructions;
	}

	public static void setInstructions(String[] instructions) {
		InstructionMemory.instructions = instructions;
	}

	public static Register getProgramCounter() {
		return programCounter;
	}

	public static void setProgramCounter(Register programCounter) {
		InstructionMemory.programCounter = programCounter;
	}
}
