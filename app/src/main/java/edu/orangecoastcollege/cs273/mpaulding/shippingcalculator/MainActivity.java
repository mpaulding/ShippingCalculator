package edu.orangecoastcollege.cs273.mpaulding.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ShipItem shipItem;

    private EditText mWeightEditText;
    private TextView mBaseCostTextView;
    private TextView mAddedCostTextView;
    private TextView mTotalCostTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shipItem = new ShipItem();
        mWeightEditText = (EditText) findViewById(R.id.weightEditText);
        mBaseCostTextView = (TextView) findViewById(R.id.baseCostTextView);
        mAddedCostTextView = (TextView) findViewById(R.id.addedCostTextView);
        mTotalCostTextView = (TextView) findViewById(R.id.totalShippingTextView);

        mWeightEditText.addTextChangedListener(mWeightTextWatcher);
    }


    private TextWatcher mWeightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                shipItem.setWeight(Integer.parseInt(s.toString()));
            }
            catch (NumberFormatException e)
            {
                shipItem.setWeight(0);
            }
            displayShipping();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private void displayShipping()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        mBaseCostTextView.setText(currency.format(shipItem.getBaseCost()));
        mAddedCostTextView.setText(currency.format(shipItem.getAddedCost()));
        mTotalCostTextView.setText(currency.format(shipItem.getTotalCost()));

    }


}
