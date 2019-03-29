package entities;

public class Account {
	private String account_Id;
	private String first_Name;
	private String last_Name;
	private String email;

	public Account() {
		super();
	}

	public Account(String account_Id, String first_Name, String last_Name, String email) {
		super();
		this.account_Id = account_Id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.email = email;
	}

	public String getAccount_Id() {
		return account_Id;
	}

	public void setAccount_Id(String account_Id) {
		this.account_Id = account_Id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + account_Id + ", first_Name=" + first_Name + ", last_Name=" + last_Name
				+ ", email="
				+ email + "]";
	}


}
