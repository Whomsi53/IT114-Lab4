
package com.example.myl4;

import android.os.Bundle;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.facebook.drawee.view.SimpleDraweeView;

// Image URL: https://web.njit.edu/~wh282/it114/g35.jpg

public class MainActivity extends AppCompatActivity {

    // Test image URL: https://web.njit.edu/~halper/carlsbad.jpeg

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top,
                            systemBars.right, systemBars.bottom);
                    return insets;
                });

        EditText urlInput = findViewById(R.id.image_url_input);
        Button displayButton = findViewById(R.id.display_image_button);
        SimpleDraweeView imageArea = findViewById(R.id.image_area);

        displayButton.setOnClickListener(v -> {
            String image_url = urlInput.getText().toString().trim();

            if (image_url.isEmpty()) {
                Toast.makeText(this, "Enter an image URL.",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            Uri uri = Uri.parse(image_url);
            imageArea.setImageURI(uri);
        });
    }
}
