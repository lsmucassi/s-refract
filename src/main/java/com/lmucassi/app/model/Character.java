package com.lmucassi.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Character {
    @NotNull(message = "\033[32mName cannot be null.\033[0m")
    private String name;
    @Min(value = 0, message = "\033[32mHitPoint cannot be lower than 0.\033[0m")
    @Max(value  = 100, message = "\033[32mHitPoint cannot be higher than 100.\033[0m")
    private int hitPoints;
    @Min(value = 0, message = "\033[32mAttack cannot be lower than 0\033[0m")
    private int attack;
    @Min(value = 0, message = "\033[32mDefense cannot be lower than 0\033[0m")
    private int defense;
    @NotNull(message = "\033[32mWeapon cannot be null.\033[0m")
    private String weapon;
    @NotNull(message = "\033[32mArmor cannot be null.\033[0m")
    private String armor;
    @Min(value = 0, message = "\033[32mPosition cannot be lower than 0\033[0m")
    private int x, y;
}
