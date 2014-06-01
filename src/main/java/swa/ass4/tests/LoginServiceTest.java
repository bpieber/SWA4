package swa.ass4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.BeforeClass;
import org.junit.Test;

import swa.ass4.server.cxf.LoginService;
import swa.ass4.server.cxf.LoginServiceImpl;
import swa.ass4.server.cxf.User;

public class LoginServiceTest {

	static LoginService remoteLoginService;

	@BeforeClass
	public static void getLoginService() throws MalformedURLException {
		URL wsdlURL = new URL("http://localhost:9000/LoginService?wsdl");
		QName SERVICE_NAME = new QName("http://cxf.server.ass4.swa/",
				"LoginServiceImplService");
		Service service = Service.create(wsdlURL, SERVICE_NAME);
		remoteLoginService = service.getPort(LoginService.class);
	}

	@Test
	public void testLoginSuccessLocal() {
		LoginService localLoginService = new LoginServiceImpl();
		User user = localLoginService.login("admin", "password");
		assertEquals("admin", user.getUserName());
		assertEquals("password", user.getPassword());
		assertEquals("Administrator", user.getRole());
	}

	@Test
	public void testLoginFailedLocal() {
		LoginService localLoginService = new LoginServiceImpl();
		User user = localLoginService.login("admin", "wrong");
		assertNull(user);
	}

	@Test
	public void testLoginSuccessRemote() {
		User user = remoteLoginService.login("admin", "password");
		assertEquals("admin", user.getUserName());
		assertEquals("password", user.getPassword());
		assertEquals("Administrator", user.getRole());
	}

	@Test
	public void testLoginFailedRemote() {
		User user = remoteLoginService.login("admin", "wrong");
		assertNull(user);
	}

}
