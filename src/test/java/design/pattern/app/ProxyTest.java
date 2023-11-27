package design.pattern.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import design.pattern.app.proxy.Printable;
import design.pattern.app.proxy.PrinterProxy;
import design.pattern.app.proxy.aspect.Aspect;
import design.pattern.app.proxy.aspect.Logging;
import design.pattern.app.proxy.aspect.UserAuth;

public class ProxyTest {

	@Test
	void PrinterTest() {	
		Aspect logging = new Logging();
		Aspect userAuth = new UserAuth();
		Printable printer = new PrinterProxy("samsung", logging, userAuth);
		String message = "Hello World!";
		String printedString = printer.print(message);
		
		String expected = "<samsung>" + message + "</samsung>";
		
		assertEquals(printedString, expected);
	}
	
	@Test
	void PrinterMockTest() {
		Aspect logging = mock(Aspect.class);
		Aspect userAuth = mock(Aspect.class);
		
		Printable printer = new PrinterProxy("samsung", logging, userAuth);
		String message = "Hello World!";
		String printedString = printer.print(message);
		
		String expected = "<samsung>" + message + "</samsung>";
		assertEquals(printedString, expected);
		
		verify(logging, times(1)).before();
		verify(userAuth, times(1)).before();
		verify(logging, times(1)).after();
		verify(userAuth, times(1)).after();
	}
}
