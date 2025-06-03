package com.example.chuong_6.ui.wn;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.chuong_6.databinding.FragmentWnBinding;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class wnFragment extends Fragment {
    private FragmentWnBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        wnViewModel wnViewModel =
                new ViewModelProvider(this).get(wnViewModel.class);

        binding = FragmentWnBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Gọi API trong một luồng mới
        new Thread(() -> {
            try {
                String apiUrl = "http://192.168.1.100:5000/api/hello"; // đổi thành IP server của bạn
                URL url = new URL(apiUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                // Cập nhật giao diện (TextView) trên UI thread
                requireActivity().runOnUiThread(() -> {
                    binding.textResult.setText("Kết quả từ API: " + response.toString());
                });

            } catch (Exception e) {
                Log.e("API_ERROR", "Lỗi khi gọi API", e);
                requireActivity().runOnUiThread(() -> {
                    binding.textResult.setText("Lỗi khi gọi API: " + e.getMessage());
                });
            }
        }).start();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
