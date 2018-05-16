package com.fossgalaxy.game.rule;

import com.fossgalaxy.games.tbs.GameState;
import com.fossgalaxy.games.tbs.rules.Rule;
import com.fossgalaxy.object.annotations.ObjectDef;

import java.util.Collections;
import java.util.List;

import static com.fossgalaxy.games.tbs.rules.Rule.NO_WINNER;

public class PlayerFilter implements Rule {
    private final Rule actual;
    private final Integer player;

    @ObjectDef("PlayerFilter")
    public PlayerFilter(int player, Rule actual) {
        this.player = player;
        this.actual = actual;
    }

    @Override
    public Integer getWinner(GameState state) {
        Integer winner = actual.getWinner(state);
        return winner == player ? winner : NO_WINNER;
    }

    @Override
    public List<Integer> getLosers(GameState state) {
        List<Integer> losers = actual.getLosers(state);
        if(losers.isEmpty()) return losers;
        if(losers.contains(player)){
            losers.clear();
            losers.add(player);
            return losers;
        }
        return Collections.emptyList();
    }
}
