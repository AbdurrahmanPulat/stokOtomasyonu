package otomasyonjava;

import java.awt.BorderLayout;
import java.io.*;
import java.util.ArrayList;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class Liste extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Liste frame = new Liste();
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
	public Liste() {
		setTitle("Kay\u0131t Listeleme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Anasayfa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anasayfa f2=new anasayfa();
				f2.setVisible(true);
				dispose();
			}
		});
		
		
		String dosyaMetni = "";
		String dosyaMetni2 = "";
		File dosya = new File("A:\\otomasyonjava\\src\\otomasyonjava\\liste.txt");

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
		
		ArrayList kitapAdList = new ArrayList();
		ArrayList yazarAdList = new ArrayList();
		ArrayList kitapTurList = new ArrayList();
		ArrayList kitapUcretList = new ArrayList();
		
		String[] liste = dosyaMetni.split("-");
		for (int i = 0; i< liste.length ; i++ ) {
			String satir = liste[i].toString();
			String[] satirDizi = satir.split(",");
			kitapAdList.add(satirDizi[0].toString());
			yazarAdList.add(satirDizi[1].toString());
			kitapTurList.add(satirDizi[2].toString());
			kitapUcretList.add(satirDizi[3].toString());
		}
		
		
		btnNewButton_2.setBounds(0, 13, 97, 25);
		contentPane.add(btnNewButton_2);
		String col[] = {"Kitap Adi","Yazar Adi","Tür","Ucret"};
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Arial", Font.BOLD, 12));
		table.setBounds(29, 10, 481, 167);
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		for (int i = 0; i < kitapAdList.size(); i++) {
			Object[] objs = {kitapAdList.get(i).toString(), yazarAdList.get(i).toString(), kitapTurList.get(i).toString(), kitapUcretList.get(i).toString()};
			tableModel.addRow(objs);
		}
		table = new JTable(tableModel);
		table.setBounds(10, 51, 295, 195);
		//contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 410, 208);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
	}
}
