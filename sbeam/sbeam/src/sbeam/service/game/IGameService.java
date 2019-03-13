package sbeam.service.game;

import java.util.List;

public interface IGameService {
    //获取上传的游戏
    public void getgames(Integer type);
    /*查找所有游戏*/
    public List allgames();
}
