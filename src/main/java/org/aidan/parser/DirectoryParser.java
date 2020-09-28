package org.aidan.parser;

import org.apache.commons.lang3.StringUtils;

/**
 * 目录解析器
 *
 * @author huxiaoning
 */
public class DirectoryParser {

    private static final String TAB = "\t";
    private static final String LINE_HEADER = "*";

    private final int deepth;

    private final String fileName;

    private final String dir;

    public DirectoryParser(int deepth, String fileName, String dir) {
        this.deepth = deepth;
        this.fileName = fileName;
        this.dir = dir;
    }

    public String parser() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < deepth; i++) {
            builder.append(TAB);
        }
        builder.append(LINE_HEADER + " [" + fileName + "](");
        if (StringUtils.isNotBlank(dir)) {
            builder.append(dir + "/");
        }
        builder.append(fileName + "/" + "README.md)");
        return builder.toString();
    }
}
