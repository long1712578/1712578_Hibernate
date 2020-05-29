package QuanLy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TKBJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMSSV;
	private JTextField txtHoTen;
	private JTextField txtGioiTinh;
	private JTextField txtCMND;
	private JTable tableTKB;
	MyConnect myconnect=new MyConnect();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TKBJFrame frame = new TKBJFrame();
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
	public TKBJFrame() {
		myconnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(null, "Nh\u1EADp th\u00F4ng tin TKB", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(0, 11, 719, 252);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MSSV");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 78, 76, 38);
		panel.add(lblNewLabel);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmnd.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCmnd.setBounds(10, 183, 76, 38);
		panel.add(lblCmnd);
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGiiTnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiiTnh.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblGiiTnh.setBounds(10, 147, 76, 38);
		panel.add(lblGiiTnh);
		
		JLabel lblHTn = new JLabel("H\u1ECD t\u00EAn");
		lblHTn.setHorizontalAlignment(SwingConstants.CENTER);
		lblHTn.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblHTn.setBounds(10, 116, 76, 38);
		panel.add(lblHTn);
		
		txtMSSV = new JTextField();
		txtMSSV.setBounds(96, 87, 263, 20);
		panel.add(txtMSSV);
		txtMSSV.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(96, 125, 263, 20);
		panel.add(txtHoTen);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(96, 156, 263, 20);
		panel.add(txtGioiTinh);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(96, 192, 263, 20);
		panel.add(txtCMND);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"17hcb_ctt011", "17hcb_ctt012", "18hcb_ctt001", "18hcb_ctt002", "tkb_17hcb", "tkb_18hcb"}));
		comboBox.setBounds(485, 26, 121, 38);
		panel.add(comboBox);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table1=comboBox.getSelectedItem().toString();
				String MSSV=txtMSSV.getText();
				String Ten=txtHoTen.getText();
				String GioiTinh=txtGioiTinh.getText();
				String CMND=txtCMND.getText();
				//Kiem tra MSSV có trong danh sach chua hoac MSSV này có ton tại chưa
				try {
					if(checkStudent(MSSV,table1)==0) {
						Student student=new Student(MSSV,Ten,GioiTinh,CMND);
						try {
							MyConnect.insert(student, table1);
							loadData(table1);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if(checkStudent(MSSV,table1)==1) {
						JOptionPane.showMessageDialog(rootPane,"MSSV da ton tai.");
						}
					else {
						JOptionPane.showMessageDialog(rootPane,"Khong ton tai sinh vien nay.");
						}
				}catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}
		});
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnThem.setBounds(435, 86, 89, 23);
		panel.add(btnThem);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table1=comboBox.getSelectedItem().toString();
				int row=tableTKB.getSelectedRow();
				if(row<0) {
					JOptionPane.showMessageDialog(null, "Chua chon doi tuong can xoa",
							"Error delete",JOptionPane.ERROR_MESSAGE);
					return;
				}
				int select=JOptionPane.showOptionDialog(null, "Ban co muon xoa khong?", "Delete", 
						0,JOptionPane.YES_NO_OPTION , null, null, 1);
				if(select==0) {
					try {
						MyConnect.delete((String)tableTKB.getValueAt(row, 1), table1);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					loadData(table1);
				}
			}
		});
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnXoa.setBounds(571, 86, 89, 23);
		panel.add(btnXoa);
		
		JButton btnXemDs = new JButton("Xem DS");
		btnXemDs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table1=comboBox.getSelectedItem().toString();
				loadData(table1);
			}
		});
		btnXemDs.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnXemDs.setBounds(435, 183, 89, 23);
		panel.add(btnXemDs);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnSua.setBounds(500, 131, 89, 23);
		panel.add(btnSua);
		
		JButton btnBangDiem = new JButton("Xem điểm");
		btnBangDiem.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnBangDiem.setBounds(571, 183, 89, 23);
		panel.add(btnBangDiem);
		
		tableTKB = new JTable();
		tableTKB.setBounds(10, 275, 709, 157);
		contentPane.add(tableTKB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 274, 709, 158);
		contentPane.add(scrollPane);
	}
	private void loadData(String table1) {
		//String table1="17hcb";
		DefaultTableModel model=new DefaultTableModel();
		
		ResultSet rs=myconnect.getData(table1);
		try {
			ResultSetMetaData rsMD=rs.getMetaData();
			int colNumber=rsMD.getColumnCount();
			String[] arr=new String[colNumber];
			for(int i=0; i<colNumber;i++) {
				arr[i]=rsMD.getColumnName(i+1);
			}
			
			model.setColumnIdentifiers(arr);
			
			while(rs.next()) {
				for(int i=0;i<colNumber;i++) {
					arr[i]=rs.getString(i+1);
				}
				model.addRow(arr);
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		tableTKB.setModel(model);
	}
	private int checkStudent(String mssv,String table) throws NumberFormatException, SQLException {
		//Kiem tra mssv nay co trong lop hoc 17hcb khong
		//Neu khong tra ve 2
			String table1="17hcb";
			ResultSet rs1=myconnect.getData(table1);
			while(rs1.next()) {
				if(Integer.parseInt(rs1.getString(2))==Integer.parseInt(mssv)) {
					//Kiem tra mssv nay co trong bảng thời khóa biểu môn học này chưa,
					//Neu roi tra ve 1
					try {
						ResultSet rs=myconnect.getData(table);
						while(rs.next()) {
							if(Integer.parseInt(rs.getString(2))==Integer.parseInt(mssv)) {
								return 1;
							}
						}
						return 0;
					}catch (SQLException e) {
						// TODO: handle exception
					}
				}
			}
		
			String table2="18hcb";
			ResultSet rs2=myconnect.getData(table2);
			while(rs2.next()) {
				if(Integer.parseInt(rs2.getString(2))==Integer.parseInt(mssv)) {
					//Kiem tra mssv nay co trong bảng thời khóa biểu môn học này chưa,
					//Neu roi tra ve 1
					try {
						ResultSet rs=myconnect.getData(table);
						while(rs.next()) {
							if(Integer.parseInt(rs.getString(2))==Integer.parseInt(mssv)) {
								return 1;
							}
						}
						return 0;
					}catch (SQLException e) {
						// TODO: handle exception
					}
				}
			}
		
		return 2;
	}
}
