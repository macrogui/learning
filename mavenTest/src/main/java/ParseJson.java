import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ParseJson {

    public static void main(String[] args) {
        ParseJson parseJson = new ParseJson();
        String s = " {\n" +
                "                    \"type\":\"FIXED\",\n" +
                "                    \"operation\":\"GE\",\n" +
                "                    \"threshold\":\"100\"\n" +
                "                }";
        String jsonList = "[{a=1}, {b=1}]";
//        parseJson.parseJsonList(s);
        parseJson.parseJsonList(jsonList);
    }

    public Object parseJsonList(String s){
        System.out.println(s);
//        Object s1 = JSON.parse(s);
        JSONArray objects = JSON.parseArray(s);
        System.out.println(objects);
        JSONObject jsonObject = objects.getJSONObject(1);
        System.out.println(jsonObject.get("threshold"));
        for (Object object : objects) {
            System.out.println(object);
        }
        return s;
    }
}
