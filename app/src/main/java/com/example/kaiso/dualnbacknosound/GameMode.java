package com.example.kaiso.dualnbacknosound;

import android.app.FragmentTransaction;
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
