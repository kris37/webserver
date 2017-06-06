package EffectiveJavaImp.observerpackage;

import EffectiveJavaImp.observerpackage.MyInterface.GamePlayer;
import EffectiveJavaImp.observerpackage.MyInterface.InfoCenter;

/**
 * Created by panqiang on 2017/6/6.
 */
public class Player implements GamePlayer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    //player 的notice 方法 调用 center 的notice
    @Override
    public void notice(InfoCenter ic) {
        System.out.println(this.getName()+" sb 了");
        ic.notice(this);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void help() {
        System.out.println(this.getName()+" will going to help you !!!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return name != null ? name.equals(player.name) : player.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
