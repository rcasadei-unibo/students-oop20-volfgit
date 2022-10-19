package vg.utils.Round;


import com.sun.javafx.geom.Vec2d;

import java.util.List;
import java.util.Map;

public class MysteryBoxPositionUtils {

    //Round 1
    private static final List<Vec2d> ROUND1 = List.of(
            new Vec2d(660, 450),
            new Vec2d(2, 791),
            new Vec2d(302, 790),
            new Vec2d(660, 790),
            new Vec2d(1016, 790),
            new Vec2d(1316, 790)
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

    public static final Map<Integer, List<Vec2d>> POSITION_ROUND = Map.of(1, ROUND1, 2, ROUND2, 3, ROUND3, 4, ROUND4);

}
