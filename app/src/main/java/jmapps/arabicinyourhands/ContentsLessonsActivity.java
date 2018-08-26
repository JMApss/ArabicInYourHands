package jmapps.arabicinyourhands;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

import jmapps.arabicinyourhands.Adapters.AdapterContentsLessons;
import jmapps.arabicinyourhands.DBSetup.SQLiteOpenHelperDataLessonsContents;
import jmapps.arabicinyourhands.Models.ModelContentsLessons;

import static jmapps.arabicinyourhands.MainChaptersActivity.mEditor;
import static jmapps.arabicinyourhands.MainChaptersActivity.mPreferences;

public class ContentsLessonsActivity extends AppCompatActivity implements
        ToggleButton.OnCheckedChangeListener {

    public static final String keyForContentLessons = "key_for_content_lessons";
    public static final String keyForTitleContentLessons = "key_for_title_content_lessons";

    private MediaPlayer mediaPlayer;
    private RecyclerView rvLessonContent;
    private AdapterContentsLessons adapterContentsLessons;
    private List<ModelContentsLessons> lessonsContent;
    private ToggleButton tbPlayAllAudio;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_content);

        String forContentLessons = getIntent().getStringExtra(keyForContentLessons);
        String forTitleContentLessons = getIntent().getStringExtra(keyForTitleContentLessons);

        rvLessonContent = findViewById(R.id.rv_lesson_content);
        TextView tvLessonTitle = findViewById(R.id.tv_lesson_title);
        tbPlayAllAudio = findViewById(R.id.tb_play_all_audio);

        tvLessonTitle.setText(Html.fromHtml(forTitleContentLessons));
        tbPlayAllAudio.setOnCheckedChangeListener(this);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.dialogs);
        }

        SQLiteOpenHelperDataLessonsContents lessonsContents = new SQLiteOpenHelperDataLessonsContents(this);
        lessonsContent = lessonsContents.getLessonsContent(forContentLessons);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvLessonContent.setLayoutManager(linearLayoutManager);
        adapterContentsLessons = new AdapterContentsLessons(lessonsContent, this);
        rvLessonContent.setAdapter(adapterContentsLessons);

        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        boolean isAgain = mPreferences.getBoolean("isAllow", true);

        if (isAgain) {
            dialogInstructions();
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("index_for_audio", currentIndex);
        super.onSaveInstanceState(outState);
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                mediaPlayer.release();
                mediaPlayer = null;
            }

            currentIndex = savedInstanceState.getInt("index_for_audio");
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            playAllAudios();
        } else {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        }
    }

    public void playOnly(ModelContentsLessons modelContentsLessons) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        if (tbPlayAllAudio.isChecked()) {
            tbPlayAllAudio.setChecked(false);
        }

        int resID = getResources().getIdentifier(modelContentsLessons.getLessonsNameAudio(),
                "raw", "jmapps.arabicinyourhands");

        mediaPlayer = MediaPlayer.create(this, resID);
        mediaPlayer.start();
    }

    private void playAllAudios() {
        play();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (currentIndex < lessonsContent.size() - 1) {
                    currentIndex++;
                    play();
                    mediaPlayer.setOnCompletionListener(this);
                } else {
                    tbPlayAllAudio.setChecked(false);
                    currentIndex = 0;
                    adapterContentsLessons.setItemBackground(currentIndex - 1);
                    adapterContentsLessons.notifyDataSetChanged();
                }
            }
        });
    }

    private void play() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        rvLessonContent.smoothScrollToPosition(currentIndex);
        adapterContentsLessons.setItemBackground(currentIndex);
        adapterContentsLessons.notifyDataSetChanged();

        int resID = getResources().getIdentifier(
                lessonsContent.get(currentIndex).getLessonsNameAudio(),
                "raw", "jmapps.arabicinyourhands");

        mediaPlayer = MediaPlayer.create(this, resID);
        mediaPlayer.start();
    }

    private void dialogInstructions() {
        AlertDialog.Builder instructionDialog = new AlertDialog.Builder(
                this, R.style.Theme_Light_Dialog_Alert);

        instructionDialog.create();

        instructionDialog.setIcon(R.drawable.ic_warning_red)
                .setTitle("ВНИМАНИЕ!")
                .setMessage(R.string.text_instruction)
                .setCancelable(false);

        instructionDialog.setPositiveButton(
                R.string.positive_ok_instruction, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNegativeButton(R.string.negative_ok_instruction, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mEditor.putBoolean("isAllow", false).apply();
                    }
                });

        instructionDialog.show();
    }
}
