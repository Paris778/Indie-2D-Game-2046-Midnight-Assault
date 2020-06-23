package app;
import org.jsfml.window.Window;
import org.jsfml.window.event.Event;
public class EventHandler
{
    private Window window;
    private Controller controller; //Provides methods for controls. Allows us to create new control schemes without modifying event handling
    /**
     * Constructor for the event handler of a given window
     * @param window The Window to poll events for
     */
    public EventHandler(Window window, Controller controller)
    {
        this.window = window;
        this.controller = controller;
    }

    public void runEvents()
    {
        for (Event event : window.pollEvents())
        {
            if (event.type == Event.Type.CLOSED)
                window.close();
            else if (event.type == Event.Type.KEY_PRESSED || event.type == Event.Type.KEY_RELEASED)
                controller.parseKey(event.asKeyEvent().key);
        }
    }

}
