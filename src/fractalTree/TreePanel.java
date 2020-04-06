package fractalTree;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class TreePanel extends JPanel
{

  private static final long serialVersionUID = 1L;
  private final int HEIGHT;
  private final int WIDTH;
  private ArrayList<Tree> trees = new ArrayList<>();
  private int time = 0;

  public TreePanel(int frameHeight, int frameWidth)
  {
    HEIGHT = frameHeight;
    WIDTH = frameWidth;
  }

  public void setTime(int time)
  {
    this.time = time;
  }

  public void addTree(int location, double trunkLength, int plantTime)
  {
    trees.add(new Tree(location, plantTime, trunkLength));
  }

  public ArrayList<Tree> getTrees()
  {
    return this.trees;
  }

  public void paintComponent(Graphics g)
  {
    int location;
    String age;

    super.paintComponent(g);
    g.drawLine(25, HEIGHT - 75, WIDTH - 45, HEIGHT - 75);
    for (Tree tree : trees)
    {
      location = tree.getSTART_X();
      tree.drawBranches(g, location, HEIGHT - 75, tree.getTrunkLength(), 90);
      age = Integer.toString((time - tree.getSTART_TIME()) / 12);
      g.drawString(age, location - 5, HEIGHT - 50);
    }

  }

}
