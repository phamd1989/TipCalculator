package com.example.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
	private EditText amount;
	private TextView tip;
	private Button btt10;
	private Button btt15;
	private Button btt20;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		amount = (EditText) this.findViewById(R.id.amount);
		tip   = (TextView) this.findViewById(R.id.tipAmount);
		btt10 = (Button) this.findViewById(R.id.btt10);
		btt15 = (Button) this.findViewById(R.id.btt15);
		btt20 = (Button) this.findViewById(R.id.btt20);
		
		setupEditAmountListener(amount);
		
		setupButtonClickListener(btt10, 0.1);
		setupButtonClickListener(btt15, 0.15);
		setupButtonClickListener(btt20, 0.2);
	}
	
	private void setupEditAmountListener(EditText amount) {
		amount.addTextChangedListener(new TextWatcher() {

			@Override
			public void afterTextChanged(Editable money) {
                if (!money.toString().equals("")) {
                    Double tipAmount = 0.15 * Double.parseDouble(money.toString());
                    DecimalFormat formatter = new DecimalFormat("#0.00");
                    tip.setText("Tip is: " + formatter.format(tipAmount.doubleValue()));
                } else {
                    tip.setText("Tip is: 0.0");
                }
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
			}
			
		});
	}

	private void setupButtonClickListener(Button btt, final double pct) {
		btt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
//				EditText amount = (EditText) view.findViewById(R.id.amount);
				Double tipAmount = pct * Double.parseDouble(amount.getText().toString());
				tip.setText("Tip is: " + tipAmount.toString());
			}
			
		});
	}
}
