package fractalTree;

import java.util.ArrayList;

import javax.swing.JFrame;

public class TreeDriver
{
  private final int WIDTH = 625, HEIGHT = 400;
  private TreePanel panel = new TreePanel(HEIGHT, WIDTH);
  private int time = 0;

  public TreeDriver()
  {
    JFrame frame = new JFrame("Fractal Trees");

    frame.setSize(WIDTH, HEIGHT);
    frame.add(panel);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public void simulate() throws InterruptedException
  {
    ArrayList<Tree> trees = panel.getTrees();
    boolean done = false;

    while (!done)
    {
      switch (time)
      {
        case 0:
          panel.addTree(400, 3, time);
          break;
        case 360:
          panel.addTree(100, 3, time);
          break;
        case 540:
          panel.addTree(300, 3, time);
          break;
        case 630:
          panel.addTree(200, 3, time);
          break;
        case 675:
          done = true;
      }
      panel.repaint();

      time++;
      panel.setTime(time);
      for (Tree tree : trees)
      {
        tree.updateTrunkLength();
      }
      Thread.sleep(25);
    }
  }

  public static void main(String[] args) throws InterruptedException
  {
    TreeDriver driver = new TreeDriver();

    driver.simulate();
  }

}
