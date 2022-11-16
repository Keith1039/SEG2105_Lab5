package com.example.lab5;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

public class Main_Activity {




    public void SetTeamIcon(View view){
        // Creating a return Intent to pass to the main Activity
        Intent returnIntent = new Intent();

        // Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;

        //Adding details to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        //setResult("RESULT_OK", returnIntent);

        // Finishing the activity and returning to the main screen
        //finish();
    }

    /*
    ActivityResultLauncher<Intent> profileActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.startActivityForResult(),
            new ActivityResultCallback<ActivityResult>(){
                @Override
                public void onActivityResult(ActivityResult result){
                    if(result.getResultCode() == Activity.RESULT_OK){
                        // There are no request codes
                        Intent data = result.getData();
                        // adding code here in next slide
                    }
                }
            }
    )
     */








}


