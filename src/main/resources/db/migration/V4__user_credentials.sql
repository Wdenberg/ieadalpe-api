CREATE TABLE IF NOT EXISTS user_credentials (
                                                id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    profile_id UUID NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT true,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ,
    CONSTRAINT fk_user_credentials_profile
    FOREIGN KEY (profile_id) REFERENCES profiles(id) ON DELETE CASCADE
    );

CREATE INDEX IF NOT EXISTS idx_user_credentials_profile_id
    ON user_credentials(profile_id);