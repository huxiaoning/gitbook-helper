package org.aidan.parser;

import java.util.List;

/**
 * @author huxiaoning
 */
public class FileParser extends AbstractParser {

    public FileParser(String fileName, List<String> dirList) {
        super(fileName, dirList);
    }

    /**
     * 去掉后缀 .md
     *
     * @return
     */
    @Override
    protected String handleFileName() {
        return fileName.replace(".md", "");
    }

    @Override
    public void doParserFileName() {
        builder.append(")");
    }
}
