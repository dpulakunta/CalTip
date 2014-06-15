package codepath.com.example.caltip.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    public EditText actualAmt;
    public TextView tip;
    public TextView total;
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
    public void calculateTip(View buttonSelected){
        int buttonId = buttonSelected.getId();
        String tipAmountStr = actualAmt.getText().toString();
        double tipAmount = Double.parseDouble(tipAmountStr);
        double tipValue=0;
        tip = (TextView) findViewById(R.id.tipTxt);
        total = (TextView) findViewById(R.id.TotalTxt);
        switch(buttonId){
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
        tip.setText(tip.getText().toString() + Double.toString(tipValue));
        total.setText(total.getText().toString() + Double.toString(tipAmount));

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
}
