package speak.AndroidCalculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import speak.AndroidCalculator.R;
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
    final Context context = this;


    // Layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capacitance_main);
        initalizeTextFields();
        TextView capacitance = (TextView) findViewById(R.id.capacitancetxt);
        capacitance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showcapdef();
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


    public void onClickEnter(View view) {
        String num1 = VoltageText.getText().toString();
        String num2 = ElectricChargeText.getText().toString();
        String num3 = CapacitanceText.getText().toString();

        double volt;
        double charge;
        double capa;

        if ((num1 != null && num1.trim().length() > 0) && (num2 != null && num2.trim().length() > 0)) {
                volt = Double.parseDouble(num1);
                charge = Double.parseDouble(num2);
                capa = (charge / volt);
                CapacitanceText.setText(String.valueOf(capa));
        }

        else if ((num2 != null && num2.trim().length() > 0) && (num3 != null && num3.trim().length() > 0)) {
                charge = Double.parseDouble(num2);
                capa = Double.parseDouble(num3);
                volt = (charge / capa);
                VoltageText.setText(String.valueOf(volt));
            }

        else if ((num3 != null && num3.trim().length() > 0) && (num1 != null && num1.trim().length() > 0)) {
                capa = Double.parseDouble(num3);
                volt = Double.parseDouble(num1);
                charge = (capa * volt);
                ElectricChargeText.setText(String.valueOf(charge));
            }

    }


    public void onClickClear(View view) {

        for (EditText editText : EditTextFields) {
            editText.setText("");
        }

    }


    public void showcapdef(){



        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set title
        alertDialogBuilder.setTitle("Your Title");

        // set dialog message
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        Capacitance.this.finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }



}
