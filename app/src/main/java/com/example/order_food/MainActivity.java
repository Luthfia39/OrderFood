package com.example.order_food;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input_menu;
    Button btn_makanan;
    Button btn_minuman;
    TextView quantityOrder;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK){
                String quantity = result.getData().getStringExtra(displayOrder.DETAIL_MENU);
                quantityOrder.setText(quantity);
            }
        }
    });

    public static final String NEW_MENU = "MENU_KEY";
    public static final String TYPE_MENU = "TYPE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_menu = findViewById(R.id.inputMenu);
        btn_makanan = findViewById(R.id.btn_food);
        btn_minuman = findViewById(R.id.btn_drink);
        quantityOrder = findViewById(R.id.displayQuantity);

        btn_minuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_drink = new Intent(view.getContext(), displayOrder.class);
                String menu = input_menu.getText().toString();
                intent_drink.putExtra(TYPE_MENU, "Minuman");
                intent_drink.putExtra(NEW_MENU, menu);
                launcher.launch(intent_drink);
            }
        });

        btn_makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_food = new Intent(view.getContext(), displayOrder.class);
                String menu = input_menu.getText().toString();
                intent_food.putExtra(TYPE_MENU, "Makanan");
                intent_food.putExtra(NEW_MENU, menu);
                launcher.launch(intent_food);
            }
        });
    }
}