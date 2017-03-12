package com.temp.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public final class JsonUtil {

	public static String constructJson(boolean isSuccess, String message, Object data) {
		JSONObject jsonStr = new JSONObject();
		jsonStr.put("Success", isSuccess);
		jsonStr.put("Message", message);
		jsonStr.put("Data", data);
		// SerializerFeature.WriteMapNullValue: 使null值显示成{"Message":null,"Data":null,"Success":true}样式
		return JSONObject.toJSONString(jsonStr, SerializerFeature.WriteMapNullValue);
	}
	
	public static Map<String, Object> parseJson(String rawData, String... types) {
		Map<String, Object> retRes = new HashMap<>();
		
		try {
			String utf8Data = URLDecoder.decode(rawData, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			String userInfo = URLDecoder.decode(request.getParameter("Info"), "UTF-8");
//			
//			JSONObject jo = JSONObject.parseObject(userInfo);
//			JSONObject data = (JSONObject) jo.get("Data");
//			userName = data.getString("UserName");
//			userPassword = data.getString("UserPassword");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		return retRes;
	}
}
