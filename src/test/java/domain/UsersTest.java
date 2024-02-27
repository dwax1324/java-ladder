package domain;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class UsersTest {
    @Test
    @DisplayName("사용자가 두명 미만이면 예외가 발생한다")
    void createOnlyUsers() {
        final String userNames = "pobi";

        assertThatThrownBy(() -> new Users(Arrays.stream(userNames.split(",")).toList()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자는 최대 50명을 초과하면 예외가 발생한다")
    void maxUsers() {
        final List<String> userNames = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            userNames.add(String.valueOf(i));
        }
        userNames.add("51");

        assertThatThrownBy(() -> new Users(userNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("존재하지 않는 이름이 주어지면 예외가 발생한다")
    void nameNotExist() {
        final Users users = new Users(List.of("pobi", "rush", "jonge"));

        assertThatThrownBy(() -> users.findPositionByName("brown")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,0", "rush,1", "jonge,2"})
    @DisplayName("사용자 이름이 주어지면 그 위치를 반환한다")
    void findPositionByName(String name, int position) {
        final Users users = new Users(List.of("pobi", "rush", "jonge"));

        assertThat(users.findPositionByName(name)).isEqualTo(position);
    }
}
