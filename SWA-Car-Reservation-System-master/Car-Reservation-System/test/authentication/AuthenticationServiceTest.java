package authentication;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import authentification.AuthenticationService;
import authentification.AuthenticationStrategy;
import authentification.Credential;
import authentification.EyeScanStrategy;
import authentification.FingerprintStrategy;
import authentification.Subject;
import authentification.UsernamePasswordStrategy;

public class AuthenticationServiceTest {

    @Test
    public void testUserNamePasswordAuthenticationSuccess() {
        // Arrange: Erstelle ein Subject und ein Credential
        Subject subject = new Subject("User123", "Person");
        Credential credential = new Credential("User123", "password");
        AuthenticationStrategy strategy = new UsernamePasswordStrategy();
        AuthenticationService authService = new AuthenticationService(strategy);

        // Act
        System.out.println("Testing Username/Password Authentication (Success case)");
        System.out.println("Subject: " + subject.getId() + ", Type: " + subject.getType());
        System.out.println("Credential: Username = " + credential.getUsername() + ", Password = " + credential.getPassword());

        boolean isAuthenticated = authService.authenticateSubject(subject, credential);

        // Assert
        System.out.println("Authentication Result: " + (isAuthenticated ? "Success" : "Failure"));
        assertTrue(isAuthenticated, "Die Authentifizierung sollte erfolgreich sein.");
    }

    @Test
    public void testUserNamePasswordAuthenticationFailure() {
        // Arrange: Erstelle ein Subject und ein Credential mit falschen Daten
        Subject subject = new Subject("User123", "Person");
        Credential credential = new Credential(null, null); // Ungültige Credentials
        AuthenticationStrategy strategy = new UsernamePasswordStrategy();
        AuthenticationService authService = new AuthenticationService(strategy);

        // Act
        System.out.println("Testing Username/Password Authentication (Failure case)");
        System.out.println("Subject: " + subject.getId() + ", Type: " + subject.getType());
        System.out.println("Credential: Username = " + credential.getUsername() + ", Password = " + credential.getPassword());

        boolean isAuthenticated = authService.authenticateSubject(subject, credential);

        // Assert
        System.out.println("Authentication Result: " + (isAuthenticated ? "Success" : "Failure"));
        assertFalse(isAuthenticated, "Die Authentifizierung sollte fehlschlagen.");
    }

    @Test
    public void testFingerPrintAuthenticationSuccess() {
        // Arrange: Erstelle ein Subject und ein Credential
        Subject subject = new Subject("User123", "Person");
        Credential credential = new Credential("fingerprint123");
        AuthenticationStrategy strategy = new FingerprintStrategy();
        AuthenticationService authService = new AuthenticationService(strategy);

        // Act
        System.out.println("Testing Fingerprint Authentication (Success case)");
        System.out.println("Subject: " + subject.getId() + ", Type: " + subject.getType());
        System.out.println("Credential: FingerPrint = " + credential.getFingerPrint());

        boolean isAuthenticated = authService.authenticateSubject(subject, credential);

        // Assert
        System.out.println("Authentication Result: " + (isAuthenticated ? "Success" : "Failure"));
        assertTrue(isAuthenticated, "Die Authentifizierung mit Fingerabdruck sollte erfolgreich sein.");
    }

    @Test
    public void testEyeScanAuthenticationSuccess() {
        // Arrange: Erstelle ein Subject und ein Credential
        Subject subject = new Subject("User123", "Person");
        Credential credential = new Credential("eyeScanABC", true);
        AuthenticationStrategy strategy = new EyeScanStrategy();
        AuthenticationService authService = new AuthenticationService(strategy);

        // Act
        System.out.println("Testing EyeScan Authentication (Success case)");
        System.out.println("Subject: " + subject.getId() + ", Type: " + subject.getType());
        System.out.println("Credential: EyeScan = " + credential.getEyeScan());

        boolean isAuthenticated = authService.authenticateSubject(subject, credential);

        // Assert
        System.out.println("Authentication Result: " + (isAuthenticated ? "Success" : "Failure"));
        assertTrue(isAuthenticated, "Die Authentifizierung mit Iris-Scan sollte erfolgreich sein.");
    }

    @Test
    public void testEyeScanAuthenticationFailure() {
        // Arrange: Erstelle ein Subject und ein Credential mit ungültigem Iris-Scan
        Subject subject = new Subject("User123", "Person");
        Credential credential = new Credential(null, true); // Kein Iris-Scan
        AuthenticationStrategy strategy = new EyeScanStrategy();
        AuthenticationService authService = new AuthenticationService(strategy);

        // Act
        System.out.println("Testing EyeScan Authentication (Failure case)");
        System.out.println("Subject: " + subject.getId() + ", Type: " + subject.getType());
        System.out.println("Credential: EyeScan = " + credential.getEyeScan());

        boolean isAuthenticated = authService.authenticateSubject(subject, credential);

        // Assert
        System.out.println("Authentication Result: " + (isAuthenticated ? "Success" : "Failure"));
        assertFalse(isAuthenticated, "Die Authentifizierung mit ungültigem Iris-Scan sollte fehlschlagen.");
    }
}
