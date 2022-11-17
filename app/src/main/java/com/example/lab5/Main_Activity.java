package com.example.lab5;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Main_Activity extends AppCompatActivity {
    String drawableName = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void OnOpenInGoogleMaps(View view){
        EditText teamAddress = (EditText) findViewById(R.id.textInputEditText2);

        //Create a URL from a string. Use the result to create an intent
        Uri gmmIntentURI = Uri.parse("https://maps.google.co.in/maps?q=" + teamAddress.getText());

        // Create an Intent from gmmIntentURi. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentURI);

        //Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start the activity that can hand the Intent
        startActivity(mapIntent);

    }
    public void OnSetAvatarButton(View view){
        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
        profileActivityResultLauncher.launch(intent);
    }
    ActivityResultLauncher<Intent> profileActivityResultLauncher =registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>(){
                @Override
                public void onActivityResult(ActivityResult result){
                    if(result.getResultCode() == Activity.RESULT_OK){
                        // There are no request codes
                        Intent data = result.getData();
                        //Switch(data.getIntExtra("imageID", R.id.imageView2)){
                            //case R.id.imageView2:
                                //drawableName = "Canadian flag";
                                //break;

                        //}
                    }
                }
            }
    );

}


