package sample;

public class ConsoleGame extends ElectronicGame {
  private String  Genre;
  private String  Developer;
  private String  Publisher;

    public ConsoleGame(int releaseDate, String gameTitle, int amountSold,String  Genre, String  Developer,String  Publisher) {
        super(releaseDate, gameTitle, amountSold);

        this.Genre = Genre;
        this.Developer = Developer;
        this.Publisher = Publisher;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDeveloper() {
        return Developer;
    }

    public void setDeveloper(String developer) {
        Developer = developer;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String toString() {
        String description = "\""  + this.getGameTitle();
        description = description + " Was released in " + this.getReleaseDate();
        description = description + " It sold" +" "+ this.getAmountSold() +" "+ "copies.";
        description = description + "The Genre was" + this.getGenre();
        description = description + this.getDeveloper()+ " developed the game";
        description = description + "The Publisher was" + this.getPublisher();
        return description;
    }
}
