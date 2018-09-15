package com.lmucassi.app.Interface;

import com.lmucassi.app.ErrException.ErrException;
import com.lmucassi.app.model.Hero;

public interface IModes {
    void createHero();
    void getHeroes() throws ErrException;
    void log(Hero hero);
}
