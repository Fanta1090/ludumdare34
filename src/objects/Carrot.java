package objects;

import org.newdawn.slick.SlickException;

public class Carrot extends BasicObject {
  
  public Carrot(int y) throws SlickException {
    super("resources/images/carrot-orange.png", y);
    this.setStartingPosition(150);
    
    System.out.println("Carrot created");
  }
}
