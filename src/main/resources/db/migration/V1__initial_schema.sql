-- 1. Borramos todo lo anterior para no tener conflictos
DROP TABLE IF EXISTS incidence_history;
DROP TABLE IF EXISTS incidence;
DROP TABLE IF EXISTS device;
DROP TABLE IF EXISTS classroom;
DROP TABLE IF EXISTS app_user;
DROP TYPE IF EXISTS incident_status;
DROP TYPE IF EXISTS user_role;

-- 2. Creamos las "listas" de opciones (Enums)
CREATE TYPE incident_status AS ENUM ('OPEN','IN_PROGRESS','RESOLVED','DISMISSED');
CREATE TYPE user_role AS ENUM ('ADMIN','STUDENT','TEACHER');

-- 3. Tabla de Usuarios
CREATE TABLE app_user (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    full_name VARCHAR(200),
    email VARCHAR(200) UNIQUE,
    roles user_role NOT NULL DEFAULT 'STUDENT',
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);

-- 4. Tabla de Aulas
CREATE TABLE classroom (
    id BIGSERIAL PRIMARY KEY,
    module VARCHAR(200) NOT NULL,
    number VARCHAR(50),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);

-- 5. Tabla de Dispositivos (PCs, Monitores...)
CREATE TABLE device (
    id BIGSERIAL PRIMARY KEY,
    serial VARCHAR(200) UNIQUE,
    display_name VARCHAR(200) NOT NULL,
    device_type VARCHAR(100),
    classroom_id BIGINT REFERENCES classroom(id) ON DELETE SET NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);

-- 6. LA TABLA IMPORTANTE: Incidencias
CREATE TABLE incidence (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(300) NOT NULL,
    description TEXT,
    status incident_status NOT NULL DEFAULT 'OPEN',
    user_id BIGINT NOT NULL REFERENCES app_user(id),
    classroom_id BIGINT REFERENCES classroom(id),
    device_id BIGINT REFERENCES device(id),
    -- AQUÍ EL CAMBIO CLAVE: photo_url es TEXT para que quepa el Base64 (la foto convertida en letras)
    photo_url TEXT, 
    reported_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
    resolved_at TIMESTAMP WITH TIME ZONE
);

-- 7. Datos de prueba para que la app no aparezca vacía al arrancar
INSERT INTO app_user (username, full_name, email, roles) VALUES 
('admin', 'Administrador', 'admin@centro.com', 'ADMIN'),
('alumno1', 'Pepito Perez', 'pepito@centro.com', 'STUDENT');

INSERT INTO classroom (module, number) VALUES ('DAM', 'Aula 101');