package test.sharang.com.amazing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

/**
 * Created by sharang on 2/8/16.
 */
public class PocSplash extends Activity {
    VideoView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pocsplash);

        v=(VideoView) findViewById(R.id.vv);
        String s= "android.resource://test.sharang.com.amazing/"+R.raw.pocsplashvv;
        Uri u= Uri.parse(s);
        v.setVideoURI(u);
        v.requestFocus();
        v.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent("test.sharang.com.amazing.WifiSearcher");
                i.putExtra("choice",0);
                startActivity(i);
                finish();
            }
        }, 5000);




    }
}
