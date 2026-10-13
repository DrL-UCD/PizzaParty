package edu.ucdenver.salimllakhani.pizzaparty;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import edu.ucdenver.salimllakhani.pizzaparty.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {
    //Class variables
//    private EditText editTextNumber;
//    private RadioButton radioButtonChild;
//    private RadioButton radioButtonTeenager;
//    private RadioButton radioButtonAdult;
//
//    private TextView textViewResult;
//    private TextView textViewCost;

    //private ActivityMainBinding binding;
    private ActivityMainBinding binding;


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.childRadioButton), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //RadioGroup rg = findViewById(R.id.radioGroup)



        binding.radioGroup.setOnCheckedChangeListener (
                new RadioGroup.OnCheckedChangeListener() {


                    @Override
                    public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
                        calculate();

                    }
                }
        );

        binding.editTextNumber.addTextChangedListener (
                new TextWatcher() {

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            calculate();
                    }
                }
        );

//        editTextNumber = findViewById(R.id.editTextNumber);
//        radioButtonChild = findViewById(R.id.radioButtonChild);
//        radioButtonTeenager = findViewById(R.id.radioButtonTeenager);
//        radioButtonAdult = findViewById(R.id.radioButtonAdult);
//        textViewResult = findViewById(R.id.textViewResult);
//        textViewCost = findViewById(R.id.textViewCost);


    }

    public void clear(View view) {
        //Log.i ("info", "SL My Error Message: You just clicked on clear button");
        //Toast.makeText(this, "You just clicked on clear button", Toast.LENGTH_LONG).show();
        String title = getResources().getString(R.string.clearDialogTitle);
        String message = getResources().getString(R.string.message);
        String positive = getResources().getString(R.string.positive);
        String negative = getResources().getString(R.string.negative);
        ClearFormDialog clearFormDialog = new ClearFormDialog(title, message, positive, negative);

        clearFormDialog.show(getSupportFragmentManager(), "");
    }

    public void clear() {
        //Log.i ("info", "SL My Error Message: You just clicked on clear button");
        //Toast.makeText(this, "You just clicked on clear button", Toast.LENGTH_LONG).show();
        binding.editTextNumber.setText("");
        binding.radioButtonChild.setChecked(true);
        binding.textViewResult.setText(getResources().getString(R.string.resultText));
        binding.textViewCost.setText(getResources().getString(R.string.costText));
    }

    public void calculate(View view) {
        //Log.i ("info", "SL My Error Message: You just clicked on calculate button");
        //Toast.makeText(this, "You just clicked on calculate button", Toast.LENGTH_LONG).show();
        calculate();

    }

    private void calculate () {
        int numberOfGuests = 0;
        int slicesPerGuests = 0;
        double numberOfSlices = 8;
        double result;
        double cost;

        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

        String numGuest = binding.editTextNumber.getText().toString();

        try {
            numberOfGuests = Integer.parseInt(numGuest);

            if (binding.radioButtonChild.isChecked()) {
                slicesPerGuests = 4;
            }
            else if (binding.radioButtonTeenager.isChecked()) {
                slicesPerGuests = 8;
            }
            else {
                slicesPerGuests = 2;
            }

            result = Math.ceil((numberOfGuests * slicesPerGuests) / numberOfSlices);

            cost = result * 13.99;

            binding.textViewResult.setText(getResources().getString(R.string.resultText) + ": " + decimalFormat.format(result));
            binding.textViewCost.setText(getResources().getString(R.string.costText) + ": " + currencyFormat.format(cost));
        }
        catch (NumberFormatException ex) {
            Toast.makeText(this, "Input must be an integer", Toast.LENGTH_LONG).show();
        }

    }
}