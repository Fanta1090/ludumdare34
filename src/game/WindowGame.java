package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class WindowGame extends BasicGame {

  GameContainer container;
  BackgroundDrawer background;
  float move = 0;

  public WindowGame() {
    super("LD34");
  }

  public static void main(String[] args) throws SlickException {
    AppGameContainer app = new AppGameContainer(new WindowGame(), 640, 480, false);
    app.setTargetFrameRate(60);
    app.setShowFPS(false);
    app.start();
  }

  @Override
  public void init(GameContainer container) throws SlickException {
    this.container = container;
    background =  new BackgroundDrawer("resources/images/background.png");
  }
  
  @Override
  public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
    background.render(graphics);
  }

  @Override
  public void update(GameContainer gameContainer, int delta) throws SlickException {
    background.update(delta);
  }

  @Override
  public void keyReleased(int key, char c) {
    if (Input.KEY_ESCAPE == key) {
      container.exit();
    }
  }

}
