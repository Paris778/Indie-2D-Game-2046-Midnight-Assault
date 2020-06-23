package app;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

public class Room
{
    private String name;
    private RectangleShape shape;

    public static final int TOP_WALL = 0;
    public static final int BOTTOM_WALL = 1;
    public static final int LEFT_WALL = 2;
    public static final int RIGHT_WALL = 3;


    public Room(String name, Vector2f size, Vector2f location, Texture texture)
    {
        shape = new RectangleShape(size);
        shape.setPosition(location);
        shape.setTexture(texture);
        this.name = name;
    }

    /**
     * @return the size
     */
    public Vector2f getSize() 
    {
        return shape.getSize();
    }

    public RectangleShape getShape()
    {
        return shape;
    }

    public String getName()
    {
        return name;
    }

    /**
     * @return the location
     */
    public Vector2f getLocation()
    {
        return shape.getPosition();
    }


    public void draw(RenderWindow window)
    {
        window.draw(shape);
    }

}