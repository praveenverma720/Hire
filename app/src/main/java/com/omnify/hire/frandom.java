package com.omnify.hire;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.omnify.hire.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * A simple {@link Fragment} subclass.
 */
public class frandom extends Fragment {

    public frandom() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frandom, container, false);
        TextView output1 = (TextView) view.findViewById(R.id.msg1);

        Random rand = new Random();
        ArrayList<Integer> randSet = new ArrayList<Integer>();
        for (int x = 0; x < 20; x++) {
            int randomNum = rand.nextInt(89) + 10;
            randSet.add(randomNum);
        }
       output1.setText(Arrays.toString(randSet.toArray()));
return view;

    }



        //randomSet=randSet;


}