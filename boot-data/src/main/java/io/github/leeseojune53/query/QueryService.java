package io.github.leeseojune53.query;

import io.github.leeseojune53.session.SessionManager;

public class QueryService {

    public <T> T queryForObject(String query, Object[] params) {
        SessionManager.isTransactionActive();
        // @Query 내부 값을 사용..?
        return null;
    }

}
