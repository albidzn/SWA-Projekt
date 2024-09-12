package authentification;


public interface AuthenticationStrategy {
	boolean authenticate(Subject subject, Credential credential);
}
