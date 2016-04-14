package com.example.ben.rossfamilyeatery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OrderTypeActivity extends AppCompatActivity {
    private String orderType;
    private Button buttonClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_type);

    }
    //When an order type button is pressed
    public void buttonPressed(View v)
    {
        //Get the pressed button text
        buttonClicked = (Button)findViewById(v.getId());
        //Open the menu activity and pass in the order type variable
        Intent i = new Intent(OrderTypeActivity.this, MenuActivity.class);
        i.putExtra("OrderType",buttonClicked.getText().toString());
        startActivity(i);
    }


}
