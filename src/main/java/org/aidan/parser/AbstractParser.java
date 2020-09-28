package org.aidan.parser;

import org.aidan.constant.Constant;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 解析器抽象
 *
 * @author huxiaoning
 */
public abstract class AbstractParser {

    protected final String fileName;

    protected final List<String> dirList;

    protected StringBuilder builder = new StringBuilder();

    public AbstractParser(String fileName, List<String> dirList) {
        this.fileName = fileName;
        this.dirList = dirList;
    }


    /**
     * 解析
     *
     * @return String
     */
    public String parser() {
        for (String s : dirList) {
            builder.append(Constant.TAB);
        }
        builder.append(Constant.LINE_HEADER + " [" + handleFileName() + "](");
        if (CollectionUtils.isNotEmpty(dirList)) {
            builder.append(StringUtils.join(dirList.toArray(), "/"));
            builder.append("/");
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
