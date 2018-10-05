package com.manch.manchfeed.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.manch.manchfeed.R;
import com.manch.manchfeed.database.DatabaseHelper;
import com.manch.manchfeed.database.model.Note;
import com.manch.manchfeed.utils.Utilities;

public class NoteDetails extends AppCompatActivity {

    private DatabaseHelper db;
    private TextView noteTitle, noteDescription, timestamp;
    private ImageView noteImage;
    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_detail_view);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        noteTitle = findViewById(R.id.note);
        noteDescription = findViewById(R.id.note_description);
        timestamp = findViewById(R.id.timestamp);
        noteImage = findViewById(R.id.note_image);


        db = new DatabaseHelper(this);

        if (getIntent().hasExtra("note_id")) {
            note = db.getNote(getIntent().getIntExtra("note_id", -1));
            SetData();
        } else {
            Toast.makeText(this, "Invalid Id", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void SetData() {
        Utilities utilities = new Utilities();

        noteTitle.setText(note.getNote());
        noteDescription.setText(note.getNoteDescription());

        Bitmap bitmap = BitmapFactory.decodeFile(note.getNoteImage());
        bitmap = Bitmap.createScaledBitmap(bitmap, 400, 400, false);
        noteImage.setImageBitmap(bitmap);

        // Formatting and displaying timestamp
        timestamp.setText("Created on: "+utilities.formatDate(note.getTimestamp()));
    }
}
