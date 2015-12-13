package characters;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

import game.GameObject;

public abstract class AnimatedCharacter extends GameObject {

  public static final int STATE_SHRINK = 0;
  public static final int STATE_NORMAL = 1;
  public static final int STATE_BIG = 2;
  

  private Map<Integer, Animation> statedAnimations = new HashMap<>();

  protected int currentState = STATE_NORMAL;

  public AnimatedCharacter() {
  }

  public AnimatedCharacter(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public AnimatedCharacter(int x, int y, Animation idleAnimation) {
    this(x, y);
    statedAnimations.put(STATE_NORMAL, idleAnimation);
  }

  /**
   * Draw this object
   * 
   * @param g
   *          graphics where you want this object to be drawn
   */
  public void render(Graphics g) {
    g.drawAnimation(statedAnimations.get(currentState), x, y - statedAnimations.get(currentState).getHeight());
  }

  public void addState(int state, Animation anim) {
    statedAnimations.put(state, anim);
  }
}
