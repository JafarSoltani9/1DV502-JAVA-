package assignmentone;

/**
 *  Album class.
 */
public class Album {
  private String name;
  private int releaseYear;
  private String artist;

  /**
   *  constructor for album class and get 3 value.
   *
   * @param name name album
   * @param artist artist name
   * @param releaseYear year
   *
   */
  public Album(String name, int releaseYear, String artist) {
    setName(name);
    setArtist(artist);
    setYear(releaseYear);
  }

  /**
   *  return name in the method.
   */
  public String getName() {
    if (name == null || name.length() < 4) {
        return "No name";
    } else {
      return this.name;
    }
  }

  /**
   * setter for name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   *  return year in the method.
   */
  public int getYear() {
    if (releaseYear <= 1800 || releaseYear > 2029) {
      return -1;
    } else {
      return this.releaseYear;
    }
  }

  /**
   * setter year in the method.
   */
  public void setYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  /**
   *  return artist name in the method.
   */
  public String getArtist() {
    if (artist == null || artist.length() < 4) {
      return "No artist";
    } else {
      return this.artist;
    }
  }
  
  /**
   *  set name artist in the method.
   */
  public void setArtist(String artist) {
    this.artist = artist;
  }
}
