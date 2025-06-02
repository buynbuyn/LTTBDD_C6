package com.example.chuong_6.ui.as;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.chuong_6.MyService;
import com.example.chuong_6.databinding.FragmentAsBinding;

public class asFragment extends Fragment {

    private FragmentAsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Khởi tạo ViewModel nếu bạn dùng
        asViewModel asViewModel =
                new ViewModelProvider(this).get(asViewModel.class);

        binding = FragmentAsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 👉 Xin quyền POST_NOTIFICATIONS nếu Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(),
                        new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
            }
        }

        // 👉 Bắt sự kiện nút Start
        binding.btnStartIntent.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), MyService.class);
            intent.putExtra("data", binding.edtDataIntent.getText().toString().trim());
            requireActivity().startService(intent);
        });

        // 👉 Bắt sự kiện nút Stop
        binding.btnStopIntent.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), MyService.class);
            requireActivity().stopService(intent);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
