package QuanLy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TranscriptJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtGK;
	private JTextField txtCK;
	private JTextField txtDiemKhac;
	private JTextField txtDiemTong;
	MyConnect myconnect=new MyConnect();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TranscriptJFrame frame = new TranscriptJFrame();
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
	public TranscriptJFrame() {
		myconnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "B\u1EA3ng \u0111i\u1EC3m c\u1EE7a sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 11, 702, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"diem_17hcb_ctt011", "diem_17hcb_ctt012", "diem_18hcb_ctt001", "diem_18hcb_ctt002"}));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		comboBox.setBounds(241, 25, 120, 34);
		panel.add(comboBox);
		
		JLabel lbllop = new JLabel("Ch\u1ECDn L\u1EDBp");
		lbllop.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbllop.setBounds(152, 24, 79, 34);
		panel.add(lbllop);
		
		JButton btnSua = new JButton("S\u1EEDa \u0111i\u1EC3m");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float gk,khac,tong;
				float ck;
				String table1=comboBox.getSelectedItem().toString();
				gk=Float.parseFloat(txtGK.getText());
				ck=Float.parseFloat(txtCK.getText());
				khac=Float.parseFloat(txtDiemKhac.getText());
				tong=Float.parseFloat(txtDiemTong.getText());
				int row=table.getSelectedRow();
				String mssv=(String)table.getValueAt(row, 1);
				try {
					MyConnect.Update(gk, ck, khac, tong, mssv, table1);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				loadData(table1);
			}
		});
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(20, 65, 103, 28);
		panel.add(btnSua);
		
		JButton btnXemDiem = new JButton("Xem \u0111i\u1EC3m");
		btnXemDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table1=comboBox.getSelectedItem().toString();
				loadData(table1);
				table.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						int row=table.getSelectedRow();
						if(row<0) {
							JOptionPane.showMessageDialog(null, "Chua chon doi tuong can xoa",
									"Error Update",JOptionPane.ERROR_MESSAGE);
							return;
						}else {
							txtGK.setText((String)table.getValueAt(row, 3));
							txtCK.setText((String)table.getValueAt(row, 4));
							txtDiemKhac.setText((String)table.getValueAt(row, 5));
							txtDiemTong.setText((String)table.getValueAt(row, 6));
						}
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
		btnXemDiem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnXemDiem.setBounds(418, 25, 113, 34);
		panel.add(btnXemDiem);
		
		JLabel lblNewLabel_1 = new JLabel("\u0110i\u1EC3m GK");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 103, 79, 28);
		panel.add(lblNewLabel_1);
		
		txtGK = new JTextField();
		txtGK.setBounds(104, 103, 97, 28);
		panel.add(txtGK);
		txtGK.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u0110i\u1EC3m CK");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_1.setBounds(10, 146, 79, 28);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u0110i\u1EC3m kh\u00E1c");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2.setBounds(10, 185, 79, 28);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\u0110i\u1EC3m t\u1ED5ng");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_3.setBounds(10, 224, 79, 28);
		panel.add(lblNewLabel_1_3);
		
		txtCK = new JTextField();
		txtCK.setColumns(10);
		txtCK.setBounds(104, 142, 97, 28);
		panel.add(txtCK);
		
		txtDiemKhac = new JTextField();
		txtDiemKhac.setColumns(10);
		txtDiemKhac.setBounds(104, 180, 97, 28);
		panel.add(txtDiemKhac);
		
		txtDiemTong = new JTextField();
		txtDiemTong.setColumns(10);
		txtDiemTong.setBounds(104, 224, 97, 28);
		panel.add(txtDiemTong);
		
		
		table = new JTable();
		table.setBounds(10, 285, 702, 122);
		contentPane.add(table);
	}
	
	private void loadData(String table1) {
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
			System.out.println("Error SQL");
		}
		table.setModel(model);
	}
}
