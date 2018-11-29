package MiniProject ;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MenuAdministrateur extends JFrame {

	private JPanel contentPane;
	
	void fermer()
	{
		dispose();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdministrateur frame = new MenuAdministrateur();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Menu");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuAdministrateur() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				"D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\logo1.jpg"));
		lblNewLabel_1.setBounds(100, 0, 988, 72);
		contentPane.add(lblNewLabel_1);
		
		JButton btnConsulate = new JButton("");
		btnConsulate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Consultation obj = new Consultation();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				fermer();

			}
		});
		btnConsulate.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\Zooicon.png"));
		btnConsulate.setBounds(409, 83, 170, 156);
		contentPane.add(btnConsulate);
		

		
		JButton btnadd = new JButton("");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Insertion obj = new Insertion();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				fermer();

				}
		});
		btnadd.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\addd.png"));
		btnadd.setBounds(229, 277, 170, 156);
		contentPane.add(btnadd);
		
		
		JButton btnmodif = new JButton("");
		btnmodif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Update obj = new Update();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				fermer();
				}
		});
		
		btnmodif.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\param.png"));
		btnmodif.setBounds(409, 277, 170, 156);
		contentPane.add(btnmodif);
		
		
		JButton btnSUPP = new JButton("");
		btnSUPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Delete obj = new Delete();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				fermer();
				}
		});
		btnSUPP.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\delete.png"));
		btnSUPP.setBounds(589, 277, 180, 156);
		contentPane.add(btnSUPP);
		
		JLabel lblConsultation = new JLabel("Consultation :");
		lblConsultation.setFont(new Font("Calibri", Font.BOLD, 15));
		lblConsultation.setForeground(Color.DARK_GRAY);
		lblConsultation.setBounds(436, 250, 123, 14);
		contentPane.add(lblConsultation);
		
		JLabel lblInsertion = new JLabel("Insertion :" );
		lblInsertion.setFont(new Font("Calibri", Font.BOLD, 15));
		lblInsertion.setForeground(Color.DARK_GRAY);
		lblInsertion.setBounds(260, 442, 139, 14);
		contentPane.add(lblInsertion);	
		JLabel lblModifier = new JLabel("Modification :");
		lblModifier.setFont(new Font("Calibri", Font.BOLD, 15));
		lblModifier.setForeground(Color.DARK_GRAY);
		lblModifier.setBounds(440, 442, 139, 14);
		contentPane.add(lblModifier);
		
		JLabel lblSupprimer = new JLabel("Suppression :");
		lblSupprimer.setFont(new Font("Calibri", Font.BOLD, 15));
		lblSupprimer.setForeground(Color.DARK_GRAY);
		lblSupprimer.setBounds(635, 442, 106, 14);
		contentPane.add(lblSupprimer);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\TP_JAVA\\Java_MongoDB\\MongoTest\\img\\background3.jpg"));
		lblNewLabel_2.setBounds(0, 74, 988, 392);
		contentPane.add(lblNewLabel_2);
		
	}
}
