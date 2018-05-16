package com.fossgalaxy.game.order;

import com.fossgalaxy.games.tbs.GameState;
import com.fossgalaxy.games.tbs.entity.Entity;
import com.fossgalaxy.games.tbs.order.AttackOrderMelee;

import java.util.UUID;

public class GameAttackMeleeOrder extends AttackOrderMelee {

    public GameAttackMeleeOrder(UUID target) {
        super(target);
    }

    @Override
    public void doOrder(Entity entity, GameState state) {

        System.out.println("preFood"+entity.getProperty("food"));
            Entity target = state.getEntityByID(targetID);
            if (target == null) {
                return;
            }

            //melee is always distance 1.
            int range = state.getDistance(entity.getPos(), target.getPos());
            if (range > 1) {
                return;
            }

            //murdering one's self is counterproductive
            if (entity.equals(target)) {
                return;
            }


            int dmgToTarget = getDamage(entity, target);
            target.setHealth(target.getHealth() - dmgToTarget);
        

            //kill the entity if they run out of health.
            //this needs to be done when the order is processed, else it could effect other entities' moves.
            //eg, A murders B, C moves into B's space.
            if (target.getHealth() <= 0) {
                state.removeEntity(target);
            // grab food
                entity.setProperty("food",entity.getProperty("food")+target.getProperty("food"));
                System.out.println("curFood"+entity.getProperty("food"));

            }

            //we could have died to...
            if (entity.getHealth() <= 0) {
                state.removeEntity(entity);

                //add XP for killing a unit.
                if (target.getHealth() > 0) {
                    target.setProperty("xp", entity.getProperty("xpAward", 0));
                }
            }
        }
    }

