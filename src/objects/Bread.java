package objects;

import org.newdawn.slick.SlickException;

public class Bread extends BasicObject {

  public Bread(int y) throws SlickException {
    super("resources/images/pain-vert.png", y);
    this.setStartingPosition(1740);
    
    System.out.println("Bread created");
  }

}
