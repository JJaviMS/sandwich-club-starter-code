package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject fullJSON = new JSONObject(json);
            JSONObject name = fullJSON.getJSONObject("name");
            String mainName = name.getString("mainName");
            List<String> alsoknow = populateList(name.getJSONArray("alsoKnownAs"));

            String placeOfOrigin = fullJSON.getString("placeOfOrigin");
            String description = fullJSON.getString("description");
            String image = fullJSON.getString("image");
            List<String> ingredients = populateList(fullJSON.getJSONArray("ingredients"));

            return new Sandwich(mainName,alsoknow,placeOfOrigin,description,image,ingredients);

        } catch (JSONException e) {
            return null; //If I don´t have a well formed JSON object I return null
        }

    }

    private static List<String> populateList (JSONArray data) throws JSONException {
        List<String> list = new ArrayList<>();
        for(int i=0;i<data.length();i++){
            list.add(data.getString(i));
        }
        return list;
    }
}
