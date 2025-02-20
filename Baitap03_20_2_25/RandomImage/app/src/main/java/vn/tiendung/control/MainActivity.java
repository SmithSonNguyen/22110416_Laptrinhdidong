package vn.tiendung.control;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int[] images = {
            R.drawable.hinhnen1,
            R.drawable.hinhnen2,
            R.drawable.hinhnen3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = findViewById(R.id.main);
        Random random = new Random();
        int randomImage = images[random.nextInt(images.length)];

        layout.setBackgroundResource(randomImage);
    }
}