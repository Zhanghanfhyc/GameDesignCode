package com.fossgalaxy.game.action;

import com.fossgalaxy.game.order.GameUpgradeOrder;
import com.fossgalaxy.games.tbs.GameState;
import com.fossgalaxy.games.tbs.actions.AbstractAction;
import com.fossgalaxy.games.tbs.actions.UpgradeAction;
import com.fossgalaxy.games.tbs.entity.Entity;
import com.fossgalaxy.games.tbs.order.Order;
import com.fossgalaxy.games.tbs.order.UpgradeOrder;
import com.fossgalaxy.games.tbs.parameters.EntityType;
import com.fossgalaxy.object.annotations.ObjectDef;
import org.codetome.hexameter.core.api.CubeCoordinate;

import java.awt.*;
import java.util.Map;
import java.util.Objects;

public class GameUpgrade extends AbstractAction{

    private EntityType from;
    private EntityType to;

    @ObjectDef("GameUpgrade")
    public GameUpgrade(EntityType first, EntityType second) {
        this.from = Objects.requireNonNull(first);
        this.to = Objects.requireNonNull(second);
        System.out.println("GameUpgrade!");
    }
    @Override
    public boolean isPossible(Entity entity, GameState s, CubeCoordinate co) {
        //can we afford it?
        for(Map.Entry<String,Integer>costEntry:to.getCosts().entrySet()){
            int currVal = s.getResource(entity.getOwner(), costEntry.getKey());
            if(currVal<costEntry.getValue())
                return false;
        }
        return co.equals(entity.getPos()) && isPossible(entity, s);
    }

    @Override
    public Color getHintColour() {
        return HINT_UPGRADE_COLOUR;
    }

    @Override
    public Color getBorderColour() {
        return Color.CYAN;
    }

    @Override
    public Order generateOrder(CubeCoordinate co, GameState s) {
        return new GameUpgradeOrder(from, to);
    }

    @Override
    public boolean isPossible(Entity entity, GameState s) {
        return from.equals(entity.getType());
    }

    public String toString() {
        return "upgrade_2 " + from;
    }

}
