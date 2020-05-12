package algorithm.other;

import org.junit.Test;

import java.util.List;

/**
 * @ClassName : KMPTest
 * @Author : TCW
 * @Date: 2020-05-12 11:18
 */
public class KMPTest {


    @Test
    public void KmpTest(){
        KMP kmp=new KMP();
        List<Integer> indexs = kmp.search("abbaabbaaba", "abbaaba");
        for (Integer index : indexs) {
            System.out.println(index);
        }

    }
}
