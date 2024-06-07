package io.github.leeseojune53.session;

import io.github.leeseojune53.connection.ConnectionFactory;
import io.github.leeseojune53.transaction.SimpleTransaction;
import io.github.leeseojune53.transaction.Transaction;

public class SessionManager {

    private static final ThreadLocal<SessionManager> session = new ThreadLocal<>();
    private final Transaction transaction;

    public SessionManager() {
        this.transaction = new SimpleTransaction(ConnectionFactory.getConnection());
    }

    public static SessionManager getInstance() {
        if (session.get() == null) {
            session.set(new SessionManager());
        }
        return session.get();
    }

    public static Transaction getTransaction() {
        return getInstance().transaction;
    }

    public static boolean isTransactionActive() {
        return session.get() != null;
    }

    /**
     * ThreadLocal 변수 제거
     * 테스트 시 동일 Thread 사용하여 이미 close된 Connection 오류가 발생하여 cleanup 함수 추가.
     */
    public static void clean() {
        session.remove();
    }
}
