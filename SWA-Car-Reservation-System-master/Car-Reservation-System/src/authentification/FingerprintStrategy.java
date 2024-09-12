package authentification;


public class FingerprintStrategy implements AuthenticationStrategy {
    @Override
    public boolean authenticate(Subject subject, Credential credential) {
        // Fingerabdruck wird überprüft
        if (credential.getFingerPrint() != null) {
            return true;  // Hier könnte z.B. eine Vergleichslogik gegen eine Datenbank kommen
        }
        return false;
    }
}

