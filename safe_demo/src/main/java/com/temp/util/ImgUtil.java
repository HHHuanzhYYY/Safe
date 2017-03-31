package com.temp.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;

import javax.xml.bind.DatatypeConverter;

public final class ImgUtil {

	/**
	 * decodeBase64CodingImg.
	 * 
	 * @param img IMG raw Data.
	 * @return byte[]
	 */
	public static InputStream decodeFromBase64CodingImg (String img) {
		InputStream inputStream = null;
		if (img != null) {
			byte[] imgRawByteArray = DatatypeConverter.parseBase64Binary(img);
			inputStream = new ByteArrayInputStream(imgRawByteArray);
		}
		return inputStream;
	}
	
	/**
	 * encodeToBase64CodingImg.
	 * 
	 * @param rawData
	 * @return base64 coding String
	 */
	public static String encodeToBase64CodingImg(Blob blob) {
		byte[] rawData = blobToBytes(blob);
		String base64CodingStr = DatatypeConverter.printBase64Binary(rawData);
		return base64CodingStr;
	}
	
	/**  
     * 把Blob类型转换为byte数组类型  
     *   
     * @param blob  
     * @return  
     */  
    public static byte[] blobToBytes(Blob blob) {  
        try (BufferedInputStream is = new BufferedInputStream(blob.getBinaryStream())) {  
            byte[] bytes = new byte[(int) blob.length()];  
            int len = bytes.length;  
            int offset = 0;  
            int read = 0;  
            while (offset < len  
                    && (read = is.read(bytes, offset, len - offset)) >= 0) {  
                offset += read;  
            }  
            return bytes;  
        } catch (Exception e) {  
            return null;  
        }
    }  
	
}
