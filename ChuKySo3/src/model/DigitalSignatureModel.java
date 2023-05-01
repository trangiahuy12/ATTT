package model;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class DigitalSignatureModel {
	private String privateKey;
	private String publicKey;
	private String signature;
	private File file;
	

	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

	
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	public DigitalSignatureModel() {
		super();
		this.privateKey = "";
		this.publicKey = "";
		this.signature = "";
	}
	
	public void generate() {
		try {
			 SecureRandom sr = new SecureRandom();
			 KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
			 kpg.initialize(1024, sr);
			 KeyPair keys = kpg.generateKeyPair();
			 
			 // Save private key
			 PrivateKey privateKey = keys.getPrivate();
			 FileOutputStream fos = new FileOutputStream("D:\\chuKySo\\priKey.txt");
			 fos.write(privateKey.getEncoded());
			 fos.close();
			 // Băm privateKey dùng hàm SHA-256			 
			 this.setPrivateKey(getSha256(privateKey.toString()));
			 
			 // Save public key
			 PublicKey publicKey = keys.getPublic();
			 fos = new FileOutputStream("D:\\chuKySo\\pubKey.txt");
			 fos.write(publicKey.getEncoded());
			 fos.close();
			// Băm publiceKey dùng hàm SHA-256			 
			 this.setPublicKey(getSha256(publicKey.toString()));
			} catch (Exception e) {
				e.printStackTrace(); 
			}
	}
	
	public static String getSha256(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(message.getBytes());
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
