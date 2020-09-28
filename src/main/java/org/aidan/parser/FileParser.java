package org.aidan.parser;

/**
 * @author huxiaoning
 */
public class FileParser extends AbstractParser {

    public FileParser(int deepth, String fileName, String dir) {
        super(deepth, fileName, dir);
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
