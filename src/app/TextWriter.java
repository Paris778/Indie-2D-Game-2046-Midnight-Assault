package app;

import java.util.LinkedList;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;

public class TextWriter
{
    private RenderWindow window;
    private LinkedList<Text> buffer;
    private LinkedList<Text> displayed;
    private LinkedList<Long> time;
    private Vector2f startPos;
    public TextWriter(RenderWindow window)
    {
        this.window = window;
        startPos = new Vector2f(window.getView().getCenter().x + (window.getSize().x / 2) - (window.getSize().x /5), window.getView().getCenter().y + (window.getSize().y / 2) - (window.getSize().y / 5));
        buffer = new LinkedList<>();
        time = new LinkedList<>();
        displayed = new LinkedList<>();
    }

    public void run()
    {
        for (Text text : buffer) 
        {
            displayed.add(text);
            time.add(System.currentTimeMillis());
        }
        buffer.clear();
        int count = 0;
        LinkedList<Text> remover = new LinkedList<Text>();
        for (Text text : displayed) 
        {   
            if (time.get(count) + 5000 < System.currentTimeMillis())
            {
                remover.add(text);
            }
            else
            {
                text.setPosition(startPos.x, startPos.y - (50 * (displayed.size() - count)));
                window.draw(text);
            }
            count++;
        }
        for (Text text : remover)
        {
            time.remove(displayed.indexOf(text));
            displayed.remove(text);
        }
    }

    public void add(String text)
    {
        Text add = new Text(text, UserInterface.getFont());
        add.setCharacterSize(20);
        add.setColor(Color.WHITE);
        buffer.add(add);
    }

    public void move(float x, float y)
    {
        Vector2f move = new Vector2f(x, y);
        startPos = Vector2f.add(startPos, move);
    }
}