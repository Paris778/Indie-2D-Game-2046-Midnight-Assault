package app;
import java.util.LinkedList;
import org.jsfml.graphics.*;
import java.util.LinkedHashMap;

public class Map
{

    private RenderWindow window;
    private LinkedHashMap<String,Collider> colliders = new LinkedHashMap<>();
    private LinkedList<Room> rooms;
    private LinkedList<RoomObject> objects;
    private LinkedList<FloatRect> intersects = new LinkedList<FloatRect>();
    private LinkedList<Text> textList = new LinkedList<Text>();
    private int enemyPreset = 0;

    public Map(RenderWindow window)
    {
        this.window = window;
    }

    public Map(RenderWindow window, LinkedList<Room> rooms, LinkedList<RoomObject> objects, int enemyPreset)
    {
        this.window = window;
        this.rooms = rooms;
        this.objects = objects;
        this.enemyPreset = enemyPreset;
    }


    public int getEnemyPreset(){
        return this.enemyPreset;
    }

    public void createColliders(Character player)
    {
        colliders.clear();
        for (RoomObject object : objects)
        {
            if (object.getType() == "Door")
            {
                if (((Door) object).isLocked() && ((Door) object).getDoorType() == 0)
                    colliders.put(object.getName(), object.getCollider());
                else
                    ((Door)object).testDamage(player);
            }
            else if (object.getCollider() != null)
                colliders.put(object.getName(), object.getCollider());
        }
        for (Room room : rooms)
        {
            FloatRect bounds = room.getShape().getGlobalBounds();
            colliders.put(room.getName() + "top", new Collider(new FloatRect(bounds.left, bounds.top - 80, bounds.width, 80), 0, false));
            colliders.put(room.getName() + "bottom", new Collider(new FloatRect(bounds.left, bounds.top + bounds.height, bounds.width, 80), 0, false));
            colliders.put(room.getName() + "left", new Collider(new FloatRect(bounds.left - 80, bounds.top, 80, bounds.height), 0, false));
            colliders.put(room.getName() + "right", new Collider(new FloatRect(bounds.left + bounds.width, bounds.top, 80, bounds.height), 0, false));
        }
        for (Collider collider : colliders.values())
        {
            for (Room room : rooms)
            {
                FloatRect roomRect = collider.getBounds().intersection((room.getShape().getGlobalBounds()));
                if (roomRect != null && collider.getAbsolute() == false)
                {
                    if (roomRect.width > roomRect.height)
                        roomRect = new FloatRect(roomRect.left, roomRect.top - 60, roomRect.width, roomRect.height + 120);
                    else
                        roomRect = new FloatRect(roomRect.left - 60, roomRect.top, roomRect.width + 120, roomRect.height);
                    intersects.add(roomRect);
                }
            }
        }
    }

    public LinkedHashMap<String, Collider> getColliders(Character player)
    {
        createColliders(player);
        return colliders;
    }

    public LinkedList<FloatRect> getIntersects()
    {
        return intersects;
    }

    public void drawMap(RenderWindow window)
    {

        for (Room room : rooms)
        {
            room.draw(window);
        }
        for (RoomObject object : objects) 
        {
            object.draw(window);
        }
    }
    public LinkedList<RoomObject> getObjects()
    {
        return objects;
    }
}