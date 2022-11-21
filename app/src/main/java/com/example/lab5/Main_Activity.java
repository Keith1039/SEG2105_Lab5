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

    ActivityResultLauncher<Intent> profileActivityResultLauncher =registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>(){
                @Override
                public void onActivityResult(ActivityResult result){
                    if(result.getResultCode() == Activity.RESULT_OK){
                        // There are no request codes
                        Intent data = result.getData();
                        ImageView avatarImage = (ImageView) findViewById(R.id.AvatarImage);
                        String drawableName = "flag_ca";
                        switch (data.getIntExtra("imageID", R.id.imageView)){
                            case R.id.imageView:
                                drawableName = "flag_ca";
                                break;
                            case R.id.imageView2:
                                drawableName = "flag_eg";
                                break;
                            case R.id.imageView3:
                                drawableName = "flag_fr";
                                break;
                            case R.id.imageView4:
                                drawableName = "flag_jp";
                                break;
                            case R.id.imageView5:
                                drawableName = "flag_kr";
                                break;
                            case R.id.imageView6:
                                drawableName = "flag_sp";
                                break;
                            case R.id.imageView7:
                                drawableName = "flag_tr";
                                break;
                            case R.id.imageView8:
                                drawableName = "flag_uk";
                                break;
                            case R.id.imageView9:
                                drawableName = "flag_us";
                                break;
                            default:
                                drawableName = "flag_ca";
                                break;
                        }
                        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
                        avatarImage.setImageResource(resID);
                    }
                }
            }
    );
    public void OnSetAvatarButton(View view){
        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
        profileActivityResultLauncher.launch(intent);
    }


}


