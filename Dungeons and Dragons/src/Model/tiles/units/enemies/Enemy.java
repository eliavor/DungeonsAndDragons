package Model.tiles.units.enemies;

import Model.tiles.Empty;
import Model.tiles.units.Unit;
import Model.tiles.units.players.Player;
import Model.utils.Position;
import utilsGeneral.MessageCallBackToView;

public abstract class Enemy extends Unit {

    protected int experienceValue;
    public Enemy(int x, int y, String name, char symbol, int health , int attack, int defense, int experienceValue, MessageCallBackToView messageCallBackToView) {
        super(x, y, symbol, name, health, attack, defense, messageCallBackToView);
        this.experienceValue = experienceValue;
    }

    public int getExperience(){
        return experienceValue;
    }

    public void onDeath(){
        messageCallBackToView.UpdateTile('.',this.position.getX(), this.position.getY());
    }

    @Override
    public void accept(Unit unit) {
        if(isAlive()){
            unit.visit(this);
        }
        else{
            unit.visit(new Empty(this.position.getX(), this.position.getY(),messageCallBackToView));
        }
    }

    public void visit(Player p){
        if(p.isAlive() &&  isAlive()){
            battle(p);
            if(!p.isAlive()){
                p.onDeath();
            }
            if(!isAlive()){
                onDeath();
            }
        }
    }

    public void visit(Enemy enemy){
        //DO NOTHING
    }



    public abstract Position OnEnemyTurn(Player  player);

}
