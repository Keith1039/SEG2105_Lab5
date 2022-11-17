package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public void SetTeamIcon(View view){
        // Creating a return Intent to pass to the main Activity
        Intent returnIntent = new Intent();

        // Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;

        //Adding details to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);

        // Finishing the activity and returning to the main screen
        finish();
    }

}