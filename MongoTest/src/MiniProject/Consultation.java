package MiniProject;

import java.awt.Color;
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
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sun.glass.ui.Size;

import java.awt.GridLayout;

public class Consultation extends JFrame {

	private JPanel contentPane;
	private JTextField prenomfeild;
	private JTextField nomfeild;
	private JTextField cinfeild;
	private JTextField numtelfeild;
	private JTextField adressefeild;
	private JTextField datenaissfeild;
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
					Consultation frame = new Consultation();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Consultation");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Consultation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\logo1.jpg"));
		lblNewLabel_1.setBounds(100, 0, 988, 116);
		contentPane.add(lblNewLabel_1);

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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 116, 700, 339);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_5 = new JLabel("Table des Etudiants : ");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setBounds(800, 91, 148, 14);
		contentPane.add(lblNewLabel_5);

		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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

				// Retrieving the documents after updation
				// Getting the iterable object
				FindIterable<Document> iterDoc = collection.find();
				int i = 1;

				// Getting the iterator
				Iterator it = iterDoc.iterator();

				while (it.hasNext()) {
					System.out.println(it.next());
					i++;
				}
			}
		});
		button_2.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\search_b_icon.png"));
		button_2.setBounds(130, 250, 64, 67);
		contentPane.add(button_2);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\b3.jpg"));
		lblNewLabel_2.setBounds(0, 74, 1000, 392);
		contentPane.add(lblNewLabel_2);
	}

}
