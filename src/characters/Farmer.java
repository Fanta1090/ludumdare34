package characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Farmer extends AnimatedCharacter {

  public Farmer(int x, int y) throws SlickException {
    super(x, y);
    SpriteSheet spriteSheet = new SpriteSheet("resources/images/idle.png", 76, 94);
    Animation idleAnimation = new Animation(spriteSheet, 120);
    idleAnimation.setAutoUpdate(true);
    idleAnimation.setLooping(true);
    this.addState(STATE_IDLE, idleAnimation);
  }
}
