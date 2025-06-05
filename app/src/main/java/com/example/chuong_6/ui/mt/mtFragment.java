package com.example.chuong_6.ui.mt;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.chuong_6.databinding.FragmentMtBinding;
import com.example.chuong_6.ui.mt.mtViewModel;

public class mtFragment extends Fragment {
    private FragmentMtBinding binding;
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mtViewModel mtViewModel =
                new ViewModelProvider(this).get(mtViewModel.class);

        binding = FragmentMtBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Initialize UI components
        Button startButton = binding.startButton;
        TextView resultTextView = binding.resultTextView;

        // Set up button click listener
        startButton.setOnClickListener(v -> startBackgroundThread(resultTextView));

        return root;
    }

    private void startBackgroundThread(TextView resultTextView) {
        new Thread(() -> {
            // Simulate a time-consuming task
            for (int i = 1; i <= 5; i++) {
                final int count = i;
                try {
                    Thread.sleep(1000); // Simulate work by sleeping for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Update UI on the main thread
                mainHandler.post(() -> resultTextView.setText("Count: " + count));
            }

            // Final update after task completion
            mainHandler.post(() -> resultTextView.setText("Task Completed!"));
        }).start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}