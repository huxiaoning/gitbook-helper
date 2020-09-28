package org.aidan.parser;

import org.aidan.constant.Constant;

/**
 * @author huxiaoning
 */
public class FileParser {

    private final int deepth;

    private final String fileName;

    private final String dir;

    public FileParser(int deepth, String fileName, String dir) {
        this.deepth = deepth;
        this.fileName = fileName;
        this.dir = dir;
    }

    public String parser() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < deepth; i++) {
            builder.append(Constant.TAB);
        }
        builder.append(Constant.LINE_HEADER + " [" + getFileNameWithOutSuffix() + "](" + dir + "/" + fileName + ")");
        return builder.toString();
    }

    /**
     * 去掉后缀 .md
     *
     * @return
     */
    private String getFileNameWithOutSuffix() {
        return fileName.replace(".md", "");
    }
}
