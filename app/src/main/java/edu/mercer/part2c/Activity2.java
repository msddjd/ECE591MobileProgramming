package edu.mercer.part2c;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Activity2 extends ActionBarActivity {

    private EditText usrName, idNumb ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        usrName   =   (EditText)findViewById(R.id.usrNameInp);
        idNumb   =   (EditText)findViewById(R.id.idNumbInp);

        Bundle bndlFromParent = getIntent().getExtras();

        if(bndlFromParent != null){
            String edtTxtHint = bndlFromParent.getString("userNameKey");
            String edtNumbHint = bndlFromParent.getString("idNumbKey");

            usrName.setHint(edtTxtHint);
            idNumb.setHint(edtNumbHint);
        }

    }

    public void     onBtnOkClick    (View v) {

        Intent  actv2Intent =  new Intent();

        // Get the  username  and save it (as a  URI object) in act2Intent

        actv2Intent.setData(Uri.parse(usrName.getText().toString()+"/"+idNumb.getText().toString() )) ;

        // Send  actv2Intent   to  MainActivity

        setResult(RESULT_OK, actv2Intent) ;

        // Close Activity2
        finish()            ;

    }


}
