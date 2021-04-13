
package Code.simpleOutput;
import com.birdbraintechnologies.Finch;

/**
 * HelloWorld.java
 * Very simple program that says something and sets the LED color
 * Author:  Tom Lauwers
 */
public class HelloWorld {
 public static void main(final String[] args)
   {
	  // Instantiating the Finch object
      Finch myFinch = new Finch();


      myFinch.saySomething("I'm feeling sky blue");
      myFinch.setLED(0, 255, 255);
      myFinch.sleep(5000);
      // Always end your program with finch.quit()
      myFinch.quit();
      System.exit(0);
    }
}
