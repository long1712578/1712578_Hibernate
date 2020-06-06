package QuanLy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RecheckJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtDiem;
	private JTextField txtLiDo;
	MyConnect myconnect=new MyConnect();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecheckJFrame frame = new RecheckJFrame();
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
	public RecheckJFrame() {
		//String mssv,String maMon
	}
	public RecheckJFrame(String mssv,String maMon) {
		myconnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 340);
		contentPane = new JPanel();
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(30, 144, 255)));
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(0, 0, 503, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PH\u00DAC KH\u1EA2O");
		lblNewLabel.setForeground(new Color(139, 0, 139));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(106, 22, 276, 47);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u1ED9t \u0111i\u1EC3m");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(62, 100, 91, 27);
		contentPane.add(lblNewLabel_1);
		
		JComboBox cbCotDiem = new JComboBox();
		cbCotDiem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		cbCotDiem.setModel(new DefaultComboBoxModel(new String[] {"    DiemGK", "    DiemCK", "    DiemKhac", "    DiemTong"}));
		cbCotDiem.setBounds(195, 95, 119, 37);
		contentPane.add(cbCotDiem);
		
		JLabel lblNewLabel_2 = new JLabel("\u0110i\u1EC3m mu\u1ED1n");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(57, 145, 91, 27);
		contentPane.add(lblNewLabel_2);
		
		txtDiem = new JTextField();
		txtDiem.setBounds(195, 146, 253, 27);
		contentPane.add(txtDiem);
		txtDiem.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("L\u00ED do");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2_1.setBounds(62, 195, 102, 37);
		contentPane.add(lblNewLabel_2_1);
		
		txtLiDo = new JTextField();
		txtLiDo.setBounds(195, 185, 253, 58);
		contentPane.add(txtLiDo);
		txtLiDo.setColumns(10);
		
		JButton btnGui = new JButton("G\u1EECI");
		btnGui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cotDiem=cbCotDiem.getSelectedItem().toString();
				Float diem=Float.parseFloat(txtDiem.getText());
				String liDo=txtLiDo.getText();
				//Lay ten sinhvien
				ResultSet rs=myconnect.getData("17hcb");
				try {
					while(rs.next()) {
						//System.out.println(rs.getString("MSSV"));
						if(rs.getString("MSSV").equals(mssv)) {
							MyConnect.insertInformation(mssv, rs.getString("HoTen"), maMon, cotDiem, diem, liDo);
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ResultSet rs1=myconnect.getData("18hcb");
				try {
					while(rs1.next()) {
						if(rs1.getString("MSSV").equals(mssv)) {
							MyConnect.insertInformation(mssv, rs1.getString("HoTen"), maMon, cotDiem, diem, liDo);
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGui.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGui.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnGui.setBounds(195, 254, 110, 36);
		contentPane.add(btnGui);
	}
}
