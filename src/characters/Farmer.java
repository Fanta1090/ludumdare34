package characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Farmer extends AnimatedCharacter {

  private int life = 3;

  public Farmer(int x, int y) throws SlickException {
    super(x, y);

    Image img = new Image("resources/images/idle.png");
    Image imgBig = img.getScaledCopy(1.5f);
    Image imgSmall = img.getScaledCopy(0.5f);

    SpriteSheet spriteSheet = new SpriteSheet(img, 76, 94);
    Animation idleAnimation = new Animation(spriteSheet, 120);
    idleAnimation.setAutoUpdate(true);
    idleAnimation.setLooping(true);
    this.addState(STATE_NORMAL, idleAnimation);

    SpriteSheet spriteSheetBig = new SpriteSheet(imgBig, (int) (76 * 1.5f), (int) (94 * 1.5f));
    Animation bigAnimation = new Animation(spriteSheetBig, 120);
    bigAnimation.setAutoUpdate(true);
    bigAnimation.setLooping(true);
    this.addState(STATE_BIG, bigAnimation);

    SpriteSheet spriteSheetSmall = new SpriteSheet(imgSmall, (int) (76 * 0.5f), (int) (94 * 0.5f));
    Animation smallAnimation = new Animation(spriteSheetSmall, 120);
    smallAnimation.setAutoUpdate(true);
    smallAnimation.setLooping(true);
    this.addState(STATE_SHRINK, smallAnimation);
  }

  public void shrink() {
    if (currentState > 0) {
      currentState--;
    }
  }

  public void large() {
    if (currentState < 2) {
      currentState++;
    }
  }
  
  public int getLife() {
    return life;
  }

  public void setLife(int life) {
    this.life = life;
  }
}
