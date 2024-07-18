package assignmenttwo.solarsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * the planet class is subclass from HeavenlyBody.
 */
public class Planet extends HeavenlyBody {
  private double avgOrbitRadiusInKm;
  ArrayList<Moon> moons = new ArrayList<>();

  /**
   * in the constructor take value from subclass and en other.
   *
   * @param name          the name of the moon
   * @param avgRadiusInKm the average radius of the moon in kilometers
   */
  protected Planet(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    super(name, avgRadiusInKm);
    setAvgOrbitRadiusInKm(avgOrbitRadiusInKm);
  }

  /**
   * return the average orbit radius.
   */
  public double getAvgOrbitRadiusInKm() {
    return this.avgOrbitRadiusInKm;
  }

  /**
   * return string with planet name and planets moons.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Planet: " + getName() + ", average radius " + getAvgRadiusInKm() + "km, average orbit radius "
        + getAvgOrbitRadiusInKm() + "km\n");
    for (HeavenlyBody moon : moons) {
      sb.append("\t").append(moon.toString()).append("\n");
    }
    return sb.toString();
  }

  /**
   * check the radius is correct.
   */
  @Override
  protected void checkAvgRadiusInK(int radius) {
    if (radius < 2000 || radius > 200000) {
      throw new IllegalArgumentException("Invalid Radius value.");
    }
  }

  /**
   * check raduis is correct before set it.
   *
   * @param avgOrbitRadiusInKm orbit average radius
   */
  private void setAvgOrbitRadiusInKm(double avgOrbitRadiusInKm) {
    if (avgOrbitRadiusInKm < 18000) {
      throw new IllegalArgumentException("orbit radius to small");
    } else {
      this.avgOrbitRadiusInKm = avgOrbitRadiusInKm;
    }
  }

  /**
   * add the moon for each planet in the ArrayList.
   *
   * @param name name of the moon
   * @param avgRadiusInKm radius of the moon
   * @param avgOrbitRadiusInKm orbit radius of the moon
   */
  public Moon addMoon(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    Moon newMonn = new Moon(name, avgRadiusInKm, avgOrbitRadiusInKm);
    if (newMonn.getAvgRadiusInKm() <= getAvgRadiusInKm() / 2 && newMonn.getAvgOrbitRadiusInKm() >= 60) {
      moons.add(newMonn);
      return newMonn;
    } else {
      throw new IllegalArgumentException("Moon is to large");
    }
  }

  /**
   * check the name and return exception if name is not correct.
   */
  @Override
  protected void checkName(String name) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name must not be null or empty.");
    }
  }

  /**
   * take a copy of the list.
   */
  public List<Moon> getMoons() {
    return new ArrayList<>(moons);
  }

  /**
   * loop in the list and for each planets and return.
   */
  public HeavenlyBody[] getHeavenlyBodies() {
    ArrayList<HeavenlyBody> list = new ArrayList<>();
    list.add(this);

    for (Moon moon : moons) {
      list.add(moon);
    }
    HeavenlyBody[] result = new HeavenlyBody[moons.size() + 1];

    int counter = 0;
    for (HeavenlyBody h : list) {
      if (h instanceof Planet) {
        Planet pl = new Planet(getName(), getAvgRadiusInKm(), getAvgOrbitRadiusInKm());
        result[counter] = pl;
        
      } else if (h instanceof Moon) {
        double avg = ((Moon) h).getAvgOrbitRadiusInKm();
        Moon m = new Moon(h.getName(), h.getAvgRadiusInKm(), avg);
        result[counter] = m;
      }
      counter++;
    }

    return result;
  }

}
