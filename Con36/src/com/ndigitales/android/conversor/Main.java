package com.ndigitales.android.conversor;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Main extends Activity {
	
	private EditText text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text = (EditText)findViewById(R.id.et1);
    }

    public void calcular(View view) {
    	switch (view.getId()) {
		case R.id.btn:
			RadioButton celsius = (RadioButton)findViewById(R.id.radio0);
			RadioButton farenheit = (RadioButton)findViewById(R.id.radio1);
			if(text.getText().length()== 0 ) {
	Toast.makeText(this, "Ingrese un valor a convertir", Toast.LENGTH_LONG).show();
	return; }
			
	float valor = Float.parseFloat(text.getText().toString());
			
	if(celsius.isChecked()) {
		text.setText(String.valueOf(convertirAcelsiuis(valor)));
		celsius.setChecked(false);
		farenheit.setChecked(true);
	} else {
		text.setText(String.valueOf(convertirAfarenheit(valor)));
		celsius.setChecked(true);
		farenheit.setChecked(false);
	}
			break;
		}
    } //endCalcular
    
    
    private float convertirAcelsiuis(float faren) {
    	return ((faren - 32 )* 5 / 9);
    }
    
    private float convertirAfarenheit(float celsi) {
    	return ((celsi * 9) / 5 ) + 32;
    }
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

} // endClass
