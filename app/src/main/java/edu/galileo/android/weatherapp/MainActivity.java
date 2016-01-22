package edu.galileo.android.weatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    @Bind(R.id.inputCity) EditText inputCity;
    @Bind(R.id.btnSubmit) Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strInput = inputCity.getText().toString();

                Log.e(TAG, strInput);
            }
        });

    }
}
