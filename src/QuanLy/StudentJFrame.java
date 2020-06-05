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
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StudentJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private String dataUser;
	private JTable table;
	MyConnect myconnect=new MyConnect();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentJFrame frame = new StudentJFrame();
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
	private StudentJFrame() {	
	//String username
	}
	public StudentJFrame(String username) {
		myconnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setForeground(Color.CYAN);
		panel.setBounds(10, 11, 711, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SINH VI\u00CAN");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-29, 11, 206, 39);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginJFrame jfame=new LoginJFrame();
				jfame.setVisible(true);
			}
		});
		btnNewButton.setBounds(567, 19, 102, 23);
		panel.add(btnNewButton);
		
		txtName = new JTextField();
		txtName.setBounds(120, 20, 86, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		this.dataUser=username;
		txtName.setText(dataUser);
		
		JButton btnNewButton_1 = new JButton("\u0110\u1ED5i pass");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input=JOptionPane.showInputDialog(this,"Enter new password!");
				if(input!=null) {
					try {
						MyConnect.updataPass(dataUser, input);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					
				}
				
			}
		});
		btnNewButton_1.setBounds(446, 19, 89, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 83, 701, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnXem = new JButton("Tra cứu điểm");
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Kiểm tra dùng mssv tìm kiếm tên trong danh sách lớp học học
					//Tìm kiếm lớp 
				DefaultTableModel tableModel=new DefaultTableModel();
				tableModel=(DefaultTableModel) table.getModel();
				List<MyStudent>listST=new ArrayList<>();
				String table1="diem_18hcb_ctt001";
				ResultSet rs1=myconnect.getData(table1);
				try {
					while(rs1.next()) {
						if(username.equals(rs1.getString("MSSV"))) {
							ResultSet rs11=myconnect.getData("tkb_18hcb");
							while(rs11.next()) {
								if(rs11.getString("MaMon").equals("CTT001")) {
									MyStudent myST=new MyStudent(rs11.getString(2),rs11.getString(3),rs11.getString(4),rs1.getFloat(4),
											rs1.getFloat(5),rs1.getFloat(6),rs1.getFloat(7));
									listST.add(myST);
								}
							}
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Loi nay");
					e1.printStackTrace();
				}
				
				String table2="diem_17hcb_ctt011";
				ResultSet rs2=myconnect.getData(table2);
				try {
					while(rs2.next()) {
						if(username.equals(rs2.getString("MSSV"))) {
							ResultSet rs22=myconnect.getData("tkb_17hcb");
							while(rs22.next()) {
								if(rs22.getString("MaMon").equals("CTT011")) {
									MyStudent myST=new MyStudent(rs22.getString(2),rs22.getString(3),rs22.getString(4),rs2.getFloat(4),
											rs2.getFloat(5),rs2.getFloat(6),rs2.getFloat(7));
									listST.add(myST);
								}
							}
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Loi nay");
					e1.printStackTrace();
				}
				tableModel.setRowCount(1);
					for(MyStudent student : listST) {
						tableModel.addRow(new Object[] {
								student.getMaMon(),student.getTenMon(),student.getPhong(),student.getDiemGK(),
								student.getDiemCK(),student.getDiemKhac(),student.getDiemTong()
						});
					}
					
				} 
		});
		btnXem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnXem.setBounds(135, 11, 106, 39);
		panel_1.add(btnXem);
		
		JButton btnPhucKhao = new JButton("Phúc khảo");
		btnPhucKhao.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnPhucKhao.setBounds(444, 11, 106, 39);
		panel_1.add(btnPhucKhao);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"M\u00E3 m\u00F4n", "T\u00EAn m\u00F4n", "Ph\u00F2ng", "\u0110i\u1EC3m GK", "\u0110i\u1EC3m CK", "\u0110i\u1EC3m kh\u00E1c", "\u0110i\u1EC3m tg"},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 m\u00F4n", "T\u00EAn M\u00F4n", "Ph\u00F2ng", "\u0110i\u1EC3m GK", "\u0110i\u1EC3m CK", "\u0110i\u1EC3m kh\u00E1c", "\u0110i\u1EC3m t\u1ED5ng"
			}
		));
		table.setBounds(30, 155, 691, 204);
		contentPane.add(table);
	}
}
