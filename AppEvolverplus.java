package com.fossgalaxy.game;

import com.fossgalaxy.games.tbs.GameState;
import com.fossgalaxy.games.tbs.ai.AIFactory;
import com.fossgalaxy.games.tbs.ai.Controller;
import com.fossgalaxy.games.tbs.io.SettingsIO;
import com.fossgalaxy.games.tbs.metrics.AppEvolver;
import com.fossgalaxy.games.tbs.metrics.GameMetrics;
import com.fossgalaxy.games.tbs.parameters.GameSettings;

/**
 * Created by cy17261 on 22/05/2018.
 */
public class AppEvolverplus extends AppEvolver{
    public AppEvolverplus(SettingsIO io, GameSettings common, AIFactory ai, String mapFile) {
        super(io, common, ai, mapFile);
    }

    @Override
    public Double evaluate(GameSettings settings) {
        GameState start = this.map.buildState(settings);
        int[] winCounts = new int[2];

        for(int score = 0; score < 10; ++score) {
            Controller[] controllers = new Controller[]{this.ai.buildAI("SFB", settings), this.ai.buildAI("SFR", settings)};
            GameState state = new GameState(start);
            GameMetrics metrics = runGame(state, settings, controllers);
            Integer winner = metrics.getWinner();
            if(winner != null) {
                ++winCounts[winner.intValue()];
            }
        }

        double var9 = (double)(winCounts[1] - winCounts[0]);
        this.fitnessScores.put(settings, Double.valueOf(var9));
        return Double.valueOf(var9);
    }
}
