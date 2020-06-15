package otomasyonjava;

import java.awt.BorderLayout;
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class Kayit extends JFrame {

	private JPanel contentPane;
	private JTextField kitapAdiTB;
	private JTextField yazarAdiTB;
	private JTextField kitapTuruTB;
	private JTextField ucretTB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kayit frame = new Kayit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Kayit() {
		setTitle("Kay\u0131t ekleme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 278, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Anasayfa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anasayfa f2=new anasayfa();
				f2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(0, 5, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Kitap Ad\u0131:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 97, 66, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Yazar Ad\u0131:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(12, 199, 69, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kitap T\u00FCr\u00FC:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(12, 302, 76, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u00DCcret:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(12, 400, 42, 17);
		contentPane.add(lblNewLabel_3);
		
		kitapAdiTB = new JTextField();
		kitapAdiTB.setBounds(103, 94, 140, 22);
		contentPane.add(kitapAdiTB);
		kitapAdiTB.setColumns(10);
		
		yazarAdiTB = new JTextField();
		yazarAdiTB.setBounds(103, 196, 140, 22);
		contentPane.add(yazarAdiTB);
		yazarAdiTB.setColumns(10);
		
		kitapTuruTB = new JTextField();
		kitapTuruTB.setBounds(103, 299, 140, 22);
		contentPane.add(kitapTuruTB);
		kitapTuruTB.setColumns(10);
		
		ucretTB = new JTextField();
		ucretTB.setBounds(103, 397, 140, 22);
		contentPane.add(ucretTB);
		ucretTB.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Kaydet");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
String dosyaMetni = "";
				
				File dosya = new File("A:\\\\otomasyonjava\\\\src\\\\otomasyonjava\\\\liste.txt");

				FileReader fileReader = null;
				try {
					fileReader = new FileReader(dosya);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String line;

				BufferedReader br = new BufferedReader(fileReader);

				try {
					while ((line = br.readLine()) != null) {

					    dosyaMetni += line;

					}
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				 try {
				        if(!dosya.exists()){ 
				            dosya.createNewFile(); 
				        }else{
				        }
				    } catch (IOException k) { 
				        // TODO: handle exception
				        k.printStackTrace();
				    }
				
				try {
					String yazi = kitapAdiTB.getText().toString() + "," + yazarAdiTB.getText().toString() + "," + kitapTuruTB.getText().toString() + "," + ucretTB.getText().toString();
					dosyaMetni += "-" + yazi;
					FileWriter fileWriter = new FileWriter(dosya,false);
					BufferedWriter bWriter = new BufferedWriter(fileWriter);
					bWriter.write(dosyaMetni);
					bWriter.close();
				}
				catch (FileNotFoundException hata) {
					hata.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Kitap Kaydedildi!", "Baþarýlý" , JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(12, 466, 231, 25);
		contentPane.add(btnNewButton_1);
	}
}
