package objects;

import org.newdawn.slick.SlickException;

public class Cheese extends BasicObject {

  public Cheese() throws SlickException {
    super("resources/images/fromage-orange.png");
    this.setStartingPosition(275);
    
    System.out.println("Cheese created");
  }

}
