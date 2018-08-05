package jmapps.arabicinyourhands;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

import jmapps.arabicinyourhands.Adapters.AdapterMainChapters;
import jmapps.arabicinyourhands.DBSetup.DBAssetHelper;
import jmapps.arabicinyourhands.DialogFragments.DialogAboutApp;
import jmapps.arabicinyourhands.DialogFragments.DialogListApps;
import jmapps.arabicinyourhands.DialogFragments.DialogSettings;

import static jmapps.arabicinyourhands.Models.ModelMainChapters.modelMainChapters;

public class MainChaptersActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    public static SharedPreferences mPreferences;
    public static SharedPreferences.Editor mEditor;

    public static SQLiteDatabase sqLiteDatabase;

    private DrawerLayout drawer;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        DBAssetHelper dbSetup = new DBAssetHelper(this);
        sqLiteDatabase = dbSetup.getReadableDatabase();

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        RecyclerView rvMainChapters = findViewById(R.id.rv_main_chapters);

        rvMainChapters.setLayoutManager(new LinearLayoutManager(this));
        rvMainChapters.setAdapter(new AdapterMainChapters(Arrays.asList(modelMainChapters)));

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_exit) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_settings) {
            DialogSettings dialogSettings = new DialogSettings();
            dialogSettings.show(getFragmentManager(), "settings");
        } else if (id == R.id.nav_list_apps) {
            DialogListApps dialogListApps = new DialogListApps();
            dialogListApps.show(getFragmentManager(), "list_apps");
        } else if (id == R.id.nav_about_app) {
            DialogAboutApp dialogAboutApp = new DialogAboutApp();
            dialogAboutApp.show(getFragmentManager(), "about_app");
        } else if (id == R.id.nav_about_us) {
            aboutUsDialog();
        } else if (id == R.id.nav_rate) {
            rateAppIntent();
        } else if (id == R.id.nav_share) {
            shareAppLink();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void aboutUsDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        @SuppressLint("InflateParams")
        View dialogAboutUs = inflater.inflate(R.layout.dialog_about_us, null);

        AlertDialog.Builder instructionDialog = new AlertDialog.Builder(this);

        instructionDialog.setView(dialogAboutUs);
        TextView tvAboutUsContent = dialogAboutUs.findViewById(R.id.tv_about_us_content);
        tvAboutUsContent.setText(R.string.about_us_text);
        tvAboutUsContent.setMovementMethod(LinkMovementMethod.getInstance());

        instructionDialog.setPositiveButton(
                R.string.positive_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        instructionDialog.create().show();
    }

    private void rateAppIntent() {
        String strAppLink = "https://play.google.com/store/apps/details?id=jmapps.arabicinyourhands";

        Intent rateApp = new Intent(Intent.ACTION_VIEW);
        rateApp.setData(Uri.parse(strAppLink));
        startActivity(rateApp);
    }

    private void shareAppLink() {
        String strAppLink = "https://play.google.com/store/apps/details?id=jmapps.arabicinyourhands";

        Intent shareLink = new Intent(Intent.ACTION_SEND);
        shareLink.setType("text/plain");
        shareLink.putExtra(Intent.EXTRA_TEXT, "Серия приложений для мусульман:\n" +
                "Арабский в твоих руках. Том 1\n" + strAppLink);
        startActivity(shareLink);
    }
}
