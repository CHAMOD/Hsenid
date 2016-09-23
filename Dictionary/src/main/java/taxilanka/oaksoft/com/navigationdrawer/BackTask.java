package taxilanka.oaksoft.com.navigationdrawer;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BackTask extends AsyncTask<Void, Void, Void> {


    private static android.content.Context ctx;
    ArrayList<String> list;
    String details="";
    public static String method;

    BackTask(Context ctx){

        this.ctx=ctx;

    }


    protected void onPreExecute(){



        super.onPreExecute();
        list=new ArrayList<>();

    }



    protected Void doInBackground(Void... param){
        InputStream is=null;
        String result="";
        method="getAcVehicles";
        String url="";

        if(method.equals("getvehicleDetails")){

            url="http://10.0.3.2/taxidb/acvehicle.php";
        }

        if(method.equals("getAcVehicles")){

            url="http://10.0.3.2/taxidb/acvehicle.php";
        }



        try{

            HttpClient httpClient=new DefaultHttpClient();
            HttpPost httpPost= new HttpPost(url);
            HttpResponse response=httpClient.execute(httpPost);
            HttpEntity entity=response.getEntity();
            is=entity.getContent();


        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //convert response to string

        try{

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is,"utf-8"));
            String line="";
            while((line=bufferedReader.readLine())!=null){
                result+=line;


            }
            is.close();

        }
        catch (IOException e){e.printStackTrace();}

        //parsing json to string

        if(method.equals("getAcVehicles")) {

            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    String newD = "";
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    list.add(jsonObject.getString("V_ID"));
                    newD = (jsonObject.getString("V_ID") + "." +
                            " moddle name :" + jsonObject.getString("moddle_name") + "\n" +
                            "    Brand name :" + jsonObject.getString("brand_name") + "\n\n");
                    details += newD;

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }



        return null;


    }
    protected void onPostExecute(Void result){

        Vehicle.listItems.addAll(list);
        Vehicle.adapter.notifyDataSetChanged();

           AlertDialog.Builder builder=new AlertDialog.Builder(ctx);
        builder.setCancelable(true);
        builder.setTitle("Details");
        builder.setMessage(details);
        builder.show();

    }

}
