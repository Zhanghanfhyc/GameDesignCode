package com.fossgalaxy.game.action;

import com.fossgalaxy.games.tbs.GameState;
import com.fossgalaxy.games.tbs.actions.UpgradeAction;
import com.fossgalaxy.games.tbs.entity.Entity;
import com.fossgalaxy.games.tbs.parameters.EntityType;
import org.codetome.hexameter.core.api.CubeCoordinate;

public class GameUpgrade extends UpgradeAction{
    @Override
    public boolean isPossible(Entity entity, GameState s, CubeCoordinate co) {

    }

    @Override
    public boolean isPossible(Entity entity, GameState s) {
        return super.isPossible(entity, s);
    }

    public GameUpgrade(EntityType first, EntityType second) {
        super(first, second);
    }
}
