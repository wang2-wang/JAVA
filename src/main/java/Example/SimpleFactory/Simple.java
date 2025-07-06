package Example.SimpleFactory;

public class Simple {
   public static Calculate createBean(String type){
       switch (type){
           case "Add":
               return new Add();
           case "Minus":
               return new Minus();
           default:
               return null;
       }
   }
}
