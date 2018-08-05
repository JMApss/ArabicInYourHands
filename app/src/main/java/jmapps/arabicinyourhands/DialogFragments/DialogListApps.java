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

import jmapps.arabicinyourhands.Adapters.AdapterListApps;
import jmapps.arabicinyourhands.R;

import static jmapps.arabicinyourhands.Models.ModelListApps.listAppsContent;

public class DialogListApps extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootListApps = inflater.inflate(R.layout.fragment_list_apps, container, false);

        setRetainInstance(true);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        RecyclerView rvListApps = rootListApps.findViewById(R.id.rv_list_apps);
        rvListApps.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvListApps.setAdapter(new AdapterListApps(Arrays.asList(listAppsContent)));

        return rootListApps;
    }
}
