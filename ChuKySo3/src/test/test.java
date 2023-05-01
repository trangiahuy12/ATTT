package test;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

import view.DigitalSignatureView;

public class test {
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		new DigitalSignatureView();
//		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//	    keyPairGenerator.initialize(2048);
//	    KeyPair keyPair = keyPairGenerator.generateKeyPair();
//	    PrivateKey privateKey = keyPair.getPrivate();
//	    PublicKey publicKey = keyPair.getPublic();
//	    System.out.println("Private key: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));
//	    System.out.println("Public key: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
//	    
//	    	String message = "This is a test message.";
//	      Signature signature = Signature.getInstance("SHA256withRSA");
//	      signature.initSign(privateKey);
//	      signature.update(message.getBytes());
//	      byte[] digitalSignature = signature.sign();
//	      System.out.println("Digital signature: " + Base64.getEncoder().encodeToString(digitalSignature));
	}
}
