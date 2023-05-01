package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.DigitalSignatureController;
import model.DigitalSignatureModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class DigitalSignatureView extends JFrame {
	public DigitalSignatureModel model;
	public JPanel contentPane;
	public JTextField textField_pubKey;
	public JTextField textField_priKey;
	public JTextField textField_chuKyDiKem;
	public JLabel lblNewLabel_duongDan;
	private JTextField textField;
	private JTextField textField_1;
	private File file;
	private JLabel lblNewLabel_duongDan_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalSignatureView frame = new DigitalSignatureView();
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
	public DigitalSignatureView() {
		this.model = new DigitalSignatureModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1181, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Chương trình tạo chữ ký số kiểm tra tính xác thực của file");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(0, 0, 1157, 59);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
//		Them su kien
		ActionListener ac = new DigitalSignatureController(this);
		
		JButton btnNewButton_taoKey = new JButton("Tạo key");
		btnNewButton_taoKey.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_taoKey.setBounds(33, 10, 102, 39);
		btnNewButton_taoKey.addActionListener(ac);
		panel_2.add(btnNewButton_taoKey);
		
		JLabel lblNewLabeb_privateKey = new JLabel("Private Key");
		lblNewLabeb_privateKey.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabeb_privateKey.setBounds(174, 12, 88, 34);
		panel_2.add(lblNewLabeb_privateKey);
		
		JLabel lblNewLabeb_publicKey = new JLabel("Public Key");
		lblNewLabeb_publicKey.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabeb_publicKey.setBounds(708, 10, 88, 39);
		panel_2.add(lblNewLabeb_publicKey);
		
		textField_pubKey = new JTextField();
		textField_pubKey.setColumns(10);
		textField_pubKey.setBounds(796, 10, 325, 39);
		panel_2.add(textField_pubKey);
		
		textField_priKey = new JTextField();
		textField_priKey.setBounds(272, 10, 325, 39);
		panel_2.add(textField_priKey);
		textField_priKey.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(0, 67, 1157, 146);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_ChonFile = new JButton("Chọn file");
		btnNewButton_ChonFile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_ChonFile.setBounds(40, 24, 102, 39);
		btnNewButton_ChonFile.addActionListener(ac);
		panel_3.add(btnNewButton_ChonFile);
		
		JLabel lblNewLabeb_privateKey_1 = new JLabel("Chữ ký đi kèm");
		lblNewLabeb_privateKey_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabeb_privateKey_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabeb_privateKey_1.setBounds(600, 26, 152, 34);
		panel_3.add(lblNewLabeb_privateKey_1);
		
		textField_chuKyDiKem = new JTextField();
		textField_chuKyDiKem.setColumns(10);
		textField_chuKyDiKem.setBounds(794, 26, 325, 39);
		panel_3.add(textField_chuKyDiKem);
		
		lblNewLabel_duongDan = new JLabel("Đường dẫn");
		lblNewLabel_duongDan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_duongDan.setBounds(171, 24, 430, 39);
		panel_3.add(lblNewLabel_duongDan);
		
		JButton btnNewButton_sign = new JButton("Tạo chữ ký đi kèm");
		btnNewButton_sign.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_sign.setBounds(463, 86, 171, 39);
		btnNewButton_sign.addActionListener(ac);
		panel_3.add(btnNewButton_sign);
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Ki\u1EC3m tra t\u00EDnh x\u00E1c th\u1EF1c", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_4.setBounds(0, 223, 1157, 289);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton_ChonFile_1 = new JButton("Chọn file cần xác thực");
		btnNewButton_ChonFile_1.setBounds(296, 18, 202, 39);
		btnNewButton_ChonFile_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_ChonFile_1.addActionListener(ac);
		panel_4.add(btnNewButton_ChonFile_1);
		
		lblNewLabel_duongDan_1 = new JLabel("Đường dẫn");
		lblNewLabel_duongDan_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_duongDan_1.setBounds(557, 18, 430, 39);
		panel_4.add(lblNewLabel_duongDan_1);
		
		JLabel lblNewLabeb_publicKey_1 = new JLabel("Nhập public key");
		lblNewLabeb_publicKey_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabeb_publicKey_1.setBounds(383, 68, 123, 39);
		panel_4.add(lblNewLabeb_publicKey_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(557, 70, 325, 39);
		panel_4.add(textField);
		
		JLabel lblNewLabeb_privateKey_1_1 = new JLabel("Nhập chữ ký");
		lblNewLabeb_privateKey_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabeb_privateKey_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabeb_privateKey_1_1.setBounds(354, 132, 152, 34);
		panel_4.add(lblNewLabeb_privateKey_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(557, 132, 325, 39);
		panel_4.add(textField_1);
		
		JButton btnNewButton_verify = new JButton("Xác thực");
		btnNewButton_verify.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_verify.setBounds(496, 217, 116, 34);
		btnNewButton_verify.addActionListener(ac);
		panel_4.add(btnNewButton_verify);
		

		
		this.setVisible(true);
	}
	
	public void displayKey() {
		this.textField_pubKey.setText(this.model.getPublicKey());
		this.textField_priKey.setText(this.model.getPrivateKey());
	}
	
	
	public void chooseFile_1() {
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			this.model.setFile(file);
			// Hiển thị đường dẫn file
			 this.lblNewLabel_duongDan.setText(this.model.getFile().getAbsolutePath());
		}
	}
	
	public void chooseFile_2() {
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			this.file = file;
			// Hiển thị đường dẫn file
			this.lblNewLabel_duongDan_1.setText(this.file.getAbsolutePath());
		}
	}
	
	public void signFile() {
		try { 
			// Nạp private key từ file
			FileInputStream fis = new FileInputStream("D:\\chuKySo\\priKey.txt");
			byte[] b = new byte[fis.available()];
			fis.read(b);
			fis.close();
			// Tạo private key
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
			KeyFactory factory = KeyFactory.getInstance("DSA");
			PrivateKey priKey = factory.generatePrivate(spec);
			//********************************
			//Ký số (Sign)***************************
			// Tạo đối tượng signer
			Signature signer = Signature.getInstance("DSA");
			signer.initSign(priKey, new SecureRandom());
			// Chọn file để thực hiện ký số
			// String filename = "C:\\Users\\HUY\\OneDrive - Industrial University of HoChiMinh City\\Desktop\\Deon.docx";
			File file = this.model.getFile();
			fis = new FileInputStream(file.getAbsolutePath());
			byte byteFile[] = new byte[fis.available()];
			// Chèn message vào đối tượng signer
			signer.update(byteFile);
			byte[] bsign = signer.sign();			 
			// Lưu chữ ký số
			this.model.setSignature(this.model.getSha256(bsign.toString()));
			FileOutputStream fos = new FileOutputStream("D:\\chuKySo\\dsa.txt");
			fos.write(bsign);
			//*******************************
			// Hiển thị chữ kỹ đi kèm			 
			this.textField_chuKyDiKem.setText(this.model.getSignature());
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	
	public void verifyFile() {
		String pubkey = this.textField.getText();
		String signature = this.textField_1.getText();
		if (pubkey.equals(this.model.getPublicKey()) && signature.equals(this.model.getSignature())) {
			try { 
				 // Nạp public key từ file
				 FileInputStream fis = new FileInputStream("D:\\chuKySo\\pubKey.txt");
				 byte[] b = new byte[fis.available()];
				 fis.read(b);
				 fis.close(); 
				 // Tạo public key
				 X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
				 KeyFactory factory = KeyFactory.getInstance("DSA");
				 PublicKey pubKey = factory.generatePublic(spec);
				 // Khởi tạo đối tượng Signature
				 Signature s = Signature.getInstance("DSA");
				 s.initVerify(pubKey);
				 // Chọn file để kiểm chứng 
				 fis = new FileInputStream(this.file.getAbsolutePath());
				 byte byteFile[] = new byte[fis.available()];
				 fis.close();
				 // Nạp message vào đối tượng Signuture
				 s.update(byteFile);
				 // Kiểm chứng chữ ký trên Message
				 // Nạp chữ ký signature từ file
				 fis = new FileInputStream("D:\\chuKySo\\dsa.txt");
				 byte[] bsign = new byte[fis.available()];
				 fis.read(bsign);
				 fis.close();
				 // Kết quả kiểm chứng
				 boolean result = s.verify(bsign);
				 if (result == true) {
				     JOptionPane.showMessageDialog(this, "File đã được xác thực tính toàn vẹn", "Thông báo", JOptionPane.WARNING_MESSAGE);
				 }
				  else {
					  JOptionPane.showMessageDialog(this, "File đã bị sửa đổi", "Thông báo", JOptionPane.WARNING_MESSAGE);
				 }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Public Key hoặc Chữ Ký không hợp lệ!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		}
		
	}
}
