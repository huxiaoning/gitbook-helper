package org.aidan.parser;

import org.aidan.constant.Constant;
import org.apache.commons.lang3.StringUtils;

/**
 * 目录解析器
 *
 * @author huxiaoning
 */
public class DirectoryParser extends AbstractParser {


    private StringBuilder builder;

    public DirectoryParser(int deepth, String fileName, String dir) {
        super(deepth, fileName, dir);
    }

    @Override
    public String parser() {
        for (int i = 0; i < deepth; i++) {
            builder.append(Constant.TAB);
        }
        builder.append(Constant.LINE_HEADER + " [" + fileName + "](");
        if (StringUtils.isNotBlank(dir)) {
            builder.append(dir + "/");
        }
        builder.append(fileName + "/" + "README.md)");
        return builder.toString();
    }
}
