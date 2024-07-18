package assignmenttwo.solitares;

/**
 * Star class.
 */
public class Star {
  private String name;
  private int avgRadiusInKm;


  /**
   * Constructs a new instance of the star class with the given name and average radius in kilometers.
   *
   * @param name the name of the star
   * @param avgRadiusInKm the average radius of the star in kilometers
   */
  public Star(String name, int avgRadiusInKm) {
    setName(name);
    setAvgRadiusinKm(avgRadiusInKm);
  }

  /**
   * set the name of star and check, ot empty or null.
   *
   * @param name star name
   */
  private void setName(String name) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name must not be empty!");
    }
    this.name = name;
  }

  /**
   * return the star name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * return the star radius.
   */
  public int getAvgRadiusInKm() {
    return this.avgRadiusInKm;
  }

  /**
   * set and check the radius.
   *
   * @param avgRadiusinKm star radius
   */
  private void setAvgRadiusinKm(int avgRadiusinKm) {
    if (avgRadiusinKm < 16700) {
      throw new IllegalArgumentException("Size cannot be smaller than 16700 km");
    } 
    this.avgRadiusInKm = avgRadiusinKm;
  }

  /*
   * return string and print star information.
   */
  @Override
  public String toString() {
    return ("Star: " + getName() + ", average radius " + getAvgRadiusInKm() + " Km");
  }
}