package test.sharang.com.amazing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sharang on 2/8/16.
 */
public class HpClue extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hpclue);
        Intent i;
        i=getIntent();
        int set[]=new int[15];
        set= i.getIntArrayExtra("cluearray");
        if(set[0]==1&&set[1]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue1);

        }
        else
        if(set[1]==1&&set[2]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue2);

        }
        else
        if(set[2]==1&&set[3]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue3);
        }
        else
        if(set[3]==1&&set[4]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue4);

        }
        else
        if(set[4]==1&&set[5]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue5);

        }
        else
        if(set[5]==1&&set[6]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue6);

        }
        else
        if(set[6]==1&&set[7]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue7);

        }
        else
        if(set[7]==1&&set[8]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue8);

        }
        else
        if(set[8]==1&&set[9]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue9);

        }
        else
        if(set[9]==1&&set[10]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue10);

        }
        else
        if(set[10]==1&&set[11]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue11);

        }
        else
        if(set[11]==1&&set[12]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue12);

        }
        else
        if(set[12]==1&&set[13]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            l.setBackgroundResource(R.drawable.hpclue13);

        }




    }
}
