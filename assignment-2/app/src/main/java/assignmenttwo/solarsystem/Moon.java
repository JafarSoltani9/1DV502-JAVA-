package assignmenttwo.solarsystem;

/**
 * moon child class from heavenlyBody.
 */
public class Moon extends HeavenlyBody {
  private double avgOrbitRadiusInKm;

  /**
   * Constructor of the Moon object and tke value from subclass.
   *
   * @param name name of the object
   * @param avgRadiusInKm average radius
   * @param avgOrbitRadiusInKm average of the orbit radisu
   */
  public Moon(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    super(name, avgRadiusInKm);
    setAvgOrbitRadiusInKm(avgOrbitRadiusInKm);
  }

  /**
   * return the orbit of the average radius.
   */
  public double getAvgOrbitRadiusInKm() {
    return this.avgOrbitRadiusInKm;
  }

  /**
   * set the orbit radius  and check it.
   *
   * @param avgOrbitRadiusInKm the orbit average radius
   */
  public void setAvgOrbitRadiusInKm(double avgOrbitRadiusInKm) {
    if (avgOrbitRadiusInKm < 60) {
      throw new IllegalArgumentException("The radius is to small");
    } else {
      this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
    }
  }
  
  /**
   * return string Moon object with name and radius and orbit radius.
   */
  @Override
  public String toString() {
    return "Moon: " + getName() + ", average radius " + getAvgRadiusInKm() + "km, average orbit radius "
        + getAvgOrbitRadiusInKm() + "km";
  }

  /**
   * che the radius and return it.
   */
  @Override
  protected void checkAvgRadiusInK(int radius) {
    if (radius < 6 || radius > 10000) {
      throw new IllegalArgumentException("Invalid Radius value.");
    }
  }

  /**
   * in the method check at name be not empty or null.
   */  
  @Override
  protected void checkName(String name) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name must not be null or empty.");
    }

  }

}
