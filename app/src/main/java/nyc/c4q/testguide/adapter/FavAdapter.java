package nyc.c4q.testguide.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.testguide.R;
import nyc.c4q.testguide.data.Fav;
import nyc.c4q.testguide.holder.FavHolder;

/**
 * Created by jervon.arnoldd on 11/20/17.
 */

public class FavAdapter  extends RecyclerView.Adapter<FavHolder>{

    List<Fav> favs;

    public FavAdapter(List<Fav> favs) {
        this.favs = favs;
    }

    @Override
    public FavHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cycle_view,parent,false);
        return new FavHolder(view);
    }

    @Override
    public void onBindViewHolder(FavHolder holder, int position) {

        Fav myFav = favs.get(position);
        holder.onBind(myFav);




    }

    @Override
    public int getItemCount() {
        return favs.size();
    }
}
