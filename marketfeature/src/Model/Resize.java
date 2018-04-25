package Model;

public class Resize {
  public static Transaction[] resizeArray(Transaction[] arr) {
      Transaction[] temp = new Transaction[2 * arr.length];
      for(int i = 0; i < arr.length; i++) {
        temp[i] = arr[i];
      
      }
      return temp;
    }
    
    
}
