package swa.ass4.client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 297, 128);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);

		JLabel lblUserName = new JLabel("User Name");
		panel_1.add(lblUserName);

		txtUserName = new JTextField();
		panel_1.add(txtUserName);
		txtUserName.setColumns(10);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);

		JLabel lblPassword = new JLabel("Password");
		panel.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		panel.add(txtPassword);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnLogin);

		JButton btnCancel = new JButton("Cancel");
		panel_2.add(btnCancel);
	}

}
