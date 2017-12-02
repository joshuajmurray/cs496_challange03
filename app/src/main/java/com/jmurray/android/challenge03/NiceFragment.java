package com.jmurray.android.challenge03;

import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jmurray.android.challenge03.databinding.FragmentNiceBinding;

public class NiceFragment extends Fragment {
    private Names names;
    private Button mResetButton;
    private Button mMangleNice;
    private TextView mNiceMangled;

    public static NiceFragment newInstance() {
        return new NiceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        String pass = getArguments().getString("firstName");
        boolean isNice = 1 == (getArguments().getInt("isNice")) ? true:false;
        FragmentNiceBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nice, container, false);
        binding.setViewModel(new NameViewModel(pass, isNice));

        return binding.getRoot();
    }
////                    mFirstName = (EditText) findViewById(R.id.first_name);
////                    names.setLastName(true);
////                    mFirstName.setText(names.getLastName());

}
