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
import java.awt.event.ActionEvent;

public class StudentJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private String dataUser;
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
	}
	
}
