package app;

import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.LinkedList;

public class TextWrapper implements RoomObject {

    private Text text;
    private Font font = new Font();

    public TextWrapper(String words,float xPosition, float yPosition,RenderWindow window,int size){
        Vector2f origin = window.getView().getCenter();
        try {
            this.font.loadFromFile(
                    FileSystems.getDefault().getPath(System.getProperty("user.dir") + App.pathVariable + "sprites" + App.pathVariable + "Coalition.ttf"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.text = new Text(words,this.font);
        this.text.setCharacterSize(size);
        this.text.setColor(Color.WHITE);
        this.text.setPosition((float) (origin.x) + xPosition, (float) (origin.y) + yPosition);
        
    }

    @Override
    public void activate() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deactivate() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean ableToInteract(Character player) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setChildren(LinkedList<RoomObject> children) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addChild(RoomObject child) {
        // TODO Auto-generated method stub

    }

    @Override
    public LinkedList<RoomObject> getChildren() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void draw(RenderWindow window) {
        window.draw(this.text);
    }

    @Override
    public boolean isActive() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public Collider getCollider() {
        // TODO Auto-generated method stub
        return new Collider();
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void interact(Character player, boolean override) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setRequiredItem(int itemType) {
        // TODO Auto-generated method stub

    }


}