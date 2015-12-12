package game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Parallaxe {

  private List<BackgroundDrawer> images = new ArrayList<>();

  public Parallaxe() throws SlickException {

    BackgroundDrawer sky = new BackgroundDrawer("resources/images/sky.png");
    sky.setSpeed(0.03f);

    BackgroundDrawer ground = new BackgroundDrawer("resources/images/ground_big.png");
    ground.setY(WindowGame.GAME_HEIGHT - ground.getImage().getHeight());

    images.add(sky);
    images.add(ground);
  }

  public void render(Graphics graphics) {
    for (BackgroundDrawer backgroundDrawer : images) {
      backgroundDrawer.render(graphics);
    }
  }

  public void update(int delta) {
    for (BackgroundDrawer backgroundDrawer : images) {
      backgroundDrawer.update(delta);
    }
  }
}
