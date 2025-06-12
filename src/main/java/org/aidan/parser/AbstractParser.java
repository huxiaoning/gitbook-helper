package org.aidan.parser;

import org.aidan.constant.Constant;
import org.apache.commons.collections4.CollectionUtils;

import java.io.File;
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

    protected final File file;
    protected final String fileName;

    protected final List<String> dirList;

    protected StringBuilder builder = new StringBuilder();

    public AbstractParser(File file, String fileName, List<String> dirList) {
        this.file = file;
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
        if (this.file.isDirectory()) {
            if (canExpand()) {
                // 可以展开的目录
//                builder.append("<span style=\"color: orange;\">\uD83D\uDCC2</span> ");
                builder.append("<span style=\"color: orange;\">\uD83D\uDDC2\uFE0F</span> ");
            } else {
                // 不可以展开的目录 (目录中只包含一个README文件)
                builder.append("<span style=\"color: orange;\">\uD83D\uDCC1</span> ");
            }
        } else {
            // 叶子节点
            builder.append("<span style=\"color: orange;\">\uD83D\uDCC4</span> ");
        }
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
     * 是目录节点，并且不能只有一个readme.md子节点
     */
    private boolean canExpand() {
        File[] files = file.listFiles();
        System.out.println("开始------------------------------------------------------");
        String dirName = file.getName();
        System.out.println("dirName = " + dirName);
        for (File f : files) {
            String name = f.getName();
            System.out.println("name = " + name);
        }
        System.out.println("结束------------------------------------------------------");
        if (files != null && files.length == 1 && files[0].getName().equals("README.md")) {
            return true;
        }
        return false;
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
