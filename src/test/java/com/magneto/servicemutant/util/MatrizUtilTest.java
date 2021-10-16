package com.magneto.servicemutant.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {MatrizUtil.class})
public class MatrizUtilTest {

    @InjectMocks
    private MatrizUtil matrizUtil;
    private final String[] regularMatriz = {"ATGCG","AAGTC","ATATG","AGAAG","GAAAT","TCACT"};
    private final String[] irregularMatriz = {"ATGA","CTGTG","TTATGT","ATAA","ATTTTA","TCAC"};
    private final char[][] matrizDnaExpect={{'A','T','G','C','G'},
            {'A','A','G','T','C'},
            {'A','T','A','T','G'},
            {'A','G','A','A','G'},
            {'G','A','A','A','T'},
            {'T','C','A','C','T'}};

    private final char[][] matrizDnaNotEqualsExpect={{'A','T','G','C','G'},
            {'A','A','G','T','C'},
            {'A','T','A','T','G'},
            {'A','G','A','A','G'},
            {'G','A','A','A','T'},
            {'T','C','A','C','G'}};




    @Test
    public void irregularColumns(){
        int irregularColumns=6;
        int row = matrizUtil.columns(irregularMatriz);
        Assert.assertEquals(irregularColumns, row);
    }

    @Test
    public void regularColumns(){
        int regularColumns=5;
        int row = matrizUtil.columns(regularMatriz);
        Assert.assertEquals(regularColumns, row);
    }

    @Test
    public void matrizDnaEquals(){
        char[][] matrizDna = matrizUtil.matrizDna(regularMatriz);
        boolean result=Arrays.deepEquals(matrizDnaExpect,matrizDna);
        Assert.assertTrue(result);
    }

    @Test
    public void matrizDnaNotEquals(){
        char[][] matrizDna = matrizUtil.matrizDna(regularMatriz);
        boolean result=Arrays.deepEquals(matrizDnaNotEqualsExpect,matrizDna);
        Assert.assertFalse(result);
    }


}
