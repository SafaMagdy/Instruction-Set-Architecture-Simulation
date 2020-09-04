
public class InstructionFetch {

	public String InstFetch(String pc) {
		String instruction = "00000000000000000000000000000000";
		int indexLin = Integer.parseInt(pc, 2);
		instruction = ControlUnit.getInstMem().getInstructions()[indexLin];
		System.out.println("the instruction fetched is: " + instruction);
		this.ProgCount(false, 0);
		return instruction;
	}

	public void ProgCount(boolean branch, int branchPC) {
		String oldPC = ControlUnit.getInstMem().getProgramCounter().data;
		int oldPCInt = Integer.parseInt(oldPC, 2);
		int newPCInt = 0;
		if (branch) {
			newPCInt = branchPC;
			//System.out.println("The branch signal is on");
		} else {
			newPCInt = oldPCInt + 1;
			// System.out.println("the program counter is incremented by 1, since there is
			// no branch");
		}
		String newPC = Integer.toBinaryString(newPCInt);
		ControlUnit.getInstMem().getProgramCounter().data = newPC;
		System.out.println("Next PC: " + this.extend32(Integer.toBinaryString(newPCInt)));
		ControlUnit.getFetDecPip().setPc(newPC);
	}

	public String extend32(String old) {
		String result = "";
		if (old.length() < 32) {
			int needed = 32 - old.length();
			for (int i = 0; i < needed; i++) {
				result += "0";
			}
			result = result + old;
		} else {
			result = old;
		}
		return result;
	}

}
