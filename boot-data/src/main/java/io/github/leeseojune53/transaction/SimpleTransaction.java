package io.github.leeseojune53.transaction;

import io.github.leeseojune53.connection.Connection;

public class SimpleTransaction implements Transaction {

    private final Connection connection;

    public SimpleTransaction(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void begin() {
        connection.setAutoCommit(false);
    }

    @Override
    public void commit() {
        connection.commit();
    }

    @Override
    public void rollback() {
        connection.rollback();
    }

    @Override
    public void close() {
        connection.setAutoCommit(true);
        connection.close();
    }
}
