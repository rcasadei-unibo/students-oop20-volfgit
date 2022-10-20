package vg.utils.Round;


import vg.utils.V2D;

import java.util.List;
import java.util.Map;

public class MysteryBoxPositionUtils {

    //Round 1
    private static final List<V2D> ROUND1 = List.of(
            new V2D(660, 450),
            new V2D(2, 791),
            new V2D(302, 790),
            new V2D(660, 790),
            new V2D(1016, 790),
            new V2D(1316, 790)
    );

    //Round 2
    private static final List<V2D> ROUND2 = List.of(
            new V2D(0, 0),
            new V2D(0, 0),
            new V2D(0, 0),
            new V2D(0, 0),
            new V2D(0, 0),
            new V2D(0, 0)
    );

    //Round 3
    private static final List<V2D> ROUND3 = List.of(
            new V2D(0, 0),
            new V2D(0, 0),
            new V2D(0, 0),
            new V2D(0, 0),
            new V2D(0, 0),
            new V2D(0, 0)
    );

    //Round 4
    private static final List<V2D> ROUND4 = List.of(
            new V2D(0, 0),
            new V2D(0, 0),
            new V2D(0, 0),
            new V2D(0, 0),
            new V2D(0, 0),
            new V2D(0, 0)
    );

    public static final Map<Integer, List<V2D>> POSITION_ROUND = Map.of(1, ROUND1, 2, ROUND2, 3, ROUND3, 4, ROUND4);

}
