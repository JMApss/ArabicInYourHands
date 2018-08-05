package jmapps.arabicinyourhands.Adapters;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import jmapps.arabicinyourhands.ContentsLessonsActivity;
import jmapps.arabicinyourhands.Models.ModelContentsLessons;
import jmapps.arabicinyourhands.R;
import jmapps.arabicinyourhands.ViewHolders.HolderContentsLessons;

public class AdapterContentsLessons extends RecyclerView.Adapter<HolderContentsLessons> {

    private final List<ModelContentsLessons> mContentInChapters;
    private final ContentsLessonsActivity mContentActivity;
    private int currentPosition = -1;

    public AdapterContentsLessons(List<ModelContentsLessons> contentInChapters,
                                  ContentsLessonsActivity contentActivity) {
        this.mContentInChapters = contentInChapters;
        this.mContentActivity = contentActivity;
    }

    @NonNull
    @Override
    public HolderContentsLessons onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.content_lesson_item, parent, false);

        return new HolderContentsLessons(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderContentsLessons holder, @SuppressLint("RecyclerView") final int position) {
        final String strContentArabic = mContentInChapters.get(position).getLessonsContentArabic();
        final String strContentRussian = mContentInChapters.get(position).getLessonsContentRussian();
        //final String strLessonAudioFileName = mContentInChapters.get(position).getLessonsNameAudio();

        holder.tvLessonsContentArabic.setText(Html.fromHtml(strContentArabic));
        holder.tvLessonsContentRussian.setText(Html.fromHtml(strContentRussian));

        holder.cvContentLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModelContentsLessons modelContentsLessons = (ModelContentsLessons) view.getTag();
                mContentActivity.playOnly(modelContentsLessons.getLessonsNameAudio());
                notifyDataSetChanged();
                currentPosition = position;
            }
        });

        // устанавливаем значение цвета для айтема
        holder.cvContentLesson.setBackgroundColor(
                (position == currentPosition) ? Color.LTGRAY : Color.WHITE);

        holder.cvContentLesson.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // Кнопка КОПИРОВАТЬ
                ClipboardManager clipboard = (ClipboardManager) view.getContext()
                        .getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("",
                        Html.fromHtml(strContentArabic + "<br/>" + strContentRussian));

                if (clipboard != null) {
                    clipboard.setPrimaryClip(clip);
                }

                Toast.makeText(view.getContext(), "Скопировано в буфер", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    // метод, устанавливающий цвет на айтем
    public void setItemSelected(int position) {
        int tmp = currentPosition;
        currentPosition = position;
        if (tmp != -1) notifyItemChanged(tmp); // восстанавливаем цвет ранее выделенного
        if (position != -1) notifyItemChanged(position); // выделяем новый
    }

    @Override
    public int getItemCount() {
        return mContentInChapters.size();
    }
}