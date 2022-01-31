package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    //final TextView textView = (TextView) findViewById(R.id.title_movie);
    static Map<String, String> movies = new HashMap<String, String>();
    static List<String> popularMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        try {
            getJsonRep();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RequestQueue queue = Volley.newRequestQueue(this);
    }
        public void getJsonRep()throws IOException {
            URL urlForGetRequest = new URL("https://api.themoviedb.org/3/movie/popular?api_key=8a7ef7cc2644c64c0de94fb16a453d29");
                    String readLine = null;
            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
            conection.setRequestMethod("GET");

            int responseCode = conection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conection.getInputStream()));
                StringBuffer response = new StringBuffer();
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }
                in.close();
                String jsonRep = response.toString();

                JSONObject obj = null;


                try {
                    obj = new JSONObject(jsonRep);
                    JSONArray results = obj.getJSONArray("results");

                    String title;
                    String poster ;
                    List<String> listSearch= new ArrayList(); ;
                    for (int i = 0; i < results.length(); i++)
                    {
                        title = results.getJSONObject(i).getString("title");
                        poster = results.getJSONObject(i).getString("poster_path");
                        if(!title.isEmpty()){
                            popularMovies.add(title);
                            popularMovies.add("https://image.tmdb.org/t/p/w500"+poster);
                        }
                    }





                } catch (JSONException e) {
                    e.printStackTrace();
                }

        }

    }

}