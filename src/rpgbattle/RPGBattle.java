/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgbattle;
import java.util.Scanner;

/**
 *
 * @author TheNinjaFS1
 */
public class RPGBattle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        boolean GameRun = true;
        int battlesWon = 0;
        String tempName = "Main";
        float health = 100;
        float defend = 15;
        float strength = 15;
        float intelli = 25;
        float mana = 3;
        
        
        System.out.println("Welcome to Endless RPG Battles!! Enter Your Name:");
        tempName = in.next();
        Player MainCharacter = new Player(tempName, health, strength, defend,
                intelli,mana);
        
        String[] enemyNames = new String[5];
        enemyNames[0] = "Goblin";
        enemyNames[1] = "Wolf";
        enemyNames[2] = "Orc";
        enemyNames[3] = "Slime";
        enemyNames[4] = "FallenKnight";
        
        Enemy enemy = new Enemy(enemyNames[0], health - 50, defend - 7, 
                strength);
        
        while(GameRun)
        {
            int EnemyAction = enemy.Update().getValue();
            int PlayerAction = MainCharacter.Update().getValue();
            
            if(MainCharacter.GetHealth() <= 0)
            {
                GameRun = false;
            }
        }
    }
    
}
