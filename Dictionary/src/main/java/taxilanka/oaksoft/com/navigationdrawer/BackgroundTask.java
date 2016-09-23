package taxilanka.oaksoft.com.navigationdrawer;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import java.util.ArrayList;

public class BackgroundTask extends AsyncTask<String,Void,String> {

    AlertDialog alertDialog;
    ProgressDialog pDialog;
    Context ctx;
    public static String method;


    BackgroundTask(Context ctx){

        this.ctx=ctx;

    }



    @Override
    protected void onPreExecute() {

        pDialog=ProgressDialog.show(ctx,"creating plan","please wait");
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("information...");

    }


    @Override
    protected String doInBackground(String... params){
       method=params[0];
        String login_url="";


        if(method.equals("plan")){
            login_url="http://10.0.3.2/taxidb/plan.php";

        }


            String data = params[1];
           // String login_url = "http://taxilanka.co.nf/plan.php";
           // String login_url = "http://10.0.3.2/taxidb/plan.php";


            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
           /* String data= URLEncoder.encode("sdate", "UTF-8")+"="+URLEncoder.encode(sdate,"UTF-8")+"&"+
                         URLEncoder.encode("edate", "UTF-8")+"="+URLEncoder.encode(edate,"UTF-8")+"&"+
                    URLEncoder.encode("slocation", "UTF-8")+"="+URLEncoder.encode(slocation,"UTF-8")+"&"+
                    URLEncoder.encode("sdestination", "UTF-8")+"="+URLEncoder.encode(sdestination,"UTF-8")+"&"+
                    URLEncoder.encode("cemail", "UTF-8")+"="+URLEncoder.encode(c_email,"UTF-8")+"&"+
                    URLEncoder.encode("method","UTF-8")+"="+URLEncoder.encode(method,"UTF-8");*/
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();


                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {

                    response += line;

                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                if(method.equals("plan"))
                return response;




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        return null;
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


    @Override
    protected void onPostExecute(final String result) {




        if(method.equals("plan")) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    pDialog.dismiss();


                    if (result.contains("Success")) {
                        alertDialog.setMessage("Plan has successfully created");
                        alertDialog.show();

                    }
                }
            }, 2000);


        }








    }



}
