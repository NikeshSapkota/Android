package com.nikesh.bodymassindexbmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {


    private EditText txt_Height,txt_Weight;
    private Button btn_Submit;
    private TextView BMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_Height = findViewById(R.id.txt_height);
        txt_Weight=findViewById(R.id.txt_weight);
        btn_Submit=findViewById(R.id.btn_calc);
        BMI = findViewById(R.id.BMI);
        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    float height = Float.parseFloat(txt_Height.getText().toString());
                    float weight = Float.parseFloat(txt_Weight.getText().toString());
                    Calc calc = new Calc();
                    calc.setHeight(height);
                    calc.setWeight(weight);
                    float bodyMassIndex = calc.calculate();
                    BMI.setText(Float.toString(bodyMassIndex));
                    if (bodyMassIndex < 18.50) {

                        Toast.makeText(getApplicationContext(), "UnderWeight", Toast.LENGTH_LONG).show();

                    } else if (bodyMassIndex >= 18.5 && bodyMassIndex < 25) {
                        Toast.makeText(getApplicationContext(), "Normal Weight", Toast.LENGTH_LONG).show();
                    } else if (bodyMassIndex >= 25 && bodyMassIndex <= 30) {
                        Toast.makeText(getApplicationContext(), "Over weight", Toast.LENGTH_LONG).show();
                    } else if (bodyMassIndex > 30) {
                        Toast.makeText(getApplicationContext(), "Obesity", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private boolean validate() {
        boolean validateFlag = true;
        Pattern p = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
        Matcher heightMatch = p.matcher(txt_Height.getText().toString());
        Matcher weightMatch = p.matcher(txt_Weight.getText().toString());

        //Validating for Empty Text
        if (TextUtils.isEmpty(txt_Height.getText().toString())) {
            txt_Height.setError("Enter Height");
            txt_Height.requestFocus();
            validateFlag = false;
        } else if (TextUtils.isEmpty(txt_Weight.getText().toString())) {
            txt_Weight.setError("Enter Weight");
            txt_Weight.requestFocus();
            validateFlag = false;
        }
        else if (!heightMatch.find())    //validating for number only
        {
            Toast.makeText(getApplicationContext(), "Invalid Height ", Toast.LENGTH_LONG).show();
            txt_Height.setError("Invalid Height ");
            txt_Height.requestFocus();
            validateFlag = false;
        }
        else if (!weightMatch.find())
        {
            Toast.makeText(getApplicationContext(), "Invalid weight", Toast.LENGTH_LONG).show();
            txt_Height.setError("Invalid weight");
            txt_Weight.requestFocus();
            validateFlag = false;
        }

        return validateFlag;
    }

}

