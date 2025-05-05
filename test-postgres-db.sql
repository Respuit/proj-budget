-- 🔁 Elimina las tablas si existen (por si vas a ejecutar varias veces durante pruebas)
DROP TABLE IF EXISTS budget_material;
DROP TABLE IF EXISTS budget;
DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS client;

-- 👤 Tabla de clientes
CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 🧱 Tabla de materiales
CREATE TABLE material (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    unit VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 📄 Tabla de presupuestos
CREATE TABLE budget (
    id SERIAL PRIMARY KEY,
    status VARCHAR(50),
    client_id INTEGER,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE SET NULL
);

-- 🔗 Tabla de relación presupuesto-material
CREATE TABLE budget_material (
    budget_id INTEGER,
    material_id INTEGER,
    quantity NUMERIC(10,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (budget_id, material_id),
    CONSTRAINT fk_budget FOREIGN KEY (budget_id) REFERENCES budget(id) ON DELETE CASCADE,
    CONSTRAINT fk_material FOREIGN KEY (material_id) REFERENCES material(id) ON DELETE CASCADE
);

-- 📥 Datos de prueba: clientes
INSERT INTO client (first_name, last_name, phone, email) VALUES
('Juan', 'Pérez', '+34123456789', 'juan.perez@example.com'),
('Ana', 'López', '+34678912345', 'ana.lopez@example.com');

-- 📥 Datos de prueba: materiales
INSERT INTO material (name, unit) VALUES
('Madera de roble', 'm²'),
('Tornillos B', 'unidades'),
('Vidrio templado', 'm²'),
('Pegamento industrial', 'litros');

-- 📥 Datos de prueba: presupuestos
INSERT INTO budget (status, client_id) VALUES
('Pendiente', 1),
('Aprobado', 1),
('Rechazado', 2);

-- 📥 Datos de prueba: relación presupuesto-material
-- Presupuesto 1 (Juan) usa madera y tornillos
INSERT INTO budget_material (budget_id, material_id, quantity) VALUES
(1, 1, 5.5), -- 5.5 m² de madera
(1, 2, 30);  -- 30 tornillos

-- Presupuesto 2 (Juan) usa vidrio y pegamento
INSERT INTO budget_material (budget_id, material_id, quantity) VALUES
(2, 3, 2.0), -- 2 m² de vidrio
(2, 4, 1.5); -- 1.5 litros de pegamento

-- Presupuesto 3 (Ana) solo con tornillos
INSERT INTO budget_material (budget_id, material_id, quantity) VALUES
(3, 2, 15); -- 15 tornillos
