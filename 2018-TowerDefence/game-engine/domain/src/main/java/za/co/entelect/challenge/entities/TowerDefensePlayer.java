package za.co.entelect.challenge.entities;

import za.co.entelect.challenge.config.GameConfig;
import za.co.entelect.challenge.enums.PlayerType;
import za.co.entelect.challenge.game.contracts.game.GamePlayer;

public class TowerDefensePlayer implements GamePlayer {

    private PlayerType playerType;
    private int energy;
    private int health;
    private int hitsTaken;
    private int score;

    public TowerDefensePlayer(PlayerType playerType, int energy, int health) {
        this.playerType = playerType;
        this.energy = energy;
        this.health = health;
        this.hitsTaken = 0;
        this.score = 0;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHitsTaken() {
        return hitsTaken;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }

    public void addEnergy(int energy) throws Exception {
        if (energy < 0) {
            throw new Exception("Unable to add negative energy, please use the removeEnergy method instead");
        }
        this.energy += energy;
    }

    public void removeEnergy(int energyToRemove) throws Exception {
        if (energyToRemove > this.energy) {
            throw new Exception("Unable to remove more energy than the player has");
        }

        this.energy -= energyToRemove;
    }

    public void takesHitByPlayer(Missile m, TowerDefensePlayer missileOwner) {
        int damageTaken = Math.min(health, m.getDamage());

        this.hitsTaken++;
        health -= damageTaken;
        health = Math.max(0, health);

        missileOwner.addScore(damageTaken * GameConfig.getHealthScoreMultiplier());
    }
}
