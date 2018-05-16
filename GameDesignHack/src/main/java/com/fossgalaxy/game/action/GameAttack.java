package com.fossgalaxy.game.action;

import com.fossgalaxy.game.order.GameMoveOrder;
import com.fossgalaxy.games.tbs.GameState;
import com.fossgalaxy.games.tbs.actions.MeleeAttackAction;
import com.fossgalaxy.games.tbs.order.Order;
import org.codetome.hexameter.core.api.CubeCoordinate;


import java.util.UUID;

public class GameAttack extends MeleeAttackAction {

    public GameAttack() {
    }

    @Override
    public Order generateOrder(CubeCoordinate co, GameState s) {
        return new GameMoveOrder(co);
    }
}
