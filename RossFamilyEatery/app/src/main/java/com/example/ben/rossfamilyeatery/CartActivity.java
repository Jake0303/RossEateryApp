package com.example.ben.rossfamilyeatery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    private ArrayList<String> cart;
    private ArrayList<String> prices;
    private ListView list;
    private TextView totalText;
    private float total = 0f;
    private String orderType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        orderType = getIntent().getStringExtra("OrderType");
        cart = getIntent().getExtras().getStringArrayList("cart");
        prices = getIntent().getExtras().getStringArrayList("prices");
        totalText = (TextView) findViewById(R.id.totalText);


        for (int i = 0; i < cart.size(); i++) {
            for (int j = 0; j < prices.size(); j++) {
                if (i == j) {
                    cart.set(i, cart.get(i) + "\t \t" + prices.get(j));
                    String val = prices.get(j).replace("$", "");
                    total += Float.valueOf(val);
                }
            }
        }
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
    }



    public void checkoutButtonClick(View v) {
        Intent i = new Intent(CartActivity.this, ReceiptActivity.class);
        i.putStringArrayListExtra("cart", cart);
        i.putStringArrayListExtra("prices", prices);
        i.putExtra("OrderType", orderType);
        i.putExtra("Total", totalText.getText());
        startActivity(i);
    }
}
