package person;

public abstract class Person {
    protected String fname; //// protected, da die Unterklassen auf die Attribute zugreifen müssen und wir nicht wissen, ob die unterklassen nur mit getter und setter arbeiten
    protected String lname;
    protected String email;
    protected String phoneNumber;
    protected String address;   
    

    // Konstruktor für gemeinsame Attribute
    public Person(String fname, String lname, String email, String phoneNumber, String address) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

   //Getter und Setter
   

    public String getEmail() {
        return email;
    }

    public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    //Gibt Details der Person aus
    public String getPersonDetails() {
    	return "Vorname: " + fname + "\nNachname: " + lname + "\nEmail: " + email + "\nPhone Number : " + phoneNumber + "\nAdress: " + address;
    }

    //Abstrakte Methode, die in den Unterklassen implementiert werden muss
    public abstract String getPersonType();
}