package com.example.ageconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private EditText topField;
	private TextView bottomField;
	private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        topField = (EditText)findViewById(R.id.etTopField);
        bottomField = (TextView)findViewById(R.id.tvBottomField);
        convertButton = (Button)findViewById(R.id.bConvert);
        
        convertButton.setOnClickListener(this);
    }
    
    public String convertDogsToHumans(EditText DogField) {
    	int dogYears = 0;
    	
    	// Only assign dogYears the value of the edit text if it is not 0,
    	// this prevents the app from crashing if no value is entered when 
    	// out convert button was pressed. dogYears has already been assigned
    	// 0 on the off chance the user entered 0.
    	if (DogField.length() != 0) {
    		dogYears = Integer.parseInt(DogField.getText().toString());
    	}
    	
    	int humanYears = 0;
    	
    	// The first few if statements are not in a set pattern so
    	// it will be manually be added to humanYears
    	if (dogYears > 0) {
    		humanYears += 15;
    	} 
    	
    	if (dogYears > 1) {
    		humanYears += 9;
    	} 
    	
    	if (dogYears > 2) {
    		humanYears += 4;
    	} 
    	
    	if (dogYears > 3) {
    		humanYears += 4;
    	} 
    	
    	if (dogYears > 4) {
    		humanYears += 4;
    	} 
    	
    	if (dogYears > 5) {
    		humanYears += 6;
    	} 
    	
    	if (dogYears > 6) {
    		// Subtract the previous 6 dogYears from the total so you
    		// can only take into account the dogYears after 6
    		dogYears -= 6;
    		
    		// The pattern starts with adding 5-4-5-4 and so on per dog year
    		boolean addFive = true;
    		
    		while (dogYears > 0) {
    			if (addFive) {
    				dogYears -= 1;
    				humanYears += 5;
    				addFive = false;
    			} else if (!addFive) {
    				dogYears -= 1;
    				humanYears += 4;
    				addFive = true;
    			}
    		}
    	}
    	
    	return String.valueOf(humanYears);
    	
    }

    public String convertHumansToDogs(EditText HumanField) {
		return null;
    	
    }
    
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bConvert:
	    	bottomField.setText(convertDogsToHumans(topField));
			break;
		}
		
	}
        
}
