package characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Farmer extends AnimatedCharacter {

  public Farmer() throws SlickException {
    super(320 - 27, 200);
    SpriteSheet spriteSheet = new SpriteSheet("resources/images/idle.png", 54, 132);
    Animation idleAnimation = new Animation(spriteSheet, 90);
    idleAnimation.setAutoUpdate(true);
    idleAnimation.setLooping(true);
    this.addState(STATE_IDLE, idleAnimation);
  }
}
