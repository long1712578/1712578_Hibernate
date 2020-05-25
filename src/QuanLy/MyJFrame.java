package QuanLy;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.awt.event.ActionEvent;


public class MyJFrame extends JFrame {
	private JTextField txtTen;
	private JTextField txtMSSV;
	private JTextField txtGioiTinh;
	private JTextField txtCMND;
	private JTable table;
	MyConnect myconnect=new MyConnect();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyJFrame frame = new MyJFrame();
					frame.setVisible(true);
					//frame.loadData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyJFrame() {
		//Connect data
		myconnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 463);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nh\u1EADp th\u00F4ng tin sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 657, 214);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMSSV = new JLabel("MSSV");
		lblMSSV.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMSSV.setBounds(20, 71, 66, 14);
		panel.add(lblMSSV);
		
		txtTen = new JTextField();
		txtTen.setBounds(96, 108, 259, 20);
		panel.add(txtTen);
		txtTen.setColumns(10);
		
		txtMSSV = new JTextField();
		txtMSSV.setBounds(96, 65, 259, 20);
		panel.add(txtMSSV);
		txtMSSV.setColumns(10);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(96, 149, 259, 20);
		panel.add(txtGioiTinh);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(96, 186, 259, 20);
		panel.add(txtCMND);
		
		JComboBox cbClass = new JComboBox();
		cbClass.setModel(new DefaultComboBoxModel(new String[] {"17hcb", "18hcb"}));
		cbClass.setBounds(20, 22, 66, 22);
		panel.add(cbClass);
		
		JLabel lblHoTen = new JLabel("H\u1ECD t\u00EAn");
		lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblHoTen.setBounds(20, 111, 66, 14);
		panel.add(lblHoTen);
		
		JLabel lblGioiTinh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblGioiTinh.setBounds(20, 152, 66, 14);
		panel.add(lblGioiTinh);
		
		JLabel lblCMND = new JLabel("CMND");
		lblCMND.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCMND.setBounds(20, 189, 66, 14);
		panel.add(lblCMND);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table1=cbClass.getSelectedItem().toString();
				int row=table.getSelectedRow();
				if(row<0) {
					JOptionPane.showMessageDialog(null, "Chua chon doi tuong can xoa",
							"Error delete",JOptionPane.ERROR_MESSAGE);
					return;
				}
				int select=JOptionPane.showOptionDialog(null, "Ban co muon xoa khong?", "Delete", 
						0,JOptionPane.YES_NO_OPTION , null, null, 1);
				if(select==0) {
					try {
						MyConnect.delete((String)table.getValueAt(row, 1), table1);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					loadData(table1);
				}
			}
		});
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnXoa.setBounds(488, 107, 89, 23);
		panel.add(btnXoa);
		
		JButton btnImport = new JButton("IMPORT");
		btnImport.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImport.setBounds(488, 148, 89, 23);
		panel.add(btnImport);
		
		JButton btnXem = new JButton("Xem DS");
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table1=cbClass.getSelectedItem().toString();
				loadData(table1);
				table.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		});
		btnXem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnXem.setBounds(488, 185, 89, 23);
		panel.add(btnXem);
		
		JButton btnThem = new JButton("th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table1=cbClass.getSelectedItem().toString();
				String MSSV=txtMSSV.getText();
				String Ten=txtTen.getText();
				String GioiTinh=txtGioiTinh.getText();
				String CMND=txtCMND.getText();
				Student student=new Student(MSSV,Ten,GioiTinh,CMND);
				try {
					MyConnect.insert(student, table1);
					loadData(table1);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnThem.setBounds(488, 67, 89, 23);
		panel.add(btnThem);
		
		//Create table
		table = new JTable();
		table.setBounds(20, 236, 647, 177);
		getContentPane().add(table);
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
		table.setModel(model);
	}
}
