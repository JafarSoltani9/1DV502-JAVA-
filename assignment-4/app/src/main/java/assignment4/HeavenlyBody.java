package assignment4;

/**
 * This class is abstract and must be subclassed to represent specific types of
 * celestial bodies.
 */
public abstract class HeavenlyBody implements Comparable<HeavenlyBody> {
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
    setAvgRadiusInKm(avgRadiusInKm);
    setName(name);
  }

  /**
   * return object name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * set the name of object.
   *
   * @param name name
   */
  private void setName(String name) {
    checkName(name);
    this.name = name;
  }

  /**
   * return the average radius.
   */
  public int getAvgRadiusInKm() {
    return this.avgRadiusInKm;
  }

  /**
   * return the average of the radius.
   *
   * @param avgRadiusInKm average radius
   */
  private void setAvgRadiusInKm(int avgRadiusInKm) {
    checkAvgRadiusInK(avgRadiusInKm);
    this.avgRadiusInKm = avgRadiusInKm;
  }

  /**
   * return the index of the element in the ArrayList. 
   */  
  @Override
  public int compareTo(HeavenlyBody h) {
    if (this.avgRadiusInKm < h.avgRadiusInKm) {
      return -1;
    } else if (this.avgRadiusInKm > h.avgRadiusInKm) {
      return 1;
    } else {
      return 0;
    }
  }

  public abstract String toString();

  protected abstract void checkAvgRadiusInK(int radius);

  protected abstract void checkName(String name);
}
