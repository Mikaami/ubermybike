package com.example.idk.myuber;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;

/**
 * Created by Mikaami13 on 3/14/2015.
 */
public class PostBike extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_postbike1, container, false);

    }


    public void test() {

        String first_name;
        String last_name;
        Httpget test = new Httpget();
        JSONObject obj = new JSONObject();
        obj = test.getUser("1");
        test.parseUser(obj);
        first_name = test.getOwner_first_name();
        last_name = test.getOwner_last_name();
        System.out.println(first_name);
        System.out.println(last_name);

    }


}
