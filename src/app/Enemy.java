package app;

import org.jsfml.system.Vector2f;
import org.jsfml.graphics.*;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Enemy{

    private int type;
    private RenderWindow window;
    private Character player;
    private RectangleShape shape;
    private float xPosition,yPosition;
    private float startPosition, endPosition;
    private boolean active = true;
    private int movementSpeed = 5;
    private int damage = 1;
    public static int TYPE_HORIZONTAL = 1;
    public static int TYPE_VERTICAL = 2;
    private float length = 80;

    //Basic Constructor
    public Enemy(RenderWindow window,Character player, int type, float xPosition, float yPosition,float endPosition){
        this.type = type;
        this.window = window;
        this.player = player;
        initialiseEnemy(type,xPosition,yPosition,endPosition);
    }
    //Basic With movementSpeed
    public Enemy(RenderWindow window,Character player, int type, float xPosition, float yPosition,float endPosition,int movementSpeed){
        this.type = type;
        this.window = window;
        this.player = player;
        this.movementSpeed = movementSpeed;
        initialiseEnemy(type,xPosition,yPosition,endPosition);
    }
    //Basic With movementSpeed and SIZE
    public Enemy(RenderWindow window,Character player, int type, float xPosition, float yPosition,float endPosition,int movementSpeed,float length){
        this.type = type;
        this.window = window;
        this.player = player;
        this.movementSpeed = movementSpeed;
        this.length = length;
        initialiseEnemy(type,xPosition,yPosition,endPosition);
    }
        //Basic With movementSpeed , SIZE and DAMAGE
    public Enemy(RenderWindow window,Character player, int type, float xPosition, float yPosition,float endPosition,int movementSpeed,float length,int damage){
            this.type = type;
            this.window = window;
            this.player = player;
            this.damage = damage;
            this.movementSpeed = movementSpeed;
            this.length = length;
           
            initialiseEnemy(type,xPosition,yPosition,endPosition);
        }

    public void initialiseEnemy( int type, float xPosition, float yPosition, float endPosition){
        this.type = type;
        this.shape = new RectangleShape(new Vector2f(this.length, this.length));
        if(length>(float)450){shape.setFillColor(Color.RED);}
        //this.shape.setFillColor(Color.GREEN);
        this.shape.setOrigin(this.length/2, this.length/2);
        this.shape.setTexture(TextureList.getPlayerTexture(10));
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.endPosition = endPosition;
        if(this.type==TYPE_HORIZONTAL){
            startPosition=xPosition;
        }
        if(this.type==TYPE_VERTICAL){
            startPosition = yPosition;
        }
    }

    public void update(){
            this.shape.rotate(1);
            if(type == TYPE_HORIZONTAL){
                xPosition += movementSpeed;
                //System.out.printf("x: %f  y: %f  Target X: %f\n",xPosition,yPosition,endPosition);
                if(xPosition >= endPosition || xPosition<=startPosition){
                    movementSpeed = -movementSpeed;
                }
            }
            if(type == TYPE_VERTICAL){
                yPosition += movementSpeed;
                if(yPosition >= endPosition || yPosition<=startPosition){
                    movementSpeed = -movementSpeed;
                }
            }
            this.shape.setPosition(xPosition,yPosition);
        }

    public void draw(){
        this.window.draw(this.shape);
    }

    public void checkCollision(){
        if(player.checkPlayerModelCollisio(this.shape.getGlobalBounds())){
            player.takeDamage(this.damage);
        }
    }
}
