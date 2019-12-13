package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//将list数据格式化成layui所需要的json数据
public class JsonData {
  JSONArray jsonArray = null; //将list转换成json
  Map<String, Object> result = result = new HashMap<String, Object>();//构造Layui所需要的json数据格式
  JSONObject jsonObject =null; //吧Map集合转换成jso数据格式
//  List格式转换成layui所需要的JSON格式
  public JSONObject getJsonObject(List list) {
    jsonArray = JSONArray.parseArray(JSON.toJSONString(list));//把list数据转换成json数据类型(什么是json数据自己百度)
    result.put("code", 0);
    result.put("msg", "");
    result.put("count", list.size());
    result.put("data", jsonArray);
    jsonObject = JSON.parseObject(JSONObject.toJSONString(result));
    return jsonObject;
  }
//  分页所需要的json数据
  public JSONObject getJsonObjectByPage(List list,int count){
    jsonArray = JSONArray.parseArray(JSON.toJSONString(list));//把list数据转换成json数据类型(什么是json数据自己百度)
    result.put("code", 0);
    result.put("msg", "");
    result.put("count", count);
    result.put("data", jsonArray);
    jsonObject = JSON.parseObject(JSONObject.toJSONString(result));
    return jsonObject;
  }
  public JSONObject getDefautJson(List list){
    jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
    result.put("data",jsonArray);
    jsonObject = JSON.parseObject(JSONObject.toJSONString(result));
    return jsonObject;

  }
}
