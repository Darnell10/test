package nyc.c4q.testguide.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.testguide.R;
import nyc.c4q.testguide.data.Fav;

/**
 * Created by jervon.arnoldd on 11/20/17.
 */

public class FavHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView favs;
git

    public FavHolder(View itemView) {
        super(itemView);
        this.favs = (TextView) itemView.findViewById(R.id.fav);
        this.name = (TextView) itemView.findViewById(R.id.name);
    }


    public void onBind(final Fav fav){
        name.setText(fav.getName().toString());
        favs.setText(fav.getFav().toString());
    }

}
