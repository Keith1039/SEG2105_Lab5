package com.example.lab5;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;

public class ActivityResultLauncher<E>
{

    ActivityResultLauncher<Intent> profileActivityResultLauncher =registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
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


    public void OnSetAvatarButton(View view) {
        //Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        //profileActivityResultLauncher.launch(intent);
    }
}
