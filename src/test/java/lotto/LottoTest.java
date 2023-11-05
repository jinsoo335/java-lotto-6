package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호 일치하는 여부 체크")
    @Test
    void checkLottoTest(){
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto.checkLotto(List.of(1, 2, 3, 4, 5, 6), 7)).isEqualTo(Position.EQUAL_6);

        lotto = new Lotto(List.of(1,3,5,7,9,11));
        Assertions.assertThat(lotto.checkLotto(List.of(1,3,5,7,9,10), 11)).isEqualTo(Position.EQUAL_5PLUS);

        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto.checkLotto(List.of(1, 2, 3, 4, 10, 11), 7)).isEqualTo(Position.EQUAL_4);

        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto.checkLotto(List.of(1, 2, 3, 12, 10, 11), 7)).isEqualTo(Position.EQUAL_3);

        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto.checkLotto(List.of(1, 2, 13, 12, 10, 11), 7)).isNull();

    }
}