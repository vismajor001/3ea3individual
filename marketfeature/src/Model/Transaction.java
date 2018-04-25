package Model;

public class Transaction {
  private float amount;
  private String description;
  private String date;
  private String user;
  
  public Transaction(float amount,String description,String date,String user){
    this.amount=amount;
    this.description=description;
    this.date=date;
    this.user=user;
  }
  
  public float getAmount(){
    return amount;
  }
  public String getDescription(){
    return description;
  }
  public String getDate(){
    return date;
  }
  public String getUser(){
    return user;
  }
  public String toString(){
    return ""+amount+","+description+","+date+","+user;
  }
  
  public int compareByAmount(Transaction other){
    return (int) (amount-other.getAmount());
  }
  public int compareDescription(Transaction other){
    return description.compareTo(other.getDescription());
  }
  public int compareByDate(Transaction other){
    return date.compareTo(other.getDate());
  }
  public int compareByUser(Transaction other){
    return user.compareTo(other.getUser());
  }
  

  
  
  
}
