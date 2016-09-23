package taxilanka.oaksoft.com.navigationdrawer;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;


public class Vehicle extends AppCompatActivity {

   public static ArrayList<String> listItems=new ArrayList<>();
    public static ArrayAdapter<String> adapter;

 Spinner sp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);


       sp=(Spinner)findViewById(R.id.spinner);
      //  String text = sp.getSelectedItem().toString();

        //viewVehicleDetails();


    }





    public void selvehicle(View view){

    boolean checked = ((RadioButton) view).isChecked();


        switch (view.getId())
        {
            case R.id.ac :
            if(checked)
            {
                BackTask bg=new BackTask(Vehicle.this);
                bg.execute();

                adapter=new ArrayAdapter<String>(this,R.layout.sprinner_layout,R.id.txt,listItems);
                sp.setAdapter(adapter);

            }break;


        }

    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();



    }

    public void viewVehicleDetails(){

        final String method="getvehicleDetails";

        sp.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {


                        String text = sp.getSelectedItem().toString();
                        try{
                            String data= URLEncoder.encode("V_ID","UTF-8")+"="+URLEncoder.encode(text,"UTF-8");

                            BackgroundTask2 backgroundTask2 = new BackgroundTask2(Vehicle.this);
                            backgroundTask2.execute(method,data);



                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }


                    }

                }


        );




    }












}
