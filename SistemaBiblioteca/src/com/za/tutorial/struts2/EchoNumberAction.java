package com.za.tutorial.struts2;

public class EchoNumberAction {
	private String numberMessage;
	public String execute(){
		String flag  = "succes";
		try{
			Integer.parseInt(getNumberMessage());
		}catch(NumberFormatException e){
			flag = "failure";
		}
		return flag;
	}
	public String getNumberMessage() {
		return numberMessage;
	}
	public void setNumberMessage(String numberMessage) {
		this.numberMessage = numberMessage;
	}
}
