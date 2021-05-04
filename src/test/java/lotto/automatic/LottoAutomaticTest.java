package lotto.automatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutomaticTest {
    LottoAutomatic lottoAutomatic = new LottoAutomatic();
    @DisplayName("로또 번호 6개 사이즈 체크확인")
    @Test
    void listSize(){
        List<Integer> lottoOne = lottoAutomatic.lottoOne(lottoAutomatic.numberList());
        assertThat(lottoOne.size()).isEqualTo(6);
    }

    @DisplayName("로또 당첨 번호 비교")
    @Test
    void proceeds(){//ArrayList<List> lottoList , String winNumbers 생략
        List<Integer> winNumbersTest = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> list = new ArrayList<>();
        list.add(32);
        list.add(24);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(3);

        int count=0;

        for(int i=0; i<6; i++) {
            count = getCount(winNumbersTest, list, count, i);
        }
        assertThat(count).isEqualTo(3);
    }

    private int getCount(List<Integer> winNumbersTest, List<Integer> list, int count, int i) {
        if(list.contains(winNumbersTest.get(i)) ==true){
            count++;
        }
        return count;
    }

}
