package io.github.leeseojune53.session;

import io.github.leeseojune53.connection.ConnectionFactory;
import io.github.leeseojune53.transaction.SimpleTransaction;
import io.github.leeseojune53.transaction.Transaction;

public class SessionManager {

    private static final ThreadLocal<SessionManager> session = new ThreadLocal<>();
    private final Transaction transaction;

    public SessionManager() {
        this.transaction = new SimpleTransaction(
                ConnectionFactory.getConnection()
        );
    }

    public static SessionManager getInstance() {
        if(session.get() == null) {
            session.set(new SessionManager());
        }
        return session.get();
    }

    public static Transaction getTransaction() {
        return getInstance().transaction;
    }

}
