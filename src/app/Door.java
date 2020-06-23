package app;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import java.util.LinkedList;

public class Door implements RoomObject
{
    private int type = 0;
    private int originalDamage;
    private int damage = 0;
    private boolean locked = true; //Whether the door is locked
    private boolean active = true; //Whether the door is active (Powered)
    private RectangleShape doorShape;
    private RectangleShape unlock1;
    private RectangleShape unlock2;
    private Collider modelCollider;
    private String name;
    private LinkedList<RoomObject> children;
    private boolean vertical = false;
    private int itemType = -1;

    // Constructor 1 Without
    public Door(String name, float xSize, float ySize, int type) 
    {

        this.type = type;
        this.name = name;
        doorShape = new RectangleShape(new Vector2f(xSize, ySize)); // static rectange
        unlock1 = new RectangleShape(new Vector2f(xSize / 2, ySize));
        unlock2 = new RectangleShape(new Vector2f(xSize / 2, ySize));
        if (doorShape.getGlobalBounds().height > doorShape.getGlobalBounds().width)
            vertical = true;
        setUpDoorParameters(type);

    }

    // Constructor 2
    public Door(String name, float xSize, float ySize, float xPosition, float yPosition, int type, boolean locked) 
    {
        this.locked = locked;
        this.type = type;
        this.name = name;
        doorShape = new RectangleShape(new Vector2f(xSize, ySize)); // static rectange
        if (doorShape.getGlobalBounds().height > doorShape.getGlobalBounds().width)
            vertical = true;
        if (type == 0)
        {
            if (vertical)
            {
                unlock1 = new RectangleShape(new Vector2f(126, 210));
                unlock2 = new RectangleShape(new Vector2f(126, 210));
            }
            else
            {
                unlock1 = new RectangleShape(new Vector2f(210, 126));
                unlock2 = new RectangleShape(new Vector2f(210, 126));
            }
        }
        else
        {
            if (vertical)
            {
                unlock1 = new RectangleShape(new Vector2f(44, 25));
                unlock2 = new RectangleShape(new Vector2f(44, 25));
            }
            else
            {
                unlock1 = new RectangleShape(new Vector2f(25, 44));
                unlock2 = new RectangleShape(new Vector2f(25, 44));
            }
        }

        setUpDoorParameters(type);
        setDoorPosition(xPosition, yPosition);
    }

    public void addChild(RoomObject child)
    {
        children.add(child);
    }

    public LinkedList<RoomObject> getChildren()
    {
        return children;
    }

    public void setChildren(LinkedList<RoomObject> children)
    {
        this.children = children;
    }

    public void setUpDoorParameters(int type) 
    {
        switch (type) 
        {
            case 0:
                doorShape.setTexture(TextureList.getLockedGateTexture(vertical));
                doorShape.setTexture(TextureList.getLockedGateTexture(vertical));
                originalDamage = 0;
                damage = originalDamage;
                break;
            case 1: // Blue energy gate
                doorShape.setTexture(TextureList.getEnergyGateTextureBlue(vertical));
                originalDamage = 1;
                damage = originalDamage;
                break;
            case 2: // Yellow energy gate
                doorShape.setTexture(TextureList.getEnergyGateTextureYellow(vertical));
                originalDamage = 2;
                damage = originalDamage;
                break;
            case 3: // Red energy gate
                doorShape.setTexture(TextureList.getEnergyGateTextureRed(vertical));
                originalDamage = 3;
                damage = originalDamage;
                break;
            default:
                doorShape.setTexture(TextureList.getLockedGateTexture(vertical));

                break;
        }
        if (type == 0)
        {
            unlock1.setTexture(TextureList.getUnlockedGateLeft(vertical));
            unlock2.setTexture(TextureList.getUnlockedGateRight(vertical));
        }
        else
        {
            unlock1.setTexture(TextureList.getEnergyGateUnlockedLeft(vertical));
            unlock2.setTexture(TextureList.getEnergyGateUnlockedRight(vertical));
        }
    }

    public void setDoorPosition(float x, float y) 
    {
        doorShape.setPosition(x, y);
        if (type == 0) 
        {
            if (vertical)
            {
                unlock1.setPosition(x, y - 65);
                unlock2.setPosition(x, y + 290);
            }
            else
            {
                unlock1.setPosition(x - 65, y);
                unlock2.setPosition(x + 290, y);
            }
            if (locked)
                modelCollider = new Collider(doorShape.getGlobalBounds(), 0, true);
        } 
        else 
        {
            if (vertical)
            {
                unlock1.setPosition(x + 30, y);
                unlock2.setPosition(x + 30, y + 387);
            }
            else
            {
                unlock1.setPosition(x, y + 30);
                unlock2.setPosition(x + 387, y + 30);
            }
        }
        
    }

    public RectangleShape getDoorShape() 
    {
        return doorShape;
    }

    public void interact(Character player, boolean override)
    {
        if (active)
        {
            if (itemType == -1 || player.getInventory().check(itemType) || override)
            {
                if (override)
                {}
                else if (itemType != -1 && override == false)
                {
                    player.getUI().getFeed().add("Used " + new Item(itemType).getName() + " on door");
                    player.getInventory().use(itemType);
                }
                else
                    player.getUI().getFeed().add("Activated door");
                if (locked)
                {
                    unlock();
                }
                else
                {
                    lock();
                }
            }
            else
                player.getUI().getFeed().add("You need " + new Item(itemType).getName() + " to activate door");
        }
        else
            player.getUI().getFeed().add("This door is unpowered");
    }

    public void damage(Character player)
    {
        player.takeDamage(damage);
    }

    public void deactivate() 
    {
        active = false;
        if (type > 0)
            unlock();

    }

    public void activate() 
    {
        active = true;
        if (type > 0)
            lock();
    }

    private void lock()
    {
        locked = true;
        damage = originalDamage;
        modelCollider = new Collider(doorShape.getGlobalBounds(), 0, true);
    }

    private void unlock()
    {
        locked = false;
        damage = 0;
        modelCollider = null;
    }

    public boolean isActive() 
    {
        return active;
    }

    public void setRequiredItem(int itemType)
    {
        this.itemType = itemType; 
    }

    public boolean isLocked()
    {
        return locked;
    }

    public void draw(RenderWindow window) 
    {

        if (locked) 
        {
            window.draw(doorShape);
        } 
        else 
        {
            window.draw(unlock1);
            window.draw(unlock2);
        }
    }

    // CHecks whether the box of the door and the interactive area of the player
    // intersect.
    public boolean checkIntersection(Character player) 
    {

        if (player.getInterArea().getGlobalBounds().intersection(doorShape.getGlobalBounds()) != null) 
        {
            return true;
        }
        return false;
    }

    public void testDamage(Character player)
    {
        if (player.getModel().getGlobalBounds().intersection(doorShape.getGlobalBounds()) != null)
            player.takeDamage(damage);
            
    }

    public Collider getCollider() {
        return modelCollider;
    }

    public String getName()
    {
        return name;
    }

    // Returns true if the player is able to unlock the door and has the required
    // equipment
    public boolean ableToInteract(Character player) { //should be paired with the condition of whether the player has the required item to unlock

        if (checkIntersection(player) && locked) {
            return true;
        }
        return false;
    }

    public int getDoorDmagae() {
        return damage;
    }

    public int getDoorType(){
        return type;
    }

    public String getType()
    {
        return "Door";
    }
}