package characters;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Monster extends AnimatedCharacter {

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
    this.addState(STATE_IDLE, idleDragon);
  }

}
