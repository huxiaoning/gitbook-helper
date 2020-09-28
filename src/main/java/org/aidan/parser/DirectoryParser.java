package org.aidan.parser;

import java.util.List;

/**
 * 目录解析器
 *
 * @author huxiaoning
 */
public class DirectoryParser extends AbstractParser {

    public DirectoryParser(String fileName, List<String> dirList) {
        super(fileName, dirList);
    }

    @Override
    protected String handleFileName() {
        return fileName;
    }

    @Override
    public void doParserFileName() {
        builder.append("/README.md");
    }
}
