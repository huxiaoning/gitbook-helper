package org.aidan.parser;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.List;

/**
 * @author huxiaoning
 */
public class FileParser extends AbstractParser {

    public FileParser(File file, String fileName, List<String> dirList) {
        super(file, fileName, dirList);
    }

    /**
     * 去掉后缀 .md
     *
     * @return
     */
    @Override
    protected String handleFileName() {
        return StringUtils.replace(fileName, ".md", "");
    }

    @Override
    public void doParserFileName() {
    }
}
