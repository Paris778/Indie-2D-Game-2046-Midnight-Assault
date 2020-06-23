package app;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import java.util.LinkedList;

public class Teleporter implements RoomObject {

    private RectangleShape teleporterArea;
    private int destinationMap;
    private RenderWindow window;

    public Teleporter(int destinationMapNo, RenderWindow window) {
        destinationMap = destinationMapNo;
        this.window = window;
        teleporterArea = new RectangleShape(new Vector2f(50, 50));
        initialise();
    }

    public Teleporter(int destinationMapNo, Vector2f position, RenderWindow window) {
        this.destinationMap = destinationMapNo;
        this.window = window;
        teleporterArea = new RectangleShape(new Vector2f(50, 50));
        initialise();
        setTeleporterPosition(position.x, position.y);
    }

    public void initialise() {
        //teleporterArea.setOutlineColor(org.jsfml.graphics.Color.MAGENTA);
        teleporterArea.setFillColor(org.jsfml.graphics.Color.TRANSPARENT);
        //teleporterArea.setOutlineThickness(2);
    }

    public void setTeleporterPosition(float x, float y) {
        teleporterArea.setPosition(x, y);
    }

    public void activate() {

    }

    public void interact(Character player, boolean override) {
        if (ableToInteract(player)){
            App.setCurrentMap(getDestinationMap(player));
            App.addJumps();
        }
            
        
    }

    public Map getDestinationMap(Character player) {
        return MapList.getMap(destinationMap, player, window);
    }

    public void deactivate() {

    }

    public boolean ableToInteract(Character player) {
        if (player.checkIntersection(teleporterArea.getGlobalBounds()))
            return true;
        else
            return false;
    }

    public void setChildren(LinkedList<RoomObject> children) {

    }

    public void addChild(RoomObject child) {

    }

    public LinkedList<RoomObject> getChildren() {
        return null;
    }

    public void draw(RenderWindow window) {
        window.draw(teleporterArea);
    }

    public boolean isActive() {
        // TODO Auto-generated method stub
        return false;
    }

    public Collider getCollider() {
        // TODO Auto-generated method stub
        return new Collider();
    }

    public void setRequiredItem(int itemType)
    {
    }

    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getType() {
        // TODO Auto-generated method stub
        return null;
    }

}