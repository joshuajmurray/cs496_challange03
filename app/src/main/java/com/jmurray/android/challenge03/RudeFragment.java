package com.jmurray.android.challenge03;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmurray.android.challenge03.databinding.FragmentRudeBinding;

public class RudeFragment extends Fragment {
    private Names names = new Names();
    public static RudeFragment newInstance() {
        return new RudeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentRudeBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_rude, container, false);

        return binding.getRoot();
    }
//                    mFirstName = (EditText) findViewById(R.id.first_name);
//                    names.setLastName(false);
//                    mFirstName.setText(names.getLastName());
}
