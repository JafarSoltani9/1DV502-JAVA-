package assignmenttwo.solitares;

/**
 * the planet class.
 */
public class Planet {
  private String name;
  private int avgRadiusInKm;

  /**
   * Constructs a new instance of the planet class with the given name and average radius in kilometers.
   *
   * @param name the name of the planet
   * @param avgRadiusInKm the average radius of the moon in kilometers
   */
  public Planet(String name, int avgRadiusInKm) {
    setName(name);
    setAvgRadiusInKm(avgRadiusInKm);
  }

  /**
   * return the name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * set name and check should not be null and empty.
   *
   * @param name name the planet
   */
  private void setName(String name) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name must not be null or empty");
    } else {
      this.name = name;
    }
  }

  /**
   * set the radius and check it.
   *
   * @param avgRadiusInKm the radius 
   */
  private void setAvgRadiusInKm(int avgRadiusInKm) {
    if (avgRadiusInKm < 2000 || avgRadiusInKm > 200000) {
      throw new IllegalArgumentException("Name must not be null or empty");
    } else {
      this.avgRadiusInKm = avgRadiusInKm;
    }
  }

  /**
   * retrun the average radius .
   */
  public int getAvgRadiusInKm() {
    return this.avgRadiusInKm;
  }

  /**
   * return the info planet.
   */
  @Override
  public String toString() {
    return "\tPlanet: " + getName() + ", average radius " + getAvgRadiusInKm() + " Km";
  }
}
