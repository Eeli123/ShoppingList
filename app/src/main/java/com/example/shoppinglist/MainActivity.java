package com.example.shoppinglist;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.shoppinglist.EXTRA_TEXT";

    Button save;
    Button done;
    EditText text;
    ArrayList<String> lista = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = (Button) findViewById(R.id.button);
        done = (Button) findViewById(R.id.button2);
        text = (EditText) findViewById(R.id.simpleEditText);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text.getText().toString().length() < 3 ){
                    Toast.makeText(getApplicationContext(),"Error, too short", Toast.LENGTH_SHORT).show();
                }
                else if(text.getText().toString().length() > 15){
                    Toast.makeText(getApplicationContext(),"Error, too long", Toast.LENGTH_SHORT).show();
                }
                else{
                    lista.add(text.getText().toString());
                    Toast.makeText(getApplicationContext(),"Item added to ShoppingList", Toast.LENGTH_SHORT).show();
                    text.setText("");
                }
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShowlist();
            }
        });


    }
    public void openShowlist(){
        Intent intent = new Intent(this, Showlist.class);
        intent.putExtra(EXTRA_TEXT, lista);
        startActivity(intent);
    }

}
