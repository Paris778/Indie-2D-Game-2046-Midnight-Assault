package app;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.Keyboard.Key;

public class Controller
{
    protected RenderWindow window;
    protected Character character;
    private Map map;
    private UserInterface ui;
    private long interactDelay;
    private long inventoryDelay;
    private App app;

    public Controller(RenderWindow window, Character character, Map map, UserInterface ui, App app)
    {
        this.window = window;
        this.character = character;
        this.map = map;
        this.ui = ui;
        this.app = app;
    }

    public void parseKey(Key key)
    {
        switch (key)
        {
            case W:
                character.up();
                break;
            case A:
                character.left();
                break;
            case S:
                character.down();
                break;
            case D:
                character.right();
                break;
            case ESCAPE:
                app.stop();
                break;
            case SPACE:
                if(App.selectingplayer){
                    App.selectingplayer = false;
                    App.keepGoing = false;
                    character.setTextureInt((App.counter+20));
                }
                for(RoomObject object : map.getObjects())
                {
                    if (object.ableToInteract(character) && System.currentTimeMillis() - interactDelay > 700)
                    {
                        interactDelay = System.currentTimeMillis();
                        object.interact(character, false);
                    }
                }
               
                //get("Door1");     
                break;
            case I:
                if (System.currentTimeMillis() - inventoryDelay > 400)
                {
                    inventoryDelay = System.currentTimeMillis();
                    String output = "Your inventory contains:\n";
                    int count = 1;
                    for (Item item : character.getInventory().getItems()) 
                    {
                        output += count + ". " + item.getName() + "\n";
                    }
                    character.getUI().getFeed().add(output);
                }
            case X:
                ui.startGame(); //Make game restart
                if (!character.isAlive())
                    app.startGame();
                break;
            case Z:
                if (System.currentTimeMillis() - interactDelay > 400)
                {
                    interactDelay = System.currentTimeMillis();
                    App.counter--;
                    if(App.counter < 0){
                        App.counter = 9;
                    }
                }
             
                break;
            case C:
                if (System.currentTimeMillis() - interactDelay > 400)
                {
                    interactDelay = System.currentTimeMillis();
                    App.counter++;
                    if(App.counter > 9){
                        App.counter = 0;
                    }
                }
                break;
            case E:
                if (character.getInventory().check(Item.HEALTH) && character.getHealth() < 102)
                {
                    character.getInventory().use(Item.HEALTH);
                    int newHealth = 0;
                    if (character.getHealth() + 25 < 102)
                        newHealth = character.getHealth() + 25;
                    else
                        newHealth = 102;
                    character.setHealth(newHealth);
                }
            default:
                break;
        }
        
    }

    public void updateMap(Map newMap)
    {
        map = newMap;
    }

    // public void parseMouse()
}