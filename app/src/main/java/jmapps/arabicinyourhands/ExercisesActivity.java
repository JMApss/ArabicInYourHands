package jmapps.arabicinyourhands;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.List;

import jmapps.arabicinyourhands.Adapters.AdapterExercises;
import jmapps.arabicinyourhands.DBSetup.SQLiteOpenHelperDataExercises;
import jmapps.arabicinyourhands.Models.ModelExercises;

import static jmapps.arabicinyourhands.MainChaptersActivity.mEditor;
import static jmapps.arabicinyourhands.MainChaptersActivity.mPreferences;

public class ExercisesActivity extends AppCompatActivity {

    public static final String keyNumberExercises = "number_exercises";

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        Toolbar toolbar = findViewById(R.id.toolbar_exercises);
        setSupportActionBar(toolbar);

        int numberExercises = getIntent().getIntExtra(keyNumberExercises, 0);

        RecyclerView rvLessonContent = findViewById(R.id.rv_exercises);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.action_exercises);
        }

        SQLiteOpenHelperDataExercises dataExercises = new SQLiteOpenHelperDataExercises(this);
        List<ModelExercises> exercisesItems = dataExercises.getExercisesContent(numberExercises);

        AdapterExercises adapterExercises = new AdapterExercises(exercisesItems, this);

        rvLessonContent.setLayoutManager(new LinearLayoutManager(this));
        rvLessonContent.setAdapter(adapterExercises);

        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }


        boolean isAgain = mPreferences.getBoolean("isAllowExercises", true);

        if (isAgain) {
            dialogInstructions();
        }
    }

    public void playAudioFile(String audioFileName) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        int audioId = getResources().getIdentifier(audioFileName, "raw", "jmapps.arabicinyourhands");
        mediaPlayer = MediaPlayer.create(this, audioId);
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void dialogInstructions() {
        AlertDialog.Builder instructionDialog = new AlertDialog.Builder(
                this, R.style.Theme_Light_Dialog_Alert);

        instructionDialog.create();

        instructionDialog.setIcon(R.drawable.ic_warning_red)
                .setTitle("ВНИМАНИЕ!")
                .setMessage(R.string.text_instruction_exercises)
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
                        mEditor.putBoolean("isAllowExercises", false).apply();
                    }
                });

        instructionDialog.show();

    }
}
