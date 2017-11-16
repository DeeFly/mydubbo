package com.gaofei.web.filter;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * 维护自己的sessionContext
 * Created by GaoQingming on 2017/11/14 0014.
 */
public class MySessionContext {
    private static HashMap mymap = new HashMap();

    public static synchronized void AddSession(HttpSession session) {
        if (session != null) {
            mymap.put(session.getId(), session);
        }
    }

    public static synchronized void DelSession(HttpSession session) {
        if (session != null) {
            mymap.remove(session.getId());
        }
    }

    public static synchronized HttpSession getSession(String session_id) {
        if (session_id == null)
            return null;
        return (HttpSession) mymap.get(session_id);
    }
}
