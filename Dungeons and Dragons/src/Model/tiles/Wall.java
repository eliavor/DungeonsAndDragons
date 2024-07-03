package Model.tiles;

import Model.tiles.units.Unit;

public class Wall extends Tile{

    public static final char SYMBOL = '#';

    public Wall() {
        super(SYMBOL);
    }


    @Override
    public void accept(Unit unit) {
        unit.visit(this);

    }
    public void interact(int i, int i1, Tile[][] board) {
        //do nothing
    }
}
