package otomasyonjava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

public class anasayfa extends JFrame {
	private JPanel p1= new JPanel();
	private JLayeredPane gp1 = new JLayeredPane();
	

	private JPanel contentPane;

	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anasayfa frame = new anasayfa();
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
	public anasayfa() {
		setTitle("Stok Otomasyon");
	gp1.setBounds(0, 0, 600, 400);
    p1.setBounds(0, 0, 600, 400);
    p1.setOpaque(true);
    gp1.add(p1, new Integer(0), 0);				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 259, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton_1 = new JButton("Yeni Kay\u0131t");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kayit f3=new Kayit();
				f3.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton_1.setBounds(61, 27, 102, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("G\u00FCncelle");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Güncelle f4=new Güncelle();
				f4.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(61, 65, 102, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Listele");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Liste f5=new Liste();
				f5.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(61, 103, 102, 25);
		contentPane.add(btnNewButton_3);
	}
}
