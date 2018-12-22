package base.enemysummoner;

import base.GameObject;
import base.action.*;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.BoxRenderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class EnemySummoner extends GameObject {
    ArrayList<EnemySummonerPart> enemySummonerParts = new ArrayList<>();
    Action action;
    int roll;

    public EnemySummoner() {
        this.roll = 0;
        this.createParts();
        this.action = this.createAction();
    }

    private void createParts() {
        EnemySummonerPart part1 = GameObject.recycle(EnemySummonerPart.class);
        part1.position.set(-100, (int)Settings.SCREEN_HEIGHT / 2 - 200);
        EnemySummonerPart part2 = GameObject.recycle(EnemySummonerPart.class);
        part2.position.set(-100, (int)Settings.SCREEN_HEIGHT / 2 + 100);
        EnemySummonerPart part3 = GameObject.recycle(EnemySummonerPart.class);
        part3.position.set(100, (int)Settings.SCREEN_HEIGHT + 100);
        EnemySummonerPart part4 = GameObject.recycle(EnemySummonerPart.class);
        part4.position.set((int)Settings.SCREEN_WIDTH/2 + 100, (int)Settings.SCREEN_HEIGHT + 100);
        EnemySummonerPart part5 = GameObject.recycle(EnemySummonerPart.class);
        part5.position.set((int)Settings.SCREEN_WIDTH + 100, (int)Settings.SCREEN_HEIGHT / 2 + 100);
        EnemySummonerPart part6 = GameObject.recycle(EnemySummonerPart.class);
        part6.position.set((int)Settings.SCREEN_WIDTH + 100, (int)Settings.SCREEN_HEIGHT / 2 - 200);
        EnemySummonerPart part7 = GameObject.recycle(EnemySummonerPart.class);
        part7.position.set((int)Settings.SCREEN_WIDTH/2 + 100, -100);
        EnemySummonerPart part8 = GameObject.recycle(EnemySummonerPart.class);
        part8.position.set(100, - 100);
        enemySummonerParts.add(part1);
        enemySummonerParts.add(part2);
        enemySummonerParts.add(part3);
        enemySummonerParts.add(part4);
        enemySummonerParts.add(part5);
        enemySummonerParts.add(part6);
        enemySummonerParts.add(part7);
        enemySummonerParts.add(part8);
    }

    private Action createAction() {
        Action wait = new ActionWait(20);
        Action summon = new ActionSummonEnemy();
        Action sequence = new ActionSequence(summon,wait);
        Action repeat = new ActionRepeat(sequence);
        return repeat;
    }

    @Override
    public void run() {
        super.run();
        rollForSummon();

    }

    private void rollForSummon() {
        Random random = new Random();
        roll = random.nextInt(8);
        for (int i = 0; i < enemySummonerParts.size(); i ++){
            if (roll == i) {
                this.action.run(enemySummonerParts.get(i));
            }
        }

    }
}
