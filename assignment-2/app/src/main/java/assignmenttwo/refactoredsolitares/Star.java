package assignmenttwo.refactoredsolitares;

/**
 * the star class is subclass from HeavenlyBody.
 */
public class Star extends HeavenlyBody {

  /**
   * take the value from superclass.
   *
   * @param name          the name of the moon
   * @param avgRadiusInKm the average radius of the moon in kilometers
   */
  public Star(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
    checkAvgRadiusInK(avgRadiusInKm);
  }

  /**
   * Overrides the checkAvgRadiusInK method in the CelestialBody class to validate
   * the input average radius
   * of a celestial body in kilometers.
   *
   * @param avgRadiusInKm the average radius of the celestial body in kilometers
   *                      to be validated
   */
  @Override
  protected void checkAvgRadiusInK(int avgRadiusInKm) {
    if (avgRadiusInKm < 16700) {
      throw new IllegalArgumentException("Invalid Radius value.");
    }
  }

  /**
   * check the name be not null or empty.
   *
   * @param name the name of the celestial body to
   */
  @Override
  protected void checkName(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name must not be null or empty.");
    }

  }

  /**
   * Returns a string representation of the Moon object, including its name and
   * average radius in kilometers.
   */
  @Override
  public String toString() {
    return "\tStar: " + getName() + ", average radius " + getAvgRadiusInKm() + "km";
  }

}
