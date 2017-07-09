package com.allan.android.employee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {
    static String ca_total,ca_b2b,ca_mca,fl_total,fl_b2b,fl_mca,tx_total,tx_b2b,tx_mca,total_email;
    static String user1_name,user1_ca,user1_fl,user1_tx;
    static String user2_name,user2_ca,user2_fl,user2_tx;
    static String user3_name,user3_ca,user3_fl,user3_tx;
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
        total_background=7;
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

        String user="jibin",user_num="user1";
        query="select distinct donebyUser from Auditdot_Internship.ca_feb9_2016 where doc_contact=7 and donebyUser='"+user+"'";
        query1="(select count(donebyUser) from Auditdot_Internship.ca_feb9_2016 where doc_contact=7 and donebyUser='"+user+"') union (select count(donebyUser) from Auditdot_Internship.fl_feb14_2016 where doc_contact=7 and donebyUser='"+user+"') union (select count(donebyUser) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and donebyUser='"+user+"')";
        query2="select count(donebyUser) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and donebyUser='jibin'";
        BackgroundWorker backgroundWorker4 = new BackgroundWorker(this);
        backgroundWorker4.execute(type,query,query1,query2,user_num);

        user="joe";
        user_num="user2";
        query="select distinct donebyUser from Auditdot_Internship.fl_feb14_2016 where doc_contact=7 and donebyUser='"+user+"'";
        query1="(select count(donebyUser) from Auditdot_Internship.ca_feb9_2016 where doc_contact=7 and donebyUser='"+user+"') union (select count(donebyUser) from Auditdot_Internship.fl_feb14_2016 where doc_contact=7 and donebyUser='"+user+"') union (select count(donebyUser) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and donebyUser='"+user+"')";
        query2="select count(donebyUser) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and donebyUser='jibin'";
        BackgroundWorker backgroundWorker5 = new BackgroundWorker(this);
        backgroundWorker5.execute(type,query,query1,query2,user_num);

        user="soji";
        user_num="user3";
        query="select distinct donebyUser from Auditdot_Internship.fl_feb14_2016 where doc_contact=7 and donebyUser='"+user+"'";
        query1="(select count(donebyUser) from Auditdot_Internship.ca_feb9_2016 where doc_contact=7 and donebyUser='"+user+"') union (select count(donebyUser) from Auditdot_Internship.fl_feb14_2016 where doc_contact=7 and donebyUser='"+user+"') union (select count(donebyUser) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and donebyUser='"+user+"')";
        query2="select count(donebyUser) from Auditdot_Internship.tx_jan26_2016 where doc_contact=7 and donebyUser='jibin'";
        BackgroundWorker backgroundWorker6 = new BackgroundWorker(this);
        backgroundWorker6.execute(type,query,query1,query2,user_num);
    }

    public void setView(View view){
        if(background_executed >=(total_background+1) ){
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
            user1_textview.setText(user1_name);
            TextView user2_textview=(TextView) findViewById(R.id.user2_textview);
            user2_textview.setText(user2_name);
            TextView user3_textview=(TextView) findViewById(R.id.user3_textview);
            user3_textview.setText(user3_name);
            TextView user1_ca_textview=(TextView) findViewById(R.id.ca_user1_textview);
            TextView user2_ca_textview=(TextView) findViewById(R.id.ca_user2_textview);
            TextView user3_ca_textview=(TextView) findViewById(R.id.ca_user3_textview);
            user1_ca_textview.setText(user1_ca);
            user2_ca_textview.setText(user2_ca);
            user3_ca_textview.setText(user3_ca);
            TextView user1_fl_textview=(TextView) findViewById(R.id.fl_user1_textview);
            TextView user2_fl_textview=(TextView) findViewById(R.id.fl_user2_textview);
            TextView user3_fl_textview=(TextView) findViewById(R.id.fl_user3_textview);
            user1_fl_textview.setText(user1_fl);
            user2_fl_textview.setText(user2_fl);
            user3_fl_textview.setText(user3_fl);
            TextView user1_tx_textview=(TextView) findViewById(R.id.tx_user1_textview);
            TextView user2_tx_textview=(TextView) findViewById(R.id.tx_user2_textview);
            TextView user3_tx_textview=(TextView) findViewById(R.id.tx_user3_textview);
            user1_tx_textview.setText(user1_tx);
            user2_tx_textview.setText(user2_tx);
            user3_tx_textview.setText(user3_tx);



//            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.user_linearlayout);


//            // Add textview 1
//            TextView textView1 = new TextView(this);
//            textView1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
//                    LayoutParams.WRAP_CONTENT));
//            textView1.setTextSize(20);
//            textView1.setAllCaps(true);
//            textView1.setText(user1_name+" :  FL:"+user1_fl+" TX:"+user1_tx+" CA:"+user1_ca);
//            //textView1.setBackgroundColor(0xff66ff66); // hex color 0xAARRGGBB
//            //textView1.setPadding(20, 20, 20, 20);// in pixels (left, top, right, bottom)
//            linearLayout.addView(textView1);
//
//            // Add textview 1
//            TextView textView2 = new TextView(this);
//            textView2.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
//                    LayoutParams.WRAP_CONTENT));
//            textView2.setTextSize(20);
//            textView2.setAllCaps(true);
//            textView2.setText(user2_name+" :  FL:"+user2_fl+" TX:"+user2_tx+" CA:"+user2_ca);
//            //textView1.setBackgroundColor(0xff66ff66); // hex color 0xAARRGGBB
//            //textView1.setPadding(20, 20, 20, 20);// in pixels (left, top, right, bottom)
//            linearLayout.addView(textView2);
//
//            // Add textview 1
//            TextView textView3 = new TextView(this);
//            textView3.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
//                    LayoutParams.WRAP_CONTENT));
//            textView3.setTextSize(20);
//            textView3.setAllCaps(true);
//            textView3.setText(user3_name+" :  FL:"+user3_fl+" TX:"+user3_tx+" CA:"+user3_ca);
//            //textView1.setBackgroundColor(0xff66ff66); // hex color 0xAARRGGBB
//            //textView1.setPadding(20, 20, 20, 20);// in pixels (left, top, right, bottom)
//            linearLayout.addView(textView3);

        }
    }

}
