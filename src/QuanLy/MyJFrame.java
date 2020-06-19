package QuanLy;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.awt.event.ActionEvent;


public class MyJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTen;
	private JTextField txtMSSV;
	private JTextField txtGioiTinh;
	private JTextField txtCMND;
	private JTextField txtSTT;
	private JTable table;
	MyConnect myconnect=new MyConnect();
	private JTextField txtFileName;

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
		
		JLabel lblSTT = new JLabel("STT");
		lblSTT.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSTT.setBounds(20, 53, 66, 14);
		panel.add(lblSTT);
		
		JLabel lblMSSV = new JLabel("MSSV");
		lblMSSV.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMSSV.setBounds(20, 85, 66, 14);
		panel.add(lblMSSV);
		
		txtSTT = new JTextField();
		txtSTT.setBounds(96, 48, 259, 20);
		panel.add(txtSTT);
		txtSTT.setColumns(10);
		
		txtTen = new JTextField();
		txtTen.setBounds(96, 113, 259, 20);
		panel.add(txtTen);
		txtTen.setColumns(10);
		
		txtMSSV = new JTextField();
		txtMSSV.setBounds(96, 80, 259, 20);
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
		cbClass.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cbClass.setModel(new DefaultComboBoxModel(new String[] {"17hcb", "18hcb"}));
		cbClass.setBounds(214, 22, 75, 22);
		panel.add(cbClass);
		
		JLabel lblHoTen = new JLabel("H\u1ECD t\u00EAn");
		lblHoTen.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblHoTen.setBounds(20, 118, 66, 14);
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
				if(table1.equals("17hcb")) {
					if(row<0) {
						JOptionPane.showMessageDialog(null, "Chua chon doi tuong can xoa",
								"Error delete",JOptionPane.ERROR_MESSAGE);
						return;
					}
					int select=JOptionPane.showOptionDialog(null, "Ban co muon xoa khong?", "Delete", 
							0,JOptionPane.YES_NO_OPTION , null, null, 1);
					if(select==0) {
						try {
							//System.out.println((String)table.getValueAt(row, 1));
							MyConnect.delete((String)table.getValueAt(row, 1),"lop17hcb");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						loadData("lop17hcb");
					}
				}else {
					if(row<0) {
						JOptionPane.showMessageDialog(null, "Chua chon doi tuong can xoa",
								"Error delete",JOptionPane.ERROR_MESSAGE);
						return;
					}
					int select=JOptionPane.showOptionDialog(null, "Ban co muon xoa khong?", "Delete", 
							0,JOptionPane.YES_NO_OPTION , null, null, 1);
					if(select==0) {
						try {
							MyConnect.delete((String)table.getValueAt(row, 1), "lop18hcb");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						loadData("lop18hcb");
					}
				}
			}
		});
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnXoa.setBounds(558, 166, 89, 23);
		panel.add(btnXoa);
		
		JButton btnXem = new JButton("Xem DS");
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table1=cbClass.getSelectedItem().toString();
				if(table1.equals("17hcb")) {
					loadData("lop17hcb");
				}else {
					loadData("lop18hcb");
				}

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
		btnXem.setBounds(421, 166, 89, 23);
		panel.add(btnXem);
		
		JButton btnThem = new JButton("th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table1=cbClass.getSelectedItem().toString();
				String stt=txtSTT.getText();
				String MSSV=txtMSSV.getText();
				String Ten=txtTen.getText();
				String GioiTinh=txtGioiTinh.getText();
				String CMND=txtCMND.getText();
				if(table1.equals("17hcb")) {
					Student student=new Student(Integer.valueOf(stt),MSSV,Ten,GioiTinh,CMND,"17HCB");
					try {
						MyConnect.insert(student, "lop17hcb");
						loadData("lop17hcb");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					Student student=new Student(MSSV,Ten,GioiTinh,CMND,"18HCB");
					try {
						MyConnect.insert(student, "lop18hcb");
						loadData("lop18hcb");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnThem.setBounds(558, 121, 89, 23);
		panel.add(btnThem);
		
		JButton btnTKB = new JButton("Xem TKB");
		btnTKB.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnTKB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TKBJFrame tkb=new TKBJFrame();
				tkb.setVisible(true);
			}
		});
		btnTKB.setBounds(421, 121, 89, 23);
		panel.add(btnTKB);
		
		JButton btnNewButton = new JButton("\u0110\u1ED5i pass");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input=JOptionPane.showInputDialog("Enter new password!");
				if(input!=null) {
					try {
						MyConnect.updataPassAdmin(input);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		btnNewButton.setBounds(20, 22, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnDangXuat = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				LoginJFrame jfame=new LoginJFrame();
				jfame.setVisible(true);
			}
		});
		btnDangXuat.setBounds(558, 71, 89, 23);
		panel.add(btnDangXuat);
		
		
		JButton btnPhucKhao = new JButton("DS ph\u00FAc kh\u1EA3o");
		btnPhucKhao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformationReCheckJFrame jframe=new InformationReCheckJFrame();
				jframe.setVisible(true);
			}
		});
		btnPhucKhao.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnPhucKhao.setBounds(421, 71, 89, 23);
		panel.add(btnPhucKhao);
		
		JLabel lblNewLabel = new JLabel("File name");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(319, 19, 66, 28);
		panel.add(lblNewLabel);
		
		txtFileName = new JTextField();
		txtFileName.setBounds(390, 23, 163, 20);
		panel.add(txtFileName);
		txtFileName.setColumns(10);
		
		Button btnFileName = new Button("Browse file");
		btnFileName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser=new JFileChooser("data");
				chooser.setMultiSelectionEnabled(false);
				
				int action=chooser.showOpenDialog(btnFileName);
				if(action==JFileChooser.APPROVE_OPTION) {
					File csvFile=chooser.getSelectedFile();
					String fileName=csvFile.getAbsolutePath();
					txtFileName.setText(fileName);
					//import diem_17hcb_ctt012
					if(fileName.contains("diem_17hcb_ctt012")) {
						try {
							ImportFileCSVPoint (csvFile,"diem_17hcb_ctt012");
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							System.out.println("ERRoR1");
							e1.printStackTrace();
						}
						//import diem_18hcb_ctt002
					}else if(fileName.contains("diem_18hcb_ctt002")) {
						try {
							ImportFileCSVPoint (csvFile,"diem_18hcb_ctt002");
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							System.out.println("ERRoR1");
							e1.printStackTrace();
						}
					}else if(fileName.contains("17HCB")) {
						try {
							ImportFileCSVClass(csvFile, "lop17hcb");
							ImportFilesubjects(csvFile, "17hcb_ctt011");
							ImportFilesubjects(csvFile, "17hcb_ctt012");
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else if(fileName.contains("18HCB")) {
						try {
							ImportFileCSVClass(csvFile, "lop18hcb");
							ImportFilesubjects(csvFile, "18hcb_ctt001");
							ImportFilesubjects(csvFile, "18hcb_ctt002");
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//import tkb
					}else if(fileName.contains("TKB_17hcb")) {
						String line="";
						try(BufferedReader br=new BufferedReader(new FileReader(csvFile))){
							line=br.readLine();
							System.out.println(line);
							while((line=br.readLine())!=null && !line.isEmpty()) {
								String fields[]=line.split(",");
								MyConnect.insertTKB(fields[1],fields[2],fields[3],fields[4],"tkb_17hcb");
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else if(fileName.contains("TKB_18hcb")) {
						String line="";
						try(BufferedReader br=new BufferedReader(new FileReader(csvFile))){
							line=br.readLine();
							System.out.println(line);
							while((line=br.readLine())!=null && !line.isEmpty()) {
								String fields[]=line.split(",");
								MyConnect.insertTKB(fields[1],fields[2],fields[3],fields[4],"tkb_18hcb");
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnFileName.setBackground(Color.GRAY);
		btnFileName.setBounds(558, 22, 75, 20);
		panel.add(btnFileName);
		
		//Create table
		table = new JTable();

//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null,null},
//			},
//			new String[] {
//				"STT", "MSSV", "Ho ten", "Gioi Tinh", "CMND","MaLop"
//			}
//		));
		table.setBackground(new Color(255, 255, 255));
		table.setBounds(20, 236, 647, 177);
		getContentPane().add(table);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
			String[]title= {"STT","MSSV","Ten","Gioi Tinh","CMND","MaLop"};
			model.addRow(title);
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
	private List<Student> readFileCSV(File file) throws FileNotFoundException, IOException{
		List<Student> listStudent=new ArrayList<Student>();
		String line=" ";
		try(BufferedReader br=new BufferedReader(new FileReader(file))){
			line=br.readLine();
			while((line=br.readLine())!=null && !line.isEmpty()) {
				
				String fields[]=line.split(",");
				Student st=new Student(Integer.parseInt(fields[0]),fields[1],fields[2],fields[3],fields[4],fields[5]);
				listStudent.add(st);
			}
		}
		return listStudent;
	}
	private void ImportFileCSVPoint (File file, String tablePiont) throws FileNotFoundException, IOException, ClassNotFoundException {
		String line="";
		try(BufferedReader br=new BufferedReader(new FileReader(file))){
			line=br.readLine();
			System.out.println(line);
			while((line=br.readLine())!=null && !line.isEmpty()) {
				String fields[]=line.split(",");
				MyConnect.insertImportPoint(fields[0],fields[1],fields[2], fields[3], fields[4], fields[5], fields[6],fields[7],tablePiont);
			}
		}
	}
	
	private void ImportFileCSVClass (File file, String tableClass) throws FileNotFoundException, IOException, ClassNotFoundException {
		String line="";
		try(BufferedReader br=new BufferedReader(new FileReader(file))){
			line=br.readLine();
			System.out.println(line);
			while((line=br.readLine())!=null && !line.isEmpty()) {
				String fields[]=line.split(",");
				Student st=new Student(Integer.valueOf(fields[0]),fields[1],fields[2],fields[3],fields[4],fields[5]);
				MyConnect.insert(st, tableClass);
			}
		}
	}
	
	private void ImportFilesubjects (File file, String tableClass) throws FileNotFoundException, IOException, ClassNotFoundException {
		String line="";
		try(BufferedReader br=new BufferedReader(new FileReader(file))){
			line=br.readLine();
			System.out.println(line);
			while((line=br.readLine())!=null && !line.isEmpty()) {
				String fields[]=line.split(",");
				Student st=new Student(Integer.valueOf(fields[0]),fields[1],fields[2],fields[3],fields[4],fields[5]);
				MyConnect.insertSubject(st, tableClass);
			}
		}
	}
	
	public void close() {
		WindowEvent windowEvent= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowEvent);
	}
}

