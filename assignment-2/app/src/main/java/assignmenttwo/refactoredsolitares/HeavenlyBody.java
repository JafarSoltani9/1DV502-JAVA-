package assignmenttwo.refactoredsolitares;

/**
 * This class is abstract and must be subclassed to represent specific types of
 * celestial bodies.
 */
public abstract class HeavenlyBody {
  private String name;
  private int avgRadiusInKm;

  /**
   * Constructs a new HeavenlyBody object with the given name and average radius
   * in kilometers.
   *
   * @param name   object name.
   * @param radius object average radius
   */
  protected HeavenlyBody(String name, int avgRadiusInKm) {
    setName(name);
    setAvgRadiusInKm(avgRadiusInKm);
  }

  /**
   * Sets the name of the object.
   *
   * @param name the new name for the object
   */
  private void setName(String name) {
    this.name = name;
    checkName(name);
  }

  /**
   * return the name of object name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the average radius of the celestial body in kilometers.
   *
   * @param avgRadiusInKm the new average radius in kilometers
   */
  private void setAvgRadiusInKm(int avgRadiusInKm) {
    checkAvgRadiusInK(avgRadiusInKm);
    this.avgRadiusInKm = avgRadiusInKm;
  }

  /**
   * the average radius of the object in kilometers.
   */
  public int getAvgRadiusInKm() {
    return avgRadiusInKm;
  }

  protected abstract void checkAvgRadiusInK(int radius);

  protected abstract void checkName(String name);

  public abstract String toString();

}
