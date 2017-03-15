package com.temp.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.temp.po.AccountPo;
import com.temp.po.Po;

public final class JsonUtil {

	public static String constructJson(boolean isSuccess, String message, Object data) {
		Map<String, Object> retJsonMap = new HashMap<>(3);
		retJsonMap.put("success", isSuccess);
		retJsonMap.put("message", message);
		retJsonMap.put("data", data);
		
		// SerializerFeature.WriteMapNullValue: ʹnullֵ��ʾ��{"Message":null,"Data":null,"Success":true}��ʽ
		return JSONObject.toJSONString(retJsonMap, SerializerFeature.WriteMapNullValue);
	}
	
	public static Map<String, Object> parseJson(String rawData, String... types) {
		Map<String, Object> retRes = new HashMap<>();		
		JSONObject data = getDataFieldInRawData(rawData);
		for (String fieldName : types) {
			retRes.put(fieldName, data.getString(fieldName));
		}		
		return retRes;
	}

	public static Po parseJson(String rawData, Class<? extends Po> clazz) {
		JSONObject data = getDataFieldInRawData(rawData);
		Po retPo = JSON.parseObject(data.toJSONString(), clazz);	
		return retPo;
	}
	
	private static JSONObject getDataFieldInRawData(String rawData) {
		JSONObject data = null;
		try {
			String utf8Data = URLDecoder.decode(rawData, "UTF-8");
			
			JSONObject jo = JSONObject.parseObject(utf8Data);
			data = (JSONObject) jo.get("data");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void main(String[] args) {
//		List<AccountVo> accountVos = new ArrayList<>();
//		
//		AccountVo t1 = new AccountVo(1, 1, "PEK111", 1);
//		accountVos.add(t1);
//		AccountVo t2 = new AccountVo(2, 2, "PEK222", 2);
//		accountVos.add(t2);
//		
//		List<BoxVo> boxVos = new ArrayList<>();
//		
//		BoxVo b1 = new BoxVo();
//		b1.setBoxId(1);
//		boxVos.add(b1);
//		BoxVo b2 = new BoxVo();
//		b2.setBoxId(2);
//		boxVos.add(b2);
//		
//		Map<String, List<? extends Object>> testMap = new HashMap<>();
//		testMap.put("accountList", accountVos);
//		testMap.put("boxList", boxVos);
//		
//		
//		System.out.println(constructJson(true, null, testMap));
		
		
		String jsonStr = "{\"success\":true,\"message\":null,\"data\":{\"accountId\":0,\"accountType\":1,\"bankId\":\"PEK022\",\"customerNum\":1,\"customers\":[{\"customerId\":2,\"customerName\":\"guest\"},{\"customerId\":3,\"customerName\":\"root\"}]}}";
		
		//AccountPo tt = JSON.parseObject(jsonStr, AccountPo.class);
		//JSONObject data = getDataFieldInRawData(jsonStr);
		
		System.out.println(parseJson(jsonStr, AccountPo.class));
	}
}
