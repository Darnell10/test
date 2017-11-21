package nyc.c4q.testguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        textView = (TextView) findViewById(R.id.secondview);

        Bundle bundle = getIntent().getExtras();

        String hello =bundle.getString("name");
        String world = bundle.getString("fav");

        textView.setText("Hello "+hello+ " You are saved with you favorite snack: "+world +"Press Back now");







    }

}
