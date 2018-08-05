package jmapps.arabicinyourhands.ViewHolders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import jmapps.arabicinyourhands.R;

import static jmapps.arabicinyourhands.DialogFragments.DialogSettings.keySizeArabicText;
import static jmapps.arabicinyourhands.DialogFragments.DialogSettings.keySizeRussianText;
import static jmapps.arabicinyourhands.MainChaptersActivity.mPreferences;

public class HolderContentsLessons extends RecyclerView.ViewHolder {

    public final CardView cvContentLesson;
    public final TextView tvLessonsContentArabic;
    public final TextView tvLessonsContentRussian;

    public HolderContentsLessons(View itemView) {
        super(itemView);

        cvContentLesson = itemView.findViewById(R.id.cv_content_lesson);
        tvLessonsContentArabic = itemView.findViewById(R.id.tv_lessons_content_arabic);
        tvLessonsContentRussian = itemView.findViewById(R.id.tv_lessons_content_russian);

        int sizeArabicText = mPreferences.getInt(keySizeArabicText, 22);
        int sizeRussianText = mPreferences.getInt(keySizeRussianText, 20);

        tvLessonsContentArabic.setTextSize(sizeArabicText);
        tvLessonsContentRussian.setTextSize(sizeRussianText);
    }
}
