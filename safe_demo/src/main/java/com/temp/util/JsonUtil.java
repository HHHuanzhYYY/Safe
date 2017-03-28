package com.temp.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.temp.po.AccountPo;
import com.temp.po.MessagePo;
import com.temp.po.Po;

public final class JsonUtil {

	/**
	 * constructJson.
	 * 
	 * @param isSuccess
	 * @param message
	 * @param data
	 * @return
	 */
	public static String constructJson(boolean isSuccess, String message, Object data) {
		Map<String, Object> retJsonMap = new LinkedHashMap<>(3);
		retJsonMap.put("success", isSuccess);
		retJsonMap.put("message", message);
		if (data instanceof List) {
			class Temp {
				private List<Object> list;

				public Temp(List<Object> temp) {
					list = temp;
				}
				
				@SuppressWarnings("unused")
				public List<Object> getList() {
					return list;
				}
			}
			
			@SuppressWarnings("unchecked")
			List<Object> dataTemp = (List<Object>) data;
			retJsonMap.put("data", new Temp(dataTemp));
		} else {
			retJsonMap.put("data", data);
		}	
		
		// SerializerFeature.WriteMapNullValue: 使null值显示成{"Message":null,"Data":null,"Success":true}样式
		return JSONObject.toJSONString(retJsonMap, SerializerFeature.WriteMapNullValue);
	}
	
	/**
	 * parseJson.
	 * 
	 * @param rawData
	 * @param types
	 * @return
	 */
	public static Map<String, Object> parseJson(String rawData, String... types) {
		Map<String, Object> retRes = new HashMap<>();		
		JSONObject data = getDataFieldInRawData(rawData);
		for (String fieldName : types) {
			retRes.put(fieldName, data.getString(fieldName));
		}		
		return retRes;
	}

	/**
	 * parseJson.
	 * 
	 * @param rawData
	 * @param clazz
	 * @return
	 */
	public static Po parseJson(String rawData, Class<? extends Po> clazz) {
		JSONObject data = getDataFieldInRawData(rawData);
		Po retPo = JSON.parseObject(data.toJSONString(), clazz);	
		return retPo;
	}
	
	/**
	 * parseJson.
	 * 
	 * @param rawData
	 * @param clazz
	 * @param type
	 * @return
	 */
	public static List<? extends Number> parseJson(String rawData, Class<? extends Number> clazz, String type) {
		JSONObject data = getDataFieldInRawData(rawData);
		List<? extends Number> numericList = JSON.parseArray(data.getString(type), clazz);
		return numericList;
	}
	
	/**
	 * getDataFieldInRawData.
	 * 
	 * @param rawData
	 * @return
	 */
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
		
		
		//String jsonStr = "{\"success\":true,\"message\":null,\"data\":{\"accountId\":0,\"accountType\":1,\"bankId\":\"PEK022\",\"customerNum\":1,\"customers\":[{\"customerId\":2,\"customerName\":\"guest\"},{\"customerId\":3,\"customerName\":\"root\"}]}}";
		
		//AccountPo tt = JSON.parseObject(jsonStr, AccountPo.class);
		//JSONObject data = getDataFieldInRawData(jsonStr);
		
//		MessagePo test = new MessagePo();
//		test.setMessageContent("English");
//		test.setMessageId(111);
//		List<Integer> reces = new ArrayList<>();
//		reces.add(1101);
//		reces.add(1102);
//		reces.add(1106);
//		test.setMessageReceivers(reces);
//		test.setMessageReceiverType(0);
//		test.setMessageTitle("FFFFF");
//		test.setMessageType(0);
//		test.setRemark("FFFFFFFFFFFF");
//		
//		System.out.println(constructJson(true, null, test));
		
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"messageIds\":[14,15,16,17],"
					+ "}"
				+ "}";
		
		System.out.println(parseJson(rawData, Long.class, null));
	}
}
