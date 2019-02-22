package com.iot.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class CommonUtils {

	public static String json2sql(String jsonString){
		String sql = "";
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		for(int i = 0; i < jsonArray.size(); i++){
			if(!sql.isEmpty())
				sql += " and ";
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String field = jsonObject.getString("field");
			String op = jsonObject.getString("op");
			String value = jsonObject.getString("value");
			sql += field;
			switch (op) {
				case "contains": sql += " like '%" + value + "%'"; break;
				case "same": sql += "='" + value + "'"; break;
				case "equal": sql += "=" + Double.parseDouble(value); break;
				case "notequal": sql += "!=" + Double.parseDouble(value); break;
				case "beginwith": sql += ">='" + value + "'"; break;
				case "endwith": sql += "<='" + value + "'"; break;
				case "less": sql += "<" + Double.parseDouble(value); break;
				case "lessorequal": sql += "<=" + Double.parseDouble(value); break;
				case "greater": sql += ">" + Double.parseDouble(value); break;
				case "greaterorequal": sql += ">=" + Double.parseDouble(value); break;
				default: sql = "";
			}
		}
		return sql;
	}

	public static String json2sql4sub(String jsonString, String table){
		String sql = "";
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		for(int i = 0; i < jsonArray.size(); i++){
			if(!sql.isEmpty())
				sql += " and ";
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String field = table + "." + jsonObject.getString("field");
			String op = jsonObject.getString("op");
			String value = jsonObject.getString("value");
			sql += field;
			switch (op) {
				case "contains": sql += " like '%" + value + "%'"; break;
				case "same": sql += "='" + value + "'"; break;
				case "equal": sql += "=" + Double.parseDouble(value); break;
				case "notequal": sql += "!=" + Double.parseDouble(value); break;
				case "beginwith": sql += ">='" + value + "'"; break;
				case "endwith": sql += "<='" + value + "'"; break;
				case "less": sql += "<" + Double.parseDouble(value); break;
				case "lessorequal": sql += "<=" + Double.parseDouble(value); break;
				case "greater": sql += ">" + Double.parseDouble(value); break;
				case "greaterorequal": sql += ">=" + Double.parseDouble(value); break;
				default: sql = "";
			}
		}
		return sql;
	}
}
