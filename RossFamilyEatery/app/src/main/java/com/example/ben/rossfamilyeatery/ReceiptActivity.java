package com.example.ben.rossfamilyeatery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReceiptActivity extends AppCompatActivity {
    private ArrayList<String> cart;
    private ArrayList<String> prices;
    private ListView list;
    private TextView totalText,orderTypeText;
    private String orderType,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        orderType = getIntent().getStringExtra("OrderType");
        cart = getIntent().getExtras().getStringArrayList("cart");
        prices = getIntent().getExtras().getStringArrayList("prices");
        totalText = (TextView) findViewById(R.id.totalText);
        total = getIntent().getExtras().getString("Total");
        orderTypeText = (TextView) findViewById(R.id.orderTypeText);
        orderTypeText.setText(orderType);

        totalText.setText("Total: $ " + String.valueOf(total));
        list = (ListView) findViewById(R.id.cartList);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                cart);

        list.setAdapter(arrayAdapter);
        totalText.setText(total);
    }


    public void ClickedNewOrder(View v) {
        Intent i = new Intent(ReceiptActivity.this, OrderTypeActivity.class);
        startActivity(i);
    }
}

