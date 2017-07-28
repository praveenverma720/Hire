package com.omnify.hire;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.omnify.hire.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class fmerge extends Fragment {
    ArrayList<Integer> randomSet=new ArrayList<Integer>();
    List<Integer> result1 = new ArrayList<Integer>();
    public fmerge() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view=  inflater.inflate(R.layout.fragment_fmerge, container, false);
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
                result1=mergeSort(randomSet);

                output2.setText(Arrays.toString(result1.toArray()));
            }
        });
        output.setText(Arrays.toString(randSet.toArray()));
    return  view;
    }
    private List<Integer> mergeSort(List<Integer> input){

        if(input.size() <= 1){
            return input;
        }

        int middle = (int) Math.ceil((double)input.size() / 2);
        //int[] left = new int[middle];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left.add(left.get(middle));

        int rightLength = 0;
        if(input.size() % 2 == 0){
            rightLength = middle;
        }
        else{
            rightLength = middle - 1;
        }
         right.add(right.get(rightLength));

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < input.size(); i++) {
            if(i < middle){
                left.add(left.get(leftIndex));
                input.add(input.get(i));
               left = input;
                leftIndex++;
            }
            else{
                right.add(right.get(rightIndex));
                input.add(input.get(i));
               right=input;
                rightIndex++;
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }


    private List<Integer> merge(List<Integer> left, List<Integer> right){
        int[] result = new int[left.size() + right.size()];
        int h=result.length;
        List<Integer> result1 = new ArrayList<>();
        result1.add(result1.get(h));
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while(leftIndex < left.size() || rightIndex < right.size()){
            if(leftIndex < left.size() && rightIndex < right.size()){
                if( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0){
                  result1.add(result1.get(resultIndex));
                    left.add(left.get(leftIndex));
                    result1= left;
                    leftIndex++;
                    resultIndex++;
                }
                else{
                    result1.add(result1.get(resultIndex));
                    right.add(right.get(leftIndex));
                    result1=right;
                    rightIndex++;
                    resultIndex++;
                }
            }
            else if(leftIndex < left.size()){
                for (int i = resultIndex; i < result.length; i++) {
                   result1.add(result1.get(i));
                    left.add(left.get(leftIndex));
                    result1=left;
                    leftIndex++;
                }
            }
            else if(rightIndex < right.size()){
                for (int i = resultIndex; i < result.length; i++) {
                    result1.add(result1.get(i));
                    right.add(right.get(leftIndex));
                    result1=right;

                    rightIndex++;
                }
            }
        }

        return result1;
    }
}
