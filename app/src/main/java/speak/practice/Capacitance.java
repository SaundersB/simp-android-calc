package speak.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon Saunders on 6/27/15.
 */



public class Capacitance extends Activity {

    private EditText VoltageText;
    private EditText ElectricChargeText;
    private EditText CapacitanceText;
    private List<EditText> EditTextFields;

    // Layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capacitance_main);
        setButtons();
        initalizeTextFields();
    }

    private void setButtons() {
        Button enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void initalizeTextFields() {
        EditTextFields = new ArrayList<>();
        VoltageText = (EditText) findViewById(R.id.voltagefield);
        EditTextFields.add(VoltageText);
        ElectricChargeText = (EditText) findViewById(R.id.electricchargefield);
        EditTextFields.add(ElectricChargeText);
        CapacitanceText = (EditText) findViewById(R.id.capacitancefield);
        EditTextFields.add(CapacitanceText);

    }


    public void onClick(View view) {
        String num1 = VoltageText.getText().toString();
        String num2 = ElectricChargeText.getText().toString();
        String num3 = CapacitanceText.getText().toString();




        if (num1 != null && num1.trim().length() > 0) {
            System.out.println("There is nothing here dude");
        }





        /*
        switch(view.getId()){
            case R.id.enter:
                float capaci1 = Integer.parseInt(num2) / Integer.parseInt(num1);
                float volta1 = Integer.parseInt(num2) / Integer.parseInt(num3);
                float elecchar1 = Integer.parseInt(num3) * Integer.parseInt(num1);
                tvresult.setText(String.valueOf(capaci1));
                break;
            case R.id.clear:
                break;
        }
        */
    }

}
