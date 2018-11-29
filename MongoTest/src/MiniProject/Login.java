package MiniProject;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

	private JFrame frame;
	private JTextField usernamefeild;
	private JPasswordField passwordfield;
	private JPanel jpane;

	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;

	void fermer() {
		frame.dispose();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Login frame = new Login();
					frame.frame.setVisible(true);
					frame.frame.setLocationRelativeTo(null);
					frame.frame.setTitle("Login");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 500);
		frame.getContentPane().setLayout(null);

		usernamefeild = new JTextField();
		usernamefeild.setBounds(399, 178, 200, 26);
		frame.getContentPane().add(usernamefeild);
		usernamefeild.setColumns(10);

		JLabel lblUserName = new JLabel("Username :");
		lblUserName.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
		lblUserName.setForeground(Color.GREEN);
		lblUserName.setBounds(326, 184, 74, 14);
		frame.getContentPane().add(lblUserName);

		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
		lblPassword.setForeground(Color.GREEN);
		lblPassword.setBounds(326, 213, 74, 14);
		frame.getContentPane().add(lblPassword);

		JButton btnNewButton = new JButton("Se Connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String username = usernamefeild.getText().toString();
				String password = passwordfield.getText().toString();

				if (username.equals("") && password.equals("")) {
					JOptionPane.showMessageDialog(null, "Remplissez Les Champs Vides ! ");

				} else {

					MenuAdministrateur obj = new MenuAdministrateur();
					obj.setVisible(true);
					obj.setLocationRelativeTo(null);

					fermer();

				}

			}
		});
		btnNewButton.setBounds(399, 243, 200, 31);
		frame.getContentPane().add(btnNewButton);

		passwordfield = new JPasswordField();
		passwordfield.setBounds(399, 206, 200, 26);
		frame.getContentPane().add(passwordfield);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\logo1.jpg"));
		lblNewLabel_1.setBounds(100, 0, 800, 72);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\background2.jpg"));
		lblNewLabel_2.setBounds(0, 74, 988, 392);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
