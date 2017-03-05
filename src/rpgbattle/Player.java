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

public class Player extends Character
{
  float MagicStrength;
  float Mana;
  int numPotions;
  
  Player(String _name, float _hp, float _str, float _def, float _intell, float 
          _mana)
  {
    SetName(_name);
    SetHealth(_hp);
    SetStrength(_str);
    SetDefend(_def);
    SetMagicStrength(_intell);
    SetMana(_mana);
  }
  public float GetMagicStrength() {return MagicStrength;}
  public float GetMana() {return Mana;}
  public float GetPotionCount() {return numPotions;}
  
  public void SetMagicStrength(float _manaStr) {MagicStrength = _manaStr;}
  public void SetMana(float _mana) {Mana = _mana;}
  public void SetPotionCount(int _potion) {numPotions = _potion;}
  
  Actions Update()
  {
      Scanner in = new Scanner(System.in);
      System.out.println("Your Name: " + GetName());
      System.out.printf("Your HP: %5.2" + GetHealth());
      System.out.printf("Your MP: %5.2" + GetMana());
      System.out.println();
      System.out.println("What will you do: ");
      System.out.println("1: Attack");
      System.out.println("2: Use Magic");
      System.out.println("3: Defend");
      System.out.println("4: Use Potion");
      int Command;
      boolean keepgoing = true;
      
      while(keepgoing)
      {
          System.out.println("Your input: ");
          Command = in.nextInt();
          
          switch(Command)
          {
              case 1 :
                  return Actions.Attack;
              case 2 :
                  if(GetMana() > 0)
                    return Actions.Magic;
                  else
                      System.out.println("You don't have enough Mana!");
              case 3:
                  return Actions.defend;
              case 4 :
                  if(GetPotionCount() > 0)
                      return Actions.item;
                  else
                      System.out.println("You have no more Potions!");
                  break;
              default:
                  System.out.println("Invalid Command");
          }
          
      }
      return Actions.Defaulter;
  }
};
