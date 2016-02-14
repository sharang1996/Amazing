package test.sharang.com.amazing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sharang on 2/8/16.
 */
public class FdClue extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fdclue);
        Intent i;
        i=getIntent();
        int set[]=new int[15];
        set= i.getIntArrayExtra("cluearray");
        if(set[0]==1&&set[1]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
            l.setBackgroundResource(R.drawable.fdclue1);
        }
        else
        if(set[1]==1&&set[2]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
            l.setBackgroundResource(R.drawable.fdclue2);

        }
        else
        if(set[2]==1&&set[3]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
            l.setBackgroundResource(R.drawable.fdclue3);

        }
        else
        if(set[3]==1&&set[4]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
            l.setBackgroundResource(R.drawable.fdclue4);

        }
        else
        if(set[4]==1&&set[5]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
           l.setBackgroundResource(R.drawable.fdclue5);

        }
        else
        if(set[5]==1&&set[6]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
            l.setBackgroundResource(R.drawable.fdclue6);

        }
        else
        if(set[6]==1&&set[7]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
            l.setBackgroundResource(R.drawable.fdclue7);

        }
        else
        if(set[7]==1&&set[8]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
           l.setBackgroundResource(R.drawable.fdclue8);

        }
        else
        if(set[8]==1&&set[9]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
            l.setBackgroundResource(R.drawable.fdclue9);

        }
        else
        if(set[9]==1&&set[10]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
            l.setBackgroundResource(R.drawable.fdclue10);


        }
        else
        if(set[10]==1&&set[11]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
           l.setBackgroundResource(R.drawable.fdclue11);
        }
        else
        if(set[11]==1&&set[12]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
           l.setBackgroundResource(R.drawable.fdclue12);
        }
        else
        if(set[12]==1&&set[13]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
            l.setBackgroundResource(R.drawable.fdclue13);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    LinearLayout l=(LinearLayout)findViewById(R.id.ll3);
                    l.setBackgroundResource(R.drawable.fdclue13alt);
                }
            }, 4000);


        }


    }
}
