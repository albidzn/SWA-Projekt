package person;
//TODO: bei vollständiger Implementierung von dem Pakage "person" attribute überprüfen.
public abstract class PersonFactory {
    public static Person createPerson(String type, String name, String address, String extraInfo1, String extraInfo2) {
        if ("natural".equalsIgnoreCase(type)) {
            return new NaturalPerson(name, address, extraInfo1, extraInfo2); // Pass extraInfo1 als Geburtsdatum und extraInfo2 als Führerscheinnummer
        } else if ("legal".equalsIgnoreCase(type)) {
            return new LegalPerson(name, address, extraInfo1, extraInfo2); // Pass extraInfo1 als Handelsregisternummer und extraInfo2 als Steuernummer
        }
        return null;
    }
}
