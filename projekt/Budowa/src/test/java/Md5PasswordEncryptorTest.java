import org.budowa.services.Md5PasswordEncryptor;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class Md5PasswordEncryptorTest {
	Md5PasswordEncryptor encryptor = new Md5PasswordEncryptor();

	@Test
	public void checkEncryption () throws NoSuchAlgorithmException {
		String encrypted = encryptor.encryptPassword("test");
		String expectedHash = "098f6bcd4621d373cade4e832627b4f6";

		assertNotNull(encrypted);
		assertTrue(Objects.equals(encrypted, expectedHash));
	}
}
