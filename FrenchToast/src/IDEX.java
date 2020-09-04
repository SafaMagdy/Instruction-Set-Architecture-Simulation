
public class IDEX {
	private static Register readData1;
	private static Register readData2;
	private static int destReg;
	private static Register signExtend;
	private static int shiftAmount;
	private static Register branchAddress;
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
	private static String rt_rd;

	public IDEX() {
		this.readData1 = new Register("P_IDEX readData1", "stores data in IDEX pipelined stage", "Specific");
		this.readData2 = new Register("P_IDEX readData2", "stores data in IDEX pipelined stage", "Specific");
		this.signExtend = new Register("P_IDEX signExtend", "stores data in IDEX pipelined stage", "Specific");
		this.branchAddress = new Register("P_IDEX branchAddress", "stores data in IDEX pipelined stage", "Specific");
	}

	public void transfer() {
		ControlUnit.getExec().setReadData1(this.readData1.data);
		ControlUnit.getExec().setReadData2(this.readData2.data);
		ControlUnit.getExec().setDestReg(this.destReg);
		ControlUnit.getExec().setSignExtend(this.signExtend.data);
		//this.branchAddress.data = ControlUnit.getDecode().getSignBranch();
		ControlUnit.getExec().setBranchAddress(this.branchAddress.data);
		//System.out.println("pip: " + this.ALUop);
		ControlUnit.getExec().setALUop(this.ALUop);
		ControlUnit.getExec().setRegDst(this.RegDst);
		ControlUnit.getExec().setRegWrite(this.RegWrite);
		ControlUnit.getExec().setALUSrc(this.ALUSrc);
		ControlUnit.getExec().setPCSrc(this.PCSrc);
		ControlUnit.getExec().setMemRead(this.MemRead);
		ControlUnit.getExec().setMemWrite(this.MemWrite);
		ControlUnit.getExec().setMemToReg(this.MemToReg);
		//this.pc = ControlUnit.getDecode().getPc();
		ControlUnit.getExec().setPc(this.pc);
		ControlUnit.getExec().setRt_rd(this.rt_rd);
		ControlUnit.getExec().setShiftAmount(this.shiftAmount);
		ControlUnit.getExec().setPositiveBranch(this.positiveBranch);
	}

	public static Register getReadData1() {
		return readData1;
	}

	public static void setReadData1(Register readData1) {
		IDEX.readData1 = readData1;
	}

	public static Register getReadData2() {
		return readData2;
	}

	public static void setReadData2(Register readData2) {
		IDEX.readData2 = readData2;
	}

	public static int getDestReg() {
		return destReg;
	}

	public static void setDestReg(int destReg) {
		IDEX.destReg = destReg;
	}

	public static Register getSignExtend() {
		return signExtend;
	}

	public static void setSignExtend(Register signExtend) {
		IDEX.signExtend = signExtend;
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

	public static int getShiftAmount() {
		return shiftAmount;
	}

	public static void setShiftAmount(int shiftAmount) {
		IDEX.shiftAmount = shiftAmount;
	}

	public static Register getBranchAddress() {
		return branchAddress;
	}

	public static void setBranchAddress(Register branchAddress) {
		IDEX.branchAddress = branchAddress;
	}

	public static String getPc() {
		return pc;
	}

	public static void setPc(String pc) {
		IDEX.pc = pc;
	}

	public static String getRt_rd() {
		return rt_rd;
	}

	public static void setRt_rd(String rt_rd) {
		IDEX.rt_rd = rt_rd;
	}

	public static boolean isPositiveBranch() {
		return positiveBranch;
	}

	public static void setPositiveBranch(boolean positiveBranch) {
		IDEX.positiveBranch = positiveBranch;
	}

}
