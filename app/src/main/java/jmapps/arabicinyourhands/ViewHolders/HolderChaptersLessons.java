package jmapps.arabicinyourhands.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import jmapps.arabicinyourhands.R;

public class HolderChaptersLessons extends RecyclerView.ViewHolder {

    public final ImageView imIconLessonsChapter;
    public final TextView tvLessonsChapterName;

    public HolderChaptersLessons(View itemView) {
        super(itemView);

        imIconLessonsChapter = itemView.findViewById(R.id.iv_icon_lessons_chapter);
        tvLessonsChapterName = itemView.findViewById(R.id.tv_lesson_chapter_name);
    }
}
