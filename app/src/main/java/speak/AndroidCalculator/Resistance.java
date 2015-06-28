package speak.AndroidCalculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Brandon Saunders on 6/27/15.
 */



public class Resistance extends Activity {

    private EditText voltagetext;
    private EditText amperetext;
    private EditText resistancetext;
    private List<EditText> EditTextFields;
    final Context context = this;


    // Layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resistance_main);
        initalizeTextFields();

        TextView volts = (TextView) findViewById(R.id.voltagetext);
        volts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showvoltdef();
            }
        });
        TextView amps = (TextView) findViewById(R.id.amperetext);
        amps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showampdef();
            }
        });
        TextView resist = (TextView) findViewById(R.id.resistancetxt);
        resist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showresistdef();
            }
        });


    }

    private void initalizeTextFields() {
        EditTextFields = new ArrayList<>();
        amperetext = (EditText) findViewById(R.id.amperefield);
        EditTextFields.add(amperetext);
        resistancetext = (EditText) findViewById(R.id.resistancefield);
        EditTextFields.add(resistancetext);
        voltagetext = (EditText) findViewById(R.id.voltagefield);
        EditTextFields.add(voltagetext);
    }


    public void onClickEnter(View view) {
        String num1 = voltagetext.getText().toString();
        String num2 = resistancetext.getText().toString();
        String num3 = amperetext.getText().toString();

        double volt;
        double amp;
        double resis;

        if ((num1 != null && num1.trim().length() > 0) && (num2 != null && num2.trim().length() > 0)) {
                volt = Double.parseDouble(num1);
                resis = Double.parseDouble(num2);
                amp = (volt / resis);
                amperetext.setText(String.valueOf(amp));
        }

        else if ((num2 != null && num2.trim().length() > 0) && (num3 != null && num3.trim().length() > 0)) {
                resis = Double.parseDouble(num2);
                amp = Double.parseDouble(num3);
                volt = (resis * amp);
                resistancetext.setText(String.valueOf(volt));
            }

        else if ((num3 != null && num3.trim().length() > 0) && (num1 != null && num1.trim().length() > 0)) {
                amp = Double.parseDouble(num3);
                volt = Double.parseDouble(num1);
                resis = (volt / amp);
                amperetext.setText(String.valueOf(resis));
            }

    }


    public void onClickClear(View view) {

        for (EditText editText : EditTextFields) {
            editText.setText("");
        }

    }

    // Three functions to have popup definitions for each of the inputs.
    public void showresistdef(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Definition");
        alertDialogBuilder.setMessage("Resistance .");
        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
    }

    public void showvoltdef(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Definition");
        alertDialogBuilder.setMessage("Voltage is the electric energy charge difference of electric potential energy transported between two points.");
        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
    }


    public void showampdef(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Definition");
        alertDialogBuilder.setMessage("Amperes ");
        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
    }


    public void OnClickMoreInfo(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Resistance");
        alertDialogBuilder.setMessage("Capacitance is typified by a parallel plate arrangement and is defined in terms of charge storage.\n" +
                "Equation: C=Q/V.\n" +
                "Unit: Coulomb/Volt = Farad.\n");
        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();
    }


    public void onClickExit(View view){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set title
        alertDialogBuilder.setTitle("Are you done?");

        // set dialog message
        alertDialogBuilder
                .setMessage("Click yes to go back")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        Resistance.this.finish();
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
