package fractalTree;

import java.awt.Graphics;

public class Tree
{
  private final int START_X;
  private final int START_TIME;
  private final double MAX_TRUNK_LENGTH = 100;
  private double trunkLength;

  public Tree(int location, int startTime, double trunkLength)
  {
    START_X = location;
    START_TIME = startTime;
    this.trunkLength = trunkLength;
  }

  public int getSTART_X()
  {
    return START_X;
  }

  public int getSTART_TIME()
  {
    return START_TIME;
  }

  public double getTrunkLength()
  {
    return trunkLength;
  }

  public void drawBranches(Graphics g, int x0, int y0, double length,
      double angle)
  {
    double radians = angle * Math.PI / 180;
    int x1 = x0 + (int) (length * Math.cos(radians));
    int y1 = y0 - (int) (length * Math.sin(radians));

    if (length > 2)
    {
      g.drawLine(x0, y0, x1, y1);
      drawBranches(g, x1, y1, length * 0.75, angle + 30);
      drawBranches(g, x1, y1, length * 0.67, angle - 50);
    }
  }

  public void updateTrunkLength()
  {
    trunkLength = trunkLength
        + 0.01 * trunkLength * (1.0 - trunkLength / MAX_TRUNK_LENGTH);
  }

}
