package assignmentone;

  /**
   * generator class.
   */
public class AlbumGenerator {

  /**
   * set in the array and return.
   */
  public Album[] generateAlbums() {
    Album[] albums = new Album[4];

    albums[0] = new Album("Dark Side of the Moon", 1973, "Pink Floyd");
    albums[1] = new Album("Wish You Were Here", 1975, "Pink Floyd");
    albums[2] = new Album("Animals", 1977, "Pink Floyd");
    albums[3] = new Album("The Wall", 1979, "Pink Floyd");

    return albums;
  }
}
