package jmapps.arabicinyourhands.DialogFragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import jmapps.arabicinyourhands.R;

import static jmapps.arabicinyourhands.MainChaptersActivity.mEditor;
import static jmapps.arabicinyourhands.MainChaptersActivity.mPreferences;

public class DialogSettings extends DialogFragment implements View.OnClickListener {

    public static final String keySizeArabicText = "size_arabic_text";
    public static final String keySizeRussianText = "size_russian_text";

    private int sizeArabicText;
    private int sizeRussianText;

    private Button btnArabicTextSizeMinus;
    private TextView tvGreetingArabic;
    private Button btnArabicTextSizePlus;

    private Button btnRussianTextSizeMinus;
    private TextView tvGreetingRussian;
    private Button btnRussianTextSizePlus;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootSettings = inflater.inflate(R.layout.fragment_settings, container, false);

        setRetainInstance(true);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        btnArabicTextSizeMinus = rootSettings.findViewById(R.id.btn_arabic_text_size_minus);
        tvGreetingArabic = rootSettings.findViewById(R.id.tv_greeting_arabic);
        btnArabicTextSizePlus = rootSettings.findViewById(R.id.btn_arabic_text_size_plus);

        btnRussianTextSizeMinus = rootSettings.findViewById(R.id.btn_russian_text_size_minus);
        tvGreetingRussian = rootSettings.findViewById(R.id.tv_greeting_russian);
        btnRussianTextSizePlus = rootSettings.findViewById(R.id.btn_russian_text_size_plus);

        textValues();

        btnArabicTextSizeMinus.setOnClickListener(this);
        btnArabicTextSizePlus.setOnClickListener(this);
        btnRussianTextSizeMinus.setOnClickListener(this);
        btnRussianTextSizePlus.setOnClickListener(this);

        return rootSettings;
    }

    @Override
    public void onClick(View buttonView) {
        if (buttonView == btnArabicTextSizeMinus) {
            sizeArabicText--;
        } else if (buttonView == btnArabicTextSizePlus) {
            sizeArabicText++;
        } else if (buttonView == btnRussianTextSizeMinus) {
            sizeRussianText--;
        } else if (buttonView == btnRussianTextSizePlus) {
            sizeRussianText++;
        }

        tvGreetingArabic.setTextSize(sizeArabicText);
        tvGreetingRussian.setTextSize(sizeRussianText);
        mEditor.putInt(keySizeArabicText, sizeArabicText).apply();
        mEditor.putInt(keySizeRussianText, sizeRussianText).apply();
    }

    private void textValues() {
        sizeArabicText = mPreferences.getInt(keySizeArabicText, 22);
        sizeRussianText = mPreferences.getInt(keySizeRussianText, 20);

        tvGreetingArabic.setTextSize(sizeArabicText);
        tvGreetingRussian.setTextSize(sizeRussianText);
    }
}
