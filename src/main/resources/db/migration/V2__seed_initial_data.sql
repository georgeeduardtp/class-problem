
WITH admin AS (
  INSERT INTO app_user (username, full_name, email, roles)
  VALUES ('admin', 'Admin User', 'admin@example.com', 'ADMIN')
  RETURNING id
),
alice AS (
  INSERT INTO app_user (username, full_name, email, roles)
  VALUES ('alice', 'Alice Perez', 'alice@example.com', 'STUDENT')
  RETURNING id
),
cls AS (
  INSERT INTO classroom (module, number)
  VALUES ('DAM', '2')
  RETURNING id
),
teacher AS (
  INSERT INTO app_user (username, full_name, email, roles)
  VALUES ('juan', 'Juan Profesor', 'juan@example.com', 'TEACHER')
  RETURNING id
),
dev AS (
  INSERT INTO device (serial, display_name, device_type, classroom_id)
  SELECT 'PC12SN', 'PC 12', 'PC', cls.id FROM cls
  RETURNING id
)

INSERT INTO incidence (title, description, status, user_id, classroom_id)
SELECT 'Falta cable HDMI', 'No hay cable HDMI en el proyector.', 'OPEN', alice.id, cls.id FROM alice, cls;
