package MiniProject;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import java.awt.GridLayout;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField prenomfeild;
	private JTextField nomfeild;
	private JTextField cinfeild;
	private JTextField numtelfeild;
	private JTextField adressefeild;
	private JTextField datenaissfeild;
	private JTextField groupefeild;
	private String s;

	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JTable table;

	/**
	 * Launch the application.
	 */

	void fermer() {
		dispose();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Delete");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\logo1.jpg"));
		lblNewLabel_1.setBounds(100, 0, 988, 72);
		contentPane.add(lblNewLabel_1);

		cinfeild = new JTextField();
		cinfeild.setColumns(10);
		cinfeild.setBounds(179, 165, 285, 30);
		contentPane.add(cinfeild);

		JLabel cin = new JLabel("CIN : ");
		cin.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		cin.setBounds(134, 170, 40, 22);
		contentPane.add(cin);
		cin.setOpaque(false);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				MenuAdministrateur obj = new MenuAdministrateur();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				fermer();

			}
		});
		lblNewLabel_6.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\back.png"));
		lblNewLabel_6.setBounds(10, 77, 47, 45);
		contentPane.add(lblNewLabel_6);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Ncin = cinfeild.getText().toString();

				// Creating a Mongo client
				MongoClient mongo = new MongoClient("localhost", 27017);

				// Creating Credentials
				MongoCredential credential;
				credential = MongoCredential.createCredential("Haythem", "MongoDATA", "password".toCharArray());
				System.out.println("Connected to the database successfully");

				// Accessing the database
				MongoDatabase database = mongo.getDatabase("MongoDATA");
				// Retrieving a collection
				MongoCollection<Document> collection = database.getCollection("mongoDATA");
				System.out.println("Collection mongoDATA selected successfully");
				///////////////////////////////

				collection.deleteOne(Filters.eq("cin", Ncin));
				///////////////////////////////
				JOptionPane.showMessageDialog(null, "Document deleted successfully... ");
			}
		});
		button.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\delll.png"));
		button.setBounds(260, 388, 64, 67);
		contentPane.add(button);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\b2.jpg"));
		lblNewLabel_2.setBounds(0, 74, 988, 392);
		contentPane.add(lblNewLabel_2);
	}

}
