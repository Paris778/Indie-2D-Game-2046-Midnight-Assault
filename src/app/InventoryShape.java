package app;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;

public class InventoryShape {
    private RectangleShape rectangle;

    public InventoryShape(float x, float y, Color colorInside, Color colorOutside, float lineSize) {
        rectangle = new RectangleShape(new Vector2f(x, y));

        // rectangle.setOrigin(x / 2, y / 2);
        // rectangle.setPosition(xPos, yPos);
        rectangle.setFillColor(Color.GREEN);
        if (Keyboard.isKeyPressed(Keyboard.Key.I)) {
            rectangle.setOutlineColor(Color.TRANSPARENT);
        }
        rectangle.setOutlineThickness(lineSize);
    }

    public void draw(RenderWindow window) {
        window.draw(rectangle);
    }

    public void move(float x, float y) {
        rectangle.move(x, y);
    }

    public RectangleShape getrecc() {
        return this.rectangle;
    }
}