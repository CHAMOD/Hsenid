package taxilanka.oaksoft.com.navigationdrawer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class Main extends AppCompatActivity {
Button btvehicle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btvehicle=(Button)findViewById(R.id.vehicle);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(Main.this,Packages.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();

    }










    }





