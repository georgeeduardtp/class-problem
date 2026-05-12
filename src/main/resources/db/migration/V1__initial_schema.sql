
CREATE TYPE incident_status AS ENUM ('OPEN','IN_PROGRESS','RESOLVED','DISMISSED');

CREATE TYPE user_role AS ENUM ('ADMIN','STUDENT','TEACHER');
CREATE TABLE app_user (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    full_name VARCHAR(200),
    email VARCHAR(200) UNIQUE,
    roles user_role NOT NULL DEFAULT 'STUDENT',
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);

CREATE TABLE classroom (
    id BIGSERIAL PRIMARY KEY,
    module VARCHAR(200) NOT NULL,
    number VARCHAR(50),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);


CREATE TABLE device (
    id BIGSERIAL PRIMARY KEY,
    serial VARCHAR(200) UNIQUE,
    display_name VARCHAR(200) NOT NULL,
    device_type VARCHAR(100),
    classroom_id BIGINT REFERENCES classroom(id) ON DELETE SET NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);


CREATE TABLE incidence (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(300) NOT NULL,
    description TEXT,
    status incident_status NOT NULL DEFAULT 'OPEN',
    user_id BIGINT NOT NULL REFERENCES app_user(id) ON DELETE RESTRICT,
    classroom_id BIGINT REFERENCES classroom(id) ON DELETE SET NULL,
    device_id BIGINT REFERENCES device(id) ON DELETE SET NULL,
    photo_url VARCHAR(1000),
    reported_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
    resolved_at TIMESTAMP WITH TIME ZONE
);

CREATE TABLE incidence_history (
    id BIGSERIAL PRIMARY KEY,
    incidence_id BIGINT NOT NULL REFERENCES incidence(id) ON DELETE CASCADE,
    changed_by BIGINT REFERENCES app_user(id) ON DELETE SET NULL,
    from_status incident_status,
    to_status incident_status,
    note TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);

CREATE INDEX idx_incidence_status ON incidence(status);
CREATE INDEX idx_incidence_classroom ON incidence(classroom_id);
CREATE INDEX idx_incidence_device ON incidence(device_id);
CREATE INDEX idx_incidence_user_id ON incidence(user_id);

