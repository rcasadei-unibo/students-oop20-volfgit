package vg.utils.Round;


import vg.model.mysteryBox.dataRound.DataRound;
import vg.model.mysteryBox.dataRound.DataRoundImpl;
import vg.utils.V2D;

import java.util.List;
import java.util.Map;

public class MysteryBoxPositionUtils {

    //Round 1
    private static final List<DataRound> ROUND1 = List.of(
            new DataRoundImpl(new V2D(660, 450), false),
            new DataRoundImpl(new V2D(2, 790), false),
            new DataRoundImpl(new V2D(302, 790), true),
            new DataRoundImpl(new V2D(660, 790), false),
            new DataRoundImpl(new V2D(1016, 790), true),
            new DataRoundImpl(new V2D(1316, 790), false)
    );

    //Round 2
    private static final List<DataRound> ROUND2 = List.of(
            new DataRoundImpl(new V2D(660, 450), false),
            new DataRoundImpl(new V2D(2, 790), false),
            new DataRoundImpl(new V2D(302, 790), false),
            new DataRoundImpl(new V2D(660, 790), false),
            new DataRoundImpl(new V2D(1016, 790), false),
            new DataRoundImpl(new V2D(1316, 790), false)
    );

    //Round 3
    private static final List<DataRound> ROUND3 = List.of(
            new DataRoundImpl(new V2D(660, 450), false),
            new DataRoundImpl(new V2D(2, 790), false),
            new DataRoundImpl(new V2D(302, 790), false),
            new DataRoundImpl(new V2D(660, 790), false),
            new DataRoundImpl(new V2D(1016, 790), false),
            new DataRoundImpl(new V2D(1316, 790), false)
    );


    public static final Map<Integer, List<DataRound>> POSITION_ROUND = Map.of(1, ROUND1, 2, ROUND2, 3, ROUND3);

}
