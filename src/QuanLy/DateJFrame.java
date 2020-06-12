package QuanLy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DateJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNgay1;
	private JTextField txtThang1;
	private JTextField txtNam1;
	private JTextField txtNgay2;
	private JTextField txtThang2;
	private JTextField txtNam2;
	MyConnect myconnect=new MyConnect();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateJFrame frame = new DateJFrame();
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
	public DateJFrame() {
		//String MaLop
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public DateJFrame(String MaLop) {
		myconnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u1EA1o gi\u1EDBi h\u1EA1n th\u1EDDi gian");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(72, 11, 270, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ng\u00E0y b\u1EAFt \u0111\u1EA7u");
		lblNewLabel_1.setBounds(10, 103, 73, 32);
		contentPane.add(lblNewLabel_1);
		
		txtNgay1 = new JTextField();
		txtNgay1.setBounds(93, 109, 73, 20);
		contentPane.add(txtNgay1);
		txtNgay1.setColumns(10);
		
		txtThang1 = new JTextField();
		txtThang1.setColumns(10);
		txtThang1.setBounds(211, 109, 73, 20);
		contentPane.add(txtThang1);
		
		txtNam1 = new JTextField();
		txtNam1.setColumns(10);
		txtNam1.setBounds(330, 109, 73, 20);
		contentPane.add(txtNam1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ng\u00E0y b\u1EAFt \u0111\u1EA7u");
		lblNewLabel_1_1.setBounds(10, 164, 73, 32);
		contentPane.add(lblNewLabel_1_1);
		
		txtNgay2 = new JTextField();
		txtNgay2.setColumns(10);
		txtNgay2.setBounds(93, 170, 73, 20);
		contentPane.add(txtNgay2);
		
		txtThang2 = new JTextField();
		txtThang2.setColumns(10);
		txtThang2.setBounds(211, 170, 73, 20);
		contentPane.add(txtThang2);
		
		txtNam2 = new JTextField();
		txtNam2.setColumns(10);
		txtNam2.setBounds(330, 170, 73, 20);
		contentPane.add(txtNam2);
		
		JButton btnHuy = new JButton("H\u1EE7y");
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnHuy.setBounds(103, 227, 89, 23);
		contentPane.add(btnHuy);
		
		JButton btnXacNhan = new JButton("X\u00E1c nh\u1EADn");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date1=new Date(txtNgay1.getText(),txtThang1.getText(),txtNam1.getText());
				Date date2=new Date(txtNgay2.getText(),txtThang2.getText(),txtNam2.getText());
				//insert du lieu vao ngay_phuckhao
				try {
					MyConnect.insertDate(MaLop, date1, date2);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("Loi inset sql");
					e1.printStackTrace();
				}
				
			}
		});
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnXacNhan.setBounds(256, 227, 89, 23);
		contentPane.add(btnXacNhan);
		
		JLabel lblNewLabel_2 = new JLabel("/");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(176, 112, 28, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("/");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(292, 112, 28, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("/");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(176, 173, 28, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("/");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_3.setBounds(294, 173, 28, 14);
		contentPane.add(lblNewLabel_2_3);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
