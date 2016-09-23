package taxilanka.oaksoft.com.navigationdrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import taxilanka.oaksoft.com.navigationdrawer.MainActivity;
import taxilanka.oaksoft.com.navigationdrawer.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();


    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
       finish();
    }

}
