import static org.assertj.core.api.Assertions.assertThat;

import java.util.random.RandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    @Test
    @DisplayName("브릿지는 무작위로 자신의 상태를 반환한다")
    public void bridgeStatus() {
        // given
        Bridge bridge = new Bridge(new TrueGenerator());
        // when
        // then
        assertThat(bridge.getState()).isEqualTo(true);
    }
}
