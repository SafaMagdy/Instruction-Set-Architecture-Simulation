
public class Register {

	public String name;
	public String purpose;
	public String type; // specific or general
	public String data;

	public Register(String name, String purpose, String type) {
		this.name = name;
		this.type = type;
		this.purpose = purpose;
		this.data = "00000000000000000000000000000000";
	}

}
