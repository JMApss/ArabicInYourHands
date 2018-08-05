package jmapps.arabicinyourhands.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jmapps.arabicinyourhands.R;

public class HolderListApps extends RecyclerView.ViewHolder {

    public final ImageView imIconAppList;
    public final TextView tvNameAppList;

    public HolderListApps(View itemView) {
        super(itemView);

        imIconAppList = itemView.findViewById(R.id.iv_icon_app_list);
        tvNameAppList = itemView.findViewById(R.id.tv_name_app_list);
    }
}
