package sample.spring.chapter15.com.hmkcode.spring.beans;

public class RootBean {

   private String name;

   public void setName(String name){
       this.name = name;
   }
   public String getName(){
       return this.name;
   }

    public String toString(){
         return getName();
    }
}
