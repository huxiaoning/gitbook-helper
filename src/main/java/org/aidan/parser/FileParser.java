package org.aidan.parser;

import org.aidan.constant.Constant;

/**
 * @author huxiaoning
 */
public class FileParser extends AbstractParser {

    private StringBuilder builder;

    public FileParser(int deepth, String fileName, String dir) {
        super(deepth, fileName, dir);
    }

    @Override
    public String parser() {
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
