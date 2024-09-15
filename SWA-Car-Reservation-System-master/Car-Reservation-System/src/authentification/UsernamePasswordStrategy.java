package authentification;


public class UsernamePasswordStrategy implements AuthenticationStrategy {
    @Override
    public boolean authenticate(Subject subject, Credential credential) {
        if (credential.getUsername() != null && credential.getPassword() != null) {
            return true;
        }
        return false;
    }
}






