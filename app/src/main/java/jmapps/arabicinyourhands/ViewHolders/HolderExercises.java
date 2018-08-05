package jmapps.arabicinyourhands.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import jmapps.arabicinyourhands.R;

import static jmapps.arabicinyourhands.DialogFragments.DialogSettings.keySizeArabicText;
import static jmapps.arabicinyourhands.MainChaptersActivity.mPreferences;

public class HolderExercises extends RecyclerView.ViewHolder {

    public final TextView tvTitleName;
    public final TextView tvTitleContent;

    public final LinearLayout llQuestionOne;
    public final LinearLayout llQuestionTwo;
    public final LinearLayout llQuestionThree;
    public final LinearLayout llQuestionFour;
    public final LinearLayout llQuestionFive;
    public final LinearLayout llQuestionSix;

    public final TextView tvQuestionNameOne;
    public final TextView tvAnswerNameTwo;
    public final TextView tvQuestionNameThree;
    public final TextView tvAnswerNameFour;
    public final TextView tvQuestionNameFive;
    public final TextView tvAnswerNameSix;

    public final ToggleButton tbArrowQuestionOne;
    public final ToggleButton tbArrowAnswerTwo;
    public final ToggleButton tbArrowQuestionThree;
    public final ToggleButton tbArrowAnswerFour;
    public final ToggleButton tbArrowQuestionFive;
    public final ToggleButton tbArrowAnswerSix;

    public HolderExercises(View itemView) {
        super(itemView);

        tvTitleName = itemView.findViewById(R.id.tv_title_name);
        tvTitleContent = itemView.findViewById(R.id.tv_title_content);

        llQuestionOne = itemView.findViewById(R.id.ll_exercises_one);
        llQuestionTwo = itemView.findViewById(R.id.ll_exercises_two);
        llQuestionThree = itemView.findViewById(R.id.ll_exercises_three);
        llQuestionFour = itemView.findViewById(R.id.ll_exercises_four);
        llQuestionFive = itemView.findViewById(R.id.ll_exercises_five);
        llQuestionSix = itemView.findViewById(R.id.ll_exercises_six);

        tvQuestionNameOne = itemView.findViewById(R.id.tv_question_one_name);
        tvAnswerNameTwo = itemView.findViewById(R.id.tv_answer_two_name);
        tvQuestionNameThree = itemView.findViewById(R.id.tv_question_three_name);
        tvAnswerNameFour = itemView.findViewById(R.id.tv_answer_four_name);
        tvQuestionNameFive = itemView.findViewById(R.id.tv_question_five_name);
        tvAnswerNameSix = itemView.findViewById(R.id.tv_answer_six_name);

        tbArrowQuestionOne = itemView.findViewById(R.id.tb_arrow_question_one);
        tbArrowAnswerTwo = itemView.findViewById(R.id.tb_arrow_answer_two);
        tbArrowQuestionThree = itemView.findViewById(R.id.tb_arrow_question_three);
        tbArrowAnswerFour = itemView.findViewById(R.id.tb_arrow_answer_four);
        tbArrowQuestionFive = itemView.findViewById(R.id.tb_arrow_question_five);
        tbArrowAnswerSix = itemView.findViewById(R.id.tb_arrow_answer_six);

        int sizeArabicText = mPreferences.getInt(keySizeArabicText, 22);

        tvQuestionNameOne.setTextSize(sizeArabicText);
        tvAnswerNameTwo.setTextSize(sizeArabicText);
        tvQuestionNameThree.setTextSize(sizeArabicText);
        tvAnswerNameFour.setTextSize(sizeArabicText);
        tvQuestionNameFive.setTextSize(sizeArabicText);
        tvAnswerNameSix.setTextSize(sizeArabicText);
    }
}