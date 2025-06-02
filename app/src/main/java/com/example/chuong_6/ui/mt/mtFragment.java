package com.example.chuong_6.ui.mt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.chuong_6.databinding.FragmentMtBinding;
import com.example.chuong_6.ui.mt.mtViewModel;

public class mtFragment extends Fragment {
    private FragmentMtBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mtViewModel mtViewModel =
                new ViewModelProvider(this).get(mtViewModel.class);

        binding = FragmentMtBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
