package vg.utils.path;

import java.util.List;

public class PathImageEnemy {
    private static final String PATH_RADICE = "img/";
    private static final String PATH_BOSS = PATH_RADICE + "boss/";


    public static final List<String> BOSS = List.of(
            PATH_BOSS + "boss1.png",
            PATH_BOSS + "boss2.png",
            PATH_BOSS + "boss3.png",
            PATH_BOSS + "boss4.png"
    );

    public static final String MOSQUITOES = PATH_RADICE + "alien.png";

}
