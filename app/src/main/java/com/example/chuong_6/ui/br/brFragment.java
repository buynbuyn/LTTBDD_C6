package com.example.chuong_6.ui.br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
    private BatteryReceiver batteryReceiver;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        brViewModel brViewModel =
                new ViewModelProvider(this).get(brViewModel.class);

        binding = FragmentBrBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Khởi tạo TextView để hiển thị trạng thái pin
        binding.textBr.setText("Đang kiểm tra trạng thái pin...");

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Đăng ký BroadcastReceiver
        batteryReceiver = new BatteryReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        requireActivity().registerReceiver(batteryReceiver, filter);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Hủy đăng ký BroadcastReceiver
        requireActivity().unregisterReceiver(batteryReceiver);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // BroadcastReceiver để lắng nghe trạng thái pin
    private class BatteryReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level", -1);
            binding.textBr.setText("Mức pin hiện tại: " + level + "%");
        }
    }
}