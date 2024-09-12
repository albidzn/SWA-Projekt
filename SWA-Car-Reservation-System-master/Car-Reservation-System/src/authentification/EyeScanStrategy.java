package authentification;


public class EyeScanStrategy implements AuthenticationStrategy {
    @Override
    public boolean authenticate(Subject subject, Credential credential) {
        // Iris-Scan wird überprüft
        if (credential.getEyeScan() != null) {
            return true;  // Hier könnte eine weitere Überprüfung z.B. aus einer Datenbank kommen
        }
        return false;
    }
}


