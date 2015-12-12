package objects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import game.GameObject;

public class Fireball extends GameObject {

  private float speed = 0.5f;
  Animation fireAnimation;

  public Fireball() throws SlickException {
    SpriteSheet spriteSheet = new SpriteSheet("resources/images/fireball.png", 64, 64);
    fireAnimation = new Animation(spriteSheet, 90);
    fireAnimation.setAutoUpdate(true);
    fireAnimation.setLooping(true);
    this.x = 100;
    this.y = 420;
  }

  public void render(Graphics graphics) {
    graphics.drawAnimation(fireAnimation, this.x, this.y);
  }

  public void update(int delta) {
    this.x += speed * delta;
    if(this.x > 1250)
      this.x = 100;
  }

}
