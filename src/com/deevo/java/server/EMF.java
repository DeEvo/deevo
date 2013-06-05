package com.deevo.java.server;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
    private static EntityManagerFactory emfInstance = null;
        

    private EMF() {}

    public static EntityManagerFactory get() {
        if (emfInstance == null || ! emfInstance.isOpen()) {
                emfInstance = Persistence.createEntityManagerFactory("deevo");
        }
        return emfInstance;
    }
}
