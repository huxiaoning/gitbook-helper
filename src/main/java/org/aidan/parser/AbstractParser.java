package org.aidan.parser;

import org.aidan.constant.Constant;
import org.apache.commons.lang3.StringUtils;

/**
 * 解析器抽象
 *
 * @author huxiaoning
 */
public abstract class AbstractParser {

    protected final int deepth;

    protected final String fileName;

    protected final String dir;

    protected StringBuilder builder = new StringBuilder();

    public AbstractParser(int deepth, String fileName, String dir) {
        this.deepth = deepth;
        this.fileName = fileName;
        this.dir = dir;
    }


    /**
     * 解析
     *
     * @return String
     */
    public String parser() {
        for (int i = 0; i < deepth; i++) {
            builder.append(Constant.TAB);
        }
        builder.append(Constant.LINE_HEADER + " [" + handleFileName() + "](");
        if (StringUtils.isNotBlank(dir)) {
            builder.append(dir + "/");
        }
        builder.append(fileName);
        doParserFileName();
        return builder.toString();
    }

    /**
     * handleFileName
     *
     * @return String
     */
    protected abstract String handleFileName();

    /**
     * doParser
     *
     * @return String
     */
    protected abstract void doParserFileName();


}
