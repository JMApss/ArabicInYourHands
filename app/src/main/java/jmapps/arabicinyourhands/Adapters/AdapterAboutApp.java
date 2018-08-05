package jmapps.arabicinyourhands.Adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jmapps.arabicinyourhands.Models.ModelAboutApp;
import jmapps.arabicinyourhands.R;
import jmapps.arabicinyourhands.ViewHolders.HolderAboutApp;

public class AdapterAboutApp extends RecyclerView.Adapter<HolderAboutApp> {

    private final List<ModelAboutApp> mModelAboutApp;

    public AdapterAboutApp(List<ModelAboutApp> modelAboutApp) {
        this.mModelAboutApp = modelAboutApp;
    }

    @NonNull
    @Override
    public HolderAboutApp onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.about_app_item, parent, false);
        return new HolderAboutApp(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderAboutApp holder, @SuppressLint("RecyclerView") final int position) {
        int pathPicture = mModelAboutApp.get(position).getPictureApp();
        String strItemName = mModelAboutApp.get(position).getNameApp();

        holder.imIconAboutApp.setBackgroundResource(pathPicture);
        holder.tvNameAboutApp.setMovementMethod(LinkMovementMethod.getInstance());
        holder.tvNameAboutApp.setText(strItemName);
    }

    @Override
    public int getItemCount() {
        return mModelAboutApp.size();
    }
}
