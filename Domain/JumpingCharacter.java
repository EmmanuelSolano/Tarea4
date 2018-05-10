package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {
     
    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 3; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping"+i+".png")));
        }
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        while (true) {
            try {
                for (int j = 270; j < 365; j++) {
                    
                    super.setImage(sprite.get(1));
                    Thread.sleep(10);
                    this.setY(j);

                }
                super.setImage(sprite.get(2));
                Thread.sleep(400);
                this.setY(270);

                for (int j = 365; j  > 270; j--) {
                    super.setImage(sprite.get(0));
                    Thread.sleep(10);
                    this.setY(j);
                }
                Thread.sleep(30);
                
            }catch (InterruptedException ex) {} 
        }
    }
}
