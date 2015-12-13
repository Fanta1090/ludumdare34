package game;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import characters.Farmer;
import characters.Monster;
import objects.BasicObject;
import objects.Bread;
import objects.Carrot;
import objects.Cheese;
import utils.RandomGenerator;

public class WindowGame extends BasicGame {

  public static final Integer GAME_WIDTH = 1200;
  public static final Integer GAME_HEIGHT = 600;

  GameContainer container;
  Parallaxe background;
  Farmer farmer;
  Monster monster;
  List<BasicObject> listConsumables;

  int ellapsedTime = 0;

  public WindowGame() {
    super("LD34");
  }

  @Override
  public void init(GameContainer container) throws SlickException {
    this.container = container;
    background = new Parallaxe();
    farmer = new Farmer(250, background.getGroundHeight());
    monster = new Monster(-100, -20 + background.getGroundHeight());
    initConsumables();
  }

  @Override
  public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
    background.render(graphics);
    farmer.render(graphics);
    monster.renderM(graphics);
    renderListConsumables(graphics);
  }

  @Override
  public void update(GameContainer gameContainer, int delta) throws SlickException {
    background.update(delta);
    updateListConsumables(delta);
    ellapsedTime += delta;

    if (ellapsedTime >= 10000) {
      int rand = RandomGenerator.getRandomNumber(1, 4);
      if (rand == 1)
        listConsumables.add(new Bread(background.getGroundHeight()));
      else if (rand == 2)
        listConsumables.add(new Carrot(background.getGroundHeight()));
      else
        listConsumables.add(new Cheese(background.getGroundHeight()));

      monster.throwFireBall();
      ellapsedTime = 0;
    }
    monster.update(delta);
  }

  @Override
  public void keyReleased(int key, char c) {
    if (Input.KEY_ESCAPE == key) {
      container.exit();
    }

    if (Input.KEY_F == key) {
      farmer.shrink();
    }

    if (Input.KEY_D == key) {
      farmer.large();
    }
  }

  public static void main(String[] args) throws SlickException {
    AppGameContainer app = new AppGameContainer(new WindowGame(), GAME_WIDTH, GAME_HEIGHT, false);
    app.setTargetFrameRate(60);
    app.setShowFPS(false);
    app.start();
  }

  private void initConsumables() throws SlickException {
    listConsumables = new ArrayList<>();
    listConsumables.add(new Carrot(background.getGroundHeight()));
    listConsumables.add(new Bread(background.getGroundHeight()));
    listConsumables.add(new Cheese(background.getGroundHeight()));
  }

  private void renderListConsumables(Graphics graphics) {
    for (BasicObject obj : listConsumables)
      obj.render(graphics);
  }

  private void updateListConsumables(int delta) {
    for (BasicObject obj : listConsumables)
      obj.update(delta);
  }
}
