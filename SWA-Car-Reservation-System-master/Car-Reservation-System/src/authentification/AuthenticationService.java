package authentification;


public class AuthenticationService {
    private AuthenticationStrategy strategy;

    public AuthenticationService(AuthenticationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean authenticateSubject(Subject subject, Credential credential) {
        return strategy.authenticate(subject, credential);
    }
}

