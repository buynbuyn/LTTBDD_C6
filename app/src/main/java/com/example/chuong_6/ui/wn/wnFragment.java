package com.example.chuong_6.ui.wn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.chuong_6.databinding.FragmentWnBinding;
import com.example.chuong_6.ui.wn.wnViewModel;

public class wnFragment extends Fragment {
    private FragmentWnBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        wnViewModel wnViewModel =
                new ViewModelProvider(this).get(wnViewModel.class);

        binding = FragmentWnBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
