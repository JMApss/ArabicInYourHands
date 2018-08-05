package jmapps.arabicinyourhands.DialogFragments;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import java.util.Arrays;

import jmapps.arabicinyourhands.Adapters.AdapterAboutApp;
import jmapps.arabicinyourhands.R;

import static jmapps.arabicinyourhands.Models.ModelAboutApp.aboutAppContent;

public class DialogAboutApp extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootAboutApp = inflater.inflate(R.layout.fragment_about_app, container, false);

        setRetainInstance(true);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        RecyclerView rvListApps = rootAboutApp.findViewById(R.id.rv_about_app);
        rvListApps.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvListApps.setAdapter(new AdapterAboutApp(Arrays.asList(aboutAppContent)));

        return rootAboutApp;
    }
}
