package fr.takiu.tpyoutube.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import fr.takiu.tpyoutube.R;
import fr.takiu.tpyoutube.activity.VideoInfoActivity;
import fr.takiu.tpyoutube.model.YoutubeVideo;

/**
 * Created by paulu_000 on 26/02/2016.
 */
public class YoutubeVideoAdapter  extends RecyclerView.Adapter<YoutubeVideoAdapter.ViewHolder>{

    public List<YoutubeVideo> list;
    private Context context;

    public YoutubeVideoAdapter(List<YoutubeVideo> list,Context context ) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.video_item, parent, false);
        YoutubeVideoAdapter.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String url =list.get(position).snippet.thumbnails.defaut.url;
        Glide
            .with(context)
            .load(url)
            .centerCrop()
            .crossFade()
            .into(holder.ivVideo);
        //TODO verifier que ça marche l'image
        holder.tvVideoName.setText(list.get(position).snippet.title);
        holder.tvVideo.setText( list.get(position).snippet.description);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tvVideo;
        public ImageView ivVideo;
        public TextView tvVideoName;

        public ViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            tvVideo = (TextView)itemView.findViewById(R.id.tv_video);
            ivVideo = (ImageView)itemView.findViewById(R.id.iv_video);
            tvVideoName = (TextView) itemView.findViewById(R.id.tv_video_name);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(v.getContext(), VideoInfoActivity.class);
            i.putExtra("video", list.get(getAdapterPosition()));
            v.getContext().startActivity(i);
        }
    }

}
