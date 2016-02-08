package test.sharang.com.amazing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by sharang on 2/8/16.
 */
public class ChooseStoryLine extends Activity implements View.OnClickListener{

    ImageButton jack,harry,fd,sherlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosestoryline);

        jack=(ImageButton)findViewById(R.id.poc);
        harry=(ImageButton)findViewById(R.id.hp);
        fd=(ImageButton)findViewById(R.id.fd);
        sherlock=(ImageButton)findViewById(R.id.sl);

        jack.setOnClickListener(this);
        harry.setOnClickListener(this);
        fd.setOnClickListener(this);
        sherlock.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        int id=v.getId();
        switch(id)
        {
            case R.id.poc:
                i=new Intent("test.sharang.com.amazing.");
                startActivity(i);
                break;

            case R.id.hp:
                i=new Intent("test.sharang.com.amazing.");
                startActivity(i);
                break;

            case R.id.fd:
                i=new Intent("test.sharang.com.amazing.");
                startActivity(i);
                break;

            case R.id.sl:
                i=new Intent("test.sharang.com.amazing.");
                startActivity(i);
                break;
        }


    }
}
