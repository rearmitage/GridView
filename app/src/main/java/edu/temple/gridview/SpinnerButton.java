package edu.temple.gridview;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class SpinnerButton extends Fragment implements View.OnClickListener {

    Button btnSubmit;
    Spinner spnrNumber;

    private OnFragmentInteractionListener mListener;

    public static SpinnerButton newInstance(String param1, String param2) {
        SpinnerButton fragment = new SpinnerButton();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SpinnerButton() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListener = (OnFragmentInteractionListener) getActivity();
        spnrNumber = (Spinner) getActivity().findViewById(R.id.spnrNumbers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.numbers_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnrNumber.setAdapter(adapter);
        btnSubmit = (Button) getActivity().findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spinner, container, false);
    }

    @Override
    public void onClick(View v) {
        String number = spnrNumber.getSelectedItem().toString();
        mListener.onFragmentInteraction(number);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String number);

    }

}
