import java.util.ArrayList;

public class ControlUnit {

	private static InstructionMemory instMem;
	private static RegisterFile regFile;
	private static ALU arith;
	private static DataMemory dataMem;
	private static Cache cache;
	private static WriteBack writeB;
	private static InstructionFetch fetch;
	private static InstructionDecode decode;
	private static Execute exec;
	private static MemoryAccess memAccess;
	private static int cycle;
	private static IFID fetDecPip;
	private static IDEX decExecPip;
	private static EXMEM execMemPip;
	private static MEMWB memWritePip;
	private static ArrayList<String> toBeFetched;
	private static ArrayList<String> toBeDecoded;
	private static ArrayList<String> toBeExecuted;
	private static ArrayList<String> forMemAccess;
	private static ArrayList<String> forWriteBack;
	private static int totalCycles;
	private static String ALUop;
	private static boolean RegDst;
	private static boolean RegWrite;
	private static boolean ALUSrc;
	private static boolean PCSrc;
	private static boolean positiveBranch;
	private static boolean MemRead;
	private static boolean MemWrite;
	private static boolean MemToReg;

	public ControlUnit() {
		this.instMem = new InstructionMemory();
		this.regFile = new RegisterFile();
		this.arith = new ALU();
		this.dataMem = new DataMemory();
		this.cache = new Cache();
		this.memAccess = new MemoryAccess();
		this.fetch = new InstructionFetch();
		this.decode = new InstructionDecode();
		this.exec = new Execute();
		this.writeB = new WriteBack();
		this.cycle = 0;
		this.fetDecPip = new IFID();
		this.decExecPip = new IDEX();
		this.execMemPip = new EXMEM();
		this.memWritePip = new MEMWB();
		this.toBeFetched = new ArrayList<String>();
		this.toBeDecoded = new ArrayList<String>();
		this.toBeExecuted = new ArrayList<String>();
		this.forMemAccess = new ArrayList<String>();
		this.forWriteBack = new ArrayList<String>();
	}

	public static InstructionMemory getInstMem() {
		return instMem;
	}

	public static void setInstMem(InstructionMemory instMem) {
		ControlUnit.instMem = instMem;
	}

	public static RegisterFile getRegFile() {
		return regFile;
	}

	public static void setRegFile(RegisterFile regFile) {
		ControlUnit.regFile = regFile;
	}

	public static ALU getArith() {
		return arith;
	}

	public static void setArith(ALU arith) {
		ControlUnit.arith = arith;
	}

	public static DataMemory getDataMem() {
		return dataMem;
	}

	public static void setDataMem(DataMemory dataMem) {
		ControlUnit.dataMem = dataMem;
	}

	public static WriteBack getWriteB() {
		return writeB;
	}

	public static void setWriteB(WriteBack writeB) {
		ControlUnit.writeB = writeB;
	}

	public static InstructionFetch getFetch() {
		return fetch;
	}

	public static void setFetch(InstructionFetch fetch) {
		ControlUnit.fetch = fetch;
	}

	public static InstructionDecode getDecode() {
		return decode;
	}

	public static void setDecode(InstructionDecode decode) {
		ControlUnit.decode = decode;
	}

	public static Execute getExec() {
		return exec;
	}

	public static void setExec(Execute exec) {
		ControlUnit.exec = exec;
	}

	public static int getCycle() {
		return cycle;
	}

	public static void setCycle(int cycle) {
		ControlUnit.cycle = cycle;
	}

	public static IFID getFetDecPip() {
		return fetDecPip;
	}

	public static void setFetDecPip(IFID fetDecPip) {
		ControlUnit.fetDecPip = fetDecPip;
	}

	public static IDEX getDecExecPip() {
		return decExecPip;
	}

	public static void setDecExecPip(IDEX decExecPip) {
		ControlUnit.decExecPip = decExecPip;
	}

	public static EXMEM getExecMemPip() {
		return execMemPip;
	}

	public static void setExecMemPip(EXMEM execMemPip) {
		ControlUnit.execMemPip = execMemPip;
	}

	public static MEMWB getMemWritePip() {
		return memWritePip;
	}

	public static void setMemWritePip(MEMWB memWritePip) {
		ControlUnit.memWritePip = memWritePip;
	}

	public static ArrayList<String> getToBeFetched() {
		return toBeFetched;
	}

	public static void setToBeFetched(ArrayList<String> toBeFetched) {
		ControlUnit.toBeFetched = toBeFetched;
	}

	public static ArrayList<String> getToBeDecoded() {
		return toBeDecoded;
	}

	public static void setToBeDecoded(ArrayList<String> toBeDecoded) {
		ControlUnit.toBeDecoded = toBeDecoded;
	}

	public static ArrayList<String> getToBeExecuted() {
		return toBeExecuted;
	}

	public static void setToBeExecuted(ArrayList<String> toBeExecuted) {
		ControlUnit.toBeExecuted = toBeExecuted;
	}

	public static ArrayList<String> getForMemAccess() {
		return forMemAccess;
	}

	public static void setForMemAccess(ArrayList<String> forMemAccess) {
		ControlUnit.forMemAccess = forMemAccess;
	}

	public static ArrayList<String> getForWriteBack() {
		return forWriteBack;
	}

	public static void setForWriteBack(ArrayList<String> forWriteBack) {
		ControlUnit.forWriteBack = forWriteBack;
	}

