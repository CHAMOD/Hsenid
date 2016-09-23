package taxilanka.oaksoft.com.navigationdrawer;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class FirstFragment extends Fragment{
    Button btvehicle,create;;
    View myView;


    EditText stdate,endate,location,destination,etime;

    String sdate,edate,slocation,sdestination,stime;
    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.first_layout,container,false);

        btvehicle=(Button)myView.findViewById(R.id.vehicle);


        stdate=(EditText)myView.findViewById(R.id.startdate);
        endate=(EditText)myView.findViewById(R.id.enddate);
        location=(EditText)myView.findViewById(R.id.location);
        destination=(EditText)myView.findViewById(R.id.destination);
        etime=(EditText)myView.findViewById(R.id.time);
        create=(Button)myView.findViewById(R.id.create);
        pcreate();
        vehicles();
        return myView;


    }

 public void pcreate(){

       create.setOnClickListener(
               new View.OnClickListener() {

                   @Override
                   public void onClick(View view) {

                       String method = "plan";

                       sdate = stdate.getText().toString();
                       edate = endate.getText().toString();
                       slocation = location.getText().toString();
                       sdestination = destination.getText().toString();
                       stime = etime.getText().toString();

                       String c_email = "cthilanchana@gmail.com";
                       String tmethod = "1";

                       try {
                           String data = URLEncoder.encode("sdate", "UTF-8") + "=" + URLEncoder.encode(sdate, "UTF-8") + "&" +
                                   URLEncoder.encode("edate", "UTF-8") + "=" + URLEncoder.encode(edate, "UTF-8") + "&" +
                                   URLEncoder.encode("slocation", "UTF-8") + "=" + URLEncoder.encode(slocation, "UTF-8") + "&" +
                                   URLEncoder.encode("sdestination", "UTF-8") + "=" + URLEncoder.encode(sdestination, "UTF-8") + "&" +
                                   URLEncoder.encode("cemail", "UTF-8") + "=" + URLEncoder.encode(c_email, "UTF-8") + "&" +
                                   URLEncoder.encode("method", "UTF-8") + "=" + URLEncoder.encode(tmethod, "UTF-8");

                           BackgroundTask backgroundTask = new BackgroundTask(myView.getContext());
                           backgroundTask.execute(method, data);


                       } catch (UnsupportedEncodingException e) {
                           e.printStackTrace();
                       }


                   }

               }


       );






    }

    public void vehicleF(View view){

        android.app.FragmentTransaction t = this.getFragmentManager().beginTransaction();
        Fragment mFrag = new SecondFragment();
        t.replace(R.id.nav_third_layout, mFrag);
        t.commit();
    }
    public void vehicles(){

        btvehicle.setOnClickListener(
                new View.OnClickListener() {



                    @Override
                    public void onClick(View view) {


                    }

                }


        );






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

            BackgroundTask backgroundTask = new BackgroundTask(myView.getContext());
            backgroundTask.execute(method,data);



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }




    }



}
