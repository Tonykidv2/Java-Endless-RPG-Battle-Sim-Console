/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgbattle;
import java.util.Random;

/**
 *
 * @author TheNinjaFS1
 */
public class Enemy extends Character
{
  Enemy(String _name, float _hp, float _str, float _def)
  {
    SetName(_name);
    SetHealth(_hp);
    SetStrength(_str);
    SetDefend(_def);
  }
  
  Actions Update()
  {
      System.out.println("Current Enemy: " + GetName());
      System.out.printf("Current Enemy HP: %5.2f", GetHealth());
      System.out.println();
      System.out.println();
      System.out.println();
      //Randomly deciding what the enemy will do
      //Attack or defend
      Random rand = new Random();
      int n = rand.nextInt(10) + 1;
      
      
      switch(n % 2)
      {
          case 0:
              return Actions.Attack;
          case 1:
              return Actions.defend;
          default:
              return Actions.Defaulter;
      }
      //return Actions.Defaulter;
  }
};
