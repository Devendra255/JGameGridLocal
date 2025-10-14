Import ch.aplu.robotsim.*;

public class withgear1
{
  public withgear1 ()
  {
    LegoRobot robot = new LegoRobot();
    Gear gear = new Gear();
    
    robot.addPart(gear);
    gear.setSpeed(20);
    gear.forward();
    Tools.delay(2000);
    gear.left(2000);
    gear.forward(2000);
    gear.leftArc(0.2, 2000);
    gear.forward(2000);
    
    
    
    gear.leftArc(-0.2, 2000);
    gear.right(2000);
    
    robot.exit();
  }
  
  public static void main(String[] args)
  {
    new withgear1 ();
  }
}

