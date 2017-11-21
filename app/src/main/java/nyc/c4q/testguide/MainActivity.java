package nyc.c4q.testguide;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.testguide.adapter.FavAdapter;
import nyc.c4q.testguide.data.Fav;

public class MainActivity extends AppCompatActivity {

   private static final String SHARED_PREF_KEY = "test";

   private SharedPreferences log;




    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);





        List<Fav> myFav = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            myFav.add(new Fav("Jervon "+i, "I like this number"+i));
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        FavAdapter adapter = new FavAdapter(myFav);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);




    }
}
