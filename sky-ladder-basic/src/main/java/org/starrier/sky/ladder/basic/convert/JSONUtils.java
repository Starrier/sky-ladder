package org.starrier.sky.ladder.basic.convert;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.starrier.sky.ladder.basic.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author starrier
 * @date 2021/1/7
 */
public class JSONUtils {


    /**
     * 数据封装成json
     *
     * @param items 物料入库数据
     * @return json
     * @throws JSONException
     */
    public static String GoodIn2Json(List<Student> items) throws JSONException {
        if (items == null) return "";
        JSONArray array = new JSONArray();
        JSONObject jsonObject = null;
        Student student = null;
        for (int i = 0; i < items.size(); i++) {
            student = items.get(i);
            jsonObject = new JSONObject();
            jsonObject.put("name", student.getName());
            jsonObject.put("age", student.getAge());
            array.add(jsonObject);
        }
        return array.toString();
    }


    /**
     * 将json数组解析出来,生成自定义数据的数组
     *
     * @param data 包含用户自定义数据的json
     * @return 自定义信息的数据
     * @throws JSONException
     */
    public static List<Student> Json2UserDefine(String data) throws JSONException {
        List<Student> items = new ArrayList<>();
        if (data.equals("")) return items;

        JSONArray array = new JSONArray(Collections.singletonList(data));
        JSONObject object = null;
        Student student = null;
        for (int i = 0; i < array.size(); i++) {
            object = array.getJSONObject(i);
            String name = object.getString("name");
            String age = object.getString("age");

            if (StringUtils.isBlank(age)) {
                student = new Student();
                student.setName(name);
            } else {
                student = new Student(name, Integer.parseInt(age));
            }
            items.add(student);
        }
        return items;
    }

    public static void google(){

        //list转换为json
        Gson gson = new Gson();
        List<Student> persons = new ArrayList<>();
        String studentJson = gson.toJson(persons);


        //json转换为list
        List<Student> list = JSONObject.parseArray(studentJson, Student.class);

    }

}
