package com.fossgalaxy.game.order;

import com.fossgalaxy.games.tbs.GameState;
import com.fossgalaxy.games.tbs.entity.Entity;
import com.fossgalaxy.games.tbs.order.UpgradeOrder;
import com.fossgalaxy.games.tbs.parameters.EntityType;
import com.fossgalaxy.games.tbs.parameters.ResourceType;

import java.util.Map;

public class GameUpgradeOrder extends UpgradeOrder{
    private EntityType from;
    private EntityType to;


    public GameUpgradeOrder(EntityType from, EntityType to, ResourceType typeToMine, int quantity) {

    }


    @Override
    public void doOrder(Entity host, GameState state) {
        if (!from.equals(host.getType())) {
            return;
        }

        int newHealth = (int) (host.getHealthFrac() * to.getProperty("health"));

        host.setType(to);
        host.setHealth(newHealth);
    }
}
