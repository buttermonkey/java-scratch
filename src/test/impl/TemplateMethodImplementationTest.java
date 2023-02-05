package impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMethodImplementationTest {

	@Test
	void doPrint() {
		assertDoesNotThrow(() -> new TemplateMethodImplementation().print());
	}
}