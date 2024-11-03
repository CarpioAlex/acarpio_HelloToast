package com.acarpio.acarpio_hellotoast;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button countButton;
    private TextView showCount;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        showCount = findViewById(R.id.show_count);
        countButton = findViewById(R.id.countButton);


        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("COUNT_INDEX", 0);
            showCount.setText(String.valueOf(count));
        } else {
            count = 0;
            showCount.setText(String.valueOf(count));
        }

        countButton.setOnClickListener(v -> {
            addCount();
        });
    }

    public void addCount() {
        count++;
        showCount.setText(String.valueOf(count));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("COUNT_INDEX", count);
    }
}
