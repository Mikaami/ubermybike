package com.example.idk.myuber;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;


public class MapsActivity extends Fragment {


    private static GoogleMap mMap = null;
    private static Context context = null;
    private static Marker position = null;
    private SupportMapFragment fragment;
    public static Httpget bikes = new Httpget();


    public  static View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        if(container == null)
            return null;
        view = (FrameLayout) inflater.inflate(R.layout.activity_maps, container, false);
        MapsActivity.context = getActivity().getApplicationContext();
        SetupMapIfNeeded();
        return view;
    }

    public void SetupMapIfNeeded()
    {
        //test();
        if(mMap == null)
        {
            mMap = getMapFragment().getMap();
            Log.v("MAP", mMap.toString());
            if(mMap != null)
                SetupMap();

        }
        else
        {
            SetupMap();
        }

    }
    private SupportMapFragment getMapFragment() {
        Main_Activity.fragmentManager = getChildFragmentManager();

        SupportMapFragment t = (SupportMapFragment) Main_Activity.fragmentManager.findFragmentById(R.id.map);


        return t;
}

    private void SetupMap()
    {

        JSONObject obj = new JSONObject();
        AsyncTask<String, Void, JSONArray> task = bikes.new bikeTask();
        task.execute("string");
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent intent = new Intent(getActivity(), rentABike.class);
                getActivity().startActivity(intent);
                return false;
            }
        });

        //Log.v("LOGS", String.valueOf(array.length()));
        //bikes.parseBike(array);



    }

    public static void makeMarkers() {

        JSONArray array = new JSONArray();
        String[][] coordinates = bikes.getCoordinates();
        Log.v("LOG", "wefew" + String.valueOf(bikes.current_bikes));
        for(int i = 0; i < bikes.current_bikes; i++)
        {
            Marker marker = mMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(coordinates[i][0]),Double.parseDouble(coordinates[i][1]))));
            Log.v("LOG","Here");
        }
        position = mMap.addMarker(new MarkerOptions().position(new LatLng(36.999, -122)).title("Origin"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.7833,-122.4167), 8));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mMap != null) {
            Main_Activity.fragmentManager.beginTransaction().remove(Main_Activity.fragmentManager.findFragmentById(R.id.map)).commit();
            mMap = null;
        }
    }

    public void test() {

        String first_name;
        String last_name;
        Httpget tst = new Httpget();
        JSONObject obj = new JSONObject();
        AsyncTask<String, Void, JSONArray> task = tst.new myTask().execute("1");
        //tst.myTask().execute(obj);
        first_name = tst.getOwner_first_name();
        last_name = tst.getOwner_last_name();
        //Log.v("Post", "TEST");
        //Log.v("Post", last_name);

    }
}
