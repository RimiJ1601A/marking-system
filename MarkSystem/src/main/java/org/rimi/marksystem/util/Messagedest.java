package org.rimi.marksystem.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Messagedest {

	//MD5加密
	public static String getMD5(String str){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			return new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new BigInteger(1, md.digest()).toString(16);
	}
}
