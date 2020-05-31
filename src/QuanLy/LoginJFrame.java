package QuanLy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	MyConnect myconnect=new MyConnect();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame();
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
	public LoginJFrame() {
		myconnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 585, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0102NG NH\u1EACP");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(115, 29, 350, 39);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(79, 148, 103, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(79, 208, 103, 36);
		contentPane.add(lblNewLabel_1_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(215, 152, 283, 28);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnDangNhap = new JButton("\u0110\u0102NG NH\u1EACP");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=txtUser.getText();
				String pass=txtPass.getText();
				int check=0;
				int check1=0;
				//Kiem tra neu user,pass thuoc sinh vien thi chuyen sang man hinh sinh vien
				//Kiem tra neu user,pass thuoc giao vu thi chuyen sang man hinh giao vu
				//Nguoc lai thong bao nhap sai user hoac pass
				ResultSet rs=myconnect.getData("login_student");
				try {
					while(rs.next()) {
						if(username.equals(rs.getString("username")) && pass.equals(rs.getString("pass"))) {
							StudentJFrame jframe1=new StudentJFrame(username);
							jframe1.setVisible(true);
							check=1;
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("dang nhap no thanh cong");
				}
				ResultSet rs1=myconnect.getData("login_admin");
				try {
					while(rs1.next()) {
						if(username.equals(rs1.getString("username")) && pass.equals(rs1.getString("pass"))) {
							MyJFrame myjframe=new MyJFrame();
							
							myjframe.setVisible(true);
							check1=1;
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(check!=1 && check1!=1) {
					JOptionPane.showMessageDialog(rootPane,"username hoac pass khong dung.");
				}
			}
		});
		btnDangNhap.setBackground(Color.WHITE);
		btnDangNhap.setForeground(Color.BLUE);
		btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDangNhap.setBounds(230, 275, 146, 36);
		contentPane.add(btnDangNhap);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(215, 212, 283, 28);
		contentPane.add(txtPass);
	}
}
