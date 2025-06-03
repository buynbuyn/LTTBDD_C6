package com.example.chuong_6.ui.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.chuong_6.databinding.FragmentIntentBinding;

public class intentFragment extends Fragment {
    private FragmentIntentBinding binding;
    private intentViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(intentViewModel.class);
        binding = FragmentIntentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Handle incoming intent
        handleIncomingIntent();

        // Observe ViewModel data
        viewModel.getText().observe(getViewLifecycleOwner(), text -> {
            binding.textIntent.setText(text != null ? text : "No data received");
        });

        return root;
    }

    private void handleIncomingIntent() {
        Intent intent = requireActivity().getIntent();
        if (intent == null || intent.getAction() == null) {
            viewModel.setText("No intent data available");
            Toast.makeText(getContext(), "No intent data", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (intent.getAction()) {
            case Intent.ACTION_VIEW:
                Uri data = intent.getData();
                if (data != null) {
                    viewModel.setText("Received Google URL: " + data.toString());
                } else {
                    viewModel.setText("Invalid URL data");
                    Toast.makeText(getContext(), "Invalid URL", Toast.LENGTH_SHORT).show();
                }
                break;
            case "com.example.chuong_6.CUSTOM_ACTION":
                String customData = intent.getStringExtra("custom_data");
                if (customData != null && !customData.isEmpty()) {
                    viewModel.setText("Received Custom Data: " + customData);
                } else {
                    viewModel.setText("No custom data received");
                    Toast.makeText(getContext(), "No custom data", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                viewModel.setText("Unsupported intent action");
                Toast.makeText(getContext(), "Unsupported action", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}