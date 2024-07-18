package assignment4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * the system manger class.
 */
public class SystemManger {
  Scanner scan = new Scanner(System.in, "UTF-8");
  // User user = new User();

  /**
   * Create system method.
   */
  public void createSystem(List<SolarSystem> solarList) {
    boolean exist = true;
    boolean backToStart = true;

    while (backToStart) {
      try {
        System.out.println("Write star name: ");
        String starName = scan.next().replace("\n", " ").trim();
        exist = checkName(starName, solarList);
        if (!exist) {

          System.out.println("Write star radius: ");
          int starRadius = scan.nextInt();
          Star newStar = new Star(starName, starRadius);

          System.out.println("Do you want add planet in the " + starName + " star? (yes/no)");
          String choice = scan.next();
          if (choice.equalsIgnoreCase("yes")) {
            Planet newPlanet = addPlanet(newStar);
          }
          SolarSystem solar = new SolarSystem();
          solar.setCentrStar(newStar);
          solarList.add(solar);
          // user.startMenu();
        } else {
          System.out.println("The star already exist");
        }
        break;
      } catch (Exception e) {
        System.out.println(e.getMessage());
        backToStart = false;
      }
    }
  }

  private Planet addPlanet(Star star) {
    Planet newPlanet = null;

    while (true) {
      try {

        System.out.println("Write planet name: ");
        String planetName = scan.next().replace("\n", " ").trim();

        System.out.println("write planet radius: (larger 2000 and smaller 200000)");
        int planetRadius = scan.nextInt();
        System.out.println("write planet orbit radius: (larger 18000)");
        double planetOrbit = scan.nextDouble();
        newPlanet = star.addPlanet(planetName, planetRadius, planetOrbit);
        System.out.println(planetName + " added to the " + star.getName());

        System.out.println("Do you want add moon in the " + planetName + " planet? (yes/no)");
        String choice = scan.next();
        if (choice.equalsIgnoreCase("yes")) {
          Moon newMoon = addMoon(newPlanet);
        }

        break;
      } catch (Exception e) {
        System.out.println("Invalid radius or orbit radius.");
      }
    }
    return newPlanet;
  }

  private Moon addMoon(Planet planet) {
    Moon moon = null;
    while (true) {
      try {
        System.out.println("Write moon name: ");
        String moonName = scan.next().replace("\n", " ").trim();
        System.out.println("Write moon radius: (larger 6 and smaller 10000)");
        int moonRadius = scan.nextInt();
        System.out.println("Write moon orbit radius: (larger 60)");
        double moonOrbit = scan.nextDouble();

        moon = planet.addMoon(moonName, moonRadius, moonOrbit);
        System.out.println(moonName + " added to the planet " + planet.getName());
        break;

      } catch (Exception e) {
        System.out.println("Invalid radius or orbit radius.");
      }
    }
    return moon;
  }

