package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws ClassNotFoundException, SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password")
        );
    }

    public void createStatement(String operationSQL, String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(operationSQL, tableName);
            statement.execute(sql);
        }

    }

    public void createTable(String tableName) throws Exception {
        createStatement(String.format("create table if not exists %s();", tableName), tableName);
    }

    public void dropTable(String tableName) throws Exception {
        createStatement(String.format("drop table if exists %s;", tableName), tableName);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        createStatement(String.format("alter table %s add column if not exists %s %s;",
                tableName, columnName, type), tableName);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        createStatement(String.format("alter table %s drop column %s;",
                tableName, columnName), tableName);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        createStatement(String.format("alter table %s rename column %s to %s;",
                tableName, columnName, newColumnName), tableName);
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        String tableName = "car";
        String columnName = "color";
        String newColumnName = "vin";
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
            try (TableEditor tableEditor = new TableEditor(properties)) {
                tableEditor.createTable(tableName);
                System.out.println(getTableScheme(tableEditor.connection, tableName));
                tableEditor.addColumn(tableName, columnName, "varchar(20)");
                System.out.println(getTableScheme(tableEditor.connection, tableName));
                tableEditor.renameColumn(tableName, columnName, newColumnName);
                System.out.println(getTableScheme(tableEditor.connection, tableName));
                tableEditor.dropColumn(tableName, newColumnName);
                System.out.println(getTableScheme(tableEditor.connection, tableName));
                tableEditor.dropTable(tableName);
                System.out.println(getTableScheme(tableEditor.connection, tableName));
            }
        }
    }
}