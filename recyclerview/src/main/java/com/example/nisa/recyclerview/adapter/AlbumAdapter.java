package com.example.nisa.recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nisa.recyclerview.R;
import com.example.nisa.recyclerview.model.Album;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<Album> mListAlbum;
    OnItemClickListener listener;

    public AlbumAdapter(Context context, ArrayList<Album> listAlbum, OnItemClickListener listener) {
        this.mContext = context;
        this.mListAlbum = listAlbum;
        this.listener = listener;
    }

//    public AlbumAdapter(Context context, ArrayList<Album> listAlbum) {
//        this.mContext = context;
//        this.mListAlbum = listAlbum;
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //view
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        return new AlbumAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //find view dan item
        final Album album = mListAlbum.get(position);
        holder.artistTV.setText(album.getArtist());
        holder.albumTV.setText(album.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClik(album);
            }
        });
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background);
        Glide.with(mContext).load(album.getImage()).apply(requestOptions).into(holder.albumIV);
    }

    @Override
    public int getItemCount() {
        //mwnghitung jumlah data
        return mListAlbum.size();
    }

    public interface OnItemClickListener {
        void onItemClik(Album album);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView albumIV;
        TextView albumTV, artistTV;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            albumIV = itemView.findViewById(R.id.album_imageview);
            albumTV = itemView.findViewById(R.id.album_textview);
            artistTV = itemView.findViewById(R.id.artis_textview);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
