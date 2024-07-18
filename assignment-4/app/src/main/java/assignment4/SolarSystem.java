package assignment4;

/**
 * the solar center class.
 */
public class SolarSystem {

  private Star centrStar;

  public Star getCentrStar() {
    return centrStar;
  }

  public void setCentrStar(Star centrStar) {
    this.centrStar = centrStar;
  }

  /**
   * return string of Solar system.
   */
  @Override
  public String toString() {
    return centrStar.toString();
  }
}
