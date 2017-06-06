package EffectiveJavaImp.observerpackage;

import EffectiveJavaImp.observerpackage.MyInterface.GamePlayer;
import EffectiveJavaImp.observerpackage.MyInterface.InfoCenter;

/**
 * Created by panqiang on 2017/6/6.
 */
public class Test {
    public static void main(String args[]){
        InfoCenter<GamePlayer> center=new PlayCenter("穿越火线，三亿鼠标的梦想");
        GamePlayer player1,player2,player3,player4;
        player1=new Player("小学生");
        player2=new Player("初中生");
        player3=new Player("高中生");
        player4=new Player("大学生");
        center.join(player1);
        center.join(player2);
        center.join(player3);
        center.join(player4);
        player1.notice(center);
    }
}
