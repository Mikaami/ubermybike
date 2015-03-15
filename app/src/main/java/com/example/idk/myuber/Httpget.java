package com.example.idk.myuber;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Httpget {

    String bike_lon;
    String bike_lat;
    String bike_num;
    int bike_rating;
    String owner_phone_num;
    String owner_first_name;
    String owner_last_name;
    String cc;
    String email;
    int experience;
    int user_rating;
    int owner_rating;
    String bike_owner_num;


    public JSONObject getJson(HttpEntity httpentity) {

        InputStream is = null;
        String received = "";
        JSONObject jObj = null;

        try {

            is = httpentity.getContent();

        }

        catch (IllegalStateException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            received = sb.toString();
            jObj = new JSONObject(received);
        }
        catch (Exception e) {
            e.printStackTrace();

        }

        return jObj;

    }

    public JSONObject getBike(String lat, String lon) {

        String URL = "http://home.loosescre.ws/~keith/astwe/server.php?commabd=bike&lat=";
        URL += lat;
        URL += "&lon=";
        URL += lon;
        JSONObject result = null;

        try {

            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();

            HttpResponse SetServerString;
            HttpClient Client = new DefaultHttpClient();
            SetServerString = Client.execute(httpget);

            HttpEntity httpentity = SetServerString.getEntity();


            result = getJson(httpentity);

        }

        catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }

    public JSONObject getUser(String owner_num) {

        String URL = "http://home.loosescre.ws/~keith/astwe/server.php?commabd=user&number=";
        URL += owner_num;
        JSONObject result = null;

        try {

            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();

            HttpResponse SetServerString;
            HttpClient Client = new DefaultHttpClient();
            SetServerString = Client.execute(httpget);

            HttpEntity httpentity = SetServerString.getEntity();


            result = getJson(httpentity);

        }

        catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }

    public JSONObject newBike(Bike new_bike) {

        String URL = "http://home.loosescre.ws/~keith/astwe/server.php?commabd=newbike&data=";

        JSONObject result = null;


        try {

            HttpGet httpget = new HttpGet(URL);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();

            HttpResponse SetServerString;
            HttpClient Client = new DefaultHttpClient();
            SetServerString = Client.execute(httpget);

            HttpEntity httpentity = SetServerString.getEntity();


            result = getJson(httpentity);

        }

        catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }

    public void parseUser(JSONObject jObj) {


        try {
            owner_first_name = (String)jObj.names().get(0);
            owner_last_name = (String)jObj.names().get(1);
            cc = (String)jObj.names().get(2);
            owner_phone_num = (String)jObj.names().get(2);
            email = (String)jObj.names().get(3);
            owner_rating = (int)jObj.names().get(4);
            user_rating = (int)jObj.names().get(5);
            experience = (int)jObj.names().get(6);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return;

    }

    public void parseBike(JSONObject jObj) {

        try {

            bike_num = (String)jObj.names().get(1);
            bike_rating = (int)jObj.names().get(2);
            bike_lat = (String)jObj.names().get(3);
            bike_lon = (String)jObj.names().get(4);
            bike_owner_num = (String)jObj.names().get(5);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getOwner_first_name() { return owner_first_name;}

    public String getOwner_last_name() { return owner_last_name;}

    public String getCc() { return cc;}

    public String getOwner_phone_num() { return owner_phone_num;}

    public String getEmail() { return email;}

    public int getOwner_rating() { return  owner_rating;}

    public int getUser_rating() { return user_rating;}

    public int getExperience() { return experience;}

    public String getBike_num() { return bike_num;}

    public int getBike_rating() { return bike_rating;}

    public String getBike_lat() { return bike_lat;}

    public String getBike_lon() { return bike_lon;}

    public String getBike_owner_num() { return bike_owner_num;}

}

