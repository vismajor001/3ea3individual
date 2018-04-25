package Control.MainPanel;

import Model.Transaction;

public class Search {

  // return the index of the key in the sorted array a[]; -1 if not found
  public static Transaction[] search(String[] keys, Transaction[] a, String sortOrder) {
    //keys are in this order: [amount,description,date,user]
    int hi=0;
    for (Transaction i:a) if (i!=null) hi++;
    if (sortOrder==null) return sequentialSearch(keys,a);
    switch (sortOrder){
      case "amount":
        if (keys[0]==null) return sequentialSearch(keys,a);
        else return binarySearch(keys, a, 0, hi,sortOrder); 
        
      case "description":
        if (keys[1]==null) return sequentialSearch(keys,a);
        else return binarySearch(keys, a, 0, hi,sortOrder); 
        
      case "date":
        if (keys[2]==null) return sequentialSearch(keys,a);
        else return binarySearch(keys, a, 0, hi,sortOrder); 
  case "user":
        if (keys[3]==null) return sequentialSearch(keys,a);
        else return binarySearch(keys, a, 0, hi,sortOrder);
      default: 
        return sequentialSearch(keys,a);
      }
  }
  private static Transaction[] sequentialSearch(String[] keys, Transaction[] a) {
  // TODO Auto-generated method stub
    Transaction[] result=new Transaction[a.length];
  for (Transaction i:a){
    //if amount is an integer, show all transactions within amount~amount+1
    if(i!=null && isValid(i,keys)) append(result,i);
  }
  return result;
}
private static Transaction[] binarySearch(String[] keys, Transaction[] a, int lo, int hi, String sortOrder) {
      // possible key indices in [lo, hi)
    Transaction[] result=new Transaction[a.length];
      if (hi <= lo) return result;
      int mid = lo + (hi - lo) / 2;
      float cmp=compare(a[mid],keys,sortOrder);
      if      (cmp > 0) return binarySearch(keys, a, lo, mid,sortOrder);
      else if (cmp < 0) return binarySearch(keys, a, mid+1, hi,sortOrder);
      else {
        //we found one of those elements, check the adjacent ones to see if they also match
        for (int i=mid-1;i>=0;i--){
          if (a[i]!=null &&compare(a[i],keys,sortOrder)==0){
            if(isValid(a[i],keys)){
              
              append(result,a[i]);
            }
          }
          else break;
        }
        if (isValid(a[mid],keys))append(result,a[mid]);
        
        for (int i=mid+1;i<a.length;i++){
          if (a[i]!=null && compare(a[i],keys,sortOrder)==0){
            if(isValid(a[i],keys)){

              append(result,a[i]);
            }
          }
          else break;
        }
        
        return result;
      }
  }
private static float compare(Transaction a,String[] keys,String sortOrder){
  float cmp=0;
  switch (sortOrder){
      case "amount":
        cmp=(a.getAmount()-Float.parseFloat(keys[0]));
        if (0<=cmp && cmp<1) cmp=0;
        break;
      case "description":
        cmp=a.getDescription().compareTo(keys[1]);
        break;
      case "date":
        cmp=a.getDate().compareTo(keys[2]);
        break;
      case "user":
        cmp=a.getUser().compareTo(keys[3]);
      }
  return cmp;
}
  private static void append(Transaction[] k,Transaction a){
  //look for the first null entry   
  int count=0;
  for (Transaction i:k){
    if (i==null) {
      k[count]=a;
      break;
    }
    else count++;
  }
}
  private static boolean isValid(Transaction i,String[] keys){
    boolean hasAmount=(keys[0]!=null);
    boolean hasDescription=(keys[1]!=null);
    boolean hasDate=(keys[2]!=null);
    boolean hasUser=(keys[3]!=null);
    float amount=.0f;
    if (hasAmount) amount=Float.parseFloat(keys[0]);
    //if amount is an integer, show all transactions within amount~amount+1
    if (!hasAmount || amount==(int) amount){
      if (!hasAmount || (0<=i.getAmount()-amount && i.getAmount()-amount<1)){
        //then, check the description
        if (!hasDescription || i.getDescription().startsWith(keys[1])){
          //next, check the date
          if (!hasDate || i.getDate().contains(keys[2])){
            //at last, check the user
            if (!hasUser || i.getUser().contains(keys[3])){
              //if everything passes, append the element to the result list
              return true;
            }
          }
        }
      }
    }
    else{
      //otherwise, check for the exact amount
      if (i.getAmount()==amount){
        if (!hasDescription || i.getDescription().startsWith(keys[1])){
          //next, check the date
          if (!hasDate || i.getDate().contains(keys[2])){
            //at last, check the user
            if (!hasUser || i.getUser().contains(keys[3])){
              //if everything passes, append the element to the result list
              return true;
            }
          }
        }
      }
    }
  return false;
  }

}