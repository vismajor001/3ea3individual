import java.io.*;
import java.util.Random;
import java.text.*;


public class CreateRandom {

  public static void main(String[] args) {
    try {
      File t = new File("data/savedData.txt");
      BufferedWriter br = new BufferedWriter(new FileWriter(t));
      
      String[] data = new String[100];
      
      String[] item = {"weapon", "potion", "hemlet", "loot box", "material", "armor", "costumes"};
      int[] year = {2018, 2018, 2018};
      String[] name = {"batman", "superman", "spiderman", "ironman"};

      
      Random description = new Random();
      Random amount = new Random();
      Random datey = new Random();
      Random datem = new Random();
      Random dated = new Random();
      Random user = new Random();
      
      for(int i = 0; i < 100; i++) {

        double d2 = amount.nextDouble() * 1000;
        d2 = Double.parseDouble(new DecimalFormat("#.00").format(d2));
        data[i] = data[i] + d2;
        int d1 = description.nextInt(7);
        data[i] = data[i] + "," + item[d1];
        
        
        
        String temp = "";
        temp = temp + year[datey.nextInt(3)];
        int month = datem.nextInt(12) + 1;
        if(month < 10)
          temp = temp + "-0" + month;
        else
          temp = temp + "-" + month;
        switch(month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12: 
          int dt1 = dated.nextInt(31) + 1;
          if(dt1 < 10)
            temp = temp + "-0" + dt1;
          else
            temp = temp + "-" + dt1;
          break;
        case 2:   // for simplification
        case 4:
        case 6:
        case 9:
        case 11: 
          int dt2 = dated.nextInt(30) + 1;
          if(dt2 < 10)
            temp = temp + "-0" + dt2;
          else
            temp = temp + "-" + dt2;
        }
        data[i] = data[i] + "," + temp;
        data[i] = data[i] + "," + name[user.nextInt(4)];
        br.write(data[i].substring(4, data[i].length()) + "\n");
      }
      

      br.close();

    } catch (Exception e) {
      System.out.println("error");
    }

  }

}
