package sg.edu.rp.c346.id18014854.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ShowInfomation extends AppCompatActivity {

    ImageView imageRating;
    TextView tvTitle;
    TextView tvYearGenre;
    TextView tvDescription;
    TextView tvWatchOn;
    TextView tvInTheatre;
    RatingBar rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_infomation);

        imageRating = findViewById(R.id.imageViewRating);
        tvTitle = findViewById(R.id.textViewTitle);
        tvYearGenre = findViewById(R.id.textViewYearGenre);
        tvDescription = findViewById(R.id.textViewDescription);
        tvWatchOn = findViewById(R.id.textViewWatchOn);
        tvInTheatre = findViewById(R.id.textViewInTheatre);
        rb = findViewById(R.id.ratingBar);

        Intent i = getIntent();
        String titleValue = i.getStringExtra("titlePassing");
        int yearValue = i.getIntExtra("yearPassing", 2020);
        String ratedValue = i.getStringExtra("ratedPassing");
        String genreValue = i.getStringExtra("genrePassing");
        String watchOnValue = i.getStringExtra("watchOnPassing");
        String inTheatreValue = i.getStringExtra("inTheatrePassing");
        String descriptionValue = i.getStringExtra("descriptionPassing");
        int ratingValue = i.getIntExtra("ratingPassing", -1);

        if (ratedValue.equals("g")){
            imageRating.setImageResource(R.drawable.rating_g);
        } else if (ratedValue.equals("pg")){
            imageRating.setImageResource(R.drawable.rating_pg);
        } else if (ratedValue.equals("pg13")){
            imageRating.setImageResource(R.drawable.rating_pg13);
        } else if (ratedValue.equals("nc16")) {
            imageRating.setImageResource(R.drawable.rating_nc16);
        } else if (ratedValue.equals("m18")){
            imageRating.setImageResource(R.drawable.rating_m18);
        } else if (ratedValue.equals("r21")){
            imageRating.setImageResource(R.drawable.rating_r21);
        }

        tvTitle.setText(titleValue);
        tvYearGenre.setText(yearValue + " - " + genreValue);
        tvDescription.setText(descriptionValue);
        tvWatchOn.setText("Watch on: " + watchOnValue);
        tvInTheatre.setText("In Theatre: " + inTheatreValue);
        rb.setRating(ratingValue);
    }
}
