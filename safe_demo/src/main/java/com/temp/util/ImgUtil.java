package com.temp.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.DatatypeConverter;

public final class ImgUtil {

	/**
	 * decodeBase64CodingImg.
	 * 
	 * @param img IMG raw Data.
	 * @return byte[]
	 */
	public static InputStream decodeFromBase64CodingImg (String img) {    	
		byte[] imgRawByteArray = DatatypeConverter.parseBase64Binary(img);
		InputStream inputStream = new ByteArrayInputStream(imgRawByteArray);
		return inputStream;
	}
	
	/**
	 * encodeToBase64CodingImg.
	 * 
	 * @param rawData
	 * @return base64 coding String
	 */
	public static String encodeToBase64CodingImg(byte[] rawData) {
		String base64CodingStr = DatatypeConverter.printBase64Binary(rawData);
		return base64CodingStr;
	}
	
}
