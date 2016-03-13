package rest;

public class Costumer{
	private String kundnummer;
	private String firstName;
	private String efternamn;
	private String mobilnummer;
	private String fastnummer;
	private String mejladress;
	private String personnummer;
	
	public Costumer() {

	}
	
	public String getCostumerNumber() {
		return kundnummer;
	}
	public void setCostumerNumber(String kundnummer) {
		this.kundnummer = kundnummer;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return efternamn;
	}
	public void setLastName(String lastName) {
		this.efternamn = lastName;
	}
	public String getMobilePhone() {
		return mobilnummer;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilnummer = mobilePhone;
	}
	public String getPhone() {
		return fastnummer;
	}
	public void setPhone(String phone) {
		this.fastnummer = phone;
	}
	public String getEmail() {
		return mejladress;
	}
	public void setEmail(String email) {
		this.mejladress = email;
	}
	public String getSocialSecurityNumber() {
		return personnummer;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.personnummer = socialSecurityNumber;
	}
	

}