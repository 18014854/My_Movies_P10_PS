package sg.edu.rp.c346.id18014854.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovies);

        alMovieList = new ArrayList<>();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2014, 11, 15);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2015, 5, 15);
        Calendar calendar3 = Calendar.getInstance();

        Movie movie1 = new Movie("The Avengers", 2012, "pg13", "Action | Sci-Fi", calendar1, "Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.", 4);
        Movie movie2 = new Movie("Planes", 2013, "pg", "Animation | Comedy", calendar2, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.", 2);
        Movie movie3 = new Movie("Sonic the Hedgehog", 2020, "pg", "Action | Adventure | Comedy", calendar3, "Location", "Fast", 3);

        alMovieList.add(movie1);
        alMovieList.add(movie2);
        alMovieList.add(movie3);

        caMovie = new CustomAdapter(this, R.layout.row, alMovieList);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movieSelected = alMovieList.get(position);
                String title = movieSelected.getTitle();
                int year = movieSelected.getYear();
                String rated = movieSelected.getRated();
                String genre = movieSelected.getGenre();
                String description = movieSelected.getDescription();
                Calendar watchOn = movieSelected.getWatched_on();
                String inTheatre = movieSelected.getIn_theatre();
                int ratingStar = movieSelected.getRating();
                String createdAsString = watchOn.get(Calendar.DATE) + "/" + (watchOn.get(Calendar.MONTH) + 1) + "/" + watchOn.get(Calendar.YEAR);

                Intent intent = new Intent(MainActivity.this, ShowInfomation.class);
                intent.putExtra("titlePassing", title);
                intent.putExtra("yearPassing", year);
                intent.putExtra("ratedPassing", rated);
                intent.putExtra("genrePassing", genre);
                intent.putExtra("descriptionPassing", description);
                intent.putExtra("watchOnPassing", createdAsString);
                intent.putExtra("inTheatrePassing", inTheatre);
                intent.putExtra("ratingPassing", ratingStar);
                startActivity(intent);
            }
        });
    }
}
