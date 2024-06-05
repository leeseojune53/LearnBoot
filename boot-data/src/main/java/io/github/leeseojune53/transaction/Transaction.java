package io.github.leeseojune53.transaction;

public interface Transaction {

    void begin();

    void commit();

    void rollback();

    void close();
}
