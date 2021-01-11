package org.aidan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.aidan.constant.Constant;
import org.aidan.parser.DirectoryParser;
import org.aidan.parser.FileParser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
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

    private static final Set<String> IGNORE_SET = Sets.newHashSet(".git",".github", ".gitignore", "_book", "book.json", "docs", "node_modules", "README.md", "SUMMARY.md");

    private static final String SUMMARY_HEADER = "# Summary";

    private final String workDir;

    private final File workDirectory;

    private final List<String> dirList;


    public SummaryGenerator(String workDir) {
        this.workDir = workDir;
        this.workDirectory = new File(this.workDir);
        dirList = Lists.newArrayList();
    }

    public String generate() {
        String result = SUMMARY_HEADER +
                "\n\n" +
                Constant.LINE_HEADER + " [" + getIntroduceName() + "](README.md)" +
                "\n" +
                listDirectory(workDirectory);
        return result;
    }

    private String getIntroduceName() {
        File bookJsonFile = new File(workDir + File.separator + "book.json");
        if (bookJsonFile.exists()) {
            try {
                String json = FileUtils.readFileToString(bookJsonFile, "UTF-8");
                JSONObject jsonObject = JSON.parseObject(json);
                String title = jsonObject.getString("title");
                if (StringUtils.isNotBlank(title)) {
                    return title;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return workDirectory.getName();

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
            String result = listFile(fileList);
            dirList.remove(directory.getName());
            return result;
        } else {
            return listFile(fileList);
        }
    }


    private String listFile(List<File> fileList) {
        StringBuilder builder = new StringBuilder();
        for (File file : fileList) {
            String fileName = file.getName();
            if (file.isDirectory()) {
                DirectoryParser directoryParser = new DirectoryParser(fileName, dirList);
                builder.append(directoryParser.parser());
            } else {
                FileParser fileParser = new FileParser(fileName, dirList);
                builder.append(fileParser.parser());
            }
            builder.append("\n");

            if (file.isDirectory()) {
                builder.append(listDirectory(file));
            }
        }
        return builder.toString();
    }

}
