package io.github.leeseojune53.session;

import io.github.leeseojune53.transaction.Transaction;

public class SessionManager {

    private static final ThreadLocal<SessionManager> session = new ThreadLocal<>();
    private Transaction transaction;

    public static SessionManager getInstance() {
        if(session.get() == null) {
            session.set(new SessionManager());
        }
        return session.get();
    }

    public static Transaction getTransaction() {
        return getInstance().transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}
