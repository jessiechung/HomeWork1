package com.example.homework1;

import java.math.BigDecimal;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	
	private static EditText textDisplay;
	private static Button btnAdd, btnSub, btnMul, btnDiv, btnEqu, btnPoint;
	private static Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero;
	private static BigDecimal result, num;
	private String op = "", tmp = "";

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
	
	public void onClick(View view) {
		
		switch (view.getId()) {
		
		case R.id.add:
			calculate();
			op = btnAdd.getText().toString();
			break;
		
		case R.id.subtract:
			calculate();
			op = btnSub.getText().toString();
			break;
			
		case R.id.multiply:
			calculate();	
			op = btnMul.getText().toString();
			break;
			
		case R.id.divide:
			calculate();
			op = btnDiv.getText().toString();
			break;
			
		case R.id.equal:
			calculate();
			op = btnEqu.getText().toString();
			break;
			
		case R.id.clear:
			clear();
			textDisplay.setText("0");
			break;
			
		case R.id.point:
			if (TextUtils.isEmpty(tmp)) tmp = "0";
			if (tmp.indexOf(".") == -1) tmp = tmp + btnPoint.getText().toString();
			textDisplay.setText(tmp);
			break;
			
		case R.id.zero:
			if (btnEqu.getText().toString().equals(op)) clear();
			if (TextUtils.isEmpty(tmp) || tmp.equals("0")) {
				tmp = "";
				textDisplay.setText("0");
			} else {
				tmp = tmp + btnZero.getText().toString();
				textDisplay.setText(tmp);
			}
			break;
			
		case R.id.one:
			if (btnEqu.getText().toString().equals(op)) clear();
			tmp = tmp + btnOne.getText().toString();
			textDisplay.setText(tmp);
			break;
		
		case R.id.two:
			if (btnEqu.getText().toString().equals(op)) clear();
			tmp = tmp + btnTwo.getText().toString();
			textDisplay.setText(tmp);
			break;
			
		case R.id.three:
			if (btnEqu.getText().toString().equals(op)) clear();
			tmp = tmp + btnThree.getText().toString();
			textDisplay.setText(tmp);
			break;
			
		case R.id.four:
			if (btnEqu.getText().toString().equals(op)) clear();
			tmp = tmp + btnFour.getText().toString();
			textDisplay.setText(tmp);
			break;
			
		case R.id.five:
			if (btnEqu.getText().toString().equals(op)) clear();
			tmp = tmp + btnFive.getText().toString();
			textDisplay.setText(tmp);
			break;
			
		case R.id.six:
			if (btnEqu.getText().toString().equals(op)) clear();
			tmp = tmp + btnSix.getText().toString();
			textDisplay.setText(tmp);
			break;
			
		case R.id.seven:
			if (btnEqu.getText().toString().equals(op)) clear();
			tmp = tmp + btnSeven.getText().toString();
			textDisplay.setText(tmp);
			break;
			
		case R.id.eight:
			if (btnEqu.getText().toString().equals(op)) clear();
			tmp = tmp + btnEight.getText().toString();
			textDisplay.setText(tmp);
			break;
			
		case R.id.nine:
			if (btnEqu.getText().toString().equals(op)) clear();
			tmp = tmp + btnNine.getText().toString();
			textDisplay.setText(tmp);
			break;
		}
	}
	
	private void calculate() {
		if (TextUtils.isEmpty(tmp) && !TextUtils.isEmpty(op)) return;
		String res = "";
		
		try {
			if (TextUtils.isEmpty(tmp)) num = BigDecimal.valueOf(0);
			else num = new BigDecimal(tmp);
			
			if (btnAdd.getText().toString().equals(op)) {
				result = result.add(num) ;
				tmp = "";
			} else if (btnSub.getText().toString().equals(op)) {
				result = result.subtract(num);
				tmp = "";
			} else if (btnMul.getText().toString().equals(op)) {
				result = result.multiply(num);
				tmp = "";
			} else if (btnDiv.getText().toString().equals(op)) {
				result = result.divide(num);
				tmp = "";
			} else if (btnEqu.getText().toString().equals(op)) {
				result = num;
				tmp = display(String.valueOf(result));
			} else {
				result = num;
				tmp = "";
			}
			
			res = display(String.valueOf(result));
		} catch (Exception e) {
			Log.e("error", e.getMessage());
			clear();
			res = "ERROR";
		}
		
		textDisplay.setText(res);
	}
	
    private String display(String str) {
    	String res = str;
        
		String[] resList = res.split("\\.");
		if (resList.length > 1 && Integer.parseInt(resList[1]) == 0) res = resList[0];

		return res;
    }
    
    private void clear() {
    	op = "";
		tmp = "";
		num = BigDecimal.valueOf(0);
		result = BigDecimal.valueOf(0);
    }

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,	false);
			
			result = new BigDecimal("0");
			num = new BigDecimal("0");
			
			textDisplay = (EditText) rootView.findViewById(R.id.display);
						
			btnAdd = (Button) rootView.findViewById(R.id.add);
			btnSub = (Button) rootView.findViewById(R.id.subtract);
			btnMul = (Button) rootView.findViewById(R.id.multiply);
			btnDiv = (Button) rootView.findViewById(R.id.divide);
			btnEqu = (Button) rootView.findViewById(R.id.equal);
			btnPoint = (Button) rootView.findViewById(R.id.point);
			
			btnZero = (Button) rootView.findViewById(R.id.zero);
			btnOne = (Button) rootView.findViewById(R.id.one);
			btnTwo = (Button) rootView.findViewById(R.id.two);
			btnThree = (Button) rootView.findViewById(R.id.three);
			btnFour = (Button) rootView.findViewById(R.id.four);
			btnFive = (Button) rootView.findViewById(R.id.five);
			btnSix = (Button) rootView.findViewById(R.id.six);
			btnSeven = (Button) rootView.findViewById(R.id.seven);
			btnEight = (Button) rootView.findViewById(R.id.eight);
			btnNine = (Button) rootView.findViewById(R.id.nine);
			
			return rootView;
		}	
	}

}
