package org.aidan;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Hello world!
 *
 * @author huxiaoning
 */
public class App {


    private static String getWorkDir() {
        if ("1".equals(System.getProperty("docker"))) {
            return "/work";
        }
        String workDir = System.getProperty("work.dir");
        if (StringUtils.isNotBlank(workDir)) {
            return workDir;
        }
        return new File("").getAbsolutePath();
    }


    public static void main(String[] args) {
        String workDir = getWorkDir();
        SummaryGenerator summaryGenerator = new SummaryGenerator(workDir);
        String result = summaryGenerator.generate();
        System.out.println(result);
        try {
            FileUtils.writeStringToFile(new File(workDir + File.separator + "SUMMARY.md"), result, StandardCharsets.UTF_8);
            System.out.println("写入SUMMARY.md成功");
        } catch (IOException e) {
            System.out.println("写入SUMMARY.md异常");
            e.printStackTrace();
        }
    }


}
