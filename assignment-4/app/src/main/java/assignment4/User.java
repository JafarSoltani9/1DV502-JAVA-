package assignment4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


/**
 * the user class.
 */
public class User {
  List<SolarSystem> solarList = new ArrayList<>();
  private String filePath = "solarSystems.data";
  Scanner scan = new Scanner(System.in, "UTF-8");
  DataManger data = new DataManger();
  SystemManger system = new SystemManger();

  /**
   * start and show menu method.
   */
  public void startMenu() throws Exception {

    if (solarList.isEmpty()) {
      var fileContent = data.readFile(filePath);
      data.extractData(fileContent, solarList);
    }
    while (true) {
      showMenu();
      String choice = scan.next();
      switch (choice) {
        case "1":
          if (solarList.isEmpty()) {
            System.out.println("Data is empty.");
          } else {
            system.listSystem(solarList);
          }
          break;
        case "2":
          system.createSystem(solarList);
          break;
        case "3":
          if (solarList.isEmpty()) {
            System.out.println("Data is empty.");
          } else {
            system.modify(solarList);
          }
          break;
        case "4":
          data.saveData(solarList, filePath);
          System.out.println("Saved.");
          break;
        case "5":
          System.exit(0);
          break;
        default:
          System.out.println("wrong input");

      }
    }
  }

  private void showMenu() {
    System.out.println("1- List system: ");
    System.out.println("2- Add solarSystem: ");
    System.out.println("3- Modify: ");
    System.out.println("4- Save: ");
    System.out.println("5- Quit ");
  }


}