package org.aidan;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.aidan.constant.Constant;
import org.aidan.parser.DirectoryParser;
import org.aidan.parser.FileParser;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * gitbook summary 目录生成器
 *
 * @author huxiaoning
 */
public class SummaryGenerator {

    private static final Set<String> IGNORE_SET = Sets.newHashSet(".git", ".gitignore", "_book", "book.json", "docs", "node_modules", "README.md", "SUMMARY.md");

    private static final String SUMMARY_HEADER = "# Summary";

    private final String workDir;

    private final File workDirectory;

    private final List<String> dirList;
    /**
     * 进入目录的深度
     */
    private int deepth = 0;


    public SummaryGenerator(String workDir) {
        this.workDir = workDir;
        this.workDirectory = new File(this.workDir);
        dirList = Lists.newArrayList();
    }

    public String generate() {
        String result = SUMMARY_HEADER +
                "\n\n" +
                Constant.LINE_HEADER + " [" + workDirectory.getName() + "](README.md)" +
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

        List<File> fileList = Arrays.stream(files).filter(file -> !IGNORE_SET.contains(file.getName())).collect(Collectors.toList());

        if (directory != workDirectory) {
            dirList.add(directory.getName());
            deepth++;
        }

        StringBuilder builder = new StringBuilder();
        for (File file : fileList) {
            String fileName = file.getName();
            if (file.isDirectory()) {
                DirectoryParser directoryParser = new DirectoryParser(deepth, fileName, StringUtils.join(dirList.toArray(), "/"));
                builder.append(directoryParser.parser());
            } else {
                FileParser fileParser = new FileParser(deepth, fileName, StringUtils.join(dirList.toArray(), "/"));
                builder.append(fileParser.parser());
            }
            builder.append("\n");

            if (file.isDirectory()) {
                builder.append(listDirectory(file));
            }
        }
        if (directory != workDirectory) {
            dirList.remove(directory.getName());
            deepth--;
        }
        return builder.toString();
    }

}
