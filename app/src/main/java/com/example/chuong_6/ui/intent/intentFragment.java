package com.example.chuong_6.ui.intent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.chuong_6.databinding.FragmentIntentBinding;
import com.example.chuong_6.ui.intent.intentViewModel;

public class intentFragment extends Fragment {
    private FragmentIntentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        intentViewModel intentViewModel =
                new ViewModelProvider(this).get(intentViewModel.class);

        binding = FragmentIntentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
