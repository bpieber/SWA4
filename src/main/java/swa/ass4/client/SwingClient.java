package swa.ass4.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import swa.ass4.server.cxf.LoginService;

public class SwingClient {
	public static void main(String args[]) throws Exception {
		// LoginService loginService = getLoginService();
		// User currentUser = loginService.login("admin", "password");

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowLoginGUI();
			}
		});
	}

	private static LoginService getLoginService() throws MalformedURLException {
		URL wsdlURL = new URL("http://localhost:9000/LoginService?wsdl");
		QName SERVICE_NAME = new QName("http://cxf.server.ass4.swa/",
				"LoginServiceImplService");
		Service service = Service.create(wsdlURL, SERVICE_NAME);
		LoginService loginService = service.getPort(LoginService.class);
		return loginService;
	}

	private static void createAndShowLoginGUI() {
		JFrame frame = new JFrame("University Grading System – Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel userNameLabel = new JLabel("Username");
		frame.getContentPane().add(userNameLabel);
		JLabel passwordLabel = new JLabel("Password");
		frame.getContentPane().add(passwordLabel);

		frame.pack();
		frame.setVisible(true);
	}
}
