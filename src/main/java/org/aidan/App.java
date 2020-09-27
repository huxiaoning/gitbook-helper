package org.aidan;

/**
 * Hello world!
 *
 * @author huxiaoning
 */
public class App {
    public static void main(String[] args) {
        String workDir = "C:\\Users\\huxiaoning\\Documents\\mybook\\env";
        SummaryGenerator summaryGenerator = new SummaryGenerator(workDir);
        String result = summaryGenerator.generate();
        System.out.println(result);
    }


}
