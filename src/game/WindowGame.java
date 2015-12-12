package game;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class WindowGame extends BasicGame {

  GameContainer container;

  public WindowGame() {
    super("LD34");
  }

  public static void main(String[] args) throws SlickException {
    new AppGameContainer(new WindowGame(), 640, 480, false).start();
  }

  @Override
  public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(GameContainer container) throws SlickException {
    this.container = container;

  }

  @Override
  public void update(GameContainer gameContainer, int delta) throws SlickException {
    // TODO Auto-generated method stub
  }

  @Override
  public void keyReleased(int key, char c) {
    if (Input.KEY_ESCAPE == key) {
      container.exit();
    }
  }
}
