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
public class SlClue extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.slclue);
        Intent i;
        i=getIntent();
        int set[]=new int[15];
        set= i.getIntArrayExtra("cluearray");
        if(set[0]==1&&set[1]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue1");
            tv.setTextColor(Color.WHITE);
        }
        else
        if(set[1]==1&&set[2]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue2");
            tv.setTextColor(Color.WHITE);
        }
        else
        if(set[2]==1&&set[3]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue3");
            tv.setTextColor(Color.WHITE);
        }
        else
        if(set[3]==1&&set[4]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue4");
            tv.setTextColor(Color.WHITE);
        }
        else
        if(set[4]==1&&set[5]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue5");
            tv.setTextColor(Color.WHITE);
        }
        else
        if(set[5]==1&&set[6]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue6");
            tv.setTextColor(Color.WHITE);
        }
        else
        if(set[6]==1&&set[7]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue7");
            tv.setTextColor(Color.WHITE);
        }
        else
        if(set[7]==1&&set[8]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue8");
            tv.setTextColor(Color.WHITE);
        }
        else
        if(set[8]==1&&set[9]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue9");
            tv.setTextColor(Color.WHITE);
        }
        else
        if(set[9]==1&&set[10]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue10");
            tv.setTextColor(Color.WHITE);
        }
        else
        if(set[10]==1&&set[11]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue11");
            tv.setTextColor(Color.WHITE);
        }
        else
        if(set[11]==1&&set[12]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue12");
            tv.setTextColor(Color.WHITE);
        }
        else
        if(set[12]==1&&set[13]==0){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll1);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Dynamic layout for clue13");
            tv.setTextColor(Color.WHITE);
        }

        
    }
}
