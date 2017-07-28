package com.omnify.hire;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class fsort extends Fragment {
    ArrayList<Integer> randomSet=new ArrayList<Integer>();
    List<Integer> list = new ArrayList<Integer>();

    public fsort() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_fsort, container, false);
        TextView output= (TextView)view.findViewById(R.id.tv);
        final TextView output2= (TextView)view.findViewById(R.id.tv2);
        Button btn = (Button) view.findViewById(R.id.btn);
        Random rand = new Random();
        ArrayList<Integer> randSet = new ArrayList<Integer>();
        for (int x = 0; x < 20; x++) {
            int randomNum = rand.nextInt(89) + 10;
            randSet.add(randomNum);
            randomSet.add(randomNum);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list=quicksort(randomSet);

                output2.setText(Arrays.toString(list.toArray()));
            }
        });
        output.setText(Arrays.toString(randSet.toArray()));
        return view;
    }

    private List<Integer> quicksort(List<Integer> input){

        if(input.size() <= 1){
            return input;
        }

        int middle = (int) Math.ceil((double)input.size() / 2);
        int pivot = input.get(middle);

        List<Integer> less = new ArrayList<Integer>();
        List<Integer> greater = new ArrayList<Integer>();

        for (int i = 0; i < input.size(); i++) {
            if(input.get(i) <= pivot){
                if(i == middle){
                    continue;
                }
                less.add(input.get(i));
            }
            else{
                greater.add(input.get(i));
            }
        }

        return concatenate(quicksort(less), pivot, quicksort(greater));
    }
    private List<Integer> concatenate(List<Integer> less, int pivot, List<Integer> greater){

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < less.size(); i++) {
            list.add(less.get(i));
        }

        list.add(pivot);

        for (int i = 0; i < greater.size(); i++) {
            list.add(greater.get(i));
        }

        return list;
    }

}
