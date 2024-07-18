package assignment4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * data manger class.
 */
public class DataManger {
  // List<SolarSystem> solarList = new ArrayList<>();

  /**
 * save data method.
 */
  public void saveData(List<SolarSystem> solarList, String filePath) throws IOException {
    try (PrintWriter printer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"))) {
      solarList.forEach(printer::print);
    } catch (IOException e) {
      throw new IOException("Unable to save the data into the file!");
    }
  }

  /**
   * Read list method.
   */
  public List<String> readFile(String path) throws Exception {
    if (!new File(path).exists()) {
      return new ArrayList<>();
    }
    return Files.readAllLines(Paths.get(path))
        .stream()
        .filter(str -> !str.trim().isEmpty())
        .collect(Collectors.toList());
  }

  /**
 * the extract data.
 */
  public void extractData(List<String> fileLines, List<SolarSystem> solarList) {
    solarList.clear();
    if (fileLines.isEmpty()) {
      return;
    }
    int i = 0;
    do {
      var starLine = fileLines.get(i++);
      List<String> planetLines = new ArrayList<>();
      while (i < fileLines.size() && fileLines.get(i).startsWith("-")) {
        planetLines.add(fileLines.get(i++));
      }
      var solarSystem = extractSolarInfo(starLine, planetLines);
      solarList.add(solarSystem);
    } while (i < fileLines.size());
  }

  /**
   * the solar system add.
   */
  private SolarSystem extractSolarInfo(String starLine, List<String> planetLines) {
    var starObj = extractStarInfo(starLine);
    SolarSystem solarSystem = new SolarSystem();
    if (planetLines.size() == 0) {
      solarSystem.setCentrStar(starObj);
      return solarSystem;
    }
    var i = 0;
    do {
      var planetLine = planetLines.get(i++);
      List<String> moonLines = new ArrayList<>();
      while (i < planetLines.size() && planetLines.get(i).startsWith("--")) {
        moonLines.add(planetLines.get(i++));
      }
      var planet = extractPlanetInfo(planetLine);
      var newPlanet = starObj.addPlanet(planet.getName(), planet.getAvgRadiusInKm(), planet.getAvgOrbitRadiusInKm());

      var moons = moonLines.stream().map(str -> extractMoonInfo(str)).collect(Collectors.toList());
      moons.stream().forEach(m -> newPlanet.addMoon(m.getName(), m.getAvgRadiusInKm(), m.getAvgOrbitRadiusInKm()));
    } while (i < planetLines.size());

    solarSystem.setCentrStar(starObj);
    return solarSystem;
  }

  /**
   * read star and add it.
   */
  private Star extractStarInfo(String starLine) {
    var starInfo = starLine.split(":");
    var starName = starInfo[0];
    var starRadius = starInfo[1];
    return new Star(starName, Integer.parseInt(starRadius));
  }

  /**
   * read planet and add it.
   */
  private Planet extractPlanetInfo(String planetLine) {
    var planetInfo = planetLine.split(":");
    var name = planetInfo[0].replace("-", "");
    var radius = planetInfo[1];
    var orbitRadius = planetInfo[2];
    return new Planet(name, Integer.parseInt(radius), Double.parseDouble(orbitRadius));
  }

  /**
   * read planet and add it.
   */
  private Moon extractMoonInfo(String moonLine) {
    var moonInfo = moonLine.split(":");
    var name = moonInfo[0].replace("--", "");
    ;
    var radius = moonInfo[1];
    var orbitRadius = moonInfo[2];
    return new Moon(name, Integer.parseInt(radius), Double.parseDouble(orbitRadius));
  }
}
