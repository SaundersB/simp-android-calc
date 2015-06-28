package speak.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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
        initalizeTextFields();
    }




    private void initalizeTextFields() {
        EditTextFields = new ArrayList<>();
        VoltageText = (EditText) findViewById(R.id.voltagefield);
        EditTextFields.add(VoltageText);
        ElectricChargeText = (EditText) findViewById(R.id.electricchargefield);
        EditTextFields.add(ElectricChargeText);
        CapacitanceText = (EditText) findViewById(R.id.capacitancetext);
        EditTextFields.add(CapacitanceText);

    }


    public void onClickEnter(View view) {
        String num1 = VoltageText.getText().toString();
        String num2 = ElectricChargeText.getText().toString();
        String num3 = CapacitanceText.getText().toString();

        int Volt = Integer.parseInt(num1);
        int Charge = Integer.parseInt(num2);
        int Capa = Integer.parseInt(num3);

        if (num1 != null && num1.trim().length() > 0)
            if (num2 != null && num2.trim().length() > 0) {
                Capa = (Charge / Volt);
                CapacitanceText.setText(Capa);
            }

        if (num2 != null && num2.trim().length() > 0)
            if (num3 != null && num3.trim().length() > 0) {
                Volt = (Charge / Capa);
                VoltageText.setText(Volt);
            }

        if (num3 != null && num3.trim().length() > 0)
            if (num1 != null && num1.trim().length() > 0) {
                Charge = (Capa * Volt);
                ElectricChargeText.setText(Charge);
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


    public void onClickClear(View view) {

        CapacitanceText.setText(" ");
        ElectricChargeText.setText(" ");
        CapacitanceText.setText(" ");


    }

}
