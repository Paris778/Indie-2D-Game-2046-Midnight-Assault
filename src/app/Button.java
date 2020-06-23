package app;

import java.util.LinkedList;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;

public class Button implements RoomObject
{
    private Collider collider;
    private RectangleShape shape;
    private String name;
    private LinkedList<RoomObject> children = new LinkedList<>();
    private boolean powered;
    private boolean active;
    private int type;
    private int itemType = -1;

    public static final int BLUE = 0;
    public static final int GREEN = 1;
    public static final int RED = 2;

    public Button(Vector2f location, int type, boolean state, boolean powered, String name)
    {
        shape = new RectangleShape(new Vector2f(36, 83));
        shape.setTexture(TextureList.getButton(state, type));
        shape.setPosition(location);
        collider = new Collider(shape.getGlobalBounds(), 0, true);
        this.type = type;
        active = state;
        this.powered = powered;
        this.name = name;
    }

    public void addChild(RoomObject child)
    {
        children.add(child);
    }

    public LinkedList<RoomObject> getChildren()
    {
        return children;
    }

    public void setRequiredItem(int itemType)
    {
        this.itemType = itemType; 
    }

    public void setChildren(LinkedList<RoomObject> children)
    {
        this.children = children;
    }

    public void interact(Character player, boolean override)
    {
        if (powered)
        {
            if (player.getInventory().check(itemType) || itemType == -1)
            {
                if (active && type == GREEN)
                    player.getUI().getFeed().add("This type of button \ncannot be deactivated");
                else if (itemType == -1)
                    player.getUI().getFeed().add("Interacted with button");
                else
                {
                    player.getUI().getFeed().add("Used " + new Item(itemType).getName() + " on button");
                    player.getInventory().use(itemType);
                }
                if (active && type != GREEN)
                {
                    deactivate();
                }
                else
                {
                    activate();
                }
            }
            else
            {
                player.getUI().getFeed().add("You need a " + new Item(itemType).getName() + " to use button");
            }
        }
        else
            player.getUI().getFeed().add("This button is unpowered");
    }

    public void deactivate() 
    {
        active = false;
        shape.setTexture(TextureList.getButton(false, type));
        for (RoomObject child : children) 
        {
            child.deactivate();
        }

    }

    public void activate() 
    {
        active = true;
        shape.setTexture(TextureList.getButton(true, type));
        for (RoomObject child : children) 
        {
            child.activate();
        }
    }

    public boolean isActive() 
    {
        return active;
    }

    public boolean isPowered()
    {
        return powered;
    }

    public void draw(RenderWindow window) 
    {
        window.draw(shape);
    }

    // CHecks whether the box of the door and the interactive area of the player
    // intersect.
    public boolean checkIntersection(Character player) 
    {

        if (player.getInterArea().getGlobalBounds().intersection(shape.getGlobalBounds()) != null) 
        {
            return true;
        }
        return false;
    }

    public Collider getCollider() {
        return collider;
    }

    public String getName()
    {
        return name;
    }

    // Returns true if the player is able to unlock the door and has the required
    // equipment
    public boolean ableToInteract(Character player) { //should be paired with the condition of whether the player has the required item to unlock

        if (checkIntersection(player) && powered) {
            return true;
        }
        return false;
    }

    public String getType()
    {
        return "Button";
    }
}