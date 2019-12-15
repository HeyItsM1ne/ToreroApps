package com.example.uasdaffa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.text.NumberFormat;
import android.text.Editable;
import android.view.View;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.TextView;

public class Mercha extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercha);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void increment(View view) {
        if (quantity == 100) {
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }


    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        EditText nameUkuran = (EditText) findViewById(R.id.ukuran);
        Editable nameEdit = nameUkuran.getText();
        String ukuran = nameEdit.toString();


        int price = calculatePrice();

        String message = createOrderSummary(name, price, ukuran);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:aldaffarifky13@gmail.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT,
                getString(R.string.order_summary_email_subject, name));
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

        private int calculatePrice (){
            int basePrice = 80000;
            return quantity * basePrice;
        }

        private String createOrderSummary (String name,int price, String ukuran){
            String priceMessage = getString(R.string.order_summary_name, name);
            priceMessage += "\n" + getString(R.string.order_summary_ukuran, ukuran);
            priceMessage += "\n" + getString(R.string.order_summary_quantity, quantity);
            priceMessage += "\n" + getString(R.string.order_summary_price,
                    NumberFormat.getCurrencyInstance().format(price));
            priceMessage += "\n" + getString(R.string.thank_you);

            return priceMessage;
        }
        private void displayQuantity ( int numberOfSweater){
            TextView quantityTextView = (TextView) findViewById(
                    R.id.quantity_text_view);
            quantityTextView.setText("" + numberOfSweater);
        }
    }
