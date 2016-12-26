package com.example.kaiso.dualnbacknosound;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.kaiso.dualnbacknosound.Fragments.GameFrag;

/**
 * Created by kaiso on 12/24/2016.
 */
public class GameMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelayout);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, new GameFrag()).commit();

    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        GameMode.super.onBackPressed();
                        finish();
                    }
                }).create().show();
    }
//    public void clickone(View view){
//        GameFrag.myClickMethod(view);
//
//
//    }
//
//    public void clicktwo(View view){
//        System.out.print("hey1");
//
//    }

}
