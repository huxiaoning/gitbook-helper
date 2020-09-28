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
    protected String handleFileName() {
        return fileName;
    }

    @Override
    public void doParserFileName() {
        builder.append("/README.md)");
    }
}
