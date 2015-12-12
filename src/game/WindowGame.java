package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import characters.Farmer;
import characters.Monster;

public class WindowGame extends BasicGame {

  public static final Integer GAME_WIDTH = 1200;
  public static final Integer GAME_HEIGHT = 600;

  GameContainer container;
  Parallaxe background;
  Farmer farmer;
  Monster monster;

  public WindowGame() {
    super("LD34");
  }

  @Override
  public void init(GameContainer container) throws SlickException {
    this.container = container;
    background = new Parallaxe();
    farmer = new Farmer();
    monster = new Monster();
  }

  @Override
  public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
    background.render(graphics);
    farmer.render(graphics);
    monster.render(graphics);
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

  public static void main(String[] args) throws SlickException {
    AppGameContainer app = new AppGameContainer(new WindowGame(), GAME_WIDTH, GAME_HEIGHT, false);
    app.setTargetFrameRate(60);
    app.setShowFPS(false);
    app.start();
  }
}
