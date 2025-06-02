package com.example.chuong_6.ui.br;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.chuong_6.databinding.FragmentBrBinding;
import com.example.chuong_6.ui.br.brViewModel;

public class brFragment extends Fragment {
    private FragmentBrBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        brViewModel brViewModel =
                new ViewModelProvider(this).get(brViewModel.class);

        binding = FragmentBrBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
