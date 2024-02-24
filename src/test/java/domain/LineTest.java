package domain;

import mock.TrueGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    @DisplayName("가로 길이는 {사용자 수 - 1} 이다.")
    void createLineWithPersonCount() {
        int personCount = 4;
        List<Bridge> bridges = List.of(Bridge.BRIDGE, Bridge.BRIDGE, Bridge.BRIDGE);

        assertThat(new Line(bridges).getBridges()).size().isEqualTo(personCount - 1);
    }

    @Test
    @DisplayName("가로 브릿지가 겹치는 경우 예외를 발생시킨다")
    void createRandomLine() {
//        List<Bridge> bridges = List.of(Bridge.BRIDGE, Bridge.BRIDGE, Bridge.BRIDGE);
//
//        assertThatThrownBy(() -> new Line(bridges)).isEqualTo();
    }
}
