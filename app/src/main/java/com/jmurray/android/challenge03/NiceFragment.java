package com.jmurray.android.challenge03;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmurray.android.challenge03.databinding.FragmentNiceBinding;

public class NiceFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentNiceBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nice, container, false);
        binding.setViewModel(new NameViewModel(getArguments().getString("firstName"), (1 == (getArguments().getInt("isNice")))));

        return binding.getRoot();
    }

}
