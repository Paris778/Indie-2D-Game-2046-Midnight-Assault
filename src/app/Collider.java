package app;

import org.jsfml.graphics.FloatRect;

public class Collider
{
    private FloatRect bounds;
    private float moveSpeed;
    private boolean absolute; //Used if the collider shouldn't be nullified by an intersect box

    public Collider(FloatRect bounds, float moveSpeed, boolean absolute)
    {
        this.bounds = bounds;
        this.moveSpeed = moveSpeed;
        this.absolute = absolute;
    }

    public Collider()
    {
        this.bounds = new FloatRect(0, 0, 0, 0);
        this.moveSpeed = 0;
        this.absolute = false;
    }
    
    public boolean testCollision(Collider col)
    {
        // if (bounds.intersection(col.getBounds()) != null)
        if (col.getBounds().intersection(new FloatRect(bounds.left - moveSpeed, bounds.top - moveSpeed, bounds.width + (moveSpeed * 2), bounds.height + (moveSpeed * 2))) != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public FloatRect getBounds()
    {
        return bounds;
    }
    public void setBounds(FloatRect current)
    {
        bounds = current;
    }

    public boolean getAbsolute()
    {
        return absolute;
    }

    public boolean testTop(Collider col)
    {
        if ((col.getBounds().top + col.getBounds().height > bounds.top - moveSpeed && col.getBounds().top < bounds.top - moveSpeed) && ((col.getBounds().left < bounds.left + bounds.width && col.getBounds().left + col.getBounds().width > bounds.left + bounds.width) || (col.getBounds().left + col.getBounds().width > bounds.left && col.getBounds().left < bounds.left)))
            return true;
        else
            return false;
    }
    public boolean testBottom(Collider col)
    {
        if ((col.getBounds().top < bounds.top + bounds.height + moveSpeed && col.getBounds().top + col.getBounds().height > bounds.top + bounds.height + moveSpeed) && ((col.getBounds().left < bounds.left + bounds.width && col.getBounds().left + col.getBounds().width > bounds.left + bounds.width) || (col.getBounds().left + col.getBounds().width > bounds.left && col.getBounds().left < bounds.left)))
            return true;
        else
            return false;
    }
    public boolean testLeft(Collider col)
    {
        if ((col.getBounds().left + col.getBounds().width > bounds.left - moveSpeed && col.getBounds().left < bounds.left - moveSpeed) && ((col.getBounds().top + col.getBounds().height > bounds.top && col.getBounds().top < bounds.top) || (col.getBounds().top < bounds.top + bounds.height && col.getBounds().top + col.getBounds().height > bounds.top + bounds.height)))
            return true;
        else
            return false;
    }
    public boolean testRight(Collider col)
    {
        if ((col.getBounds().left < bounds.left + bounds.width + moveSpeed && col.getBounds().left + col.getBounds().width > bounds.left + bounds.width + moveSpeed) && ((col.getBounds().top + col.getBounds().height > bounds.top && col.getBounds().top < bounds.top) || (col.getBounds().top < bounds.top + bounds.height && col.getBounds().top + col.getBounds().height > bounds.top + bounds.height)))
            return true;
        else
            return false;
    }
}