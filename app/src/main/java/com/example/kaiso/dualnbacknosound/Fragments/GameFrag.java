package com.example.kaiso.dualnbacknosound.Fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kaiso.dualnbacknosound.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kaiso on 12/24/2016.
 */
public class GameFrag extends Fragment implements View.OnClickListener{
    Fragment someFragment;
    TextView timerTextView;
    LinearLayout one = null;
    LinearLayout two = null;
    LinearLayout three = null;
    LinearLayout four = null;
    LinearLayout five = null;
    LinearLayout six = null;
    LinearLayout seven = null;
    LinearLayout eight = null;
    LinearLayout nine = null;
    Button button = null;
    int selected = -1;
    int clicked = 0;
    int correct = 0;
    int wrong = 0;
    int i = 0;
    int newNum;
    int oldNum;
    MediaPlayer mediaPlayer;
    ArrayList<Integer> calc;
    long startTime = 0;
    int level = 1;
//need another argument for gamemode
    public boolean check(int i , int level){

        if(i >= level ) {
            if (calc.get(i - level) == clicked) {
                return true;


            }
        }
        return false;



    }




    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
                //one.setBackgroundColor(Color.BLUE);
                //generateSquares();
           // timerTextView.setText(String.format("%d:%02d", minutes, seconds));
            Log.d("Test2", "pressed:" + clicked);
            //Toast.makeText(getActivity().getApplicationContext(), String.format("%d:%02d", minutes, seconds), Toast.LENGTH_LONG).show();
            Log.d("Test2", "time:" + millis);
            if(millis >= 2000) {

                //timerHandler.postDelayed(timerRunnable, 0);

                calc.add(selected);
                if (check(i, level)){
                    correct++;
                    Toast.makeText(getActivity().getApplicationContext(), "yeahhhhhh correct:" + correct + "wrong:" + wrong + "arr:" + calc, Toast.LENGTH_LONG).show();

                }else{

                    wrong++;
                    //Toast.makeText(getActivity().getApplicationContext(), "incorrect:( wrong:" + wrong + "correct:" + correct + "arr:" + calc , Toast.LENGTH_LONG).show();

                }
                if (oldNum != newNum) {

                }
                startTime = System.currentTimeMillis();
                generateSquares();
                i++;
                clicked = 0;
            }else{
                if (selected == clicked) {
                    oldNum = newNum;
                    Log.d("Test2", "correct!!!!" +" correct:" + correct + "wrong:" + wrong );
                } else {

                    Log.d("Test2", "wrong!!!!" + " correct:" + correct + "wrong:" + wrong);
                }
            }

            timerHandler.postDelayed(this, 500);
            }

    };

    @Override
    public void onPause() {
        super.onPause();
        timerHandler.removeCallbacks(timerRunnable);
        //Button b = (Button)findViewById(R.id.button);
      //  b.setText("start");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mCustomView = inflater.inflate(R.layout.custom_actionbar, null);
        TextView title = (TextView) mCustomView.findViewById(R.id.title_text);
        mCustomView.findViewById(R.id.back_text).setVisibility(View.INVISIBLE);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);
        title.setText("DualNBack");
        calc = new ArrayList();
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.clicksound);
       // final MediaPlayer mBob = MediaPlayer.create(getActivity(), R.raw.clicksound);
        //mBob.start();
//        mBob.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(final MediaPlayer mp) {
//                mp.start();
//            }
//        });
        View view = inflater.inflate(R.layout.squares, container, false);
        one = (LinearLayout) view.findViewById(R.id.one);
        //b.setOnClickListener(this);
        System.out.print("hey2");
//        one.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Log.d("Test", "onClickListener ist gestartet");
//                timerHandler.removeCallbacks(timerRunnable);
//                //Toast.makeText(getActivity().getApplicationContext(), "Test", Toast.LENGTH_LONG).show();
//
//            }
//        });

        setSquares(view);
        two = (LinearLayout) view.findViewById(R.id.two);
        two.setBackgroundColor(Color.YELLOW);
        //b.setOnClickListener(this);

        LinearLayout all = (LinearLayout) view.findViewById(R.id.all);
        //two.setBackgroundColor(Color.YELLOW);
        System.out.print("hey2");
