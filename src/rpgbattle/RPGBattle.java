/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgbattle;
import java.util.Scanner;
import java.util.Random;

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
        String tempName;
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
            Character.Actions EnemyAction = enemy.Update();
            Character.Actions PlayerAction = MainCharacter.Update();
            
            //if Enemy is Defending
            if(EnemyAction == Character.Actions.defend)
            {
                float totalDamage;
                switch(PlayerAction)
                {
                    case defend:
                         System.out.println("Both of you Braced for an attack but you"
                           + " both did at the same you too look stupid doing it!!");
                         break;
                    case Attack:
                        System.out.println("Enemy Braced for an attack");
                        totalDamage = MainCharacter.GetStrength()- enemy.GetDefend();
                        System.out.printf("You Attacked dealing %5.2f ", totalDamage, " Damage!");
                        enemy.SetHealth(enemy.GetHealth() - totalDamage);
                        break;
                    case Magic:
                        System.out.println("Enemy Braced for an attack");
                        totalDamage = MainCharacter.GetStrength()- enemy.GetDefend();
                        System.out.printf("You use a Magic Attack Dealing %5.2f "
                            , totalDamage, " Damage!");
                        enemy.SetHealth(enemy.GetHealth() - totalDamage);
                        break;
                    case item:
                        System.out.println("Enemy Braced for an attack");
                        System.out.println("You used a Potion Healing 30 HP ");
                        MainCharacter.SetHealth(MainCharacter.GetHealth() + 30);
                }
            }
            else
            {
                float totalDamage;
                
                switch(PlayerAction)
                {
                    case defend:
                        System.out.println("You Braced for an Attack! ");
                        
                        totalDamage = enemy.GetStrength() - MainCharacter.GetDefend();
                        System.out.printf(enemy.GetName() + " attacked you with "
                                + "%5.2f ", totalDamage, " Damage!" );
                        MainCharacter.SetHealth(MainCharacter.GetHealth() - totalDamage);
                        break;
                    case Attack:
                        totalDamage = MainCharacter.GetStrength();
                        System.out.printf("You Attacked dealing %5.2f ", totalDamage, " Damage!");
                        enemy.SetHealth(enemy.GetHealth() - totalDamage);
                        
                        totalDamage = enemy.GetStrength();
                        System.out.printf(enemy.GetName() + " attacked you with "
                                + "%5.2f ", totalDamage, " Damage!" );
                        MainCharacter.SetHealth(MainCharacter.GetHealth() - totalDamage);
                        break;
                    case Magic:
                        
                        totalDamage = MainCharacter.GetStrength() + MainCharacter.GetMagicStrength();
                        System.out.printf("You use a Magic Attack Dealing %5.2f ", totalDamage, " Damage!");
                        enemy.SetHealth(enemy.GetHealth() - totalDamage);
                        
                        totalDamage = enemy.GetStrength();
                        System.out.printf(enemy.GetName() + " attacked you with "
                                + "%5.2f ", totalDamage, " Damage!" );
                        MainCharacter.SetHealth(MainCharacter.GetHealth() - totalDamage);
                        break;
                    case item:
                        System.out.println("You used a Potion Healing 30 HP ");
                        MainCharacter.SetHealth(MainCharacter.GetHealth() + 30);
                        totalDamage = enemy.GetStrength();
                        System.out.printf(enemy.GetName() + " attacked you with "
                                + "%5.2f ", totalDamage, " Damage!" );
                        MainCharacter.SetHealth(MainCharacter.GetHealth() - totalDamage);
                        break;
                }
            }
            
            if(MainCharacter.GetHealth() <= 0)
            {
                GameRun = false;
            }
            else if(MainCharacter.GetHealth() >= 0 && GameRun == true && enemy.GetHealth() <= 0)
            {
                battlesWon++;
                System.out.println("You Won the battle you got a potion! Next Battle will commense");
                try {Thread.sleep(1000);}
                catch (InterruptedException e){e.printStackTrace();}
                Random rand = new Random();
                int n = rand.nextInt(5);
                enemy = new Enemy(enemyNames[n], health - 50, defend - 7, 
                strength);
            }
        }
    }
    
}
