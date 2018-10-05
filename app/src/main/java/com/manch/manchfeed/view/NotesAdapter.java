package com.manch.manchfeed.view;

/**
 * Created by ravi on 20/02/18.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.manch.manchfeed.R;
import com.manch.manchfeed.database.model.Note;
import com.manch.manchfeed.utils.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private Context context;
    private List<Note> notesList;
    Utilities utilities = new Utilities();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView note, noteDescription;
        public TextView dot;
        public TextView timestamp;
        public ImageView noteImage;

        public MyViewHolder(View view) {
            super(view);
            note = view.findViewById(R.id.note);
            noteDescription = view.findViewById(R.id.note_description);
            dot = view.findViewById(R.id.dot);
            timestamp = view.findViewById(R.id.timestamp);
            noteImage = view.findViewById(R.id.note_image);
        }
    }


    public NotesAdapter(Context context, List<Note> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Note note = notesList.get(position);

        holder.note.setText(note.getNote());
        holder.noteDescription.setText(note.getNoteDescription());

        Bitmap bitmap = BitmapFactory.decodeFile(note.getNoteImage());
        bitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false);
        holder.noteImage.setImageBitmap(bitmap);

        // Displaying dot from HTML character code
        holder.dot.setText(Html.fromHtml("&#8226;"));

        // Formatting and displaying timestamp
        holder.timestamp.setText(utilities.formatDate(note.getTimestamp()));
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }
}
