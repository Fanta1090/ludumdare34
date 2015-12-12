package game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BackgroundDrawer {

  private Image back;
  private int move;
  private float speed = 0.1f;

  public BackgroundDrawer(String imageSrc) throws SlickException {
    back = new Image(imageSrc);
  }

  public void render(Graphics graphics) {
    graphics.drawImage(back, -move, 0);
    graphics.drawImage(back, -move + back.getWidth(), 0);
  }

  public void update(int delta) {
    move += speed * delta;
    if (move > back.getWidth())
      move = 0;
  }

  public void setSpeed(float speed) {
    this.speed = speed;
  }

  public float getSpeed() {
    return speed;
  }

}
