package org.aidan.parser;

import java.io.File;
import java.util.List;

/**
 * 目录解析器
 *
 * @author huxiaoning
 */
public class DirectoryParser extends AbstractParser {

    public DirectoryParser(File file, String fileName, List<String> dirList) {
        super(file, fileName, dirList);
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
