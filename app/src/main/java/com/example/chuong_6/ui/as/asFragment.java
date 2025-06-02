package com.example.chuong_6.ui.as;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.chuong_6.databinding.FragmentAsBinding;
import com.example.chuong_6.ui.as.asViewModel;

public class asFragment extends Fragment {
    private FragmentAsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        asViewModel asViewModel =
                new ViewModelProvider(this).get(asViewModel.class);

        binding = FragmentAsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
