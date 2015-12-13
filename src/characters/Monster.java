package characters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import game.WindowGame;
import objects.Fireball;

public class Monster extends AnimatedCharacter {

  private int nbFireBalls = 1;
  List<Fireball> fireballs;

  public Monster(int x, int y) throws SlickException {
    super(x, y);

    Image img1 = new Image("resources/images/dragon-idle-1.png");
    Image img2 = new Image("resources/images/dragon-idle-2.png");
    Image img3 = new Image("resources/images/dragon-idle-3.png");
    Image img4 = new Image("resources/images/dragon-idle-4.png");

    Image[] dragonImages = new Image[4];
    dragonImages[0] = img1;
    dragonImages[1] = img2;
    dragonImages[2] = img3;
    dragonImages[3] = img4;

    Animation idleDragon = new Animation(dragonImages, 180);
    idleDragon.setAutoUpdate(true);
    idleDragon.setLooping(true);
    this.addState(STATE_NORMAL, idleDragon);

    fireballs = new ArrayList<>();
    fireballs.add(new Fireball());
  }

  public void renderM(Graphics graphics) {
    render(graphics);
    for (Fireball fb : fireballs) {
      fb.render(graphics);
    }
  }

  public void update(int delta) {
    Iterator<Fireball> fb = fireballs.iterator();
    while (fb.hasNext()) {
      Fireball f = fb.next();
      if (f.getX() > WindowGame.GAME_WIDTH) {
        fb.remove();
      }
      f.update(delta);
    }
  }

  public int getNbFireBalls() {
    return nbFireBalls;
  }

  public void throwFireBall() throws SlickException {
    fireballs.add(new Fireball());
  }

  public void setNbFireBalls(int nbFireBalls) {
    this.nbFireBalls = nbFireBalls;
  }
}
