package authentification;


public class EyeScanStrategy implements AuthenticationStrategy {
    @Override
    public boolean authenticate(Subject subject, Credential credential) {
        if (credential.getEyeScan() != null) {
            return true;
        }
        return false;
    }
}


