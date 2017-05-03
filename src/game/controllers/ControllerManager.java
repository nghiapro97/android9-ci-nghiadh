package game.controllers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ControllerManager {
    private ArrayList<Controller> controllers;

    public static final ControllerManager instance = new ControllerManager();

    private ControllerManager() {
        controllers = new ArrayList<>();
    }

    public void add(Controller controller){
        controllers.add(controller);
    }

    public void draw(Graphics graphics){
        for(Controller controller : controllers){
            controller.update();
        }
    }

    public void update(){
        Iterator<Controller> iterator = controllers.iterator();
        while(iterator.hasNext()){
            Controller controller = iterator.next();
            if(controller.getGameRect().isDead()){
                controllers.remove(controller);
            }
        }

        for(Controller controller : controllers){
            controller.update();
        }
    }
}
