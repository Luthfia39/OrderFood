package com.example.order_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class displayOrder extends AppCompatActivity {

    TextView display_type;
    TextView display_menu;
    EditText quantity;
    Button ok;

    public static final String DETAIL_MENU = "DETAIL_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_order);
        display_type = findViewById(R.id.foodDrink);
        display_menu = findViewById(R.id.displayMenu);
        quantity = findViewById(R.id.quantity);
        ok = findViewById(R.id.btn_ok);

        Intent intent_menu = getIntent();
        Intent intent_type = getIntent();
        String menu = intent_menu.getStringExtra(MainActivity.NEW_MENU);
        String type = intent_type.getStringExtra(MainActivity.TYPE_MENU);
        display_type.setText(type);
        display_menu.setText(menu);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String amount = quantity.getText().toString();
                intent.putExtra(DETAIL_MENU, amount);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}