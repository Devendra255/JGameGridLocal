// GearControl.java
import ch.aplu.robotsim.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GearControl implements KeyListener
{
  private Gear gear;
  
  public GearControl()
  {
    LegoRobot robot = new LegoRobot();
    gear = new Gear();
    robot.addPart(gear);
    
    // Register key listener on RobotContext window
    RobotContext.getFrame().addKeyListener(this);
    
    System.out.println("Use arrow keys to control the robot, and SPACE to stop.");
    
    Tools.delay(60000); // Run for 60 seconds
    robot.exit();
  }
  
  // Handle key press events
  public void keyPressed(KeyEvent e)
  {
    int code = e.getKeyCode();
    
    switch (code)
    {
      case KeyEvent.VK_UP:
      gear.forward();
      break;
      case KeyEvent.VK_DOWN:
      gear.backward();
      break;
      case KeyEvent.VK_LEFT:
      gear.left();
      break;
      case KeyEvent.VK_RIGHT:
      gear.right();
      break;
      case KeyEvent.VK_SPACE:
      gear.stop();
      break;
    }
  }
  
  public void keyReleased(KeyEvent e) {}
  public void keyTyped(KeyEvent e) {}
  
  public static void main(String[] args)
  {
    new GearControl();
  }
}
