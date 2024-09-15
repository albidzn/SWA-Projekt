package authentification;


public class Credential {
    private String username;
    private String password;
    private String fingerPrint;
    private String eyeScan;

    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Credential(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public Credential(String eyeScan, boolean isEyeScan) {
        if (isEyeScan) {
            this.eyeScan = eyeScan;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public String getEyeScan() {
        return eyeScan;
    }

    @Override
    public String toString() {
        if (username != null && password != null) {
            return "Benutzername: " + username + ", Passwort: [geschützt]";
        } else if (fingerPrint != null) {
            return "Fingerabdruck: " + fingerPrint;
        } else if (eyeScan != null) {
            return "Iris-Scan: " + eyeScan;
        }
        return "Keine gültigen Authentifizierungsdaten vorhanden.";
    }
}

