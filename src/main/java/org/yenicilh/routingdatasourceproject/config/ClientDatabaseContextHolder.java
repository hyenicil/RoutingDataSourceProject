package org.yenicilh.routingdatasourceproject.config;

public class ClientDatabaseContextHolder {

    private static final ThreadLocal<ClientDatabase> CONTEXT_HOLDER = new ThreadLocal<>();


    public static void set(ClientDatabase clientDatabase) {
        CONTEXT_HOLDER.set(clientDatabase);
    }

    public static ClientDatabase getClientDatabase() {
        return CONTEXT_HOLDER.get();
    }

    public static void clear() {
        CONTEXT_HOLDER.remove();
    }
}

