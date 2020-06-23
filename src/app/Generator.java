package app;

import java.util.LinkedList;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;

public class Generator implements RoomObject
{
    private String name;
    private LinkedList<RoomObject> children = new LinkedList<RoomObject>();
    private RectangleShape shape;
    private Collider collider;
    private boolean active;
    private int itemType = -1;


    public Generator(Vector2f location, boolean state, String name)
    {
        shape = new RectangleShape(new Vector2f(104, 102));
        shape.setPosition(location);
        this.name = name;
        collider = new Collider(shape.getGlobalBounds(), 0, true);
        active = state;
        shape.setTexture(TextureList.getGenerator(state));
    }

    public void interact(Character player, boolean override)
    {
        if (player.getInventory().check(itemType) || itemType == -1)
        {
            if (itemType == -1)
                player.getUI().getFeed().add("Interacted with generator");
            else
            {
                player.getUI().getFeed().add("Used " + new Item(itemType).getName() + " on generator");
                player.getInventory().use(itemType);
            }
            
            if (active)
                deactivate();
            else
                activate();
        }
        else
        {
            player.getUI().getFeed().add("You need a " + new Item(itemType).getName() + "\nto use generator");
        }
    }

    public void activate()
    {
        active = true;
        shape.setTexture(TextureList.getGenerator(true));
        for (RoomObject object : children)
        {
            object.activate();
        }
    }

    public void setRequiredItem(int itemType)
    {
        this.itemType = itemType; 
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
        active = false;
        shape.setTexture(TextureList.getGenerator(false));
        for (RoomObject object : children)
        {
            object.deactivate();
        }
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
        return active;
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
        return "Generator";
    }
}