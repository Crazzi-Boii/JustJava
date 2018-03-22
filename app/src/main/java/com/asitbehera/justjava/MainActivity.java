package com.asitbehera.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;
    int price = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(quantity);
        displayPrice(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        if (quantity != 0) {
            String priceMessage = "Total: " + displayPrice(quantity) + "\n Thank You! Have a nice day.";
            displayMessage(priceMessage);
        }
    }
    public void resetAll(View view) {
        quantity = 0;
        display(quantity);
        displayPrice(quantity);
    }
    public void increment(View view){
        quantity++;
        display(quantity);
        displayPrice(quantity);
    }
    public void decrement(View view){
        if (quantity > 0) {
            quantity--;
            display(quantity);
            displayPrice(quantity);
        }
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private String displayPrice(int number) {
        number = number * price;
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        String total = NumberFormat.getCurrencyInstance(new Locale("en", "in")).format(number);
        priceTextView.setText(total);
        return total;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
