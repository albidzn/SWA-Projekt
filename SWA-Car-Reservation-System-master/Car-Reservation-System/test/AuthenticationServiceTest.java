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

		// Act: Da die Strategie nun dynamisch ist, simulieren wir die Datenüberprüfung
		// Hier simulieren wir, dass die übergebenen Credentials nicht null sind
		boolean isAuthenticated = authService.authenticateSubject(subject, credential);

		// Assert: Authentifizierung sollte erfolgreich sein, wenn Credentials gültig
		// sind
		assertTrue(isAuthenticated, "Die Authentifizierung sollte erfolgreich sein.");
	}

	@Test
	public void testUserNamePasswordAuthenticationFailure() {
		// Arrange: Erstelle ein Subject und ein Credential mit falschen Daten
		Subject subject = new Subject("User123", "Person");
		Credential credential = new Credential(null, null); // Ungültige Credentials
		AuthenticationStrategy strategy = new UsernamePasswordStrategy();
		AuthenticationService authService = new AuthenticationService(strategy);

		// Act: Simuliere eine fehlgeschlagene Authentifizierung aufgrund von ungültigen
		// Daten
		boolean isAuthenticated = authService.authenticateSubject(subject, credential);

		// Assert: Authentifizierung sollte fehlschlagen, da die Credentials null sind
		assertFalse(isAuthenticated, "Die Authentifizierung sollte fehlschlagen.");
	}

	@Test
	public void testFingerPrintAuthenticationSuccess() {
		// Arrange: Erstelle ein Subject und ein Credential
		Subject subject = new Subject("User123", "Person");
		Credential credential = new Credential("fingerprint123");
		AuthenticationStrategy strategy = new FingerprintStrategy();
		AuthenticationService authService = new AuthenticationService(strategy);

		// Act: Simuliere eine erfolgreiche Authentifizierung mit Fingerabdruck
		boolean isAuthenticated = authService.authenticateSubject(subject, credential);

		// Assert: Authentifizierung sollte erfolgreich sein, wenn der Fingerabdruck
		// nicht null ist
		assertTrue(isAuthenticated, "Die Authentifizierung mit Fingerabdruck sollte erfolgreich sein.");
	}

	@Test
	public void testEyeScanAuthenticationSuccess() {
		// Arrange: Erstelle ein Subject und ein Credential
		Subject subject = new Subject("User123", "Person");
		Credential credential = new Credential("eyeScanABC", true);
		AuthenticationStrategy strategy = new EyeScanStrategy();
		AuthenticationService authService = new AuthenticationService(strategy);

		// Act: Simuliere eine erfolgreiche Authentifizierung mit Iris-Scan
		boolean isAuthenticated = authService.authenticateSubject(subject, credential);

		// Assert: Authentifizierung sollte erfolgreich sein, wenn der Iris-Scan nicht
		// null ist
		assertTrue(isAuthenticated, "Die Authentifizierung mit Iris-Scan sollte erfolgreich sein.");
	}

	@Test
	public void testEyeScanAuthenticationFailure() {
		// Arrange: Erstelle ein Subject und ein Credential mit ungültigem Iris-Scan
		Subject subject = new Subject("User123", "Person");
		Credential credential = new Credential(null, true); // Kein Iris-Scan
		AuthenticationStrategy strategy = new EyeScanStrategy();
		AuthenticationService authService = new AuthenticationService(strategy);

		// Act: Simuliere eine fehlgeschlagene Authentifizierung aufgrund eines
		// fehlenden Iris-Scans
		boolean isAuthenticated = authService.authenticateSubject(subject, credential);

		// Assert: Authentifizierung sollte fehlschlagen, wenn der Iris-Scan null ist
		assertFalse(isAuthenticated, "Die Authentifizierung mit ungültigem Iris-Scan sollte fehlschlagen.");
	}
}
