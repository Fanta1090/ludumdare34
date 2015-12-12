package objects;

import org.newdawn.slick.SlickException;

public class Carrot extends BasicObject {
  
  public Carrot() throws SlickException {
    super("resources/images/carrot-orange.png");
    this.setStartingPosition(150);
  }
}
