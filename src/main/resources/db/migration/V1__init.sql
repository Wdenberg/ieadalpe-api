CREATE TABLE IF NOT EXISTS system_bootstrap (
                                                id BIGSERIAL PRIMARY KEY,
                                                description VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

INSERT INTO system_bootstrap (description)
VALUES ('IEADALPE API inicializada');