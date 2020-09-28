package org.aidan.parser;

import org.aidan.constant.Constant;
import org.apache.commons.lang3.StringUtils;

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
        builder.append(Constant.LINE_HEADER + " [" + handleFileName() + "](");
        if (StringUtils.isNotBlank(dir)) {
            builder.append(dir + "/");
        }
        builder.append(fileName + "/" + "README.md)");
        return builder.toString();
    }

    /**
     * 去掉后缀 .md
     *
     * @return
     */
    private String handleFileName() {
        return fileName;
    }
}
