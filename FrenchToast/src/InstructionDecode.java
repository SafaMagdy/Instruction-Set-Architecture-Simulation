
public class InstructionDecode {

	private static String instruction;
	private static String pc;
	private static String signBranch;

	public void InstDecode() {
		String instruction = this.getInstruction();
		// String nextPc = ControlUnit.getInstMem().getProgramCounter().data;
		String nextPc = this.pc;
		RegisterFile r = new RegisterFile();
		r = ControlUnit.getRegFile();
		String op = instruction.substring(0, 6);
		int opCode = Integer.parseInt(op, 2);
		String rsS = "don't care";
		int rs;
		String rtS = "don't care";
		int rt;
		String rdS = "don't care";
		int rd;
		String imS;
		int immediate;
		String shamtS;
		int shamt;
		String imSextended = "00000000000000000000000000000000";
		String readData1 = "00000000000000000000000000000000";
		String readData2 = "00000000000000000000000000000000";
		this.signBranch = this.SignExtend(instruction.substring(16, 32));
		ControlUnit.getDecExecPip().getBranchAddress().data = this.signBranch;
		ControlUnit.getDecExecPip().setPc(this.pc);
		switch (opCode) {
		case (0):
			// opcode rs rt rd
			System.out.println("The instruction in Decode stage is ADD");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			// System.out.println("the first operand is at register: " + rs);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);
			// System.out.println("the second operand is at register: " + rt);
			readData2 = r.registers[rt].data;
			ControlUnit.getDecExecPip().getReadData2().data = this.extend32(readData2);
			rdS = instruction.substring(16, 21);
			rd = Integer.parseInt(rdS, 2);
			// System.out.println("The result should be written in register: " + rd);
			ControlUnit.getDecExecPip().setDestReg(rd);
			ControlUnit.getDecExecPip().setRt_rd(rdS);
			break;
		case (1):
			// opcode rs rt IMM
			System.out.println("The instruction in Decode stage is ADDI");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);// destination
			ControlUnit.getDecExecPip().setDestReg(rt);
			ControlUnit.getDecExecPip().setRt_rd(rtS);
			imS = instruction.substring(16, 32);
			immediate = Integer.parseInt(imS, 2);
			imSextended = this.SignExtend(imS);
			ControlUnit.getDecExecPip().getSignExtend().data = this.extend32(imSextended);
			break;
		case (2):
			// opcode rs rt rd
			System.out.println("The instruction in Decode stage is SUB");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			// System.out.println("the first operand is at register: " + rs);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);
			// System.out.println("the second operand is at register: " + rt);
			readData2 = r.registers[rt].data;
			ControlUnit.getDecExecPip().getReadData2().data = this.extend32(readData2);
			rdS = instruction.substring(16, 21);
			rd = Integer.parseInt(rdS, 2);
			// System.out.println("The result should be written in register: " + rd);
			ControlUnit.getDecExecPip().setDestReg(rd);
			ControlUnit.getDecExecPip().setRt_rd(rdS);
			break;
		case (3):
			// opcode rs rt rd
			System.out.println("The instruction in Decode stage is MULT");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			// System.out.println("the first operand is at register: " + rs);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);
			// System.out.println("the second operand is at register: " + rt);
			readData2 = r.registers[rt].data;
			ControlUnit.getDecExecPip().getReadData2().data = this.extend32(readData2);
			rdS = instruction.substring(16, 21);
			rd = Integer.parseInt(rdS, 2);
			// System.out.println("The result should be written in register: " + rd);
			ControlUnit.getDecExecPip().setDestReg(rd);
			ControlUnit.getDecExecPip().setRt_rd(rdS);
			break;
		case (4):
			// opcode rs rt rd
			System.out.println("The instruction in Decode stage is AND");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			// System.out.println("the first operand is at register: " + rs);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);
			// System.out.println("the second operand is at register: " + rt);
			readData2 = r.registers[rt].data;
			ControlUnit.getDecExecPip().getReadData2().data = this.extend32(readData2);
			rdS = instruction.substring(16, 21);
			rd = Integer.parseInt(rdS, 2);
			// System.out.println("The result should be written in register: " + rd);
			ControlUnit.getDecExecPip().setDestReg(rd);
			ControlUnit.getDecExecPip().setRt_rd(rdS);
			break;
		case (5):
			// opcode rs rt IMM
			// addi $s1, $s2, 100
			System.out.println("The instruction in Decode stage is ORI");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);// destination
			ControlUnit.getDecExecPip().setDestReg(rt);
			ControlUnit.getDecExecPip().setRt_rd(rtS);
			imS = instruction.substring(16, 32);
			immediate = Integer.parseInt(imS, 2);
			imSextended = this.SignExtend(imS);
			ControlUnit.getDecExecPip().getSignExtend().data = this.extend32(imSextended);
			break;
		case (6):
			// opcode rs rt shamt
			// shift left logical
			System.out.println("The instruction in Decode stage is SLL");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			// System.out.println("the first operand is at register: " + rs);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);
			// System.out.println("the second operand is at register: " + rt);
			// TODO check if this is correct
//			readData2 = r.registers[rt].data;
//			ControlUnit.getDecExecPip().getReadData2().data = readData2;
//			rdS = instruction.substring(16, 21);
//			rd = Integer.parseInt(rdS, 2);
			// System.out.println("The result should be written in register: " + rd);
			ControlUnit.getDecExecPip().setDestReg(rt);
			ControlUnit.getDecExecPip().setRt_rd(rtS);
			shamtS = instruction.substring(16, 21);
			System.out.println("ShiftAmount: " + shamtS);
			shamt = Integer.parseInt(shamtS, 2);
			ControlUnit.getDecExecPip().setShiftAmount(shamt);
			break;
		case (7):
			// opcode rs rt shamt
			// shift right logical
			System.out.println("The instruction in Decode stage is SRL");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			// System.out.println("the first operand is at register: " + rs);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);
			// System.out.println("the second operand is at register: " + rt);
//			readData2 = r.registers[rt].data;
//			ControlUnit.getDecExecPip().getReadData2().data = readData2;
//			rdS = instruction.substring(16, 21);
//			rd = Integer.parseInt(rdS, 2);
			// System.out.println("The result should be written in register: " + rd);
			ControlUnit.getDecExecPip().setDestReg(rt);
			ControlUnit.getDecExecPip().setRt_rd(rtS);
			shamtS = instruction.substring(16, 21);
			System.out.println("ShiftAmount: " + shamtS);
			shamt = Integer.parseInt(shamtS, 2);
			ControlUnit.getDecExecPip().setShiftAmount(shamt);
			break;
		case (8):
			// OP rt, IMM(rs)
			System.out.println("The instruction in Decode stage is LW");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			// System.out.println("the base address is at register: " + rs);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			// System.out.println("the base address is: " + readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);
			ControlUnit.getDecExecPip().setDestReg(rt);
			ControlUnit.getDecExecPip().setRt_rd(rtS);
			// System.out.println("the output should be put in register: " + rt);
			imS = instruction.substring(16, 32);
			immediate = Integer.parseInt(imS, 2);
			imSextended = this.SignExtend(imS);// second operand for ALU
			ControlUnit.getDecExecPip().getSignExtend().data = this.extend32(imSextended);
			// System.out.println("The immediate after extension is: " + imSextended);
			break;
		case (9):
			System.out.println("The instruction in Decode stage is SW");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			// System.out.println("the base address is at register: " + rs);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			// System.out.println("the base address is: " + readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);
			// System.out.println("the data to be stored is at register: " + rt);
			readData2 = r.registers[rt].data;
			ControlUnit.getDecExecPip().getReadData2().data = this.extend32(readData2);
			ControlUnit.getDecExecPip().setRt_rd(rtS);
			// System.out.println("the data to be stored is: " + readData2);
			imS = instruction.substring(16, 32);
			immediate = Integer.parseInt(imS, 2);
			imSextended = this.SignExtend(imS);// second operand for ALU
			ControlUnit.getDecExecPip().getSignExtend().data = this.extend32(imSextended);
			// System.out.println("The immediate after extension is: " + imSextended);
			break;
		case (10):
			// opcode rs rt IMM
			System.out.println("The instruction in Decode stage is BNE");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			// System.out.println("the first operand is at register: " + rs);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);
			// System.out.println("the second operand is at register: " + rt);
			readData2 = r.registers[rt].data;
			ControlUnit.getDecExecPip().getReadData2().data = this.extend32(readData2);
			ControlUnit.getDecExecPip().setRt_rd(rtS);
			imS = instruction.substring(16, 32);
			immediate = Integer.parseInt(imS, 2);
			imSextended = this.SignExtend(imS);
			ControlUnit.getDecExecPip().getBranchAddress().data = this.extend32(imSextended);
			break;
		case (11):
			// opcode rs rt IMM
			System.out.println("The instruction in Decode stage is BGT");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			// System.out.println("the first operand is at register: " + rs);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);
			// System.out.println("the second operand is at register: " + rt);
			readData2 = r.registers[rt].data;
			ControlUnit.getDecExecPip().getReadData2().data = this.extend32(readData2);
			ControlUnit.getDecExecPip().setRt_rd(rtS);
			imS = instruction.substring(16, 32);
			immediate = Integer.parseInt(imS, 2);
			imSextended = this.SignExtend(imS);
			ControlUnit.getDecExecPip().getBranchAddress().data = this.extend32(imSextended);
			break;
		case (12):
			// opcode IMM
			System.out.println("The instruction in Decode stage is Jump");
			imS = instruction.substring(16, 32);
			immediate = Integer.parseInt(imS, 2);
			if (imS.charAt(0) == '0') {
				imSextended = "000000" + imS;
			} else {
				imSextended = "111111" + imS;
			}
			int bAddress = Integer.parseInt(imSextended, 2);
			// TODO check if this is right
			ControlUnit.getFetch().ProgCount(true, bAddress);
			ControlUnit.getDecExecPip().setRt_rd("Null");
			break;
		case (13):
			// opcode rs rt rd
			System.out.println("The instruction in Decode stage is SLT");
			rsS = instruction.substring(6, 11);
			rs = Integer.parseInt(rsS, 2);
			// System.out.println("the first operand is at register: " + rs);
			readData1 = r.registers[rs].data;
			ControlUnit.getDecExecPip().getReadData1().data = this.extend32(readData1);
			rtS = instruction.substring(11, 16);
			rt = Integer.parseInt(rtS, 2);
			// System.out.println("the second operand is at register: " + rt);
			readData2 = r.registers[rt].data;
			ControlUnit.getDecExecPip().getReadData2().data = this.extend32(readData2);
			rdS = instruction.substring(16, 21);
			rd = Integer.parseInt(rdS, 2);
			// System.out.println("The result should be written in register: " + rd);
			ControlUnit.getDecExecPip().setDestReg(rd);
			ControlUnit.getDecExecPip().setRt_rd(rdS);
			break;
		default:
			System.out.println("This instruction is not supported");
			break;
		}
		System.out.println("readData1: " + this.extend32(readData1));
		System.out.println("readData2: " + this.extend32(readData2));
		System.out.println("sign-extend: " + this.extend32(imSextended));
		System.out.println("Next PC: " + this.extend32(nextPc));
		System.out.println("rt: " + rtS);
		System.out.println("rd: " + rdS);
		this.ContUnit(opCode);
	}

	public String SignExtend(String toBeExtended) {
		String result = "";
		if (toBeExtended.charAt(0) == '0') {
			result = "0000000000000000" + toBeExtended;
		} else {
			result = "1111111111111111" + toBeExtended;
		}
		System.out.println("after sign extentsion the immediate is: " + result);
		return result;
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

	public void ContUnit(int opCode) {
		String ALUop = "0000";
		String RegDst = "0";
		String RegWrite = "0";
		String ALUSrc = "0";
		String PCSrc = "0";
		String MemRead = "0";
		String MemWrite = "0";
		String MemToReg = "0";
		switch (opCode) {
		case (0):
			// "The instruction in Decode stage is ADD"
			ALUop = "0010";
			ControlUnit.getDecExecPip().setALUop("0010");
			RegDst = "1";
			ControlUnit.getDecExecPip().setRegDst(true);
			ALUSrc = "0";
			ControlUnit.getDecExecPip().setALUSrc(false);
			RegWrite = "1";
			ControlUnit.getDecExecPip().setRegWrite(true);
			MemRead = "0";
			ControlUnit.getDecExecPip().setMemRead(false);
			MemWrite = "0";
			ControlUnit.getDecExecPip().setMemWrite(false);
			PCSrc = "0";
			ControlUnit.getDecExecPip().setPCSrc(false);
			MemToReg = "0";
			ControlUnit.getDecExecPip().setMemToReg(false);
			break;
		case (1):
			// "The instruction in Decode stage is ADDI"
			ALUop = "0010";
			ControlUnit.getDecExecPip().setALUop("0010");
			RegDst = "0";
			ControlUnit.getDecExecPip().setRegDst(false);
			ALUSrc = "1";
			ControlUnit.getDecExecPip().setALUSrc(true);
			RegWrite = "1";
			ControlUnit.getDecExecPip().setRegWrite(true);
			MemRead = "0";
			ControlUnit.getDecExecPip().setMemRead(false);
			MemWrite = "0";
			ControlUnit.getDecExecPip().setMemWrite(false);
			PCSrc = "0";
			ControlUnit.getDecExecPip().setPCSrc(false);
			MemToReg = "0";
			ControlUnit.getDecExecPip().setMemToReg(false);
			break;
		case (2):
			// "The instruction in Decode stage is SUB"
			ALUop = "0110";
			ControlUnit.getDecExecPip().setALUop("0110");
			RegDst = "1";
			ControlUnit.getDecExecPip().setRegDst(true);
			ALUSrc = "0";
			ControlUnit.getDecExecPip().setALUSrc(false);
			RegWrite = "1";
			ControlUnit.getDecExecPip().setRegWrite(true);
			MemRead = "0";
			ControlUnit.getDecExecPip().setMemRead(false);
			MemWrite = "0";
			ControlUnit.getDecExecPip().setMemWrite(false);
			PCSrc = "0";
			ControlUnit.getDecExecPip().setPCSrc(false);
			MemToReg = "0";
			ControlUnit.getDecExecPip().setMemToReg(false);
			break;
		case (3):
			// "The instruction in Decode stage is MULT"
			ALUop = "0011";
			ControlUnit.getDecExecPip().setALUop("0011");
			RegDst = "1";
			ControlUnit.getDecExecPip().setRegDst(true);
			ALUSrc = "0";
			ControlUnit.getDecExecPip().setALUSrc(false);
			RegWrite = "1";
			ControlUnit.getDecExecPip().setRegWrite(true);
			MemRead = "0";
			ControlUnit.getDecExecPip().setMemRead(false);
			MemWrite = "0";
			ControlUnit.getDecExecPip().setMemWrite(false);
			PCSrc = "0";
			ControlUnit.getDecExecPip().setPCSrc(false);
			MemToReg = "0";
			ControlUnit.getDecExecPip().setMemToReg(false);
			break;
		case (4):
			// "The instruction in Decode stage is AND"
			ALUop = "0000";
			ControlUnit.getDecExecPip().setALUop("0000");
			RegDst = "1";
			ControlUnit.getDecExecPip().setRegDst(true);
			ALUSrc = "0";
			ControlUnit.getDecExecPip().setALUSrc(false);
			RegWrite = "1";
			ControlUnit.getDecExecPip().setRegWrite(true);
			MemRead = "0";
			ControlUnit.getDecExecPip().setMemRead(false);
			MemWrite = "0";
			ControlUnit.getDecExecPip().setMemWrite(false);
			PCSrc = "0";
			ControlUnit.getDecExecPip().setPCSrc(false);
			MemToReg = "0";
			ControlUnit.getDecExecPip().setMemToReg(false);
			break;
		case (5):
			// "The instruction in Decode stage is ORI"
			ALUop = "0001";
			ControlUnit.getDecExecPip().setALUop("0001");
			RegDst = "0";
			ControlUnit.getDecExecPip().setRegDst(false);
			ALUSrc = "1";
			ControlUnit.getDecExecPip().setALUSrc(true);
			RegWrite = "1";
			ControlUnit.getDecExecPip().setRegWrite(true);
			MemRead = "0";
			ControlUnit.getDecExecPip().setMemRead(false);
			MemWrite = "0";
			ControlUnit.getDecExecPip().setMemWrite(false);
			PCSrc = "0";
			ControlUnit.getDecExecPip().setPCSrc(false);
			MemToReg = "0";
			ControlUnit.getDecExecPip().setMemToReg(false);
			break;
		case (6):
			// "The instruction in Decode stage is SLL"
			ALUop = "0100";
			ControlUnit.getDecExecPip().setALUop("0100");
			RegDst = "1";
			ControlUnit.getDecExecPip().setRegDst(true);
			ALUSrc = "0";
			ControlUnit.getDecExecPip().setALUSrc(false);
			RegWrite = "1";
			ControlUnit.getDecExecPip().setRegWrite(true);
			MemRead = "0";
			ControlUnit.getDecExecPip().setMemRead(false);
			MemWrite = "0";
			ControlUnit.getDecExecPip().setMemWrite(false);
			PCSrc = "0";
			ControlUnit.getDecExecPip().setPCSrc(false);
			MemToReg = "0";
			ControlUnit.getDecExecPip().setMemToReg(false);
			break;
		case (7):
			// "The instruction in Decode stage is SRL"
			ALUop = "0101";
			ControlUnit.getDecExecPip().setALUop("0101");
			RegDst = "1";
			ControlUnit.getDecExecPip().setRegDst(true);
			ALUSrc = "0";
			ControlUnit.getDecExecPip().setALUSrc(false);
			RegWrite = "1";
			ControlUnit.getDecExecPip().setRegWrite(true);
			MemRead = "0";
			ControlUnit.getDecExecPip().setMemRead(false);
			MemWrite = "0";
			ControlUnit.getDecExecPip().setMemWrite(false);
			PCSrc = "0";
			ControlUnit.getDecExecPip().setPCSrc(false);
			MemToReg = "0";
			ControlUnit.getDecExecPip().setMemToReg(false);
			break;
		case (8):
			// "The instruction in Decode stage is LW"
			ALUop = "0010";
			ControlUnit.getDecExecPip().setALUop("0010");
			RegDst = "0";
			ControlUnit.getDecExecPip().setRegDst(false);
			ALUSrc = "1";
			ControlUnit.getDecExecPip().setALUSrc(true);
			RegWrite = "1";
			ControlUnit.getDecExecPip().setRegWrite(true);
			MemRead = "1";
			ControlUnit.getDecExecPip().setMemRead(true);
			MemWrite = "0";
			ControlUnit.getDecExecPip().setMemWrite(false);
			PCSrc = "0";
			ControlUnit.getDecExecPip().setPCSrc(false);
			MemToReg = "1";
			ControlUnit.getDecExecPip().setMemToReg(true);
			break;
		case (9):
			// "The instruction in Decode stage is SW"
			ALUop = "0010";
			ControlUnit.getDecExecPip().setALUop("0010");
			RegDst = "X";
			ALUSrc = "1";
			ControlUnit.getDecExecPip().setALUSrc(true);
			RegWrite = "0";
			ControlUnit.getDecExecPip().setRegWrite(false);
			MemRead = "0";
			ControlUnit.getDecExecPip().setMemRead(false);
			MemWrite = "1";
			ControlUnit.getDecExecPip().setMemWrite(true);
			PCSrc = "0";
			ControlUnit.getDecExecPip().setPCSrc(false);
			MemToReg = "X";
			break;
		case (10):
			// "The instruction in Decode stage is BNE"
			ALUop = "0110";
			ControlUnit.getDecExecPip().setALUop("1110");
			RegDst = "X";
			ALUSrc = "0";
			ControlUnit.getDecExecPip().setALUSrc(false);
			RegWrite = "0";
			ControlUnit.getDecExecPip().setRegWrite(false);
			MemRead = "0";
			ControlUnit.getDecExecPip().setMemRead(false);
			MemWrite = "0";
			ControlUnit.getDecExecPip().setMemWrite(false);
			PCSrc = "1";
			ControlUnit.getDecExecPip().setPCSrc(true);
			MemToReg = "X";
			break;
		case (11):
			// "The instruction in Decode stage is BGT"
			ALUop = "1000";
			ControlUnit.getDecExecPip().setALUop("1000");
			RegDst = "X";
			ALUSrc = "0";
			ControlUnit.getDecExecPip().setALUSrc(false);
			RegWrite = "0";
			ControlUnit.getDecExecPip().setRegWrite(false);
			MemRead = "0";
			ControlUnit.getDecExecPip().setMemRead(false);
			MemWrite = "0";
			ControlUnit.getDecExecPip().setMemWrite(false);
			PCSrc = "1";
			ControlUnit.getDecExecPip().setPCSrc(true);
			ControlUnit.getDecExecPip().setPositiveBranch(true);
			MemToReg = "X";
			break;
		case (12):
			// "The instruction in Decode stage is Jump"
			ALUop = "X";
			ControlUnit.getDecExecPip().setALUop("X");
			RegDst = "X";
			ALUSrc = "X";
			RegWrite = "X";
			MemRead = "X";
			MemWrite = "X";
			PCSrc = "1";
			ControlUnit.getDecExecPip().setPCSrc(true);
			MemToReg = "X";
			break;
		case (13):
			// "The instruction in Decode stage is SLT"
			ALUop = "0111";
			ControlUnit.getDecExecPip().setALUop("0111");
			RegDst = "1";
			ControlUnit.getDecExecPip().setRegDst(true);
			ALUSrc = "0";
			ControlUnit.getDecExecPip().setALUSrc(false);
			RegWrite = "1";
			ControlUnit.getDecExecPip().setRegWrite(true);
			MemRead = "0";
			ControlUnit.getDecExecPip().setMemRead(false);
			MemWrite = "0";
			ControlUnit.getDecExecPip().setMemWrite(false);
			PCSrc = "0";
			ControlUnit.getDecExecPip().setPCSrc(false);
			MemToReg = "0";
			ControlUnit.getDecExecPip().setMemToReg(false);
			break;
		default:
			System.out.println("This instruction is not supported");
			break;
		}
		System.out.println("WB controls: MemToReg: " + MemToReg + "," + " RegWrite: " + RegWrite);
		System.out.println(
				"MEM controls: MemRead: " + MemRead + "," + " MemWrite: " + MemWrite + "," + " Branch: " + PCSrc);
		System.out.println("EX controls: RegDest: " + RegDst + "," + " ALUOp: " + ALUop + "," + " ALUSrc: " + ALUSrc);

	}

	public static String getInstruction() {
		return instruction;
	}

	public static void setInstruction(String instruction) {
		InstructionDecode.instruction = instruction;
	}

	public static String getPc() {
		return pc;
	}

	public static void setPc(String pc) {
		InstructionDecode.pc = pc;
	}

	public static String getSignBranch() {
		return signBranch;
	}

	public static void setSignBranch(String signBranch) {
		InstructionDecode.signBranch = signBranch;
	}

}
