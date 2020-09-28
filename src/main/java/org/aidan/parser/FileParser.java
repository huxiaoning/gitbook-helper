package org.aidan.parser;

/**
 * @author huxiaoning
 */
public class FileParser {

    private static final String TAB = "\t";
    private static final String LINE_HEADER = "*";

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
            builder.append(TAB);
        }
        builder.append(LINE_HEADER + " [" + getFileNameWithOutSuffix() + "](" + dir + "/" + fileName + ")");
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
