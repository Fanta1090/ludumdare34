package game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BackgroundDrawer extends GameObject {

  private Image image;
  private float move;
  private float speed = 0.1f;

  public BackgroundDrawer(String imageSrc) throws SlickException {
    image = new Image(imageSrc);
  }

  public BackgroundDrawer(String imageSrc, int y) throws SlickException {
    this(imageSrc);
    this.y = y;
  }

  public BackgroundDrawer(String imageSrc, int y, int speed) throws SlickException {
    this(imageSrc, y);
    this.speed = speed;
  }

  public void render(Graphics graphics) {
    graphics.drawImage(image, x - move, y);
    graphics.drawImage(image, x - move + image.getWidth(), y);
  }

  public void update(int delta) {
    move += speed * delta;
    if (move > image.getWidth())
      move = 0;
  }

  public void setSpeed(float speed) {
    this.speed = speed;
  }

  public float getSpeed() {
    return speed;
  }

  public Image getImage() {
    return image;
  }
}
