package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import control.HashcodeController;
import model.HashcodeModel;

public class HashcodeView extends JFrame {
	private HashcodeModel model;
	private JPanel contentPane;
	private JTextField textField_MD5;
	private JTextField textField_pass;
	private JTextField textField_SHA1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashcodeView frame = new HashcodeView();
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
	public HashcodeView() {
		this.model = new HashcodeModel();
		ActionListener ac = new HashcodeController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("CHƯƠNG TRÌNH MÃ HOÁ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(0, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(112, 1, 667, 359);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblNewLabel_Pass = new JLabel("Nội Dung:");
		lblNewLabel_Pass.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Pass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_Pass);
		
		JPanel panel_pass = new JPanel();
		panel_pass.setLayout(null);
		panel_2.add(panel_pass);
		
		textField_pass = new JTextField();
		textField_pass.setColumns(10);
		textField_pass.setBounds(10, 39, 313, 61);
		textField_pass.addActionListener(ac);
		panel_pass.add(textField_pass);
		
		JLabel lblNewLabel_ = new JLabel("Mã Hoá Sang MD5:");
		lblNewLabel_.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_);
		
		JPanel panel_MD5 = new JPanel();
		panel_2.add(panel_MD5);
		panel_MD5.setLayout(null);
		
		textField_MD5 = new JTextField();
		textField_MD5.setBounds(10, 39, 313, 61);
		textField_MD5.setColumns(10);
		textField_MD5.addActionListener(ac);
		panel_MD5.add(textField_MD5);
		
		JLabel lblNewLabel__SHA1 = new JLabel("Mã Hoá Sang SHA1:");
		lblNewLabel__SHA1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel__SHA1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_2.add(lblNewLabel__SHA1);
		
		JPanel panel_SHA1 = new JPanel();
		panel_SHA1.setLayout(null);
		panel_2.add(panel_SHA1);
		
		textField_SHA1 = new JTextField();
		textField_SHA1.setColumns(10);
		textField_SHA1.setBounds(10, 39, 313, 61);
		textField_SHA1.addActionListener(ac);
		panel_SHA1.add(textField_SHA1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Ch\u1EE9c N\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnNewButton_MaHoa = new JButton("Mã Hoá");
		btnNewButton_MaHoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_MaHoa.setForeground(new Color(0, 0, 0));
		btnNewButton_MaHoa.addActionListener(ac);
		panel_3.add(btnNewButton_MaHoa);
		
		JButton btnNewButton_XoaRong = new JButton("Xoá Rỗng");
		btnNewButton_XoaRong.setForeground(Color.BLACK);
		btnNewButton_XoaRong.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_XoaRong.addActionListener(ac);
		panel_3.add(btnNewButton_XoaRong);
		
		this.setVisible(true);
	}
	
	public void xoaRong() {
		this.textField_pass.setText("");
		this.textField_MD5.setText("");
		this.textField_SHA1.setText("");
	}
	
	public void maHoa() {
		String pass = this.textField_pass.getText();
		System.out.println(pass);
		this.model.setPassword(pass);
		this.textField_MD5.setText(this.model.getMD5(this.model.getPassword()));
		this.textField_SHA1.setText(this.model.getSHA1(this.model.getPassword()));
	}
}
