package org.aidan;

import com.google.common.collect.Sets;

import java.io.File;
import java.util.Set;

/**
 * gitbook summary 目录生成器
 *
 * @author huxiaoning
 */
public class SummaryGenerator {

    private static final Set<String> IGNORE_SET = Sets.newHashSet(".git", ".gitignore", "_book", "book.json", "docs", "node_modules", "README.md", "SUMMARY.md");

    private static final String SUMMARY_HEADER = "# Summary";
    private static final String TAB = "\t";
    private static final String LINE_HEADER = "* ";

    private final String workDir;

    private final File workDirectory;

    public SummaryGenerator(String workDir) {
        this.workDir = workDir;
        this.workDirectory = new File(this.workDir);
    }

    public String generate() {
        return SUMMARY_HEADER + "\n\n" + listDirectory(workDirectory);
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
            builder.append(fileName);
            builder.append("\n");
            if (file.isDirectory()) {
                builder.append(listDirectory(file));
            }
        }
        return builder.toString();
    }

}
