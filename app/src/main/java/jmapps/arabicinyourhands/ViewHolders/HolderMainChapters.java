package jmapps.arabicinyourhands.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jmapps.arabicinyourhands.R;

public class HolderMainChapters extends RecyclerView.ViewHolder {

    public final TextView tvNumberMainChapter;
    public final ImageView iconMainChapter;
    public final TextView titleMainChapter;
    public final TextView subTitleMainChapter;

    public HolderMainChapters(View itemView) {
        super(itemView);

        tvNumberMainChapter = itemView.findViewById(R.id.tv_number_main_chapter);
        iconMainChapter = itemView.findViewById(R.id.iv_icon_main_chapter);
        titleMainChapter = itemView.findViewById(R.id.tv_title_main_chapter);
        subTitleMainChapter = itemView.findViewById(R.id.tv_subtitle_main_chapter);
    }
}
