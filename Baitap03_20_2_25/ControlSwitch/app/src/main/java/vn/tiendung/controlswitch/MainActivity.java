package vn.tiendung.controlswitch;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    private Switch switchBackground;

    private int[] images = {
            R.drawable.hinhnen1, // Hình nền khi bật
            R.drawable.hinhnen2  // Hình nền khi tắt
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        layout = findViewById(R.id.main);
        switchBackground = findViewById(R.id.switchBackground);

        // Xử lý sự kiện khi bật/tắt Switch
        switchBackground.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    layout.setBackgroundResource(images[0]); // Bật switch: đổi sang hình 1
                } else {
                    layout.setBackgroundResource(images[1]); // Tắt switch: đổi sang hình 2
                }
            }
        });
    }
}