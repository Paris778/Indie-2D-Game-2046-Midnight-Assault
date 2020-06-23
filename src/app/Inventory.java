package app;

import java.util.LinkedList;

import org.jsfml.graphics.Texture;

public class Inventory {
    // public int scrap;
    // public int hackingTool;
    // public int battery;
    // public int health1;
    // public int health2;
    // public int grenade;
    private boolean can;
    private LinkedList<Item> items;
    private Character player;

    public Inventory(Character player) {
        /*
         * scrap = 0; hackingTool = 0; battery = 0; health1 = 0; health2 = 0; grenade =
         * 0;
         */

        // plan to link the index of linked list to which box it fills
        items = new LinkedList<Item>();

    }

    public boolean check(int type) {
        can = false;
        for (Item item : items) {
            if (item.getType() == type)
                can = true;
        }
        return can;
    }

    public void addItem(Item Item) {
        if (items.size() < 5) {
            items.add(Item); // MAKE AN LIST OF ITEMS NOT STRINGS THEREFORE CAN GET TEXTURE

        } else {
            player.getUI().getFeed().add("you don't have enough space to collect this"); // Make this on text screen
        }
    }

    public void use(int type) {

        // need to make the check variable
        if (check(type) == true) {
            int remove = -1;
            for (Item item : items) 
            {
                if (item.getType() == type)
                {
                    remove = items.indexOf(item);
                    break;
                }
            }
            items.remove(remove);
            // return true;
        }
    }

    public Texture itemView(int x) // takes an array) {
    {
        // search the array
        // get the index#
        try {
            return items.get(x).getTexture();
        } catch (Exception e) {
            return null;
        }

    }

    public LinkedList<Item> getItems()
    {
        return items;

    }

    public boolean isfull() {
        if (items.size() < 5) {
            return false;
        } else {
            return true;
        }
    }

}
