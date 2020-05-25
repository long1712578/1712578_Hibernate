package QuanLy;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GiaoVuJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyConnect myconnect=new MyConnect();
	//private String[] titleColumn= {"STT","MSSV","Họ Tên","Giới Tính","CMND"};
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoVuJFrame frame = new GiaoVuJFrame();
					frame.setVisible(true);
					frame.loadData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GiaoVuJFrame() {
		//add main panel to JFrame
		getContentPane().add(createMainPanel());
		
		//Connect data
		myconnect.connect();
		//setTitle("Manager");
		//Set display
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		//setVisible(true);
		//setBounds(100, 100, 450, 300);
	}

	private JPanel createMainPanel() {
		// TODO Auto-generated method stub
		JPanel panel=new JPanel(new BorderLayout());
		panel.add(createTitlePanel(), BorderLayout.PAGE_START);
		panel.add(createTablePanel(), BorderLayout.CENTER);
		panel.add(createButtonPanel(), BorderLayout.PAGE_END);
		return panel;
	}
	private JPanel createTitlePanel() {
		JPanel panel =new JPanel();
		JLabel lbTitle=new JLabel("Giáo vụ");
		panel.add(lbTitle);
		return panel;
	}
	private JPanel createTablePanel() {
		JPanel panel =new JPanel();
		panel.add(new JScrollPane(table=createTable()));
		return panel;
	}
	private JPanel createButtonPanel() {
		JPanel panel =new JPanel();
		{
			JComboBox cbClass = new JComboBox();
			cbClass.setModel(new DefaultComboBoxModel(new String[] {"17hcb", "18hcb"}));
			panel.add(cbClass);
		}
		panel.add(createButton("thêm"));
		panel.add(createButton("Xóa"));
		panel.add(createButton("hiển thị"));
		return panel;
	}
	private JTable createTable() {
		//DefaultTableModel model =new DefaultTableModel();
		//model.setColumnIdentifiers(titleColumn);
		JTable table=new JTable();
		return table;
	}
	private JButton createButton(String text) {
		JButton btn =new JButton(text);
		return btn;
	}
	private void loadData() {
		String table1="17hcb";
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
