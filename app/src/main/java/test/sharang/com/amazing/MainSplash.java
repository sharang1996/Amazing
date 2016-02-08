package test.sharang.com.amazing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by sharang on 2/7/16.
 */
public class MainSplash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainsplash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent("test.sharang.com.amazing.ChooseStoryLine");
                startActivity(i);
                finish();
            }
        }, 5000);



    }
}
