package app;

import java.util.ArrayList;

import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

// do the constants here 

public class Item {

    private int x;
    private int y;
    private Texture view;
    private int num;
    private int type;
    private String name;


    public static final int HACKING_TOOL = 0;
    public static final int BOMB = 1;
    public static final int HEALTH = 2;
    public static final int BATTERY = 3;
    public static final int EMP = 4;

    public Item(int type) {
        this.type = type;

        view = SetTexture(type);
        switch (type)
        {
            case 0:
                name = "Hacking Tool";
                break;
            case 1:
                name = "Bomb";
                break;
            case 2:
                name = "Health";
                break;
            case 3:
                name = "Battery";
                break;
            case 4:
                name = "EMP";
                break;
        }

    }

    public String getName()
    {
        return name;
    }

    public int getType() {

        return type;

    }

    public int getNum() {
        return num;
    }

    public Texture SetTexture(int type) { // needs changing

        if (getType() == HEALTH) {
            view = TextureList.getHealth();
        }
        if (getType() == BOMB) {
            view = TextureList.getBomb();
        }
        if (getType() == HACKING_TOOL) {
            view = TextureList.getHack();
        }
        if (getType() == BATTERY) {
            view = TextureList.getBattery();
        }
        if (getType() == EMP) {
            view = TextureList.getEMP();
        }
        return view;
    }

    public Texture getTexture() {
        return view;
    }

}