//        all.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                Log.d("Test2", "onClickListener ist gestartet");
//                //Log.d("Test2", view.getId());
//             //   Toast.makeText(getActivity().getApplicationContext(), "Test2", Toast.LENGTH_LONG).show();
////                switch (view.getId()) {
////                    case R.id.two:
////                        // do your code
////                        startTime = System.currentTimeMillis();
////                        timerHandler.postDelayed(timerRunnable, 0);
////                        Log.d("Test2", "three");
////                        break;
////                    case R.id.three:
////                        // do your code
////                        Log.d("Test2", "three");
////                        break;
////
////                    case R.id.four:
////                        // do your code
////                        Log.d("Test2", "four");
////                        break;
////
////                    case R.id.five:
////                        // do your code
////                        Log.d("Test2", "five");
////                        break;
////                    case R.id.six:
////                        // do your code
////                        Log.d("Test2", "six");
////                        break;
////                    case R.id.seven:
////                        // do your code
////                        Log.d("Test2", "seven");
////                        break;
////                    case R.id.eight:
////                        // do your code
////                        Log.d("Test2", "eight");
////                        break;
////                    case R.id.nine:
////                        // do your code
////                        Log.d("Test2", "nine");
////                        break;
////
////                    default:
////                        break;
////                }
//            }
//        });
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        button.setOnClickListener(this);
        return view;

    }
public void setSquares(View view){

    one = (LinearLayout) view.findViewById(R.id.one);
    two = (LinearLayout) view.findViewById(R.id.two);
    three = (LinearLayout) view.findViewById(R.id.three);
    four = (LinearLayout) view.findViewById(R.id.four);
    five = (LinearLayout) view.findViewById(R.id.five);
    six = (LinearLayout) view.findViewById(R.id.six);
    seven = (LinearLayout) view.findViewById(R.id.seven);
    eight = (LinearLayout) view.findViewById(R.id.eight);
    nine = (LinearLayout) view.findViewById(R.id.nine);
    button = (Button) view.findViewById(R.id.button);

}

    public void generateSquares(){
        Random generated = new Random();
        int randomNum;
        randomNum = generated.nextInt(9) + 1;
        setColor(randomNum);

    }
public LinearLayout returnNum(int num){

    if(1 == num){
        //setColor(1);
        return one;
    }else if(2 == num){
        return two;
    }else if(3 == num){
        return three;
    }else if(4 == num){
        return four;
    }else if(5 == num){
        return five;
    }else if(6 == num){
        return six;
    }else if(7 == num){
        return seven;
    }else if(8 == num){
        return eight;
    }else{
        return nine;
    }


}

    public void setColor(int num){

        returnNum(num).setBackgroundColor(Color.BLUE);
        selected = num;
        newNum = selected;
     //   returnNum(num).setOnClickListener(this);
//        returnNum(num).setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//               // Log.d("Test2", "onClickListener ist gestartet");
//                Log.d("Test2", "good job");z
//                Toast.makeText(getActivity().getApplicationContext(), "good!", Toast.LENGTH_LONG).show();
//
//            }
//        });
        setOthers(num);


    }

    public void setOthers(int num){
        int i = 1;
        while(i < 10){
            if(i != num) {
                returnNum(i).setBackgroundColor(Color.WHITE);
               // returnNum(num).setOnClickListener(null);
            }
            i++;
        }


    }
    public void setOnclicks(){
        int i = 1;
        while(i < 10) {
            returnNum(i).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    // Log.d("Test2", "onClickListener ist gestartet");
                    Log.d("Test2", "good job");
                    Toast.makeText(getActivity().getApplicationContext(), "good!", Toast.LENGTH_LONG).show();

                }
            });
            i++;
        }

    }

    @Override
    public void onClick(View view) {
        //mediaPlayer.start();
        switch (view.getId()) {
            case R.id.button:
                // do your code
                startTime = System.currentTimeMillis();
                timerHandler.postDelayed(timerRunnable, 0);
                Log.d("Test2", "start");
                break;
            case R.id.one:
                // do your code
                //startTime = System.currentTimeMillis();
                //timerHandler.postDelayed(timerRunnable, 0);
                clicked = 1;
                Log.d("Test2", "one");
                break;
            case R.id.two:
                // do your code
                //startTime = System.currentTimeMillis();
                //timerHandler.postDelayed(timerRunnable, 0);
                clicked = 2;
                Log.d("Test2", "two");
                break;
            case R.id.three:
                // do your code
                clicked = 3;
                Log.d("Test2", "three");
                break;

            case R.id.four:
                // do your code
                clicked = 4;
                Log.d("Test2", "four");
                break;

            case R.id.five:
                // do your code
                clicked = 5;
                Log.d("Test2", "five");
                break;
            case R.id.six:
                // do your code
                clicked = 6;
                Log.d("Test2", "six");
                break;
            case R.id.seven:
                // do your code
                clicked = 7;
                Log.d("Test2", "seven");
                break;
            case R.id.eight:
                // do your code
                clicked = 8;
                Log.d("Test2", "eight");
                break;
            case R.id.nine:
                // do your code
                clicked = 9;
                Log.d("Test2", "nine");
                break;

            default:
                break;
        }
    }


}