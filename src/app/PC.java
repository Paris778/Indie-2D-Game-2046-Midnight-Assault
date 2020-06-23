package app;

import java.util.LinkedList;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;

public class PC implements RoomObject
{
    private String name;
    private LinkedList<RoomObject> children = new LinkedList<RoomObject>();
    private RectangleShape shape;
    private Collider collider;
    private boolean powered;
    private int itemType = -1;


    public PC(Vector2f location, boolean powered, String name)
    {
        shape = new RectangleShape(new Vector2f(64, 105));
        shape.setPosition(location);
        this.name = name;
        collider = new Collider(shape.getGlobalBounds(), 0, true);
        this.powered = powered;
        shape.setTexture(TextureList.getPC());
    }

    public void interact(Character player, boolean override)
    {
        if (powered)
        {
            if (player.getInventory().check(itemType) || itemType == -1)
            {
                if (override)
                {}
                else if (itemType == -1)
                    player.getUI().getFeed().add("Interacted with PC");
                else
                {
                    player.getUI().getFeed().add("Used " + new Item(itemType).getName() + " on PC");
                    player.getInventory().use(itemType);
                }
                for (RoomObject roomObject : children) 
                {
                    roomObject.interact(player, true);
                }
            }
            else
                player.getUI().getFeed().add("You need a " + new Item(itemType).getName() + " to interact with PC");
        }
        else
            player.getUI().getFeed().add("This PC is unpowered");
    }

    public void activate()
    {
        powered = true;
    }

    public boolean ableToInteract(Character player)
    {
        if (player.checkIntersection(shape.getGlobalBounds()))
            return true;
        else
            return false;
    }

    public void deactivate()
    {
        powered = false;
    }

    public void setRequiredItem(int itemType)
    {
        this.itemType = itemType; 
    }

    public void setChildren(LinkedList<RoomObject> children)
    {
        this.children = children;
    }

    public LinkedList<RoomObject> getChildren()
    {
        return children;
    }

    public void addChild(RoomObject child)
    {
        children.add(child);
    }

    public void draw(RenderWindow window)
    {
        window.draw(shape);
    }

    public boolean isActive()
    {
        return powered;
    }

    public Collider getCollider()
    {
        return collider;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return "PC";
    }
}