package person;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

// Privatkunden repräsentiert
public class NaturalPerson extends Person {
	private String birthDate; // Birth date of the person, die Person sollte mindestens 18 Jahre alt sein!

	// Constructor
	public NaturalPerson(String fname, String lname, String email, String phoneNumber, String address, String birthDate) {
		super(fname, lname, email, phoneNumber, address); // Übergibt alle notwendigen Parameter an den Superkonstruktor
		this.birthDate = birthDate;
	}

	// Überprüfen, ob die Person mindestens 18 Jahre alt ist
	public boolean isOver18() {
		try {
			LocalDate birthDate = LocalDate.parse(this.birthDate); // Format: yyyy-MM-dd
			LocalDate today = LocalDate.now();
			return Period.between(birthDate, today).getYears() >= 18;
		} catch (DateTimeParseException e) {
			System.out.println(
					"Ungültiges Geburtsdatumformat! Bitte verwenden Sie das Format yyyy-MM-dd, Beispiel: 2000-01-01");
			return false;
		}
	}

	// Getter und Setter
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String getPersonType() {
		return "Natural Person / Natürliche Person";
	}
}
