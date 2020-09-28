package org.aidan.parser;

/**
 * @author huxiaoning
 */
public class FileParser extends AbstractParser {

    public FileParser(int deepth, String fileName, String dir) {
        super(deepth, fileName, dir);
    }

    @Override
    public String doParser() {
        builder.append(")");
        return builder.toString();
    }

    /**
     * 去掉后缀 .md
     *
     * @return
     */
    private String handleFileName() {
        return fileName.replace(".md", "");
    }
}
