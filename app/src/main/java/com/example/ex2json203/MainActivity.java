package com.example.ex2json203;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = findViewById(R.id.lst);
        String json = loadJsonFromRaw(R.raw.stagiaires);

        try {
            JSONArray arr = new JSONArray(json);
            ArrayList<String> res = new ArrayList<>();

            for(int i=0;i<arr.length();i++){
                JSONObject ob = arr.getJSONObject(i);

                res.add(ob.getString("nom") + ":" + ob.getString("filiere") + " - " + ob.getInt("age"));
            }

            ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,res);
            lst.setAdapter(ad);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJsonFromRaw(int resId) {

        try {
            InputStream in = getResources().openRawResource(resId);
            byte[] data = new byte[in.available()];
            in.read(data);
            in.close();
            return new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}