package jmapps.arabicinyourhands;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.List;

import jmapps.arabicinyourhands.Adapters.AdapterChaptersLessons;
import jmapps.arabicinyourhands.DBSetup.SQLiteOpenHelperDataLessonsChapters;
import jmapps.arabicinyourhands.Models.ModelChaptersLessons;

import static jmapps.arabicinyourhands.ExercisesActivity.keyNumberExercises;
import static jmapps.arabicinyourhands.MainChaptersActivity.mEditor;
import static jmapps.arabicinyourhands.MainChaptersActivity.mPreferences;

public class ChaptersLessonsActivity extends AppCompatActivity {

    public static final String keyForContentExercises = "key_for_content_exercises";
    public static final String keyForContentChaptersLessons = "key_for_content_chapters_lessons";
    public static final String keyForTitleChapterLesson = "key_for_title_chapter_lesson";
    public static final String keyForIconChapterLesson = "key_for_icon_chapter_lesson";

    private int forContentExercises;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_chapter);

        toolbar = findViewById(R.id.toolbar_for_exercises);
        setSupportActionBar(toolbar);

        TextView tvLessonChaptersTitle = findViewById(R.id.tv_lesson_chapter_title);
        ImageView imLessonsChapterIcon = findViewById(R.id.im_lesson_chapter_icon);

        forContentExercises = getIntent().getIntExtra(keyForContentExercises, 0);
        String forContentChaptersLessons = getIntent().getStringExtra(keyForContentChaptersLessons);
        String forTitleChaptersLessons = getIntent().getStringExtra(keyForTitleChapterLesson);
        int forIconChaptersLessons = getIntent().getIntExtra(keyForIconChapterLesson, R.drawable.ic_menu_pen_white);

        RecyclerView rvLessonChapters = findViewById(R.id.rv_lesson_chapters);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        SQLiteOpenHelperDataLessonsChapters lessonsChaptersContent = new SQLiteOpenHelperDataLessonsChapters(this);
        List<ModelChaptersLessons> lessonsChaptersItem = lessonsChaptersContent.getContentLessonsChapters(forContentChaptersLessons);

        rvLessonChapters.setLayoutManager(new LinearLayoutManager(this));
        rvLessonChapters.setAdapter(new AdapterChaptersLessons(lessonsChaptersItem));

        tvLessonChaptersTitle.setText(forTitleChaptersLessons);
        imLessonsChapterIcon.setBackgroundResource(forIconChaptersLessons);

        boolean isAgain = mPreferences.getBoolean("targetView", true);

        if (isAgain) {
            targetTap();
        }

        mEditor.putBoolean("targetView", false).apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chapter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        } else if (id == R.id.action_exercises) {
            Intent openExercises = new Intent(this, ExercisesActivity.class);
            openExercises.putExtra(keyNumberExercises, forContentExercises);
            startActivity(openExercises);
        }

        return super.onOptionsItemSelected(item);
    }

    private void targetTap() {
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            public void run() {
                TapTargetView.showFor(ChaptersLessonsActivity.this, TapTarget.forToolbarMenuItem(toolbar, R.id.action_exercises,
                        "Здесь упражнения!", "Нажмите на кнопку, чтобы открыть раздел упражнений.")
                        .cancelable(true).tintTarget(true));
            }
        };

        handler.postDelayed(r, 100);
    }

}