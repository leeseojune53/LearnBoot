package io.github.leeseojune53.connection;

public interface Connection {
    boolean isAutoCommit();

    void setAutoCommit(boolean autoCommit);

    void commit();

    void rollback();

    boolean isClosed();

    void close();
}
