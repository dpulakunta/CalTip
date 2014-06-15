package codepath.com.example.caltip.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {
    public EditText actualAmt;
    public TextView tip;
    public TextView total;
    int buttonId;
    //int tipPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actualAmt = (EditText) findViewById(R.id.tipText);

        tip = (TextView) findViewById(R.id.tipText);
        total = (TextView) findViewById(R.id.tipAmttxt);
        //customTipListener();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void calculateTip(int buttonSelected){
        if(buttonSelected!=R.id.tipPercentTxt)
            addTextChangeListener();
        String tipAmountStr = actualAmt.getText().toString();
        double tipAmount = Double.parseDouble(tipAmountStr);
        double tipValue=0;
        tip = (TextView) findViewById(R.id.tipTxt);
        total = (TextView) findViewById(R.id.TotalTxt);
        EditText percentText = null;
        if(buttonSelected==R.id.tipPercentTxt) {
            percentText = (EditText) findViewById(R.id.tipPercentTxt);
            double percent = Double.parseDouble(percentText.getText().toString());
            tipValue = tipAmount * percent / 100;
        }else {
            Button b = (Button) findViewById(buttonSelected);
            String percentStr = b.getText().toString();
            double percent = Double.parseDouble(percentStr.substring(0, percentStr.length() - 1));
            tipValue = tipAmount * percent / 100;
        }

        tipAmount += tipValue;
        tip.setText("Tip is: "+ Double.toString(tipValue));
        total.setText("Total is: " + Double.toString(tipAmount));

    }

    private void addTextChangeListener() {
        actualAmt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if(!actualAmt.getText().toString().equals(""))
                    calculateTip(buttonId);
                else{
                    tip.setText("Tip is: 0");
                    total.setText("Total is: 0");
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {
                //calculateTip(buttonId);

            }
        });
    }

/*
    private void customTipListener() {
        final EditText splitTxt = (EditText) findViewById(R.id.splitByTxt);
        splitTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if(!splitTxt.getText().toString().equals(""))

                else{

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
    }
*/
    public void customSelected(View v){
        ToggleButton t = (ToggleButton) findViewById(R.id.toggleButton);

        if(t.isChecked()) {
            Button tipBtn = (Button) findViewById(R.id.tip1);
            tipBtn.setClickable(false);
            tipBtn = (Button) findViewById(R.id.tip2);
            tipBtn.setClickable(false);
            tipBtn = (Button) findViewById(R.id.tip3);
            tipBtn.setClickable(false);

            calculateTip(R.id.tipPercentTxt);
        }else{
            Button tipBtn = (Button) findViewById(R.id.tip1);
            tipBtn.setClickable(true);
            tipBtn = (Button) findViewById(R.id.tip2);
            tipBtn.setClickable(true);
            tipBtn = (Button) findViewById(R.id.tip3);
            tipBtn.setClickable(true);
            TextView tipPerText = (TextView) findViewById(R.id.tipPercentTxt);
            tipPerText.setText("");
        }
    }

    public void buttonPressed(View buttonSelected){
        buttonId = buttonSelected.getId();
        calculateTip(buttonId);
    }

}
