package objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import utils.RandomGenerator;

public class BasicObject {

  private Image object;
  private int position = 350;
  private float speed = 0.1f;
  private int y;

  public BasicObject(String imgSrc, int y) throws SlickException {
    object = new Image(imgSrc);
    position = 1250;
    this.y = y;
  }
  
  public void render(Graphics graphics) {
    graphics.drawImage(object, position, y-object.getHeight());
  }

  public void update(int delta) {
    position -= speed * delta;
    if(position < 0-object.getWidth()) {
      position = RandomGenerator.getRandomNumber(1250, 2000);
    }
  }
  
  public void setStartingPosition(int pos) {
    this.position = pos;
  }
  
  public int getStartingPosition() {
    return position;
  }
}
