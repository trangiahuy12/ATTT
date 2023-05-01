package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashcodeModel {
	private String password;

	public HashcodeModel(String password) {
		super();
		this.password = password;
	}

	public HashcodeModel() {
		this.password = "";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	 public String getSHA1(String input) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-1");
	            byte[] hash = md.digest(input.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (byte b : hash) {
	                sb.append(String.format("%02x", b));
	            }
	            return sb.toString().toUpperCase();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    
	    public String getMD5(String input) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] hash = md.digest(input.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (byte b : hash) {
	                sb.append(String.format("%02x", b));
	            }
	            return sb.toString().toUpperCase();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	
	
}
