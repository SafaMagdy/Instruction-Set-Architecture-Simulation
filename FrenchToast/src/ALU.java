
public class ALU {
	private static boolean zeroFlag;
	private static boolean positiveFlag;
	private static int shiftAmount;

	public static boolean isZeroFlag() {
		return zeroFlag;
	}

	public static void setZeroFlag(boolean zeroFlag) {
		ALU.zeroFlag = zeroFlag;
	}

	public int ALUEvaluator(String Op, int Operand1, int Operand2) {
		// Input Type : Decimal
		// System.out.println("Output: ");
		int result;
		switch (Op) {
		case ("0000"):
			// System.out.println("Operation Name: AND");
			// System.out.println("1st Operand: " + Operand1);
			// System.out.println("2nd Operand: " + Operand2);
			result = ANDOp(Operand1, Operand2);
			if (result == 0) {
				this.setZeroFlag(true);
				// System.out.println("Z-Flag Value: " + "1");
			} else {
				this.setZeroFlag(false);
				// System.out.println("Z-Flag Value: " + "0");
			}
			// System.out.println("The result in decimal is: " + result);
			return result;
		case ("0001"):
			// System.out.println("Operation Name: OR");
			// System.out.println("1st Operand: " + Operand1);
			// System.out.println("2nd Operand: " + Operand2);
			result = OROp(Operand1, Operand2);
			if (result == 0) {
				this.setZeroFlag(true);
				// System.out.println("Z-Flag Value: " + "1");
			} else {
				this.setZeroFlag(false);
				// System.out.println("Z-Flag Value: " + "0");
			}
			// System.out.println("The result in decimal is: " + result);
			return result;
		case ("0010"):
			// System.out.println("Operation Name: ADD");
			// System.out.println("1st Operand: " + Operand1);
			// System.out.println("2nd Operand: " + Operand2);
			result = addOp(Operand1, Operand2);
			if (result == 0) {
				this.setZeroFlag(true);
				// System.out.println("Z-Flag Value: " + "1");
			} else {
				this.setZeroFlag(false);
				// System.out.println("Z-Flag Value: " + "0");
			}
			// System.out.println("The result in decimal is: " + result);
			return result;
		case ("0110"):
			// System.out.println("Operation Name: SUB");
			// System.out.println("1st Operand: " + Operand1);
			// System.out.println("2nd Operand: " + Operand2);
			result = subOp(Operand1, Operand2);
			if (result == 0) {
				this.setZeroFlag(true);
				// System.out.println("Z-Flag Value: " + "1");
			} else {
				this.setZeroFlag(false);
				// System.out.println("Z-Flag Value: " + "0");
			}
			// System.out.println("The result in decimal is: " + result);
			return result;
		case ("0111"):
			// System.out.println("Operation Name: SLT");
			// System.out.println("1st Operand: " + Operand1);
			// System.out.println("2nd Operand: " + Operand2);
			result = sltOp(Operand1, Operand2);
			if (result == 0) {
				this.setZeroFlag(true);
				// System.out.println("Z-Flag Value: " + "1");
			} else {
				this.setZeroFlag(false);
				// System.out.println("Z-Flag Value: " + "0");
			}
			// System.out.println("The result in decimal is: " + result);
			return result;
		case ("1100"):
			// System.out.println("Operation Name: NOR");
			// System.out.println("1st Operand: " + Operand1);
			// System.out.println("2nd Operand: " + Operand2);
			result = NOR(Operand1, Operand2);
			if (result == 0) {
				this.setZeroFlag(true);
				// System.out.println("Z-Flag Value: " + "1");
			} else {
				this.setZeroFlag(false);
				// System.out.println("Z-Flag Value: " + "0");
			}
			// System.out.println("The result in decimal is: " + result);
			return result;
		case ("0011"):
			// multiply
			// System.out.println("Operation Name: MULT");
			// System.out.println("1st Operand: " + Operand1);
			// System.out.println("2nd Operand: " + Operand2);
			result = Multiply(Operand1, Operand2);
			if (result == 0) {
				this.setZeroFlag(true);
				// System.out.println("Z-Flag Value: " + "1");
			} else {
				this.setZeroFlag(false);
				// System.out.println("Z-Flag Value: " + "0");
			}
			// System.out.println("The result in decimal is: " + result);
			return result;
		case ("0100"):
			// shift left
			// System.out.println("Operation Name: SLL");
			// System.out.println("1st Operand: " + Operand1);
			// System.out.println("shiftAmount: " + this.shiftAmount);
			result = shiftLeft(Operand1, this.shiftAmount);
			if (result == 0) {
				this.setZeroFlag(true);
				// System.out.println("Z-Flag Value: " + "1");
			} else {
				this.setZeroFlag(false);
				// System.out.println("Z-Flag Value: " + "0");
			}
			// System.out.println("The result in decimal is: " + result);
			return result;
		case ("0101"):
			// shift right
			// System.out.println("Operation Name: SRL");
			// System.out.println("1st Operand: " + Operand1);
			// System.out.println("shiftAmount: " + this.shiftAmount);
			result = shiftRight(Operand1, this.shiftAmount);
			if (result == 0) {
				this.setZeroFlag(true);
				// System.out.println("Z-Flag Value: " + "1");
			} else {
				this.setZeroFlag(false);
				// System.out.println("Z-Flag Value: " + "0");
			}
			// System.out.println("The result in decimal is: " + result);
			return result;
		case ("1110"):
			// branch if not equal
			// System.out.println("Operation Name: BNE");
			// System.out.println("1st Operand: " + Operand1);
			// System.out.println("2nd Operand: " + Operand2);
			result = subOp(Operand1, Operand2);
			if (result == 0) {
				this.setZeroFlag(true);
				// System.out.println("Z-Flag Value: " + "1");
			} else {
				this.setZeroFlag(false);

				// System.out.println("Z-Flag Value: " + "0");
				if (ControlUnit.getExec().isPCSrc()) {
					ControlUnit.getFetch().ProgCount(true,
							Integer.parseInt(ControlUnit.getExec().getBranchAddress(), 2));
				}
			}
			// System.out.println("The result in decimal is: " + result);
			return result;
		case ("1000"):
			// branch if greater than
			// System.out.println("Operation Name: BGT");
			// System.out.println("1st Operand: " + Operand1);
			// System.out.println("2nd Operand: " + Operand2);
			result = subOp(Operand1, Operand2);
			if (result == 0) {
				this.setZeroFlag(true);
				this.setPositiveFlag(false);
				// System.out.println("Z-Flag Value: " + "1");
			} else if (result > 0) {
				this.setZeroFlag(false);
				this.setPositiveFlag(true);
				if (ControlUnit.getExec().isPCSrc()) {
					ControlUnit.getFetch().ProgCount(true,
							Integer.parseInt(ControlUnit.getExec().getBranchAddress(), 2));
				}
				// System.out.println("Z-Flag Value: " + "0");
			} else {
				this.setZeroFlag(false);
			}
			// System.out.println("The result in decimal is: " + result);
			return result;
		default:
			System.out.println("this operation is invalid");
			return -1;
		}

	}

