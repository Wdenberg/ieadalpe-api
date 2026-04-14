INSERT INTO profiles (id, nome, email, created_at)
VALUES ('11111111-1111-1111-1111-111111111111', 'Administrador', 'admin@ieadalpe.com', now())
    ON CONFLICT DO NOTHING;

INSERT INTO user_roles (id, user_id, role, created_at, updated_at)
VALUES (gen_random_uuid(), '11111111-1111-1111-1111-111111111111', 'ADMIN', now(), now())
    ON CONFLICT DO NOTHING;