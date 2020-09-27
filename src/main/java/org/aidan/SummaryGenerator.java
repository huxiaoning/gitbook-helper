package org.aidan;

import com.google.common.collect.Sets;

import java.io.File;
import java.util.Set;
import java.util.StringJoiner;

/**
 * gitbook summary 目录生成器
 *
 * @author huxiaoning
 */
public class SummaryGenerator {

    private static final Set<String> IGNORE_SET = Sets.newHashSet(".git", ".gitignore", "_book", "book.json", "docs", "node_modules", "README.md", "SUMMARY.md");

    private static final String SUMMARY_HEADER = "# Summary";
    private static final String TAB = "\t";
    private static final String LINE_HEADER = "*";

    private final String workDir;

    private final File workDirectory;

    private final StringJoiner dirJoiner;
    /**
     * 进入目录的深度
     */
    private int deepth = 0;


    public SummaryGenerator(String workDir) {
        this.workDir = workDir;
        this.workDirectory = new File(this.workDir);
        dirJoiner = new StringJoiner(File.separator);
    }

    public String generate() {
        String result = SUMMARY_HEADER +
                "\n\n" +
                LINE_HEADER + " [" + workDirectory.getName() + "](README.md)" +
                "\n" +
                listDirectory(workDirectory);
        return result;
    }

    private String listDirectory(File directory) {
        if (!directory.isDirectory()) {
            return null;
        }
        File[] files = directory.listFiles();
        if (files == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (File file : files) {
            String fileName = file.getName();
            if (IGNORE_SET.contains(fileName)) {
                continue;
            }

            if (file.isDirectory()) {
                builder.append(LINE_HEADER + " [" + fileName + "](" + fileName + File.separator + "README.md)");
            } else {
                builder.append(TAB + LINE_HEADER + " [" + fileName + "](" + dirJoiner.toString() + File.separator + fileName);
            }
            builder.append("\n");

            if (file.isDirectory()) {
                deepth++;
                builder.append(listDirectory(file));
                deepth--;
            }
        }
        return builder.toString();
    }

}
