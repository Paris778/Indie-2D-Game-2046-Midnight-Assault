package app;

import java.util.LinkedList;
import java.util.Random;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

public class Box implements RoomObject 
{
    private RectangleShape box;
    private Item item1;
    private int click;
    private int ScrapAmount;
    private Boolean access;
    private Boolean open;
    private Collider collider;
    private String name;

    public Box(Vector2f location, int item, int scrap, String name) 
    {

        box = new RectangleShape(new Vector2f(120, 120));
        this.name = name;
        box.setPosition(location);
        this.item1 = new Item(item);
        click = 0;
        collider = new Collider(box.getGlobalBounds(), 0, true);
        open = false; // is the box open or not
        access = true; // is the item in the box accessible
        box.setTexture(TextureList.getBox());
        if (scrap == 0) 
        {
            ScrapAmount = 0;
        } 
        else 
        {
            ScrapAmount = setScrap();
        }
    }

    public void setRequiredItem(int itemType) 
    {
        
    }

    public void setAccessFalse() 
    {
        this.access = false;
    }

    public void setAccessTrue() 
    {
        this.access = true;
    }

    public boolean getAccess() 
    {
        return this.access;
    }

    public void setopen() 
    {
        this.open = true;
    }

    public void setClosed() 
    {
        this.open = false;
        box.setFillColor(Color.TRANSPARENT);
        collider = null;
    }

    public boolean getStatus() 
    {
        return this.open;
    }

    public void drawOpen(RenderWindow window, RectangleShape box) 
    {

        this.box = box;
        Texture view = new Texture();
        view = getItem().getTexture();
        box.setTexture(view, true); // will be item.get texture
        window.draw(box);
    }

    public RectangleShape getrec() 
    {
        return box;
    }

    public Item getItem() {
        return item1;
    }

    public int getScrapAmount() 
    {
        return ScrapAmount;
    }

    public void getItemView() 
    {
        item1.getTexture();
    }

    public void draw(RenderWindow window) 
    {

        if (open == true && access == true) 
        {
            drawOpen(window, box);
        }
        if (access == false && open == false) 
        {
            window.draw(box);
        } 
        else 
        {
            window.draw(box);
        }
    }

    public int setScrap() 
    {
        int max = 100;
        int min = 0;
        Random randomNum = new Random();
        int num = min + randomNum.nextInt(max);
        return num;
    }

    public void activate() 
    {}

    public void interact(Character player, boolean override) 
    {
        click++;

        if (access = true && access == true) 
        {
            setopen();

        }

        if (click >= 2 && player.getInventory().isfull() == false && access == true) 
        {
            collect(box, player);
            player.addScrap(getScrapAmount());
            setAccessFalse();
            setClosed();
        }

        if (player.getInventory().isfull() == true) 
        {
            player.getUI().getFeed().add("Your inventory is full");
        }

    }

    public void deactivate() 
    {}

    public void collect(RectangleShape rec, Character player) 
    {
        rec.setTexture(TextureList.getBox());
        setClosed();
        setAccessFalse();
        player.getInventory().addItem(item1);
    }

    public boolean ableToInteract(Character player) 
    {
        if (player.getInterArea().getGlobalBounds().intersection(box.getGlobalBounds()) != null)
            return true;
        else
            return false;
    }

    /**
     * Sets the roomObjects that will be affected by activation of this roomObject
     * 
     * @param children The list of children to use
     */
    public void setChildren(LinkedList<RoomObject> children) 
    {}

    /**
     * Adds a child to this roomObject
     * 
     * @param child the roomObject to add
     */
    public void addChild(RoomObject child) 
    {}

    public boolean Active() 
    {
        return true;
    }

    /**
     * gets the name of this object
     * 
     * @return the name of the object
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Gets the type of this roomObject
     * 
     * @return the type of this object
     */
    public String getType() 
    {
        return "Box";
    }

    public LinkedList<RoomObject> getChildren() 
    {
        return null;
    }

    public boolean isActive() 
    {
        return false;
    }

    public Collider getCollider() 
    {
        return collider;
    }
}
