package test.sharang.com.amazing;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.List;

public class WifiSearcher extends AppCompatActivity{


    int choice=0;                     //this holds the user storyline choice
    WifiManager wifi;                 //this is the wifiManager object
    String ssids[];                   //this will hold the array list of wifi networks available
    WifiScanReceiver wifiReciever;    //this is the broadcast reciever class object
    int credits=0;                    //this is the in-game credits

    String wh[]={"TransportationLab","NaacRoom","Schc","FluidMechanicsLab","WorkShop","EmechLab","DarkRoom","SurveyingLab","Library","ProjectLab","ExaminationDept","SeminarHall","NutritionAndDlab","13","14"};  //this is the ssid list we create
    //this has to be set according to the room names!!!

    int set[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};   //this determines whether the ssid is unlocked

    SharedPreferences preferences;              //we use this for saving the ssid set or not details in shared prefs
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_searcher);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "hint at a price!!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent i =getIntent();
        choice=i.getIntExtra("choice",0);            //we get the user choice of storyline


        wifi=(WifiManager)getSystemService(Context.WIFI_SERVICE);  //initialing the wifimanager object
        wifiReciever = new WifiScanReceiver();                     //initializing the broadcast reciever
        wifi.startScan();                                          //we begin to scan for networks


        preferences=getApplicationContext().getSharedPreferences("xyz",MODE_PRIVATE);
        editor = preferences.edit();

        set[0]=preferences.getInt("set0", 0);                                //setting all ssids to 0 by default
        set[1]=preferences.getInt("set1",0);
        set[2]=preferences.getInt("set2",0);
        set[3]=preferences.getInt("set3",0);
        set[4]=preferences.getInt("set4",0);
        set[5]=preferences.getInt("set5",0);
        set[6]=preferences.getInt("set6",0);
        set[7]=preferences.getInt("set7",0);
        set[8]=preferences.getInt("set8",0);
        set[9]=preferences.getInt("set9",0);
        set[10]=preferences.getInt("set10",0);
        set[11]=preferences.getInt("set11",0);
        set[12]=preferences.getInt("set12",0);
        set[13]=preferences.getInt("set13",0);
        set[14]=preferences.getInt("set14",0);

    }
    protected void onPause() {
        unregisterReceiver(wifiReciever);
        super.onPause();
    }

    protected void onResume() {
        registerReceiver(wifiReciever, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        super.onResume();
        wifi.startScan();                        //start scanning for wifi hotspots
        set[0]=preferences.getInt("set0",0);
        set[1]=preferences.getInt("set1",0);
        set[2]=preferences.getInt("set2",0);
        set[3]=preferences.getInt("set3",0);
        set[4]=preferences.getInt("set4",0);
        set[5]=preferences.getInt("set5",0);
        set[6]=preferences.getInt("set6",0);
        set[7]=preferences.getInt("set7",0);
        set[8]=preferences.getInt("set8",0);
        set[9]=preferences.getInt("set9",0);
        set[10]=preferences.getInt("set10",0);
        set[11]=preferences.getInt("set11",0);
        set[12]=preferences.getInt("set12",0);
        set[13]=preferences.getInt("set13",0);
        set[14]=preferences.getInt("set14",0);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wifi_searcher, menu);
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


    private class WifiScanReceiver extends BroadcastReceiver {


        public void onReceive(Context c, Intent intent) {

            List<ScanResult> wifiScanList = wifi.getScanResults();     //listArray of all the wifi hotspots

            ScanResult result[]=wifiScanList.toArray(new ScanResult[wifiScanList.size()]);  //getting an array from list

            ssids = new String[wifiScanList.size()];               //stores the ssid

            for(int i = 0; i < wifiScanList.size(); i++){

                //  wifis[i] = ((wifiScanList.get(i)).toString());

                ssids[i] = ((result[i].SSID));                 //extracting ssid from result of wifi scan

            }




            switch(choice)                //different clue spots for different storylines...
            {
                case 0:
                    for(int i=0;i<ssids.length;++i){

                        if(ssids[i].contentEquals(wh[0])) {
                            if(set[0]==0)
                            {

                                Dialog dialog = new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(R.layout.dialoguebox);
                                dialog.show();

                                set[0] = 1;
                                editor.putInt("set0", set[0]);
                                editor.commit();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }



                        }

                        else
                        if(ssids[i].contentEquals(wh[1])&&set[0]==1){
                            if(set[1]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog = new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[1]=1;
                            editor.putInt("set1", set[1]);
                            editor.commit();


                        }
                        else
                        if(ssids[i].contentEquals(wh[2])&&set[1]==1) {
                            if(set[2]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[2] = 1;

                            editor.putInt("set2", set[2]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[3])&&set[2]==1) {
                            if(set[3]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[3] = 1;
                            editor.putInt("set3", set[3]);
                            editor.commit();


                        }

                        else
                        if(ssids[i].contentEquals(wh[4])&&set[3]==1) {
                            if(set[4]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[4] = 1;

                            editor.putInt("set4", set[4]);
                            editor.commit();

                        }

                        else
                        if(ssids[i].contentEquals(wh[5])&&set[4]==1) {
                            if(set[5]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[5] = 1;
                            credits+=10;
                            editor.putInt("set5", set[5]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[6])&&set[5]==1) {
                            if(set[6]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[6] = 1;
                            credits+=10;
                            editor.putInt("set6", set[6]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[7])&&set[6]==1) {
                            if(set[7]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[7] = 1;
                            credits+=10;
                            editor.putInt("set7", set[7]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[8])&&set[7]==1) {
                            if(set[8]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[8] = 1;
                            credits+=10;
                            editor.putInt("set8", set[8]);
                            editor.commit();

                        }

                        else
                        if(ssids[i].contentEquals(wh[9])&&set[8]==1) {
                            if(set[9]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[9] = 1;
                            credits+=10;
                            editor.putInt("set9", set[9]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[10])&&set[9]==1) {
                            if(set[10]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[10] = 1;
                            credits+=10;
                            editor.putInt("set10", set[10]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[11])&&set[10]==1) {
                            if(set[11]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[11] = 1;
                            credits+=15;
                            editor.putInt("set11", set[11]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[12])&&set[11]==1) {
                            if(set[12]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[12] = 1;
                            credits+=15;
                            editor.putInt("set12", set[12]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[13])&&set[12]==1) {
                            if(set[13]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.PocClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[13] = 1;
                            credits+=15;
                            editor.putInt("set13", set[13]);
                            editor.commit();

                        }

              /*  else
                if(ssids[i].contentEquals(wh[14])&&set[13]==1) {
                    if(set[14]==0)
                    {
                        TextView tv = new TextView(WifiSearcher.this);
                        tv.setText("You have just unlocked a clue!!!check it now!!");
                        Dialog dialog =new Dialog(WifiSearcher.this);
                        dialog.setTitle("Congrats!!!");
                        dialog.setContentView(tv);
                        dialog.show();
                    }
                    set[14] = 1;
                    editor.putInt("set14", set[14]);
                    editor.commit();

                }*/
                    }

                    break;





                case 1:


                    for(int i=0;i<ssids.length;++i){

                        if(ssids[i].contentEquals(wh[0])) {
                            if(set[0]==0)
                            {

                                Dialog dialog = new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(R.layout.dialoguebox);
                                dialog.show();

                                set[0] = 1;
                                editor.putInt("set0", set[0]);
                                editor.commit();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }



                        }

                        else
                        if(ssids[i].contentEquals(wh[1])&&set[0]==1){
                            if(set[1]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog = new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[1]=1;
                            editor.putInt("set1", set[1]);
                            editor.commit();


                        }
                        else
                        if(ssids[i].contentEquals(wh[2])&&set[1]==1) {
                            if(set[2]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[2] = 1;

                            editor.putInt("set2", set[2]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[3])&&set[2]==1) {
                            if(set[3]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[3] = 1;
                            editor.putInt("set3", set[3]);
                            editor.commit();


                        }

                        else
                        if(ssids[i].contentEquals(wh[4])&&set[3]==1) {
                            if(set[4]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[4] = 1;

                            editor.putInt("set4", set[4]);
                            editor.commit();

                        }

                        else
                        if(ssids[i].contentEquals(wh[5])&&set[4]==1) {
                            if(set[5]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[5] = 1;
                            credits+=10;
                            editor.putInt("set5", set[5]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[6])&&set[5]==1) {
                            if(set[6]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[6] = 1;
                            credits+=10;
                            editor.putInt("set6", set[6]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[7])&&set[6]==1) {
                            if(set[7]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[7] = 1;
                            credits+=10;
                            editor.putInt("set7", set[7]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[8])&&set[7]==1) {
                            if(set[8]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[8] = 1;
                            credits+=10;
                            editor.putInt("set8", set[8]);
                            editor.commit();

                        }

                        else
                        if(ssids[i].contentEquals(wh[9])&&set[8]==1) {
                            if(set[9]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[9] = 1;
                            credits+=10;
                            editor.putInt("set9", set[9]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[10])&&set[9]==1) {
                            if(set[10]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[10] = 1;
                            credits+=10;
                            editor.putInt("set10", set[10]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[11])&&set[10]==1) {
                            if(set[11]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[11] = 1;
                            credits+=15;
                            editor.putInt("set11", set[11]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[12])&&set[11]==1) {
                            if(set[12]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[12] = 1;
                            credits+=15;
                            editor.putInt("set12", set[12]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[13])&&set[12]==1) {
                            if(set[13]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.HpClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[13] = 1;
                            credits+=15;
                            editor.putInt("set13", set[13]);
                            editor.commit();

                        }

              /*  else
                if(ssids[i].contentEquals(wh[14])&&set[13]==1) {
                    if(set[14]==0)
                    {
                        TextView tv = new TextView(WifiSearcher.this);
                        tv.setText("You have just unlocked a clue!!!check it now!!");
                        Dialog dialog =new Dialog(WifiSearcher.this);
                        dialog.setTitle("Congrats!!!");
                        dialog.setContentView(tv);
                        dialog.show();
                    }
                    set[14] = 1;
                    editor.putInt("set14", set[14]);
                    editor.commit();

                }*/
                    }


                    break;









                case 2:
                    for(int i=0;i<ssids.length;++i){

                        if(ssids[i].contentEquals(wh[0])) {
                            if(set[0]==0)
                            {

                                Dialog dialog = new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(R.layout.dialoguebox);
                                dialog.show();

                                set[0] = 1;
                                editor.putInt("set0", set[0]);
                                editor.commit();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }



                        }

                        else
                        if(ssids[i].contentEquals(wh[1])&&set[0]==1){
                            if(set[1]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog = new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[1]=1;
                            editor.putInt("set1", set[1]);
                            editor.commit();


                        }
                        else
                        if(ssids[i].contentEquals(wh[2])&&set[1]==1) {
                            if(set[2]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[2] = 1;

                            editor.putInt("set2", set[2]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[3])&&set[2]==1) {
                            if(set[3]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[3] = 1;
                            editor.putInt("set3", set[3]);
                            editor.commit();


                        }

                        else
                        if(ssids[i].contentEquals(wh[4])&&set[3]==1) {
                            if(set[4]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[4] = 1;

                            editor.putInt("set4", set[4]);
                            editor.commit();

                        }

                        else
                        if(ssids[i].contentEquals(wh[5])&&set[4]==1) {
                            if(set[5]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[5] = 1;
                            credits+=10;
                            editor.putInt("set5", set[5]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[6])&&set[5]==1) {
                            if(set[6]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[6] = 1;
                            credits+=10;
                            editor.putInt("set6", set[6]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[7])&&set[6]==1) {
                            if(set[7]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[7] = 1;
                            credits+=10;
                            editor.putInt("set7", set[7]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[8])&&set[7]==1) {
                            if(set[8]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[8] = 1;
                            credits+=10;
                            editor.putInt("set8", set[8]);
                            editor.commit();

                        }

                        else
                        if(ssids[i].contentEquals(wh[9])&&set[8]==1) {
                            if(set[9]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[9] = 1;
                            credits+=10;
                            editor.putInt("set9", set[9]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[10])&&set[9]==1) {
                            if(set[10]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[10] = 1;
                            credits+=10;
                            editor.putInt("set10", set[10]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[11])&&set[10]==1) {
                            if(set[11]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[11] = 1;
                            credits+=15;
                            editor.putInt("set11", set[11]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[12])&&set[11]==1) {
                            if(set[12]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[12] = 1;
                            credits+=15;
                            editor.putInt("set12", set[12]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[13])&&set[12]==1) {
                            if(set[13]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.FdClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[13] = 1;
                            credits+=15;
                            editor.putInt("set13", set[13]);
                            editor.commit();

                        }

              /*  else
                if(ssids[i].contentEquals(wh[14])&&set[13]==1) {
                    if(set[14]==0)
                    {
                        TextView tv = new TextView(WifiSearcher.this);
                        tv.setText("You have just unlocked a clue!!!check it now!!");
                        Dialog dialog =new Dialog(WifiSearcher.this);
                        dialog.setTitle("Congrats!!!");
                        dialog.setContentView(tv);
                        dialog.show();
                    }
                    set[14] = 1;
                    editor.putInt("set14", set[14]);
                    editor.commit();

                }*/
                    }


                    break;



                case 3:
                    for(int i=0;i<ssids.length;++i){

                        if(ssids[i].contentEquals(wh[0])) {
                            if(set[0]==0)
                            {

                                Dialog dialog = new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(R.layout.dialoguebox);
                                dialog.show();

                                set[0] = 1;
                                editor.putInt("set0", set[0]);
                                editor.commit();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }



                        }

                        else
                        if(ssids[i].contentEquals(wh[1])&&set[0]==1){
                            if(set[1]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog = new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[1]=1;
                            editor.putInt("set1", set[1]);
                            editor.commit();


                        }
                        else
                        if(ssids[i].contentEquals(wh[2])&&set[1]==1) {
                            if(set[2]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[2] = 1;

                            editor.putInt("set2", set[2]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[3])&&set[2]==1) {
                            if(set[3]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[3] = 1;
                            editor.putInt("set3", set[3]);
                            editor.commit();


                        }

                        else
                        if(ssids[i].contentEquals(wh[4])&&set[3]==1) {
                            if(set[4]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[4] = 1;

                            editor.putInt("set4", set[4]);
                            editor.commit();

                        }

                        else
                        if(ssids[i].contentEquals(wh[5])&&set[4]==1) {
                            if(set[5]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[5] = 1;
                            credits+=10;
                            editor.putInt("set5", set[5]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[6])&&set[5]==1) {
                            if(set[6]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[6] = 1;
                            credits+=10;
                            editor.putInt("set6", set[6]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[7])&&set[6]==1) {
                            if(set[7]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[7] = 1;
                            credits+=10;
                            editor.putInt("set7", set[7]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[8])&&set[7]==1) {
                            if(set[8]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[8] = 1;
                            credits+=10;
                            editor.putInt("set8", set[8]);
                            editor.commit();

                        }

                        else
                        if(ssids[i].contentEquals(wh[9])&&set[8]==1) {
                            if(set[9]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[9] = 1;
                            credits+=10;
                            editor.putInt("set9", set[9]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[10])&&set[9]==1) {
                            if(set[10]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[10] = 1;
                            credits+=10;
                            editor.putInt("set10", set[10]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[11])&&set[10]==1) {
                            if(set[11]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[11] = 1;
                            credits+=15;
                            editor.putInt("set11", set[11]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[12])&&set[11]==1) {
                            if(set[12]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[12] = 1;
                            credits+=15;
                            editor.putInt("set12", set[12]);
                            editor.commit();

                        }
                        else
                        if(ssids[i].contentEquals(wh[13])&&set[12]==1) {
                            if(set[13]==0)
                            {
                                TextView tv = new TextView(WifiSearcher.this);
                                tv.setText("You have just unlocked a clue!!!check it now!!");
                                Dialog dialog =new Dialog(WifiSearcher.this);
                                dialog.setTitle("Congrats!!!");
                                dialog.setContentView(tv);
                                dialog.show();
                                Intent x= new Intent("test.sharang.com.amazing.SlClue");
                                x.putExtra("cluearray",set);
                                startActivity(x);
                            }
                            set[13] = 1;
                            credits+=15;
                            editor.putInt("set13", set[13]);
                            editor.commit();

                        }

              /*  else
                if(ssids[i].contentEquals(wh[14])&&set[13]==1) {
                    if(set[14]==0)
                    {
                        TextView tv = new TextView(WifiSearcher.this);
                        tv.setText("You have just unlocked a clue!!!check it now!!");
                        Dialog dialog =new Dialog(WifiSearcher.this);
                        dialog.setTitle("Congrats!!!");
                        dialog.setContentView(tv);
                        dialog.show();
                    }
                    set[14] = 1;
                    editor.putInt("set14", set[14]);
                    editor.commit();

                }*/
                    }



                    break;


            }






















        }
    }
}