  /**
   * the modify method.
   */
  public void modify(List<SolarSystem> solarList) throws Exception {

    try {
      System.out.println("Enter the name of the star:");
      String starName = scan.next();
      SolarSystem newStar = getStar(starName, solarList);
      Star star = newStar.getCentrStar();

      System.out.println(newStar);
      System.out.println("1. Delete star.");
      System.out.println("2. Add planet to the star..");
      System.out.println("3. Delete a planet.");
      System.out.println("4. Edit planet");

      int choice = scan.nextInt();
      switch (choice) {
        case 1:
          solarList.removeAll(Collections.singleton(newStar));
          break;
        case 2:
          Planet newPlanet = addPlanet(star);
          System.out.println(newPlanet.getName() + " added.");
          break;
        case 3:
          System.out.println("Enter the name of the planet to delete:");
          String planetName = scan.next();
          boolean planetRemoved = false;
          for (Planet planet : newStar.getCentrStar().getPlanets()) {
            if (planet.getName().equals(planetName)) {
              newStar.getCentrStar().removePlanet(planet);
              planetRemoved = true;
              break;
            }
          }
          if (planetRemoved) {
            System.out.println("Planet " + planetName + " deleted from " + star.getName());
          } else {
            System.out.println("Planet not found.");
          }
          break;
        case 4:
          newStar.getCentrStar().planetList.forEach(System.out::print);
          System.out.println("Enter planet name:");
          String selectedPlanetName = scan.next();
          java.util.Optional<Planet> selectedPlanet = newStar.getCentrStar().planetList.stream()
              .filter(p -> p.getName().equalsIgnoreCase(selectedPlanetName)).findFirst();
          if (selectedPlanet.isEmpty()) {
            System.out.println("Planet not found");
            break;
          }

          System.out.println("1. Add moon.");
          System.out.println("2. Delete moon.");
          int choiceMoon = scan.nextInt();
          switch (choiceMoon) {
            case 1:
              addMoon(selectedPlanet.get());
              break;
            case 2:
              System.out.println("Enter moon name:");
              String selectedMoonName = scan.next();
              java.util.Optional<Moon> selectedMoon = selectedPlanet.get().moons.stream()
                  .filter(p -> p.getName().equalsIgnoreCase(selectedMoonName)).findFirst();
              if (selectedMoon.isEmpty()) {
                System.out.println("Moon not found");
                break;
              }
              selectedPlanet.get().moons.remove(selectedMoon.get());
              System.out.println("Moon deleted");
              break;
            default:
              System.out.println("wrong input");
          }
          break;
        default:
          System.out.println("Wrong input");
      }
    } catch (Exception e) {
      System.out.println("Invalid name" + e);
    }
  }

  /**
   * the try to list datann.
   */
  public void listSystem(List<SolarSystem> solarList) {
    while (true) {
      System.out.println("1.List all system");
      System.out.println("2.List by radius.");
      System.out.println("3.List by orbit radius.");
      String choice = scan.next();
      switch (choice.toLowerCase()) {
        case "1":
          solarList.forEach(System.out::print);
          break;
        case "2":
          System.out.println("List by radius");
          listByRadius(solarList);
          break;
        case "3":
          listByOrbit(solarList);
          System.out.println("list by orbit");
          break;
        default:
          System.out.println("Invalid choice");
      }
      break;
    }

  }

  /**
   * list by radius.
   */
  public void listByRadius(List<SolarSystem> solarList) {
    StringBuilder str = new StringBuilder();
    for (SolarSystem s : solarList) {
      s.getCentrStar().planetList.sort(Comparator.comparingInt(HeavenlyBody::getAvgRadiusInKm));
      str.append(s);
      // str.append(s.getCentrStar().getName() + ":"
      // + s.getCentrStar().getAvgRadiusInKm() + "\n");
      // Collections.sort(s.getCentrStar().getPlanets());
      // for (Planet planet : s.getCentrStar().getPlanets()) {
      // str.append(planet.getName() + ":" + planet.getAvgRadiusInKm()
      // + ":" + planet.getAvgOrbitRadiusInKm()+ "\n");
      // Collections.sort(planet.getMoons());
      // for (Moon moon : planet.getMoons()) {
      // str.append(moon.getName() + ":" + moon.getAvgRadiusInKm()
      // + ":" + moon.getAvgOrbitRadiusInKm()+ "\n");
      // }
      // }
    }
    System.out.println(str.toString());
  }

  /**
   * list by orbit radius.
   */
  public void listByOrbit(List<SolarSystem> solarList) {
    StringBuilder str = new StringBuilder();
    for (SolarSystem s : solarList) {
      s.getCentrStar().planetList.sort(Comparator.comparingDouble(Planet::getAvgOrbitRadiusInKm));
      str.append(s);
    }
    System.out.println(str.toString());
  }

  /**
   * check if star already exist.
   */
  public SolarSystem getStar(String name, List<SolarSystem> solarList) {
    for (SolarSystem s : solarList) {
      if (s.getCentrStar().getName().equalsIgnoreCase(name)) {
        return s;
      }
    }
    return null;
  }

  private boolean checkName(String name, List<SolarSystem> solarList) {
    return solarList.stream().anyMatch(s -> s.getCentrStar().getName().trim().equalsIgnoreCase(name.trim()));
  }
}
