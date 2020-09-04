
public class Execute {
	private static String readData1;
	private static String readData2;
	private static int destReg;
	private static String signExtend;
	private static int shiftAmount;
	private static String branchAddress;
	private static String ALUop;
	private static boolean RegDst;
	private static boolean RegWrite;
	private static boolean ALUSrc;
	private static boolean PCSrc;
	private static boolean positiveBranch;
	private static boolean MemRead;
	private static boolean MemWrite;
	private static boolean MemToReg;
	private static String pc;
	// private static String dataStored;// for memory
	private static String rt_rd;
	private static String toBeWritten;// for registers

	public void Execute() {
		String AluOp = this.ALUop;
		//System.out.println("aluop: " + AluOp);
		ControlUnit.getArith().setShiftAmount(this.shiftAmount);
		String RegDst;
		if (this.RegDst) {
			RegDst = "1";
		} else {
			RegDst = "0";
		}
		String RegWrite = "X";
		if (this.RegWrite) {
			RegWrite = "1";
		} else {
			RegWrite = "0";
		}
		String ALUSrc = "X";
		if (this.ALUSrc) {
			ALUSrc = "1";
		} else {
			ALUSrc = "0";
		}
		String PCSrc = "X";
		if (this.PCSrc) {
			PCSrc = "1";
		} else {
			PCSrc = "0";
		}
		String MemRead = "X";
		if (this.MemRead) {
			MemRead = "1";
		} else {
			MemRead = "0";
		}
		String MemWrite = "X";
		if (this.MemWrite) {
			MemWrite = "1";
		} else {
			MemWrite = "0";
		}
		String MemToReg = "X";
		if (this.MemToReg) {
			MemToReg = "1";
		} else {
			MemToReg = "0";
		}
		int op1;
		int op2;
		int signex;
		int resultInt = 0;
		String befExt = "";
		String finalRes;
		String zeroFlag;
		String finalBranchAddress = "00000000000000000000000000000000";
		finalBranchAddress = Integer.toBinaryString(ControlUnit.getArith().ALUEvaluator("0010",
				Integer.parseInt(this.branchAddress, 2), Integer.parseInt(this.pc, 2)));
		this.branchAddress = this.extend32(finalBranchAddress);
		op1 = Integer.parseInt(this.getReadData1(), 2);
		op2 = Integer.parseInt(this.getReadData2(), 2);
		if (this.getSignExtend().charAt(0) == '1') {
			System.out.println("the immediate is negative");
			String comp = this.twosComp(signExtend);
			signex = Integer.parseInt(comp, 2);
		} else {
			signex = Integer.parseInt(this.getSignExtend(), 2);
		}
		if (this.isALUSrc()) {
			resultInt = ControlUnit.getArith().ALUEvaluator(AluOp, op1, signex);
		} else {
			resultInt = ControlUnit.getArith().ALUEvaluator(AluOp, op1, op2);
		}
		befExt = Integer.toBinaryString(resultInt);
		finalRes = this.extend32(befExt);
		if (ControlUnit.getArith().isZeroFlag()) {
			zeroFlag = "1";
		} else {
			zeroFlag = "0";
		}
		if (this.MemRead || this.MemWrite) {
			// I will read/write from memory so the alu result is the destination address in
			// data memory
			ControlUnit.getExecMemPip().setIndex(resultInt);
		} else {
			// I will write in the register the result of alu
			ControlUnit.getExecMemPip().getToBeWritten().data = finalRes;
		}
		System.out.println("zero flag: " + zeroFlag);
		System.out.println("branch address: " + this.branchAddress);
		System.out.println("ALU result/address: " + finalRes);
		if (this.MemWrite) {
			System.out.println("register value to write to memory: " + this.readData2);
			// datastored is readdata2
		}
		System.out.println("rt/rd register: " + this.rt_rd);
		System.out.println("WB controls: MemToReg: " + MemToReg + "," + " RegWrite: " + RegWrite);
		System.out.println(
				"MEM controls: MemRead: " + MemRead + "," + " MemWrite: " + MemWrite + "," + " Branch: " + PCSrc);
		ControlUnit.getExecMemPip().setPc(this.pc);
		ControlUnit.getExecMemPip().setDestReg(this.destReg);
		ControlUnit.getExecMemPip().setMemRead(this.MemRead);
		ControlUnit.getExecMemPip().setMemWrite(this.MemWrite);
		ControlUnit.getExecMemPip().setMemToReg(this.MemToReg);
		ControlUnit.getExecMemPip().setRt_rd(this.rt_rd);
		ControlUnit.getExecMemPip().setAluRes(finalRes);
		ControlUnit.getExecMemPip().setRegWrite(this.RegWrite);

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

	public String twosComp(String old) {
		String result = "";
		String inverted = this.invertDigits(old);
		int beforeAdd = Integer.parseInt(inverted, 2);
		int n = beforeAdd + 1;
		result = Integer.toBinaryString(n);
		return result;
	}

	public String invertDigits(String binNum) {
		String result = "";
		for (int i = 0; i < binNum.length(); i++) {
			if (binNum.charAt(i) == '0') {
				result += "1";
			} else {
				result += "0";
			}
		}
		return result;
	}

	public static int getDestReg() {
		return destReg;
	}

	public static void setDestReg(int destReg) {
		Execute.destReg = destReg;
	}

	public static int getShiftAmount() {
		return shiftAmount;
	}

	public static void setShiftAmount(int shiftAmount) {
		Execute.shiftAmount = shiftAmount;
	}

	public static String getALUop() {
		return ALUop;
	}

	public static void setALUop(String aLUop) {
		ALUop = aLUop;
	}

	public static boolean isRegDst() {
		return RegDst;
	}

	public static void setRegDst(boolean regDst) {
		RegDst = regDst;
	}

	public static boolean isRegWrite() {
		return RegWrite;
	}

	public static void setRegWrite(boolean regWrite) {
		RegWrite = regWrite;
	}

	public static boolean isALUSrc() {
		return ALUSrc;
	}

	public static void setALUSrc(boolean aLUSrc) {
		ALUSrc = aLUSrc;
	}

	public static boolean isPCSrc() {
		return PCSrc;
	}

	public static void setPCSrc(boolean pCSrc) {
		PCSrc = pCSrc;
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

	public static boolean isMemToReg() {
		return MemToReg;
	}

	public static void setMemToReg(boolean memToReg) {
		MemToReg = memToReg;
	}

	public static String getReadData1() {
		return readData1;
	}

	public static void setReadData1(String readData1) {
		Execute.readData1 = readData1;
	}

	public static String getReadData2() {
		return readData2;
	}

	public static void setReadData2(String readData2) {
		Execute.readData2 = readData2;
	}

	public static String getSignExtend() {
		return signExtend;
	}

	public static void setSignExtend(String signExtend) {
		Execute.signExtend = signExtend;
	}

	public static String getBranchAddress() {
		return branchAddress;
	}

	public static void setBranchAddress(String branchAddress) {
		Execute.branchAddress = branchAddress;
	}

	public static String getPc() {
		return pc;
	}

	public static void setPc(String pc) {
		Execute.pc = pc;
	}

	public static String getRt_rd() {
		return rt_rd;
	}

	public static void setRt_rd(String rt_rd) {
		Execute.rt_rd = rt_rd;
	}

	public static String getToBeWritten() {
		return toBeWritten;
	}

	public static void setToBeWritten(String toBeWritten) {
		Execute.toBeWritten = toBeWritten;
	}

	public static boolean isPositiveBranch() {
		return positiveBranch;
	}

	public static void setPositiveBranch(boolean positiveBranch) {
		Execute.positiveBranch = positiveBranch;
	}

}
