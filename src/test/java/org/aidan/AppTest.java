package org.aidan;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test() {
        String projectDir = System.getProperty("user.dir");
        String workDir = projectDir + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "测试";

        SummaryGenerator summaryGenerator = new SummaryGenerator(workDir);
        String result = summaryGenerator.generate();
        System.out.println(result);
        Assert.assertEquals("# Summary\n" +
                "\n" +
                "* [测试](README.md)\n" +
                "* [01 章节一](01 章节一/README.md)\n" +
                "\t* [01 小节一](01 章节一/01 小节一.md)\n" +
                "\t* [0101 章节一一](01 章节一/0101 章节一一/README.md)\n" +
                "\t\t* [01 小节一一](01 章节一/0101 章节一一/01 小节一一.md)\n" +
                "\t* [02 小节二](01 章节一/02 小节二.md)\n" +
                "* [02 章节二](02 章节二/README.md)\n", result);
    }
}
