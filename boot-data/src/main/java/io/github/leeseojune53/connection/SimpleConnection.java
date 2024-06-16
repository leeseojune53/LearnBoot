package io.github.leeseojune53.connection;

import java.sql.SQLException;

// TODO Exception handling
public class SimpleConnection implements Connection {

    private final java.sql.Connection connection;

    public SimpleConnection(java.sql.Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean isAutoCommit() {
        try {
            return connection.getAutoCommit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setAutoCommit(boolean autoCommit) {
        try {
            connection.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isClosed() {
        try {
            return connection.isClosed();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
