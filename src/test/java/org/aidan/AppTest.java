package org.aidan;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test() {
        String workDir = "C:\\Users\\huxiaoning\\Documents\\mybook\\env";
        SummaryGenerator summaryGenerator = new SummaryGenerator(workDir);
        String result = summaryGenerator.generate();
        Assert.assertEquals("# Summary\n" +
                "\n" +
                "* [env](README.md)\n" +
                "* [Git](Git/README.md)\n" +
                "\t* [01 Git安装配置](Git/01 Git安装配置.md)\n" +
                "\t* [02 Git忽略不想提交的配置文件](Git/02 Git忽略不想提交的配置文件.md)\n" +
                "\t* [03 Gitbook安装配置](Git/03 Gitbook安装配置.md)\n" +
                "* [Java安装配置](Java安装配置/README.md)\n" +
                "\t* [Java安装配置之Centos](Java安装配置/Java安装配置之Centos.md)\n" +
                "\t* [Java安装配置之Windows](Java安装配置/Java安装配置之Windows.md)\n" +
                "* [Maven安装配置](Maven安装配置/README.md)\n" +
                "\t* [Maven安装配置Windows](Maven安装配置/Maven安装配置Windows.md)\n" +
                "* [test1](test1/README.md)\n" +
                "\t* [01 a](test1/01 a.md)\n" +
                "\t* [02 b](test1/02 b.md)\n" +
                "\t* [test2](test1/test2/README.md)\n" +
                "\t\t* [01 xxx](test1/test2/01 xxx.md)\n" +
                "\t\t* [02 yyyy](test1/test2/02 yyyy.md)\n", result);
    }
}
