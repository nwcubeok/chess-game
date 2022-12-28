package model;

import java.util.Objects;
import java.util.List;

public class King extends Piece {
    private Boolean isUndefendable;

    public King(Integer color, Position position) {
        super(color, position);
    }


    public Boolean getIsUndefendable() {
        return this.isUndefendable;
    }

    public void setIsUndefendable (Boolean isUndefendable) {
        this.isUndefendable = isUndefendable;
    }
    @Override
    public void setMove(Piece[][] plateau){
        possibleMoves.clear();
        possibleCaptures.clear();

        int pX = this.getPosition().getX(), pY = this.getPosition().getY();

        if(pX+1 < plateau.length)
            possibleMoves.add(new Position(pX+1, pY));
        if(pX-1 > -1)
            possibleMoves.add(new Position(pX-1, pY));
        if(pY+1 < plateau.length)
            possibleMoves.add(new Position(pX, pY+1));
        if(pY-1 > -1)
            possibleMoves.add(new Position(pX, pY-1));
        if(pX+1 < plateau.length && pY+1 < plateau.length)
            possibleMoves.add(new Position(pX+1, pY+1));
        if(pX+1 < plateau.length && pY-1 > -1)
            possibleMoves.add(new Position(pX+1, pY-1));
        if(pX-1 > -1 && pY+1 < plateau.length)
            possibleMoves.add(new Position(pX-1, pY+1));
        if(pX-1 > -1 && pY-1 > -1)
            possibleMoves.add(new Position(pX-1, pY-1));

        List<Integer> index_remove = new java.util.ArrayList<>();
        for(int i = 0; i < possibleMoves.size() ; i++){
            if (plateau[possibleMoves.get(i).getX()][possibleMoves.get(i).getY()] != null && Objects.equals(plateau[possibleMoves.get(i).getX()][possibleMoves.get(i).getY()].getColor(), this.getColor()))
                index_remove.add(i);
        }
        for(int i = index_remove.size()-1; i > -1; i--){
            possibleMoves.remove((int)index_remove.get(i));
        }
        setCapture(plateau);
    }
}