	public static int ANDOp(int operand1, int operand2) {
		int result;
		result = operand1 & operand2;
		return result;
	}

	public static int OROp(int operand1, int operand2) {
		int result;
		result = operand1 | operand2;
		return result;
	}

	public static int addOp(int operand1, int operand2) {
		int result;
		result = operand1 + operand2;
		return result;
	}

	public int subOp(int operand1, int operand2) {
		int result;
//		if (operand1 < operand2) {
//			System.out.println(
//					"since op1 < op2 therefore we are going to use two's complement to get the correct answer");
//			//String op2Inv = this.twosComp(Integer.toBinaryString(operand2));
//			//operand2 = Integer.parseInt(op2Inv, 2);
//			result = (operand1 + operand2) * -1;
//		} else {
//			result = operand1 - operand2;
//		}
		result = operand1 - operand2;
		return result;
	}

	public static int Multiply(int operand1, int operand2) {
		int result;
		result = operand1 * operand2;
		return result;
	}

	public static int shiftLeft(int operand1, int shiftAmount) {
		int result;
		result = operand1 << shiftAmount;
		return result;
	}

	public static int shiftRight(int operand1, int shiftAmount) {
		int result;
		result = operand1 >> shiftAmount;
		return result;
	}

	public static int sltOp(int operand1, int operand2) {
		int result;
		if (operand1 < operand2) {
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	public static int NOR(int operand1, int operand2) {
		int result;
		int decRes = operand1 | operand2;
		int comDec = ~decRes;
		result = comDec;
		return result;
	}

	public static int getShiftAmount() {
		return shiftAmount;
	}

	public static void setShiftAmount(int shiftAmount) {
		ALU.shiftAmount = shiftAmount;
	}

	public static boolean isPositiveFlag() {
		return positiveFlag;
	}

	public static void setPositiveFlag(boolean positiveFlag) {
		ALU.positiveFlag = positiveFlag;
	}

}
