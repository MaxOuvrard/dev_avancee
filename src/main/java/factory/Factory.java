package factory;

import action.*;

import java.util.HashMap;

public class Factory {
    private static HashMap<String, Class> classHashMap = new HashMap<>();

    static {
        classHashMap.put("loginServlet.do", LoginAction.class);
        classHashMap.put("logoutServlet.do", LogoutAction.class);
        classHashMap.put("updateAttributesServlet.do",ActionUn.class);
        classHashMap.put("debut_servlet.do",ActionDebut.class);
    }

    public static Action get(String className) throws InstantiationException, IllegalAccessException {
        return (Action) classHashMap.get(className).newInstance();
    }
}
