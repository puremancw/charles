package com.charles.common.utils;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class MapJsonUtil {

    public static Map<String, String> parseString(String jsonString) {
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        Map map = new HashMap();
        for (Iterator iter = jsonObject.keySet().iterator(); iter.hasNext(); ) {
          String key = (String)iter.next();
          map.put(key, (String)jsonObject.get(key));
        }
        return map;
      }
    public static String toString(Map<String,String> map){
        JSONObject json = (JSONObject) JSONObject.toJSON(map);
        return json.toString();
    }
    public static boolean canParse(String mapString) {
        if (StringUtils.isBlank(mapString)) {
            return true;
        }
        try {
            JSON.parseObject(mapString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

