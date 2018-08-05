package jmapps.arabicinyourhands.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jmapps.arabicinyourhands.R;

public class HolderAboutApp extends RecyclerView.ViewHolder {

    public final ImageView imIconAboutApp;
    public final TextView tvNameAboutApp;

    public HolderAboutApp(View itemView) {
        super(itemView);

        imIconAboutApp = itemView.findViewById(R.id.iv_icon_about_app);
        tvNameAboutApp = itemView.findViewById(R.id.tv_name_about_app);
    }
}
