package authentification;


public class FingerprintStrategy implements AuthenticationStrategy {
    @Override
    public boolean authenticate(Subject subject, Credential credential) {
        if (credential.getFingerPrint() != null) {
            return true;
        }
        return false;
    }
}

