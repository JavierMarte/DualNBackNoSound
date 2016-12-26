package com.example.kaiso.dualnbacknosound.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kaiso.dualnbacknosound.R;

/**
 * Created by kaiso on 12/26/2016.
 */
public class ReportFrag extends Fragment{
    int nback;
    GameFrag gameFragment;
    int progress;


//    public ReportFrag() {
//        gameFragment = new GameFrag();
//    }

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

        View view = inflater.inflate(R.layout.reportlayout, container, false);
        gameFragment = new GameFrag();
        Bundle bundle = this.getArguments();
        int correct = bundle.getInt("correct");
        int wrong = bundle.getInt("wrong");
        nback = bundle.getInt("nback");

        TextView correctPrompt = (TextView) view.findViewById(R.id.correctPro);
        TextView wrongPrompt = (TextView) view.findViewById(R.id.wrongPro);
        wrongPrompt.setText("number of wrong selections:" + wrong);
        correctPrompt.setText("number of correct selections:" + correct);
        Log.d("Test2", "xxxxxxx correct:" + correct + "wrong:" + wrong );

        Button nextGame = (Button) view.findViewById(R.id.nextpage);
        if(wrong < 4) {
            nback++;
            progress = (nback * 100) + progress;
        }

        nextGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Bundle bundle = new Bundle();
                bundle.putInt("nback", nback);
                bundle.putInt("progress", progress);

                gameFragment.setArguments(bundle);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.frameLayout, gameFragment);
                transaction.commit();

            }
        }
        );

        return view;
    }


}
