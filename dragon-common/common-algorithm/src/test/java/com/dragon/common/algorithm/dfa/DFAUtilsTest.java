package com.dragon.common.algorithm.dfa;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class DFAUtilsTest {
    /*==========================AddSensitiveWord-start==========================*/
    @Test
    public void testAddSensitiveWord01() {
        DFAUtils.clearSensitiveWord();
        LinkedList<String> listWords = null;
        DFAUtils.addSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.addSensitiveWord("中哈");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
        DFAUtils.addSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
        DFAUtils.addSensitiveWord("中哈");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
        DFAUtils.delSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.addSensitiveWord("中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
        DFAUtils.addSensitiveWord("中中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(3, listWords.size());
        DFAUtils.addSensitiveWord("人");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(4, listWords.size());
        DFAUtils.addSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(5, listWords.size());
    }

    /*==========================AddSensitiveWord-end============================*/


    /*==========================CheckSensitiveWord-start==========================*/
    @Test
    public void testCheckSensitiveWord01() {
        DFAUtils.clearSensitiveWord();
        String sencitivaWord = null;
        LinkedList<String> listWords = null;
        DFAUtils.addSensitiveWord("滚");
        DFAUtils.addSensitiveWord("滚蛋");
        DFAUtils.addSensitiveWord("操蛋");
        DFAUtils.addSensitiveWord("操");
        DFAUtils.addSensitiveWord("国");
        DFAUtils.addSensitiveWord("滚滚");
        DFAUtils.addSensitiveWord("滚滚滚");
        DFAUtils.addSensitiveWord("中中中国中中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(8, listWords.size());
        sencitivaWord = DFAUtils.checkSensitiveWord("滚");
        Assert.assertEquals("滚", sencitivaWord);

        sencitivaWord = DFAUtils.checkSensitiveWord("翻滚");
        Assert.assertEquals(null, sencitivaWord);

        sencitivaWord = DFAUtils.checkSensitiveWord("滚 ");
        Assert.assertEquals("滚", sencitivaWord);

        sencitivaWord = DFAUtils.checkSensitiveWord(" 滚");
        Assert.assertEquals("滚", sencitivaWord);

        sencitivaWord = DFAUtils.checkSensitiveWord("体操");
        Assert.assertEquals(null, sencitivaWord);


        sencitivaWord = DFAUtils.checkSensitiveWord("你好滚滚");
        Assert.assertEquals("滚滚", sencitivaWord);

        sencitivaWord = DFAUtils.checkSensitiveWord("滚你好滚");
        Assert.assertEquals(null, sencitivaWord);


        sencitivaWord = DFAUtils.checkSensitiveWord("操 蛋");
        Assert.assertEquals("操", sencitivaWord);


        sencitivaWord = DFAUtils.checkSensitiveWord("体操 蛋");
        Assert.assertEquals(null, sencitivaWord);


        sencitivaWord = DFAUtils.checkSensitiveWord("滚蛋");
        Assert.assertEquals("滚蛋", sencitivaWord);


        sencitivaWord = DFAUtils.checkSensitiveWord("滚轮胎");
        Assert.assertEquals(null, sencitivaWord);

        sencitivaWord = DFAUtils.checkSensitiveWord("你你国国");
        Assert.assertEquals(null, sencitivaWord);

        sencitivaWord = DFAUtils.checkSensitiveWord("中中国中中 中中中中国中中中");
        Assert.assertEquals("中中中国中中中", sencitivaWord);
    }

    /*==========================CheckSensitiveWord-start==========================*/

    /*==========================DelSensitiveWor-start==========================*/
    @Test
    public void testDelSensitiveWord01() {
        DFAUtils.clearSensitiveWord();
        LinkedList<String> listWords = null;
        DFAUtils.addSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.delSensitiveWord("");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.delSensitiveWord("国");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.delSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(0, listWords.size());
    }

    @Test
    public void testDelSensitiveWord02() {
        DFAUtils.clearSensitiveWord();
        LinkedList<String> listWords = null;
        DFAUtils.addSensitiveWord("中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.delSensitiveWord("");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.delSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.delSensitiveWord("中中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.delSensitiveWord("中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(0, listWords.size());
    }

    @Test
    public void testDelSensitiveWord03() {
        DFAUtils.clearSensitiveWord();
        LinkedList<String> listWords = null;
        DFAUtils.addSensitiveWord("中中");
        DFAUtils.addSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
        DFAUtils.delSensitiveWord("");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
        DFAUtils.delSensitiveWord("中中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
        DFAUtils.delSensitiveWord(" 中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
        DFAUtils.delSensitiveWord("中中 ");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
        DFAUtils.delSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.delSensitiveWord("中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(0, listWords.size());
        DFAUtils.addSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.delSensitiveWord("中中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.delSensitiveWord("中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(1, listWords.size());
        DFAUtils.delSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(0, listWords.size());
    }

    @Test
    public void testDelSensitiveWord04() {
        DFAUtils.clearSensitiveWord();
        LinkedList<String> listWords = null;
        DFAUtils.addSensitiveWord("中中中111");
        DFAUtils.addSensitiveWord("中中");
        DFAUtils.addSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(3, listWords.size());
        DFAUtils.delSensitiveWord("");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(3, listWords.size());
        DFAUtils.delSensitiveWord("中中中111");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
        DFAUtils.addSensitiveWord("中中中111");
        DFAUtils.delSensitiveWord("中中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(3, listWords.size());
        DFAUtils.delSensitiveWord("中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
        DFAUtils.addSensitiveWord("中中 ");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(3, listWords.size());
        DFAUtils.delSensitiveWord("中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
        DFAUtils.delSensitiveWord("中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(2, listWords.size());
    }
    /*==========================DelSensitiveWor-end============================*/


    /*==========================ContainSensitiveWord-start==========================*/
    @Test
    public void testContainSensitiveWord01() {
        DFAUtils.clearSensitiveWord();
        LinkedList<String> listWords = null;
        DFAUtils.addSensitiveWord("滚");
        DFAUtils.addSensitiveWord("滚蛋");
        DFAUtils.addSensitiveWord("操蛋");
        DFAUtils.addSensitiveWord("操");
        DFAUtils.addSensitiveWord("滚滚");
        DFAUtils.addSensitiveWord("滚滚滚");
        DFAUtils.addSensitiveWord("中中中国中中中");
        listWords = DFAUtils.getSevsitiveWords();
        Assert.assertEquals(7, listWords.size());
        Assert.assertEquals(true, DFAUtils.containSensitiveWord("滚蛋"));
        Assert.assertEquals(false, DFAUtils.containSensitiveWord("滚 蛋"));
        Assert.assertEquals(false, DFAUtils.containSensitiveWord(" "));
        Assert.assertEquals(true, DFAUtils.containSensitiveWord("操"));
    }

    /*==========================ContainSensitiveWord-end============================*/
}