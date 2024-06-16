package io.github.leeseojune53.query;

import io.github.leeseojune53.session.SessionManager;

import java.util.Map;

public class QueryService {

    public <T> T queryForObject(String query, Map<String, Object> params) {
        SessionManager.isTransactionActive();

        // get param from params map, :params to params
        // replace query params by params name in query




        for(String key : params.keySet()) {
            query = query.replace(":" + key, params.get(key).toString());
        }

        SessionManager.getTransaction().queryForObject(query);

        // @Query 내부 값을 사용..?
        return null;
    }

}
