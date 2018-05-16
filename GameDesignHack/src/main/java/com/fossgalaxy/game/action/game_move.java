package com.fossgalaxy.game.action;

import com.fossgalaxy.game.order.GameMoveOrder;
import com.fossgalaxy.games.tbs.GameState;
import com.fossgalaxy.games.tbs.actions.MoveAction;
import com.fossgalaxy.games.tbs.entity.Entity;
import com.fossgalaxy.games.tbs.order.Order;
import com.fossgalaxy.games.tbs.parameters.TerrainType;
import org.codetome.hexameter.core.api.CubeCoordinate;

public class game_move extends MoveAction {
    private static final String MOVEMENT_PROP = "movement";

@Override
public boolean isPossible(Entity entity, GameState s, CubeCoordinate co) {
    //movement is not possible if the space is occupied
    Entity e = s.getEntityAt(co);
    if (e != null) {
        return false;
    }

    //movement is not possible if it's too far away
    int movementDist = entity.getType().getProperty(MOVEMENT_PROP, 0);
    if (movementDist < s.getDistance(entity.getPos(), co)) {
        return false;
    }

    TerrainType tt = s.getTerrainAt(co);
    if (tt == null || !tt.isPassible(entity)) {
        return false;
    }

    if(entity.getProperty("food")<1)
        return false;

    //movement might not be possible
    return isPossible(entity, s);
}

    @Override
    public Order generateOrder(CubeCoordinate co, GameState s) {
        return new GameMoveOrder(co);
    }

    @Override
    public boolean isPossible(Entity entity, GameState s) {
        System.out.println(entity.getProperty("food"));

        return entity.getType().getProperty(MOVEMENT_PROP, 0) >= 1;
    }
}
