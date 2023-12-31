package com.moutamid.calenderapp.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moutamid.calenderapp.R;
import com.moutamid.calenderapp.models.ChatsModel;

import java.util.ArrayList;

public class MediaPagerAdapter extends RecyclerView.Adapter<MediaPagerAdapter.MediaVH> {
    private Context context;
    private ArrayList<ChatsModel> list;
    ProgressDialog progressDialog;
    public static MediaController mediaController;
    public MediaPagerAdapter(Context context, ArrayList<ChatsModel> list) {
        this.context = context;
        this.list = list;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Media is Loading...");
        progressDialog.setCancelable(false);
        mediaController = new MediaController(context);
    }

    @NonNull
    @Override
    public MediaVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MediaVH(LayoutInflater.from(context).inflate(R.layout.pager, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MediaVH holder, int position) {
        ChatsModel model = list.get(holder.getAdapterPosition());

        boolean isImage = model.getType().equals("img");
        if (isImage) {
            if (holder.videoView.isPlaying()) {
                holder.videoView.pause();
                holder.videoView.stopPlayback();
            }
            holder.videoView.setVisibility(View.GONE);
        } else {
            holder.imageView.setVisibility(View.GONE);
        }

        if (isImage) {
            Glide.with(context).load(model.getMessage()).placeholder(R.color.black).into(holder.imageView);
        } else {
            progressDialog.show();
            mediaController.setAnchorView(holder.videoView);
            mediaController.setMediaPlayer(holder.videoView);
            holder.videoView.setVideoPath(model.getMessage());
            holder.videoView.setMediaController(mediaController);
            holder.videoView.start();
            holder.videoView.setOnPreparedListener(mp -> {
                progressDialog.dismiss();
                mediaController.show();
            });
            holder.videoView.setOnCompletionListener(mp -> {
                holder.videoView.start();
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MediaVH extends RecyclerView.ViewHolder {
        ImageView imageView;
        VideoView videoView;

        public MediaVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            videoView = itemView.findViewById(R.id.videoView);
        }
    }

}
