package nyc.c4q.testguide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nyc.c4q.testguide.adapter.FavAdapter;
import nyc.c4q.testguide.data.Fav;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREF_KEY = "test";

    private SharedPreferences log;

    Button button;
    EditText first, second;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        button = (Button) findViewById(R.id.save);
        first = (EditText) findViewById(R.id.first);
        second = (EditText) findViewById(R.id.second);

        log = getSharedPreferences(SHARED_PREF_KEY, MODE_PRIVATE);


        Map<String, ?> keys = log.getAll();


        List<Fav> myFav = new ArrayList<>();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {

            myFav.add(new Fav(entry.getKey(), entry.getValue().toString()));
        }

        for (int i = 0; i < 10; i++) {
            myFav.add(new Fav("Jervon " + i, "I like this number" + i));
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        FavAdapter adapter = new FavAdapter(myFav);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = log.edit();

               editor.putString(first.getText().toString(),second.getText().toString());
               editor.commit();

                Intent intent = new Intent(getApplicationContext(),Second.class);
                intent.putExtra("name", first.getText().toString());
                intent.putExtra("fav",second.getText().toString());
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();


        Map<String, ?> keys = log.getAll();


        List<Fav> myFav = new ArrayList<>();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {

            myFav.add(new Fav(entry.getKey().toString(), entry.getValue().toString()));
        }

//        for (int i = 0; i < 10; i++) {
//            myFav.add(new Fav("Jervon " + i, "I like this number" + i));
//        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        FavAdapter adapter = new FavAdapter(myFav);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
