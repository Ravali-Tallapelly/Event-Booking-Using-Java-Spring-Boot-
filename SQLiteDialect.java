package com.mycompany.eventbooking;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class SQLiteDialect extends H2Dialect {

    public SQLiteDialect() {
        super();
        // Register SQLite-specific functions
        registerFunction("concat", new SQLFunctionTemplate(StandardBasicTypes.STRING, "{0} || {1}"));
        registerFunction("mod", new StandardSQLFunction("mod"));
    }

    // SQLite supports identity columns (autoincrement)
    public boolean supportsIdentityColumns() {
        return true;
    }

    // SQLite doesn't support data types in identity columns
    public boolean hasDataTypeInIdentityColumn() {
        return false;
    }

    // SQLite does not support sequences
    public boolean supportsSequences() {
        return false;
    }

    // SQLite supports temporary tables
    public boolean supportsTemporaryTables() {
        return true;
    }

    // SQLite does not drop tables automatically
    public boolean dropTableAfterUse() {
        return false;
    }

    // SQLite does not support sequences
    public String getCreateSequenceString(String sequenceName) {
        throw new UnsupportedOperationException("SQLite does not support sequences");
    }

    // SQLite syntax for creating a table if it doesn't exist
    public String getCreateTableString() {
        return "create table if not exists";
    }

    // SQLite supports the LIMIT clause
    public boolean supportsLimit() {
        return true;
    }

    // SQLite syntax for query with OFFSET and LIMIT
    public String getLimitString(String query, boolean hasOffset) {
        if (hasOffset) {
            return query + " limit ? offset ?";
        } else {
            return query + " limit ?";
        }
    }

    // SQLite syntax for adding a column to a table
    public String getAddColumnString() {
        return "add column";
    }
}
