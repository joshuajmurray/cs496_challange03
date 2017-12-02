package com.jmurray.android.challenge03;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmurray.android.challenge03.databinding.FragmentRudeBinding;

public class RudeFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String pass = getArguments().getString("firstName");
        boolean isNice = 1 == (getArguments().getInt("isNice")) ? true:false;
        FragmentRudeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rude, container, false);
        binding.setViewModel(new NameViewModel(pass, isNice));

        return binding.getRoot();
    }

}
