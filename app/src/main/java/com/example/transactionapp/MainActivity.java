package com.example.transactionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText date,particulars,income,expends;
    Button add,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();



        date = findViewById(R.id.et_date);
        particulars = findViewById(R.id.et_particulars);
        income = findViewById(R.id.et_income);
        expends = findViewById(R.id.et_expends);

        add = findViewById(R.id.btn_add);
        view = findViewById(R.id.btn_view);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processinsert(date.getText().toString(),
                        particulars.getText().toString(),
                        income.getText().toString(),
                        expends.getText().toString());
            }
        });



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ViewActivity.class));
            }
        });


    }

    private void processinsert(String d, String p, String i, String e) {

        String res=new DbManager(this).addRecord(d,p,i,e);
        date.setText("");
        particulars.setText("");
        income.setText("");
        expends.setText("");
        Toast.makeText(getApplicationContext(),res, Toast.LENGTH_SHORT).show();
    }
}
