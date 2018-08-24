package model;

public class Characters {

    int life = 100;
    int hitPoint = 0;
    int level = 0;
    int exp = 0;

    public Characters() {}

    //set
    public void setLife(int lf) {
        this.life = lf;
    }

    public void setHitPoint(int hp) {
        this.hitPoint = hp;
    }

    public void setLevel(int lev) {
        this.level = lev;
    }

    public void setExp(int expr) {
        this.exp = expr;
    }

    //get
    public int getLife() {
        return this.life;
    }

    public int getHitPoint() {
        return this.hitPoint;
    }

    public int getLevel() {
        return this.level;
    }

    public int getExp() {
        return this.exp;
    }
}
