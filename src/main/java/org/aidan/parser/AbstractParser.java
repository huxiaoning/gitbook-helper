package org.aidan.parser;

/**
 * 解析器抽象
 *
 * @author huxiaoning
 */
public abstract class AbstractParser {

    protected final int deepth;

    protected final String fileName;

    protected final String dir;

    public AbstractParser(int deepth, String fileName, String dir) {
        this.deepth = deepth;
        this.fileName = fileName;
        this.dir = dir;
    }


    /**
     * 解析
     *
     * @return String
     */
    public abstract String parser();
}
