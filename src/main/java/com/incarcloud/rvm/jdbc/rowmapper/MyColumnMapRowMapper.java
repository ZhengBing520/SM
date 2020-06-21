package com.incarcloud.rvm.jdbc.rowmapper;

import com.incarcloud.rvm.util.StringUtil;
import org.springframework.jdbc.core.ColumnMapRowMapper;

public class MyColumnMapRowMapper extends ColumnMapRowMapper {
    public final static MyColumnMapRowMapper ROW_MAPPER=new MyColumnMapRowMapper();
    @Override
    protected String getColumnKey(String columnName) {
        return StringUtil.toFirstUpperCaseWithSplit(columnName,'_');
    }
}
