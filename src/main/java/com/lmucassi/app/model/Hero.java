package com.lmucassi.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Hero extends Character{
    @NotNull
    private String heroClass;
    public int prevDir;
    private int exp;
    private int level = 1;

}
