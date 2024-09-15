package person;

public class LegalPerson extends Person {
	private String companyName;
	private String registrationNumber; // Beispiel-Attribut für eine juristische Person
	private String taxNumber; // TODO #2 Überprüfen, ob die Steuernummer immer 13-stellig ist, und Methode
								// zumÜberprüfen implementieren
//GmbH AG haben Handelsregister.

	public LegalPerson(String fname, String lname, String email, String phoneNumber, String address, String companyName,
			String registrationNumber, String taxNumber) {
		super(fname, lname, email, phoneNumber, address); // Übergabe aller erforderlichen Parameter an den
															// Superkonstruktor
		this.companyName = companyName;
		this.registrationNumber = registrationNumber;
		this.taxNumber = taxNumber;
	}

	// Konstruktorüberladung sehe notizen, relevant wegen Daten

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public String getCompanyName() {
		return companyName;

	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public boolean isTaxNumberValid() {
		return taxNumber != null && taxNumber.length() == 13;
	}

	@Override
	public String getPersonType() {
		return "Legal Person / Juristische Person";
	}
}
