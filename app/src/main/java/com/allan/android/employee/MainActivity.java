package com.allan.android.employee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static String ca_total,ca_b2b,ca_mca,fl_total,fl_b2b,fl_mca,tx_total,tx_b2b,tx_mca,total_email;
    static String user1_name,user1_count;
    static int total_background,background_executed;
    int i;
    //private TextView ca_total_textview,ca_mca_textview,ca_b2b_textview,fl_total_textview,fl_mca_textview,fl_b2b_textview,tx_total_textview,tx_mca_textview,tx_b2b_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ca_total_textview=(TextView) findViewById(R.id.ca_total_textview);
//        ca_mca_textview=(TextView) findViewById(R.id.ca_mca_textview);
//        ca_b2b_textview=(TextView) findViewById(R.id.ca_b2b_textview);
//        fl_total_textview=(TextView) findViewById(R.id.fl_total_textview);
//        fl_mca_textview=(TextView) findViewById(R.id.fl_mca_textview);
//        fl_b2b_textview=(TextView) findViewById(R.id.fl_b2b_textview);
//        tx_total_textview=(TextView) findViewById(R.id.tx_total_textview);
//        tx_mca_textview=(TextView) findViewById(R.id.tx_mca_textview);
//        tx_b2b_textview=(TextView) findViewById(R.id.tx_b2b_textview);
    }

    public void OnLogin(View view) {
        total_background=5;
        background_executed=1;
        String type = "login";
        String query="select count(*) from Auditdot_Internship.ca_feb9_2016 where doc_contact=7 and doneDate='2016-11-14' and leadtype='MCA'";;
        String query1="select count(*) from Auditdot_Internship.ca_feb9_2016 where doc_contact=7 and doneDate='2016-11-14' and leadtype='B2B'";
        String query2="select count(*) from Auditdot_Internship.ca_feb9_2016 where doc_contact=7 and doneDate='2016-11-14' ";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,query,query1,query2, "ca");
        query="select count(*) from Auditdot_Internship.fl_feb14_2016 where doc_contact=7 and doneDate='2016-11-14' and leadtype='MCA'";;
        query1="select count(*) from Auditdot_Internship.fl_feb14_2016 where doc_contact=7 and doneDate='2016-11-14' and leadtype='B2B'";
        query2="select count(*) from Auditdot_Internship.fl_feb14_2016 where doc_contact=7 and doneDate='2016-11-14' ";
        BackgroundWorker backgroundWorker1 = new BackgroundWorker(this);
        backgroundWorker1.execute(type,query,query1,query2, "fl");
        query="select count(*) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and doneDate='2016-11-14' and leadtype='MCA'";;
        query1="select count(*) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and doneDate='2016-11-14' and leadtype='B2B'";
        query2="select count(*) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and doneDate='2016-11-14' ";
        BackgroundWorker backgroundWorker2 = new BackgroundWorker(this);
        backgroundWorker2.execute(type,query,query1,query2, "tx");
        query="select count(debtor_email) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and doneDate='2016-11-14' and debtor_email and debtor_email IS NOT NULL or debtor_email <>''";
        query1="select count(debtor_email) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and doneDate='2016-11-14' and debtor_email and debtor_email IS NOT NULL or debtor_email <>''";
        query2="select count(debtor_email) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and doneDate='2016-11-14' and debtor_email and debtor_email IS NOT NULL or debtor_email <>''";
        BackgroundWorker backgroundWorker3 = new BackgroundWorker(this);
        backgroundWorker3.execute(type,query,query1,query2, "email");

        query="select count(donebyUser) from Auditdot_Internship.ca_feb9_2016 where doc_contact=7 and donebyUser='jibin'";
        query1="select donebyUser from Auditdot_Internship.ca_feb9_2016 where doc_contact=7 and donebyUser='jibin'";
        query2="select count(donebyUser) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and donebyUser='jibin'";
        BackgroundWorker backgroundWorker4 = new BackgroundWorker(this);
        backgroundWorker4.execute(type,query,query1,query2,"user1");
    }

    public void setView(View view){
        if(background_executed==(total_background+1) ){
            TextView ca_total_textview = (TextView) findViewById(R.id.ca_total_textview);
            TextView ca_mca_textview = (TextView) findViewById(R.id.ca_mca_textview);
            TextView ca_b2b_textview = (TextView) findViewById(R.id.ca_b2b_textview);
            ca_total_textview.setText(ca_total);
            ca_b2b_textview.setText(ca_b2b);
            ca_mca_textview.setText(ca_mca);
            TextView fl_total_textview = (TextView) findViewById(R.id.fl_total_textview);
            TextView fl_mca_textview = (TextView) findViewById(R.id.fl_mca_textview);
            TextView fl_b2b_textview = (TextView) findViewById(R.id.fl_b2b_textview);
            fl_total_textview.setText(fl_total);
            fl_b2b_textview.setText(fl_b2b);
            fl_mca_textview.setText(fl_mca);
            TextView tx_total_textview = (TextView) findViewById(R.id.tx_total_textview);
            TextView tx_mca_textview = (TextView) findViewById(R.id.tx_mca_textview);
            TextView tx_b2b_textview = (TextView) findViewById(R.id.tx_b2b_textview);
            tx_total_textview.setText(tx_total);
            tx_b2b_textview.setText(tx_b2b);
            tx_mca_textview.setText(tx_mca);
            i = Integer.parseInt(ca_total.toString()) + Integer.parseInt(tx_total.toString()) + Integer.parseInt(fl_total.toString());
            TextView total_textview = (TextView) findViewById(R.id.total_textview);
            total_textview.setText(":" + i);
            TextView email_textview = (TextView) findViewById(R.id.email_textview);
            email_textview.setText(":" + total_email);

            TextView user1_textview=(TextView) findViewById(R.id.user1_textview);
            user1_textview.setText(user1_name+":"+user1_count);
        }
    }

}
