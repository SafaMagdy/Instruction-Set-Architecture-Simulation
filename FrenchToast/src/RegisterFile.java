
public class RegisterFile {

	Register[] registers;

	public RegisterFile() {
		this.registers = new Register[32];
		for (int i = 0; i < this.registers.length; i++) {
			String regName = "R" + i;
			this.registers[i] = new Register(regName, "Stores data temporarily", "General");
		}
		// TODO make value of register 0 constant and check if we want to do this to 1
		// also

	}

}
