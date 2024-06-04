package io.github.leeseojune53.transaction;

import io.github.leeseojune53.connection.SimpleConnection;

public class SimpleTransaction implements Transaction {

    private final SimpleConnection connection;


    @Override
    public void begin() {
        connection.
    }

    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    @Override
    public void close() {

    }

    @Override
    public boolean isBegin() {
        return false;
    }

    @Override
    public boolean isRollback() {
        return false;
    }

    @Override
    public boolean isClosed() {
        return false;
    }
}
