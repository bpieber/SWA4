package swa.ass4.client;

import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import swa.ass4.server.cxf.Greeter;

public class Client {
	public static void main(String args[]) throws Exception {
		URL wsdlURL = new URL("http://localhost:9000/Greeter?wsdl");
		QName SERVICE_NAME = new QName("http://cxf.server.ass4.swa/", "GreeterImplService");
		Service service = Service.create(wsdlURL, SERVICE_NAME);
		Greeter client = service.getPort(Greeter.class);
		final String result = client.greetMe("test");
		System.out.println(result);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(result);
            }
        });
	}
	private static void createAndShowGUI(String greeting) {
        JFrame frame = new JFrame("GreeterSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JLabel label = new JLabel(greeting);
        frame.getContentPane().add(label);
 
        frame.pack();
        frame.setVisible(true);
    }
}
