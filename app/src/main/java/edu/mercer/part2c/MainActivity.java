package edu.mercer.part2c;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Button btn1;

    private int  myActivity2_id =  1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btnClick_id);

    }   // end of onCreate(...)

    public void onBtn1Click(View v) {

        // Start Activity2 after the user clicks the button

        if (v == btn1  ) {

            Intent a2Intent = new Intent(this, Activity2.class);

            Bundle a2promptsBndl = new Bundle();

            String usr_name_prmpt = getResources().getString(R.string.usrNamePrmpt);
            String id_numb_prmpt = getResources().getString(R.string.idNumbTxt);

            a2promptsBndl.putString("userNameKey",usr_name_prmpt);
            a2promptsBndl.putString("idNumbKey",id_numb_prmpt);

            a2Intent.putExtras(a2promptsBndl);

            startActivityForResult(a2Intent, myActivity2_id) ;

        }
    }      // end of onBtn1Click(...)

    // Method for receiving and displaying data from another activity, e.g. Activity2

      public void onActivityResult(int rcvdRsltId, int rcvdRsltCode, Intent rcvdData) {

          if ( (rcvdRsltId == myActivity2_id)&&(rcvdRsltCode==RESULT_OK) ) {
              Bundle bndlFromAct2 = rcvdData.getExtras();

              if (bndlFromAct2 != null) {
                  String entered_name = bndlFromAct2.getString("enteredName");
                  String entered_id = bndlFromAct2.getString("enteredID");

                  String toastMsg = getResources().getString(R.string.data_txt)
                          + " " + entered_name + "/" + entered_id;


                  // Note: data_txt = "Data Received = ", and
                  // this is defined in the strings.xml file

                  Toast.makeText(this, toastMsg,
                          Toast.LENGTH_SHORT).show();
              }
          }

      }  // end of onActivityResult(...)


    }  // end of MainActivity class
