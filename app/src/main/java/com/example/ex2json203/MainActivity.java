package com.example.ex2json203;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new MyDatabase(this);
        lst = findViewById(R.id.lst);
        ArrayList<Stagiaire> st = getAllstags();

        ArrayList<String> res = new ArrayList<>();
        for(Stagiaire ss : st)
            res.add(ss.getNom() + " - " + ss.getAge());

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, res);
        lst.setAdapter(ad);

        for(Stagiaire s : st)
            MyDatabase.insert_stagiaire(db.getWritableDatabase(),s);

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

    public ArrayList<Stagiaire> getAllstags() {
        ArrayList<Stagiaire> stgs = new ArrayList<>();

        try {
            String json = loadJsonFromRaw(R.raw.stagiaires);
            JSONArray arr = new JSONArray(json);

            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                Stagiaire s = new Stagiaire();
                s.setNom(o.getString("nom"));
                s.setFiliere(o.getString("filiere"));
                s.setAge(o.getInt("age"));
                stgs.add(s);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return stgs;
    }
}