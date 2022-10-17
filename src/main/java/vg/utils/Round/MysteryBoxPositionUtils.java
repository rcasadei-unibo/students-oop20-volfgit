package vg.utils.Round;


import com.sun.javafx.geom.Vec2d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysteryBoxPositionUtils {


    public static final Map<Integer, List<Vec2d>> POSITION_ROUND = new HashMap<>(){{
        put(1, ROUND1);
        put(2, ROUND2);
        put(3, ROUND3);
        put(4, ROUND4);
    }};

    //Round 1
    private static final List<Vec2d> ROUND1 = List.of(
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0)
    );

    //Round 2
    private static final List<Vec2d> ROUND2 = List.of(
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0)
    );

    //Round 3
    private static final List<Vec2d> ROUND3 = List.of(
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0)
    );

    //Round 4
    private static final List<Vec2d> ROUND4 = List.of(
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0),
            new Vec2d(0, 0)
    );

}
