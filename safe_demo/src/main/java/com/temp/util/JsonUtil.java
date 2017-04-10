package com.temp.util;

import java.io.BufferedReader;
//import java.io.UnsupportedEncodingException;
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.temp.po.Po;

public final class JsonUtil {
	
	public static String getRawData(HttpServletRequest request) {
		String utf8Data = null;
		try {
	    	request.setCharacterEncoding("UTF-8");
			StringBuffer sb = new StringBuffer();
			String line = null;
		
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}	
			
			//String rawData = sb.substring(sb.indexOf("%7B")).toString(); 			
			//utf8Data = URLDecoder.decode(rawData, "UTF-8");
			
			utf8Data = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utf8Data;
	}

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
		
		// SerializerFeature.WriteMapNullValue: ʹnullֵ��ʾ��{"Message":null,"Data":null,"Success":true}��ʽ
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
	 * parseJson.
	 * 
	 * @param tagParam
	 * @param rawData
	 * @param type
	 * @return
	 */
	public static List<String> parseJson(TagParam tagParam, String rawData, String type) {
		JSONObject data = getDataFieldInRawData(rawData);
		List<String> numericList = JSON.parseArray(data.getString(type), String.class);
		return numericList;
	}
	
	/**
	 * getDataFieldInRawData.
	 * 
	 * @param rawData
	 * @return
	 */
	private static JSONObject getDataFieldInRawData(String rawData) {
		//JSONObject data = null;
		//try {
			//String utf8Data = URLDecoder.decode(rawData, "UTF-8");
			
			JSONObject jo = JSONObject.parseObject(rawData);
			//data = (JSONObject) jo.get("data");
			
		//} catch (UnsupportedEncodingException e) {
		//	e.printStackTrace();
		//}
		return jo;
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
		
//		final String rawData = "{"
//				+ "\"success\":true,"
//				+ "\"message\":null,"
//				+ "\"data\":{"
//					+ "\"messageIds\":[14,15,16,17],"
//					+ "}"
//				+ "}";
//		
//		System.out.println(parseJson(rawData, Long.class, null));
		
		
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date start = null;
//		Date end = null;
//		try {
//			start = simpleDateFormat.parse("2017-4-5");
//			end = simpleDateFormat.parse("2018-4-4");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(JSON.toJSONString(start));
//		System.out.println(JSON.toJSONString(end));
		
//		final String rawData = "{"
//					+ "\"accountType\":0,"
//					+ "\"bankId\":101,"
//					+ "\"isAccountFree\":0,"
//					+ "\"openAccountFee\":0.0,"
//					+ "\"paymentType\":0,"
//					+ "\"amountSum\":550.5,"
//					+ "\"customerSum\":1,"
//					+ "\"customerList\":"
//						+ "[{"
//						+ "\"customerType\":0,"
//						+ "\"customerName\":\"张大麻子\","
//						+ "\"customerSex\":1,"
//						+ "\"certificateType\":1,"
//						+ "\"certificateNo\":\"110123456789\","
//						+ "\"unitAddress\":\"北京市朝阳区***路\","
//						+ "\"homeAddress\":\"北京市海淀区***小区\","
//						+ "\"phone\":\"010-56436789\","
//						+ "\"mobile\":\"18500003443\","
//						+ "\"post\":\"010\","
//						+ "\"remark\":\"这只是一个测试用例\","
//						+ "\"photo\":null,"
//						+ "\"cardType\":1,"
//						+ "\"cardNo\":\"PEK12345\","
//						+ "\"cardRfid\":\"PEK12345\","
//						+ "\"password\":\"asdfghjkl\","
//						+ "\"fingerPwd\":\"asdfghjkllkjhgfdsa\","
//						+ "\"reserveFingerPwd\":\"asdfghjkllkjhgfdsa\","
//						+ "}],"
//					+ "\"rentList\":"
//						+ "[{"
//						+ "\"boxId\":110,"
//						+ "\"cardRfid\":\"PEK12345\","
//						+ "\"leaseNo\":\"L11111\","
//						+ "\"leaseRemark\":\"无\","
//						+ "\"voucherNo\":\"V11111\","
//						+ "\"voucherRemark\":\"无\","
//						+ "\"rentType\":2,"
//						+ "\"rentTime\":2,"
//						+ "\"startDate\":1491321600000,"
//						+ "\"endDate\":1554307200000,"
//						+ "\"deposit\":1000.0,"
//						+ "\"rent\":5000.0,"
//						+ "\"rentDiscount \":0.8,"
//						+ "\"actualRent\":4000.0,"
//						+ "\"paymentType\":0,"
//						+ "\"feeTotal\":4000.0,"
//						+ "},"
//						+ "{"
//						+ "\"boxId\":111,"
//						+ "\"cardRfid\":\"PEK54321\","
//						+ "\"leaseNo\":\"L22222\","
//						+ "\"leaseRemark\":\"无\","
//						+ "\"voucherNo\":\"V22222\","
//						+ "\"voucherRemark\":\"无\","
//						+ "\"rentType\":2,"
//						+ "\"rentTime\":1,"
//						+ "\"startDate\":1491321600000,"
//						+ "\"endDate\":1522771200000,"
//						+ "\"deposit\":1000.0,"
//						+ "\"rent\":3000.0,"
//						+ "\"rentDiscount \":0.8,"
//						+ "\"actualRent\":2400.0,"
//						+ "\"paymentType\":0,"
//						+ "\"feeTotal\":2400.0,"
//						+ "}]"
//				+ "}";
//		System.out.println(JSON.parseObject(rawData, AccountPo.class).toString());
		
		final String rawData = "{"
				+ "\"success\":true,"
				+ "\"message\":null,"
				+ "\"data\":{"
					+ "\"boxModels\":[\"A\",\"B\",\"C\",\"D\"]"
					+ "}"
				+ "}";
		
		System.out.println(parseJson(rawData, "boxModels"));
	}
}
