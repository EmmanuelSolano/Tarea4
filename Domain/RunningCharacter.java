package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 8; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Running"+i+".png")));
        }
          
    }

    @Override
    public void run() {
        
        ArrayList<Image> sprite = super.getSprite();
        
        while (true) {
            try {
                for (int i = 70; i <=700; i+=5) {
                    for (int f = 0; f < 8; f++) {
                        super.setImage(sprite.get(f));
                        Thread.sleep(55);
                    }
                    super.setX(i);
                }
            
            }catch (InterruptedException ex) {}
        }
    }
}
