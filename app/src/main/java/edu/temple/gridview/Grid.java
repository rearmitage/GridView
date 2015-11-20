package edu.temple.gridview;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

public class Grid extends Fragment {

    GridView gridView;
    int x;

    // TODO: Rename and change types and number of parameters
    public static Grid newInstance(String param1, String param2) {
        Grid fragment = new Grid();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public Grid() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView = (GridView) getActivity().findViewById(R.id.gridView);
        //gridView.setAdapter(new CustomAdapter(getActivity(), numbers));
    }

    public void changeNumber(String number)
    {
        switch (number)
        {
            case "Two":
                x = 2;
                break;

            case "Four":
                x = 4;
                break;

            case "Six":
                x = 6;
                break;

            case "Eight":
                x = 8;
                break;

            case "Ten":
                x = 10;
                break;
        }
        gridView.setNumColumns(x);
        gridView.setAdapter(new CustomAdapter(getActivity(), number));
        //text.setText(number);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid, container, false);
    }



}
