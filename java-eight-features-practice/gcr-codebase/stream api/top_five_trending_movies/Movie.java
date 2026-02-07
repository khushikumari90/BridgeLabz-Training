package top_five_trending_movies;
class Movie {
    String name;
    double rating;
    int releaseYear;

    Movie(String name, double rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return name + " (" + releaseYear + ") - Rating: " + rating;
    }
}

