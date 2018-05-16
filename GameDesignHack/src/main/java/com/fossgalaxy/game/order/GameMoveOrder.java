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
        System.out.println("food:"+entity.getProperty("food"));
    }
}
