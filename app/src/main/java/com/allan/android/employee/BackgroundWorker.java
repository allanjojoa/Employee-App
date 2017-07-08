package com.allan.android.employee;

/**
 * Created by allan on 03-07-2017.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by ProgrammingKnowledge on 1/5/2016.
 */
public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    BackgroundWorker (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://nitrobaba.com/internship/count.php";
        if(type.equals("login")) {
            try {
//                String user_name = params[1];
//                String password = params[2];
                String query=params[1];
                String query1=params[2];
                String query2=params[3];
                String lead_type=params[4];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("query","UTF-8")+"="+URLEncoder.encode(query,"UTF-8")+"&" +URLEncoder.encode("query1","UTF-8")+"="+URLEncoder.encode(query1,"UTF-8")+"&" +URLEncoder.encode("query2","UTF-8")+"="+URLEncoder.encode(query2,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                int num=1;
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                    if(lead_type.equals("ca")){
                        if (num==1){
                            MainActivity.ca_mca=line;
                            num++;
                        }
                        else if(num==2){
                            MainActivity.ca_b2b=line;
                            num++;
                        }
                        else if (num==3){
                            MainActivity.ca_total=line;
                        }
                    }
                    else if(lead_type.equals("fl")){
                        if (num==1){
                            MainActivity.fl_mca=line;
                            num++;
                        }
                        else if(num==2){
                            MainActivity.fl_b2b=line;
                            num++;
                        }
                        else if (num==3){
                            MainActivity.fl_total=line;
                        }

                    }
                    else if(lead_type.equals("tx")){
                        if (num==1){
                            MainActivity.tx_mca=line;
                            num++;
                        }
                        else if(num==2){
                            MainActivity.tx_b2b=line;
                            num++;
                        }
                        else if (num==3){
                            MainActivity.tx_total=line;
                        }
                    }
                    else if(lead_type.equals("email")){
                        if (num==1){
                            MainActivity.total_email=line;
                            num++;
                        }
                    }
                    else if(lead_type.equals("user1")){
                        if (num==1) {
                            MainActivity.user1_count = line;
                            num++;
                        }
                        else if (num==2) {
                            MainActivity.user1_name = line;
                            num++;
                        }

                    }

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

//    public static String getresult(){
//        return total_result;
//    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");
    }

    @Override
    protected void onPostExecute(String result) {
        MainActivity.background_executed++;
        if(MainActivity.background_executed==MainActivity.total_background){
            alertDialog.setMessage("Done");
            alertDialog.show();
        }
        //MainActivity.total_result=result;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}