package jmapps.arabicinyourhands.Adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jmapps.arabicinyourhands.Models.ModelListApps;
import jmapps.arabicinyourhands.R;
import jmapps.arabicinyourhands.ViewHolders.HolderListApps;

public class AdapterListApps extends RecyclerView.Adapter<HolderListApps> {

    private final List<ModelListApps> mModelListApps;

    public AdapterListApps(List<ModelListApps> modelListApps) {
        this.mModelListApps = modelListApps;
    }

    @NonNull
    @Override
    public HolderListApps onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_app_item, parent, false);
        return new HolderListApps(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderListApps holder, @SuppressLint("RecyclerView") final int position) {
        int pathPicture = mModelListApps.get(position).getPictureApp();
        String strAppName = mModelListApps.get(position).getNameApp();
        final String strAppLink = mModelListApps.get(position).getLinkApp();

        holder.imIconAppList.setBackgroundResource(pathPicture);
        holder.tvNameAppList.setText(strAppName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(strAppLink));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mModelListApps.size();
    }
}
