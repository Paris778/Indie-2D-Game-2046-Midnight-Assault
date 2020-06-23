package app;

import java.util.LinkedList;

import org.jsfml.graphics.RenderWindow;

public interface RoomObject
{

    /**
     * Activates this object, based on the interaction of another
     */
    public void activate();
    /**
     * Player interaction with object
     */
    public void interact(Character player, boolean override);
    /**
     * Deactivates this object, based on the interaction on another
     */
    public void deactivate();

    /**
     * Sets the item that is required for the player to interact with this object
     * @param itemType The type of item required (Constants found in Item class)
     */
    public void setRequiredItem(int itemType);

    /**
     * @return Whether the player is capable of interacting with the object
     * @param player The player to check
     */
    public boolean ableToInteract(Character player);
    /**
     * Sets the roomObjects that will be affected by activation of this roomObject
     * @param children The list of children to use
     */
    public void setChildren(LinkedList<RoomObject> children);

    /**
     * Adds a child to this roomObject
     * @param child the roomObject to add
     */
    public void addChild(RoomObject child);

    /**
     * Gets all the children of this roomObject
     * @return The list of children
     */
    public LinkedList<RoomObject> getChildren();

    /**
     * Draws the object to the given RenderWindow
     * @param window The window to draw to
     */
    public void draw(RenderWindow window);

    /**
     * Whether the object is active or not
     * @return the state or not
     */
    public boolean isActive();

    /**
     * Gets the collider of this object
     * @return the collider of this object
     */
    public Collider getCollider();

    /**
     * gets the name of this object
     * @return the name of the object
     */
    public String getName();

    /**
     * Gets the type of this roomObject
     * @return the type of this object
     */
    public String getType();
}