	public static int getTotalCycles() {
		return totalCycles;
	}

	public static void setTotalCycles(int totalCycles) {
		ControlUnit.totalCycles = totalCycles;
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

	public static MemoryAccess getMemAccess() {
		return memAccess;
	}

	public static void setMemAccess(MemoryAccess memAccess) {
		ControlUnit.memAccess = memAccess;
	}

	public static Cache getCache() {
		return cache;
	}

	public static void setCache(Cache cache) {
		ControlUnit.cache = cache;
	}

	public void start(Program p) {
		this.instMem.load(p);
		this.totalCycles = 5 + p.inst.size() - 1;
		this.nextCycle();
	}

	public static void nextCycle() {
		while (ControlUnit.getCycle() < ControlUnit.getTotalCycles()) {
			ControlUnit.setCycle(ControlUnit.getCycle() + 1);
			System.out.println("Cycle number: " + ControlUnit.getCycle());

			String pc = ControlUnit.instMem.getProgramCounter().data;
			ControlUnit.getFetDecPip().transfer();
			ControlUnit.getDecExecPip().transfer();
			ControlUnit.getExecMemPip().transfer();
			ControlUnit.getMemWritePip().transfer();
			if (!(ControlUnit.getToBeFetched().isEmpty())) {
				System.out.println("1- Fetch stage");
				String instruction = ControlUnit.fetch.InstFetch(pc);
				ControlUnit.getFetDecPip().getInstruction().data = instruction;
			}
			if (!(ControlUnit.getToBeDecoded().isEmpty())) {
				System.out.println("2- Decode stage");
				String inst = ControlUnit.getToBeDecoded().get(0);
				System.out.println("The instruction in decode: " + inst);
				ControlUnit.decode.InstDecode();
			}
			if (!(ControlUnit.getToBeExecuted().isEmpty())) {
				System.out.println("3- Execute stage");
				String inst2 = ControlUnit.getToBeExecuted().get(0);
				System.out.println("The instruction in execute: " + inst2);
				ControlUnit.exec.Execute();
			}
			if (!(ControlUnit.getForMemAccess().isEmpty())) {
				System.out.println("4- Memory Access stage");
				String inst3 = ControlUnit.getForMemAccess().get(0);
				System.out.println("The instruction in memory access: " + inst3);
				ControlUnit.memAccess.MemAccess();
			}
			if (!(ControlUnit.getForWriteBack().isEmpty())) {
				System.out.println("5- Write Back stage");
				String inst4 = ControlUnit.getForWriteBack().get(0);
				System.out.println("The instruction in write back: " + inst4);
				ControlUnit.writeB.WriteBack();
			}
			if (!(ControlUnit.getToBeFetched().isEmpty())) {
				ControlUnit.getToBeDecoded().add(ControlUnit.getToBeFetched().remove(0));
			}
			if (ControlUnit.getCycle() > 1) {
				if (!(ControlUnit.getToBeDecoded().isEmpty())) {
					ControlUnit.getToBeExecuted().add(ControlUnit.getToBeDecoded().remove(0));
				}
				if (ControlUnit.getCycle() > 2) {
					if (!(ControlUnit.getToBeExecuted().isEmpty())) {
						ControlUnit.getForMemAccess().add(ControlUnit.getToBeExecuted().remove(0));
					}
					if (ControlUnit.getCycle() > 3) {
						if (!(ControlUnit.getForMemAccess().isEmpty())) {
							ControlUnit.getForWriteBack().add(ControlUnit.getForMemAccess().remove(0));
						}
						if (ControlUnit.getCycle() > 4) {
							if (!(ControlUnit.getForWriteBack().isEmpty())) {
								ControlUnit.getForWriteBack().remove(0);
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ControlUnit u = new ControlUnit();
		u.getRegFile().registers[1].data = "1";
		u.getRegFile().registers[2].data = "10";
		u.getRegFile().registers[3].data = "11";
		u.getRegFile().registers[4].data = "100";
		u.getRegFile().registers[5].data = "101";
		ArrayList<String> instructions = new ArrayList<String>();
		String add = "00000000001000100011000000000000";
		instructions.add(add);
		String addi = "00000100001011000000000000000010";
		instructions.add(addi);
		String sub = "00001000011000100011100000000000";
		instructions.add(sub);
		String multiply = "00001100011000100100000000000000";
		instructions.add(multiply);
		String and = "00010000011000100100100000000000";
		instructions.add(and);
		String orI = "00010100011010100000000000000001";
		instructions.add(orI);
		String shiftLeft = "00011000011010110000100000000000";
		instructions.add(shiftLeft);
		String shiftRight = "00011100011010110000100000000000";
		instructions.add(shiftRight);
		String load = "00100000001011000000000000000010";
		instructions.add(load);
		String store = "00100100001000110000000000000010";
		instructions.add(store);
		String bne = "00101000001000110000000000000010";
		instructions.add(bne);
		String bgt = "00101100011000010000000000000010";
		instructions.add(bgt);
		String slt = "00110100001000110110100000000000";
		instructions.add(slt);
		String jump = "00110000001000110110100000000000";
		instructions.add(jump);

		Program p = new Program(instructions);
		u.start(p);
	}

	public static boolean isPositiveBranch() {
		return positiveBranch;
	}

	public static void setPositiveBranch(boolean positiveBranch) {
		ControlUnit.positiveBranch = positiveBranch;
	}

}
