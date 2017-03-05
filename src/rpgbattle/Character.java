/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgbattle;

/**
 *
 * @author TheNinjaFS1
 */


public abstract class Character
{
  public enum Actions
  {
    Attack(1), defend(2), item(3), Magic(4), Defaulter(5);
    
    private int id = 1;
    private Actions(int id) { this.id = id; }
    public int getValue() { return id; }
    public Actions returnEnmu() {return this;}
  }
  
  Character()
  {
      
  }
  private String Name;  
  private float Health;
  private float Strength;
  private float Defense;
 
  public void SetHealth(float _health){Health = _health;}
  public void SetStrength(float _strength){ Strength = _strength;}
  public void SetDefend(float _defend) { Defense = _defend;}
  public void SetName(String _name) { Name = _name;};
  
  public float GetHealth(){return Health;}
  public float GetStrength(){return Strength;}
  public float GetDefend(){return Defense;}
  public String GetName() {return Name;}
  
};
