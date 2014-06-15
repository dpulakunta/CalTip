package codepath.com.example.caltip.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    public EditText actualAmt;
    public TextView tip;
    public TextView total;
    int buttonId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actualAmt = (EditText) findViewById(R.id.tipText);

        tip = (TextView) findViewById(R.id.tipText);
        total = (TextView) findViewById(R.id.tipAmttxt);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void calculateTip(int buttonSelected){
        addTextChangeListener();
        String tipAmountStr = actualAmt.getText().toString();
        double tipAmount = Double.parseDouble(tipAmountStr);
        double tipValue=0;
        tip = (TextView) findViewById(R.id.tipTxt);
        total = (TextView) findViewById(R.id.TotalTxt);
        switch(buttonSelected){
            case R.id.tip1 :
                tipValue = tipAmount * 0.1;
                tipAmount += tipValue;
                break;
            case R.id.tip2 :
                tipValue = tipAmount * 0.15;
                tipAmount += tipValue;
                break;
            case R.id.tip3 :
                tipValue = tipAmount * 0.20;
                tipAmount += tipValue;
                break;
        }
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


    public void buttonPressed(View buttonSelected){
        buttonId = buttonSelected.getId();
        calculateTip(buttonId);
    }

}
