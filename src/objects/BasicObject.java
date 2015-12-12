package objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import utils.RandomGenerator;

public class BasicObject {

  private Image object;
  private int position = 350;
  private float speed = 0.1f;

  public BasicObject(String imgSrc) throws SlickException {
    object = new Image(imgSrc);
    position = 350;
  }
  
  public void render(Graphics graphics) {
    graphics.drawImage(object, position, 420);
  }

  public void update(int delta) {
    position -= speed * delta;
    if(position < 0) {
      position = RandomGenerator.getRandomNumber(300, 2000);
    }
  }
  
  public void setStartingPosition(int pos) {
    this.position = pos;
  }
  
  public int getStartingPosition() {
    return position;
  }
}
