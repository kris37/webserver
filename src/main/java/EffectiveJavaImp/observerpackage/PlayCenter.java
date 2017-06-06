package EffectiveJavaImp.observerpackage;

import EffectiveJavaImp.observerpackage.MyInterface.GamePlayer;
import EffectiveJavaImp.observerpackage.MyInterface.InfoCenter;

import java.util.ArrayList;

/**
 * Created by panqiang on 2017/6/6.
 */
public class PlayCenter extends InfoCenter<GamePlayer> {

    public PlayCenter(String centerName){
        this.setCenterName(centerName);
        System.out.println(this.getCenterName()+" center build sucess !");
    }
    @Override
    public String getCenterName() {
        return super.getCenterName();
    }

    @Override
    public void setCenterName(String centerName) {
        super.setCenterName(centerName);
    }

    @Override
    public void join(GamePlayer player) {
        super.join(player);
        System.out.println("welcome player"+player.getName()+" join "+this.getCenterName());
    }

    @Override
    public void quit(GamePlayer player) {
        super.quit(player);
        System.out.println("Warning player"+player.getName()+" quit "+this.getCenterName());
    }

    // 调用 组内的help
    @Override
    public void notice(GamePlayer player) {
        //super.list.forEach(obj->if (o) obj.help());
        super.list.stream().filter(obj-> !obj.equals(player)).forEach(obj-> obj.help());
    }
}
