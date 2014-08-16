package com.starfarers.service.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SecurityServiceTest {

	private transient SecurityService instance = new SecurityService();

	@Test
	public void testEncodePassword() {
		String password = "password";
		String encoded = instance.encode(password);
		assertNotNull(encoded);
		assertTrue(instance.matches(encoded, password));
		assertTrue(instance.matches("$2a$10$knG.O2IVKtO0nbSw/uiu2utevDef34hAIBqxFEbCrGOYbx9AB9eEW", password));
		assertTrue(instance.matches(instance.encode(password), password));
	}

}