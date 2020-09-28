package org.aidan.parser;

/**
 * 目录解析器
 *
 * @author huxiaoning
 */
public class DirectoryParser extends AbstractParser {

    public DirectoryParser(int deepth, String fileName, String dir) {
        super(deepth, fileName, dir);
    }

    @Override
    public String doParser() {
        builder.append("/README.md)");
        return builder.toString();
    }

    /**
     * 去掉后缀 .md
     *
     * @return
     */
    @Override
    protected String handleFileName() {
        return fileName;
    }
}
