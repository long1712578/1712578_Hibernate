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
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InformationReCheckJFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	MyConnect myconnect=new MyConnect();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformationReCheckJFrame frame = new InformationReCheckJFrame();
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
	public InformationReCheckJFrame() {
		myconnect.connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 614, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh s\u00E1ch ph\u00FAc kh\u1EA3o");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(164, 25, 327, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 77, 614, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnKhongCapNhat = new JButton("Kh\u00F4ng c\u1EADp nh\u00E2t");
		btnKhongCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Update lại trang thái
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
							JOptionPane.showMessageDialog(null, "Chua chon doi tuong muon cap nhat",
									"Error",JOptionPane.ERROR_MESSAGE);
							return;
						}else {
							String mssv=(String)table.getValueAt(row, 0);
							String maMon=(String)table.getValueAt(row, 2);
							String cotDiem=(String)table.getValueAt(row, 3);
							//System.out.println("Cot diem: "+ cotDiem);
							try {
								MyConnect.updataStatus1(mssv, maMon, cotDiem);
								loadData("thongtin_phuckhao");
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
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
		btnKhongCapNhat.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnKhongCapNhat.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnKhongCapNhat.setBounds(95, 11, 133, 33);
		panel_1.add(btnKhongCapNhat);
		
		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
							JOptionPane.showMessageDialog(null, "Chua chon doi tuong muon cap nhat",
									"Error",JOptionPane.ERROR_MESSAGE);
							return;
						}else {
							String mssv=(String)table.getValueAt(row, 0);
							String maMon=(String)table.getValueAt(row, 2);
							String cotDiem=(String)table.getValueAt(row, 3);
							String diemMuon=(String)table.getValueAt(row, 4);
							System.out.println(diemMuon);
							try {
								MyConnect.updataPoint(mssv, maMon, cotDiem, diemMuon);
								MyConnect.updataStatus2(mssv, maMon, cotDiem);
								loadData("thongtin_phuckhao");
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
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
		btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnCapNhat.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCapNhat.setBounds(378, 11, 133, 33);
		panel_1.add(btnCapNhat);
	
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MSSV", "HoTen", "MaMon", "CotDiem", "DiemMuon", "LiDo", "TrangThai"
			}
		));
		table.setBounds(0, 157, 624, 212);
		contentPane.add(table);
		String table1="thongtin_phuckhao";
		loadData(table1);
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
		}
		table.setModel(model);
	}
}
