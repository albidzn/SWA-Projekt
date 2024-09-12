package authentification;


public class UsernamePasswordStrategy implements AuthenticationStrategy {
    @Override
    public boolean authenticate(Subject subject, Credential credential) {
        // Die Logik prüft, ob Benutzername und Passwort im Credential vorhanden sind
        if (credential.getUsername() != null && credential.getPassword() != null) {
            return true;  // Hier könnte z.B. eine Datenbankabfrage kommen
        }
        return false;
    }
}






