package com.fossgalaxy.game.order;

import com.fossgalaxy.game.Game;
import com.fossgalaxy.games.tbs.GameState;
import com.fossgalaxy.games.tbs.entity.Entity;
import com.fossgalaxy.games.tbs.order.Order;
import com.fossgalaxy.games.tbs.parameters.EntityType;
import com.sun.prism.shader.Solid_TextureRGB_AlphaTest_Loader;

import java.util.Map;

public class GameUpgradeOrder implements Order {

        private EntityType from;
        private EntityType to;

        public GameUpgradeOrder(EntityType from, EntityType to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void doOrder(Entity host, GameState state) {
            if (!from.equals(host.getType())) {
                return;
            }

            int newHealth = (int) (host.getHealthFrac() * to.getProperty("health"));
            System.out.println("getCost!"+ to.getCosts());
            for(Map.Entry<String,Integer>costEntry:to.getCosts().entrySet()){
                String t = costEntry.getKey();
                int costVal = costEntry.getValue();
                state.addResource(host.getOwner(), t, -costVal);
                System.out.println("cost"+costEntry.getKey()+" "+costEntry.getValue());
            }
            host.setType(to);
            host.setHealth(newHealth);
        }
}

