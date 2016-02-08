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

        setContentView(R.layout.test);
        Intent i;
        i=getIntent();
        int set[]=new int[15];
        set= i.getIntArrayExtra("cluearray");
        if(set[0]==1){
            LinearLayout l=(LinearLayout)findViewById(R.id.ll);
            //l.setBackgroundResource(R.drawable.mainsplash);
            l.setBackgroundColor(Color.BLUE);
            TextView tv=(TextView)findViewById(R.id.tv);
            tv.setText("Clue1111111111111111111111111111111111111111111111111111111111");
            tv.setTextColor(Color.WHITE);
        }

        
    }
}
