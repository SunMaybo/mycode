/**    
 * @{#} Base64.java Create on Nov 5, 2008 7:19:56 PM    
 *    
 */
package com.gren.remotecheck.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class FileCode {
	public static String encodeBase64File(String path) throws Exception {
		File file = new File(path);
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		return new BASE64Encoder().encode(buffer);
	}

	public static void decoderBase64File(String base64Code, String targetPath) throws Exception {
		byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);

//		for (int i = 0; i < buffer.length; i++) {
//			if (buffer[i] < 0) {
//				buffer[i] += 256;
//			}
//		}

		File f = new File(targetPath);

		if (!f.exists())
			f.createNewFile();

		FileOutputStream out = new FileOutputStream(f);
		out.write(buffer);
		out.close();
	}

	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}

	public static String md5Code(String code) {
		String result = "";
		try {
			MessageDigest md5 = null;

			md5 = MessageDigest.getInstance("MD5");
			md5.update(code.getBytes());
			result = hex(md5.digest());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String readFileText(String path) throws Exception {
		File file = new File(path);
		FileInputStream inputFile = new FileInputStream(file);

		BufferedReader bf = new BufferedReader(new InputStreamReader(inputFile, "GBK"));

		StringBuffer sb = new StringBuffer();

		char[] rData = new char[1024]; // 读缓存默认1024
		int len = 0;
		while (true) {
			len = bf.read(rData);
			if (len <= 0) {
				// log.info("接收到的数据长度为0");
				break;
			}
			sb.append(new String(rData, 0, len));
			if (len < 1024) {
				break;
			}
		}

		bf.close();
		inputFile.close();
		return sb.toString();
	}

	public static void saveTextFile(String filepath, String filetext) throws Exception {

		File f = new File(filepath);

		if (!f.exists())
			f.createNewFile();

		FileOutputStream out = new FileOutputStream(f);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "GBK"));

		bw.write(filetext);

		bw.flush();

		out.close();
	}
}
