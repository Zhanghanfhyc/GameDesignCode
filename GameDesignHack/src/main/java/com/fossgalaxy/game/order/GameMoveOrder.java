package com.fossgalaxy.game.order;

import com.fossgalaxy.games.tbs.GameState;
import com.fossgalaxy.games.tbs.entity.Entity;
import com.fossgalaxy.games.tbs.order.MoveOrder;
import org.codetome.hexameter.core.api.CubeCoordinate;

public class GameMoveOrder extends MoveOrder {
    public GameMoveOrder(CubeCoordinate move) {
        super(move);
    }

    @Override
    public void doOrder(Entity entity, GameState state) {
        super.doOrder(entity, state);
        entity.setProperty("food",entity.getProperty("food")-1);
        if(entity.getProperty("food")<=0)
        {state.removeEntity(entity);
        return;}
        System.out.println("food:"+entity.getProperty("food"));
    }
}
