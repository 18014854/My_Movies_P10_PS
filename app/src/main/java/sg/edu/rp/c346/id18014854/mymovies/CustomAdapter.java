package sg.edu.rp.c346.id18014854.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> moviesList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects){
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        moviesList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYearGenre = rowView.findViewById(R.id.textViewYearGenre);
        ImageView ivRating = rowView.findViewById(R.id.imageViewRating);

        // Obtain the Android Version information based on the position
        Movie currentMovie = moviesList.get(position);

        // Set values to display the corresponding information
        if (currentMovie.getRated().equals("g")){
            ivRating.setImageResource(R.drawable.rating_g);
        } else if (currentMovie.getRated().equals("pg")){
            ivRating.setImageResource(R.drawable.rating_pg);
        } else if (currentMovie.getRated().equals("pg13")){
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if (currentMovie.getRated().equals("nc16")) {
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if (currentMovie.getRated().equals("m18")){
            ivRating.setImageResource(R.drawable.rating_m18);
        } else if (currentMovie.getRated().equals("r21")){
            ivRating.setImageResource(R.drawable.rating_r21);
        }
        tvTitle.setText(currentMovie.getTitle());
        tvYearGenre.setText(currentMovie.getYear() + " - " + currentMovie.getGenre());

        if(currentMovie.getYear() == 2020){
            tvTitle.setTextColor(Integer.parseInt("@android:color/holo_red_dark"));
        }

        return rowView;
    }
}
