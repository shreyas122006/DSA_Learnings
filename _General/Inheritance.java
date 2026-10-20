public class Inheritance { // single inheritance // hierarchial // multilevel // multiple // hybrid
  public static void main(String[] args) {
    System.out.println("Main Method");
    animal obj = new animal();
    fish obj1 = new fish();
    shark obj2 = new shark();
  
  }
}
class animal {
  animal() {
    System.out.println("Animal Method");
  }
}
class fish extends animal{
  fish() {
    System.out.println("Fish Method");
  }
}
class shark extends fish {
  shark() {
    System.out.println("Shark Method");
  }
}