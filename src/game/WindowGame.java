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

public class WindowGame extends BasicGame {

  GameContainer container;
  BackgroundDrawer background;
  Farmer farmer;
  Monster monster;
  List<BasicObject> listConsumables;

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
    background = new BackgroundDrawer("resources/images/background.png");
    farmer = new Farmer();
    monster = new Monster();

    // Init of consumables
    listConsumables = new ArrayList<>();
    listConsumables.add(new Carrot());
    listConsumables.add(new Bread());
    listConsumables.add(new Cheese());
  }

  @Override
  public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
    background.render(graphics);
    farmer.render(graphics);
    monster.render(graphics);
    renderListConsumables(graphics);
  }

  @Override
  public void update(GameContainer gameContainer, int delta) throws SlickException {
    background.update(delta);
    updateListConsumables(delta);
  }

  @Override
  public void keyReleased(int key, char c) {
    if (Input.KEY_ESCAPE == key) {
      container.exit();
    }
  }

  private void renderListConsumables(Graphics graphics) {
    for(BasicObject obj : listConsumables)
      obj.render(graphics);
  }
  
  private void updateListConsumables(int delta) {
    for(BasicObject obj : listConsumables)
      obj.update(delta);
  }

}
