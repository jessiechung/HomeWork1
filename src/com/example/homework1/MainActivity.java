package com.example.homework1;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		
		private EditText display;
		private Button btnAdd, btnSub, btnMul, btnDiv, btnEqu, btnClear;
		private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
		private int result = 0, num = 0;
		private String op = "", tmp = "";

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,	false);
			
			display = (EditText) rootView.findViewById(R.id.display);
						
			btnAdd = (Button) rootView.findViewById(R.id.add);
			btnSub = (Button) rootView.findViewById(R.id.subtract);
			btnMul = (Button) rootView.findViewById(R.id.multiply);
			btnDiv = (Button) rootView.findViewById(R.id.divide);
			btnEqu = (Button) rootView.findViewById(R.id.equal);
			btnClear = (Button) rootView.findViewById(R.id.clear);
			
			btnOne = (Button) rootView.findViewById(R.id.one);
			btnTwo = (Button) rootView.findViewById(R.id.two);
			btnThree = (Button) rootView.findViewById(R.id.three);
			btnFour = (Button) rootView.findViewById(R.id.four);
			btnFive = (Button) rootView.findViewById(R.id.five);
			btnSix = (Button) rootView.findViewById(R.id.six);
			btnSeven = (Button) rootView.findViewById(R.id.seven);
			btnEight = (Button) rootView.findViewById(R.id.eight);
			btnNine = (Button) rootView.findViewById(R.id.nine);
			btnZero = (Button) rootView.findViewById(R.id.zero);
						
			btnAdd.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					calculate();
					op = "+";
				}
			});
			
			btnSub.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					calculate();
					op = "-";
				}
			});
			
			btnMul.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					calculate();
					op = "*";
				}
			});
			
			btnDiv.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					calculate();					
					op = "/";
				}
			});
			
			btnEqu.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					calculate();
					op = "=";
				}
			});
			
			btnClear.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					op = "";
					tmp = "";
					result = 0;
			    	display.setText(tmp);
				}
			});
			
			btnOne.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					tmp = tmp + btnOne.getText().toString();
			    	display.setText(tmp);
				}
			});
			
			btnTwo.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					tmp = tmp + btnTwo.getText().toString();
			    	display.setText(tmp);
				}
			});
			
			btnThree.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					tmp = tmp + btnThree.getText().toString();
			    	display.setText(tmp);
				}
			});
			
			btnFour.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					tmp = tmp + btnFour.getText().toString();
			    	display.setText(tmp);
				}
			});
			
			btnFive.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					tmp = tmp + btnFive.getText().toString();
			    	display.setText(tmp);
				}
			});
			
			btnSix.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					tmp = tmp + btnSix.getText().toString();
			    	display.setText(tmp);
				}
			});
			
			btnSeven.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					tmp = tmp + btnSeven.getText().toString();
			    	display.setText(tmp);
				}
			});
			
			btnEight.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					tmp = tmp + btnEight.getText().toString();
			    	display.setText(tmp);
				}
			});
			
			btnNine.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					tmp = tmp + btnNine.getText().toString();
			    	display.setText(tmp);
				}
			});
			
			btnZero.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if (TextUtils.isEmpty(tmp) || Integer.parseInt(tmp) == 0) 
						tmp = "";
					tmp = tmp + btnZero.getText().toString();
			    	display.setText(tmp);
				}
			});
			
			return rootView;
		}
		
		private void calculate() {
			if (TextUtils.isEmpty(tmp)) num = 0;
			else num = Integer.parseInt(tmp);
			
			if (op.equals("+"))
				result = result + num;
			else if (op.equals("-"))
				result = result - num;
			else if (op.equals("*"))
				result = result * num;
			else if (op.equals("/"))
				result = result / num;
			else
				result = num;
			
			display.setText(String.valueOf(result));
			tmp = "";
		}
	}

}
