INSERT INTO user_credentials (id, profile_id, password_hash, enabled, created_at, updated_at)
VALUES (
           gen_random_uuid(),
           '11111111-1111-1111-1111-111111111111',
           '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
           true,
           now(),
           now()
       )
    ON CONFLICT DO NOTHING;