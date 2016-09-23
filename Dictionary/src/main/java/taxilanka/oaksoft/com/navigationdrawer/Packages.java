package taxilanka.oaksoft.com.navigationdrawer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Packages extends AppCompatActivity {
    EditText stdate,endate,location,destination,etime;
    Button create;
    String sdate,edate,slocation,sdestination,stime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        stdate=(EditText)findViewById(R.id.startdate);
        endate=(EditText)findViewById(R.id.enddate);
        location=(EditText)findViewById(R.id.location);
        destination=(EditText)findViewById(R.id.destination);
        etime=(EditText)findViewById(R.id.time);
        create=(Button)findViewById(R.id.create);

    }

    public void vehicle(View view){


        Intent i = new Intent(Packages.this,Vehicle.class);
        startActivity(i);


    }


    public void middle(View view){


        Intent i = new Intent(Packages.this,Third.class);
        startActivity(i);


    }

    public void create(View view){

        String method="plan";

        sdate=stdate.getText().toString();
        edate=endate.getText().toString();
        slocation=location.getText().toString();
        sdestination=destination.getText().toString();
        stime=etime.getText().toString();

        String c_email="cthilanchana@gmail.com";
        String tmethod="1";

        try{
            String data= URLEncoder.encode("sdate", "UTF-8")+"="+URLEncoder.encode(sdate,"UTF-8")+"&"+
                    URLEncoder.encode("edate", "UTF-8")+"="+URLEncoder.encode(edate,"UTF-8")+"&"+
                    URLEncoder.encode("slocation", "UTF-8")+"="+URLEncoder.encode(slocation,"UTF-8")+"&"+
                    URLEncoder.encode("sdestination", "UTF-8")+"="+URLEncoder.encode(sdestination,"UTF-8")+"&"+
                    URLEncoder.encode("cemail", "UTF-8")+"="+URLEncoder.encode(c_email,"UTF-8")+"&"+
                    URLEncoder.encode("method","UTF-8")+"="+URLEncoder.encode(tmethod,"UTF-8");

            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method,data);



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }




    }




}
