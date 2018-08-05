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

import jmapps.arabicinyourhands.ContentsLessonsActivity;
import jmapps.arabicinyourhands.Models.ModelChaptersLessons;
import jmapps.arabicinyourhands.R;
import jmapps.arabicinyourhands.ViewHolders.HolderChaptersLessons;

import static jmapps.arabicinyourhands.ContentsLessonsActivity.keyForContentLessons;
import static jmapps.arabicinyourhands.ContentsLessonsActivity.keyForTitleContentLessons;

public class AdapterChaptersLessons extends RecyclerView.Adapter<HolderChaptersLessons> {

    private final List<ModelChaptersLessons> mModelChaptersLessons;

    public AdapterChaptersLessons(List<ModelChaptersLessons> modelChaptersLessons) {
        this.mModelChaptersLessons = modelChaptersLessons;
    }

    @NonNull
    @Override
    public HolderChaptersLessons onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.chapter_lesson_item, parent, false);
        return new HolderChaptersLessons(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderChaptersLessons holder, @SuppressLint("RecyclerView") final int position) {
        final String strTitleChapter = mModelChaptersLessons.get(position).getTitleChapter();
        final String strPathIcon = mModelChaptersLessons.get(position).getPathIcon();
        final String strSetContentForChapter = mModelChaptersLessons.get(position).getSetContentForChapter();

        holder.tvLessonsChapterName.setText(Html.fromHtml(strTitleChapter));

        final int iconID = holder.itemView.getContext().getResources().getIdentifier(strPathIcon,
                "drawable", "jmapps.arabicinyourhands");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentToNextActivity(holder, strTitleChapter, strSetContentForChapter);
            }
        });

        holder.imIconLessonsChapter.setBackgroundResource(iconID);
    }

    private void intentToNextActivity(HolderChaptersLessons holder, String titleChapter, String strSetContentForChapter) {
        Intent openContentActivity = new Intent(holder.itemView.getContext(), ContentsLessonsActivity.class);
        openContentActivity.putExtra(keyForTitleContentLessons, titleChapter);
        openContentActivity.putExtra(keyForContentLessons, strSetContentForChapter);
        holder.itemView.getContext().startActivity(openContentActivity);
    }

    @Override
    public int getItemCount() {
        return mModelChaptersLessons.size();
    }
}
