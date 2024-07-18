package assignment4;

import java.util.ArrayList;

/**
 * the star class is subclass from HeavenlyBody.
 */
public class Star extends HeavenlyBody {
  ArrayList<Planet> planetList = new ArrayList<>();

  /**
   * take value from superclass.
   *
   * @param name          the name of the moon
   * @param avgRadiusInKm the average radius of the moon in kilometers
   */
  public Star(String name, int avgRadiusInKm) {
    super(name, avgRadiusInKm);
    checkName(name);
    checkAvgRadiusInK(avgRadiusInKm);
  }

  /**
   * return string of name and there star value.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getName()).append(":").append(getAvgRadiusInKm() + "\n");
    for (HeavenlyBody planet : planetList) {
      sb.append(planet.toString());
    }
    return sb.toString();
  }

  /**
   * check the radius the this should be right and return exception if not correct.
   */
  @Override
  protected void checkAvgRadiusInK(int radius) {
    if (radius < 16700) {
      throw new IllegalArgumentException("Invalid Radius value.");
    }
  }

  /**
   * che name and it should be not null and empty.
   */
  @Override
  protected void checkName(String name) {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("Name must not be null or empty.");
    }
  }

  /**
   * add planet for each star and return the list.
   *
   * @param name name planet
   * @param avgRadiusInKm average radius
   * @param avgOrbitRadiusInKm orbit average radius
   */
  public Planet addPlanet(String name, int avgRadiusInKm, double avgOrbitRadiusInKm) {
    Planet newList = new Planet(name, avgRadiusInKm, avgOrbitRadiusInKm);
    if (avgOrbitRadiusInKm < 18000) {
      throw new IllegalArgumentException("The minimum orbit radius of a Planet is 18 000km,");
    }
    planetList.add(newList);
    return newList;
  }

  public ArrayList<Planet> getPlanets() {
    return new ArrayList<>(this.planetList);
  }

  /**
   * loop in the list and for each star and return.
   */
  public HeavenlyBody[] getHeavenlyBodies() {
    ArrayList<HeavenlyBody> list = new ArrayList<>();
    list.add(this);
    for (Planet moon : planetList) {
      list.add(moon);
      for (Moon m : moon.getMoons()) {
        list.add(m);
      }
    }
    HeavenlyBody[] result = new HeavenlyBody[list.size()];
    int counter = 0;
    for (HeavenlyBody h : list) {
      if (h instanceof Star) {
        Star pl = new Star(getName(), getAvgRadiusInKm());
        result[counter] = pl;
      } else if (h instanceof Moon) {
        double avg = ((Moon) h).getAvgOrbitRadiusInKm();
        Moon moon1 = new Moon(h.getName(), h.getAvgRadiusInKm(), avg);
        result[counter] = moon1;
      } else if (h instanceof Planet) {
        double avg1 = ((Planet) h).getAvgOrbitRadiusInKm();
        Planet planet1 = new Planet(h.getName(), h.getAvgRadiusInKm(), avg1);
        result[counter] = planet1;
      }
      counter++;
    }
    return result;
  }
  
  public void removePlanet(Planet planet) {
    planetList.remove(planet);
  }
}
