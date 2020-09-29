package org.aidan.parser;

import org.aidan.constant.Constant;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解析器抽象
 *
 * @author huxiaoning
 */
public abstract class AbstractParser {

    private static final Pattern pattern = Pattern.compile("^\\d*[ ]*(.*)$");

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
        builder.append(Constant.LINE_HEADER);
        builder.append(" ");

        builder.append("[");

        builder.append(handlePrefix(handleFileName()));
        builder.append("]");

        builder.append("(");
        if (CollectionUtils.isNotEmpty(dirList)) {
            for (String dir : dirList) {
                builder.append(dir);
                builder.append("/");
            }
        }
        builder.append(fileName);
        doParserFileName();
        builder.append(")");

        return builder.toString();
    }


    /**
     * 删除文件名、目录名的数字前缀
     *
     * @param name name
     * @return String
     */
    private String handlePrefix(String name) {
        // 去除name的数字前缀
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return name;
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
