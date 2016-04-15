package com.example.ben.rossfamilyeatery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private final String[] FOOD_TYPES = {"Main", "Sides" , "Beverages", "Desserts"};
    private final String[] MAIN_FOODS = {"Burger","Pasta","Pizza","Chicken Sandwich",""};
    private final String[] SIDE_FOODS = {"Fries","House Salad","Bean Soup","Onion Rings",""};
    private final String[] BEVERAGE_OPTIONS = {"Water","Pop","Orange Juice","Milk",""};
    private final String[] DESSERT_OPTIONS = {"Cheesecake","Giant Cookie","Rice Pudding","Brownie",""};
    private final String[] MAIN_PRICES = {"$4.50","$4.50","$3.00","$5.75"};
    private final String[] SIDE_PRICES = {"$1.50","$2.00","$2.75","$4.00"};
    private final String[] BEVERAGE_PRICES = {"$3.00","$1.00","$2.00","$3.25"};
    private final String[] DESSERT_PRICES = {"$8.00","$3.50","$5.00","$6.75"};


    private ArrayList<Button> buttons;
    private ArrayList<String> cart;
    private ArrayList<String> prices;
    private String currentPrice;
    private TextView cartItemNumber,instructionText,itemAddedText;
    private int foodTypeSelected = 0;

    private RelativeLayout layout;
    private String orderType,foodType;
    private Button buttonClicked;
    private boolean secondMenu = false;

    final Animation in = new AlphaAnimation(0.0f, 1.0f);
    final Animation out = new AlphaAnimation(1.0f, 0.0f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Get the order type
        orderType = getIntent().getStringExtra("OrderType");
        layout = (RelativeLayout)findViewById(R.id.layout);
        cart = new ArrayList<>();
        prices = new ArrayList<>();
        cartItemNumber = (TextView)findViewById(R.id.cartNumber);
        instructionText = (TextView)findViewById(R.id.instructionText);
        itemAddedText = (TextView)findViewById(R.id.itemAddedTextView);

        in.setDuration(3000);
        out.setDuration(3000);
        out.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                itemAddedText.setText("");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    //When the back arrow is pressed
    public void backArrowPressed(View v)
    {
        onBackPressed();
    }
    //When the back hardware button is clicked
    @Override
    public void onBackPressed() {
        if(!secondMenu)
        {
            super.onBackPressed();
        }
        else
        {
            int j = 0;
            for(Button button : buttons)
            {
                button.setText(FOOD_TYPES[j]);
                j++;
            }
            secondMenu = false;
            instructionText.setText("Please select an item");
        }
    }

    //When a food type button is pressed
    public void menuButtonPressed(View v)
    {
        //Get the pressed button text
        buttonClicked = (Button)findViewById(v.getId());
        foodType = buttonClicked.getText().toString();

        secondMenu = true;
        buttons = new ArrayList<>();
        int j = 0;
        instructionText.setText("Please select a food");


        //Update the text of the buttons depending on which food type you selected
        //Check if the food type was Main
        if (foodType.equalsIgnoreCase(FOOD_TYPES[0])) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View button = layout.getChildAt(i);
                //Check if its a button
                if (button instanceof Button) {
                    Button updateButton = (Button) button;
                    buttons.add(updateButton);
                }
            }
            j = 0;
            foodTypeSelected = 1;
            for (Button button : buttons) {
                button.setText(MAIN_FOODS[j]);
                j++;
            }
        }
        //Check if the food type was Sides
        else if (foodType.equalsIgnoreCase(FOOD_TYPES[1])) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View button = layout.getChildAt(i);
                //Check if its a button
                if (button instanceof Button) {
                    Button updateButton = (Button) button;
                    buttons.add(updateButton);
                }
            }
            j = 0;
            foodTypeSelected = 2;
            for (Button button : buttons) {
                button.setText(SIDE_FOODS[j]);
                j++;
            }
        }
        //Check if the food type was Beverages
        else if (foodType.equalsIgnoreCase(FOOD_TYPES[2])) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View button = layout.getChildAt(i);
                //Check if its a button
                if (button instanceof Button) {
                    Button updateButton = (Button) button;
                    buttons.add(updateButton);
                }
            }
            j = 0;
            foodTypeSelected = 3;
            for (Button button : buttons) {
                button.setText(BEVERAGE_OPTIONS[j]);
                j++;
            }
        }
        //Check if the food type was Desserts
        else if (foodType.equalsIgnoreCase(FOOD_TYPES[3])) {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View button = layout.getChildAt(i);
                //Check if its a button
                if (button instanceof Button) {
                    Button updateButton = (Button) button;
                    buttons.add(updateButton);
                }
            }
            j = 0;
            foodTypeSelected = 4;
            for (Button button : buttons) {
                button.setText(DESSERT_OPTIONS[j]);
                j++;
            }
        }
        //Else a food item is selected, add to cart and update cart number
        else
        {
            for (int i = 0; i < layout.getChildCount(); i++) {
                View button = layout.getChildAt(i);
                //Check if its a button
                if (button instanceof Button) {
                    Button updateButton = (Button) button;
                    buttons.add(updateButton);
                }
            }
            for(int i = 0; i < buttons.size(); i++)
            {
                if(buttons.get(i).getText() == foodType)
                {
                    switch(foodTypeSelected)
                    {
                        case 1:
                            prices.add(MAIN_PRICES[i]);
                            break;
                        case 2:
                            prices.add(SIDE_PRICES[i]);
                            break;
                        case 3:
                            prices.add(BEVERAGE_PRICES[i]);
                            break;
                        case 4:
                            prices.add(DESSERT_PRICES[i]);
                            break;
                    }
                    break;
                }
            }
            cart.add(foodType);
            cartItemNumber.setText(String.valueOf(cart.size()));
            itemAddedText.setText(foodType + " has been added to your cart");
            itemAddedText.startAnimation(in);
            itemAddedText.startAnimation(out);
        }
    }
    public void cartClicked(View v)
    {
        Intent i = new Intent(MenuActivity.this, CartActivity.class);
        i.putStringArrayListExtra("cart",cart);
        i.putStringArrayListExtra("prices",prices);
        i.putExtra("OrderType",orderType);
        startActivity(i);
    }

}
