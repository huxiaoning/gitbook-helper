package org.aidan;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                "* [章节一](01 章节一/README.md)\n" +
                "\t* [小节一](01 章节一/01 小节一.md)\n" +
                "\t* [章节一一](01 章节一/0101 章节一一/README.md)\n" +
                "\t\t* [小节一一](01 章节一/0101 章节一一/01 小节一一.md)\n" +
                "\t* [小节二](01 章节一/02 小节二.md)\n" +
                "* [章节二](02 章节二/README.md)\n", result);
    }


    /**
     * 去除数字前缀
     */
    @Test
    public void testFileNameHandle() {
        String s = "01 小节01 天才第一步";
        String reg = "^\\d*[ ]*(.*)$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }

    }
}
