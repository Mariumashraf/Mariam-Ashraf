package com.common.helpers.Wrappers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.json.JsonException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class JsonReader {
    Object obj;
    public JsonReader(String filePath)  {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader;
        try {
            fileReader = new FileReader(filePath);
            obj = jsonParser.parse(fileReader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getNodeValue(String node, String child) {
        Object myObj;
        String singleValue = null;
        boolean isArray = false;
        JSONArray array = null;

        JSONObject jsonObject = (JSONObject) obj;
        myObj = jsonObject.get(node);
        if (myObj instanceof JSONArray) {
            array = (JSONArray) jsonObject.get(node);
            isArray = true;
        } else {
            singleValue = jsonObject.get(node).toString();
        }
        ArrayList<String> list = new ArrayList<>();
        if (isArray) {
            for (int i = 0; i < array.size(); i++) {
                JSONObject service = (JSONObject) array.get(i);
                singleValue = (String) service.get(child);
                list.add(singleValue);
            }
        } else {
            list.add(singleValue);
        }
        return list;
    }

}
