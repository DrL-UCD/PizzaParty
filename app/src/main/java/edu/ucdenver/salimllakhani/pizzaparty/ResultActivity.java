package edu.ucdenver.salimllakhani.pizzaparty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.ucdenver.salimllakhani.pizzaparty.databinding.ActivityMainBinding;
import edu.ucdenver.salimllakhani.pizzaparty.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {
    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_result);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        binding = ActivityResultBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);




        String result = "";
        String cost= "";

        Intent intent = getIntent();
        if (intent != null) {
            result = intent.getStringExtra("result");
            cost = intent.getStringExtra("cost");
        }

        binding.resultTextView.setText("Number of Pizza: " + result);
        binding.costTextView.setText("Cost of Pizza: " + cost);
    }


    public void onClickOk(View view) {
        Intent mainActivty = new Intent(this, MainActivity.class);
        startActivity(mainActivty);
    }
}