package com.example.demo.models;

public class Bank_Details {
	private String Bank_id;

	private String Bank_Name;
	private String Account_Number;
	private String IFSC_Code;
	
	public Bank_Details() {
	
	
	}
	
	public Bank_Details(String bank_id, String bank_Name, String account_Number, String iFSC_Code) {
		super();
		Bank_id = bank_id;
		Bank_Name = bank_Name;
		Account_Number = account_Number;
		IFSC_Code = iFSC_Code;
	}
	public String getBank_id() {
		return Bank_id;
	}
	public void setBank_id(String bank_id) {
		Bank_id = bank_id;
	}
	public String getBank_Name() {
		return Bank_Name;
	}
	public void setBank_Name(String bank_Name) {
		Bank_Name = bank_Name;
	}
	public String getAccount_Number() {
		return Account_Number;
	}
	public void setAccount_Number(String account_Number) {
		Account_Number = account_Number;
	}
	public String getIFSC_Code() {
		return IFSC_Code;
	}
	public void setIFSC_Code(String iFSC_Code) {
		IFSC_Code = iFSC_Code;
	}

}
