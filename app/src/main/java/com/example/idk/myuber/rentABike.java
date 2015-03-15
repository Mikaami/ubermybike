package com.example.idk.myuber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by chrisgin on 3/14/15.
 */

    public class rentABike extends Activity implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.rent_button:
                launch_rent_button();
                break;
            case R.id.owner_profile_button:
                launch_owner_profile();
                break;
        }

    }

    public void launch_rent_button()
    {
        Intent intent = new Intent(this,rentalActivity.class);
        startActivity(intent);
    }
    public void launch_owner_profile(){
        Intent intent = new Intent(this,Owner.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_a_bike);
        Button rent = (Button)findViewById(R.id.rent_button);
        rent.setOnClickListener(this);
        Button ownerProfile = (Button)findViewById(R.id.owner_profile_button);
        ownerProfile.setOnClickListener(this);

    }
}