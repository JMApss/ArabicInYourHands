package jmapps.arabicinyourhands.Adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jmapps.arabicinyourhands.ChaptersLessonsActivity;
import jmapps.arabicinyourhands.Models.ModelMainChapters;
import jmapps.arabicinyourhands.R;
import jmapps.arabicinyourhands.ViewHolders.HolderMainChapters;

import static jmapps.arabicinyourhands.ChaptersLessonsActivity.keyForContentChaptersLessons;
import static jmapps.arabicinyourhands.ChaptersLessonsActivity.keyForContentExercises;
import static jmapps.arabicinyourhands.ChaptersLessonsActivity.keyForIconChapterLesson;
import static jmapps.arabicinyourhands.ChaptersLessonsActivity.keyForTitleChapterLesson;

public class AdapterMainChapters extends RecyclerView.Adapter<HolderMainChapters> {

    private final List<ModelMainChapters> mModelMainChapters;

    public AdapterMainChapters(List<ModelMainChapters> modelMainChapters) {
        this.mModelMainChapters = modelMainChapters;
    }

    @NonNull
    @Override
    public HolderMainChapters onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.main_chapter_item, parent, false);
        return new HolderMainChapters(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderMainChapters holder,
                                 @SuppressLint("RecyclerView") final int position) {
        final int numberChapter = mModelMainChapters.get(position).getNumberMainChapter();
        final int pathIconName = mModelMainChapters.get(position).getIconMainChapter();
        final int pathIconNameWhite = mModelMainChapters.get(position).getIconMainChapterWhite();
        final String strTitleName = mModelMainChapters.get(position).getTitleMainChapter();
        final String strSubTitleName = mModelMainChapters.get(position).getSubTitleMainChapter();
        final String strSetContentNumber = mModelMainChapters.get(position).getSetContentMainNumber();

        holder.tvNumberMainChapter.setText(String.valueOf(numberChapter));
        holder.iconMainChapter.setBackgroundResource(pathIconName);
        holder.titleMainChapter.setText(strTitleName);
        holder.subTitleMainChapter.setText(Html.fromHtml("<b>" + strSubTitleName + "</b>"));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChapterLessonActivity(holder, position, strSetContentNumber,
                        strTitleName, pathIconNameWhite);
            }
        });
    }

    private void openChapterLessonActivity(HolderMainChapters holder,
                                           int forContentExercises,
                                           String forContentChaptersLessons,
                                           String titleChapterLessons,
                                           int iconChapterLesson) {
        Intent openChapterActivity = new Intent(holder.itemView.getContext(), ChaptersLessonsActivity.class);
        openChapterActivity.putExtra(keyForContentExercises, forContentExercises);
        openChapterActivity.putExtra(keyForContentChaptersLessons, forContentChaptersLessons);
        openChapterActivity.putExtra(keyForTitleChapterLesson, titleChapterLessons);
        openChapterActivity.putExtra(keyForIconChapterLesson, iconChapterLesson);
        holder.itemView.getContext().startActivity(openChapterActivity);
    }

    @Override
    public int getItemCount() {
        return mModelMainChapters.size();
    }
}
