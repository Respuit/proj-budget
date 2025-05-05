package com.budgyeti.budgyeti.debug;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseDebugRunner {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void debugConnection() {
        try {
            String dbName = (String) em.createNativeQuery("SELECT current_database()").getSingleResult();
            System.out.println("✅ Conectado a la base de datos: " + dbName);

            String schema = (String) em.createNativeQuery("SELECT current_schema()").getSingleResult();
            System.out.println("✅ Esquema actual: " + schema);

            List<?> budgets = em.createNativeQuery("SELECT * FROM budget LIMIT 1").getResultList();
            System.out.println("✅ Consulta tabla 'budget' OK. Filas devueltas: " + budgets.size());
        } catch (Exception e) {
            System.err.println("❌ Error consultando la tabla 'budget': " + e.getMessage());
        }
    }
}

