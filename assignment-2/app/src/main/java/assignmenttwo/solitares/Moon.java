package assignmenttwo.solitares;

/**
 * the moon class.
 */
public class Moon {
  private String name;
  private int avgRadiusInKm;

  /**
   * Constructs a new instance of the Moon class with the given name and average radius in kilometers.
   *
   * @param name the name of the moon
   * @param avgRadiusInKm the average radius of the moon in kilometers
   */
  public Moon(String name, int avgRadiusInKm) {
    setName(name);
    setavgRadiusInKm(avgRadiusInKm);
  }

  /**
   * return the name.
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * check the name and is should not be null and empty.
   *
   * @param name name of the moon
   */
  private void setName(String name) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name must not be empty!");
    } else {
      this.name = name;
    }
  }

  /**
   * return the average radius.
   */
  public int getAvgRadiusInKm() {
    return this.avgRadiusInKm;
  }

  /**
   * set the radius and check it.
   *
   * @param avgRadiusInKm average radius
   */
  private void setavgRadiusInKm(int avgRadiusInKm) {
    if (avgRadiusInKm < 6 || avgRadiusInKm > 10000) {
      throw new IllegalArgumentException("Size cannot be smaller than 16700 km");
    } else {
      this.avgRadiusInKm = avgRadiusInKm;
    }
  }

  /**
   * return the string name and radius the moon.
   */
  @Override
  public String toString() {
    return "\tMoon: " + getName() + ", average radius " + getAvgRadiusInKm() + "km";
  }
}
