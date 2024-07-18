package assignmenttwo.refactoredsolitares;

/**
 * the planet class is subclass from HeavenlyBody.
 */
public class Planet extends HeavenlyBody {

  /**
   * take value from superclass.
   *
   * @param name          the name of the moon
   * @param avgRadiusInKm the average radius of the moon in kilometers
   */
  public Planet(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
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
    if (avgRadiusInKm < 2000 || avgRadiusInKm > 200000) {
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
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name must not be null or empty.");
    }

  }

  /**
   * Returns a string representation of the Moon object, including its name and
   * average radius in kilometers.
   */
  @Override
  public String toString() {
    return "\tPlanet: " + getName() + ", average radius " + getAvgRadiusInKm() + "km";
  }

}
