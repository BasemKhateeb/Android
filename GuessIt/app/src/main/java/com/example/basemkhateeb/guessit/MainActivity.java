package com.example.basemkhateeb.guessit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Random;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.Math;


public class MainActivity extends ActionBarActivity {
        int randomnum=generate();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
    public void buttononClick(View v){

      String x;
        int y;
        EditText ed= (EditText)findViewById(R.id.NumberText);
       x= String.valueOf(ed.getText());
        if(!x.isEmpty()) {
            y = Integer.parseInt(x);
        }
        else
        y=-1;
        Check(y,randomnum);
    }
    public void buttonon2Click(View v){

        randomnum=generate();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public int generate(){
        Random r= new Random();
        int randomnum = r.nextInt((1000-1)+1)+1;
        return randomnum;
    }
    public void Check(int x,int y){
        String res="You must enter a number between 1 and 1000";
        if (x>=1&& x<=1000){
            if(x==y){
            res = " Congratulation you guessed the number";
        }
       else  if(((x-y)<=5)&&((y-x))<=5){
            res=" You are Very Close";
        }
        else if  (x>y){
            res=" The number You entered is bigger than the number Generated";
        }
        else {
            res ="The number you entered is less than The Generated Number ";
        }


    }
        else{
            res = "You must enter a number between 1 and 1000";

        }
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_LONG).show();

}
}
