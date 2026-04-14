CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS profiles (
                                        id UUID PRIMARY KEY,
                                        nome VARCHAR(150),
    email VARCHAR(180),
    avatar_url TEXT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ
    );

CREATE TABLE IF NOT EXISTS user_roles (
                                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL,
    role VARCHAR(20) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ,
    CONSTRAINT fk_user_roles_profile FOREIGN KEY (user_id) REFERENCES profiles(id) ON DELETE CASCADE,
    CONSTRAINT uk_user_roles_user_role UNIQUE (user_id, role),
    CONSTRAINT ck_user_roles_role CHECK (role IN ('ADMIN', 'OBREIRO'))
    );

CREATE TABLE IF NOT EXISTS obreiros (
                                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL UNIQUE,
    matricula VARCHAR(50) NOT NULL UNIQUE,
    nome VARCHAR(150) NOT NULL,
    funcao VARCHAR(100),
    setor VARCHAR(120),
    congregacao VARCHAR(120),
    telefone VARCHAR(30),
    data_nascimento DATE,
    data_batismo DATE,
    anos_obreiro INTEGER,
    foto_url TEXT,
    bloqueado BOOLEAN NOT NULL DEFAULT false,
    ultimo_acesso TIMESTAMPTZ,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ,
    CONSTRAINT fk_obreiros_profile FOREIGN KEY (user_id) REFERENCES profiles(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS noticias (
                                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    titulo VARCHAR(200) NOT NULL,
    conteudo TEXT NOT NULL,
    resumo VARCHAR(500),
    imagem_url TEXT,
    publicada BOOLEAN NOT NULL DEFAULT false,
    autor_id UUID,
    autor_nome VARCHAR(150),
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ,
    CONSTRAINT fk_noticias_autor FOREIGN KEY (autor_id) REFERENCES profiles(id) ON DELETE SET NULL
    );

CREATE TABLE IF NOT EXISTS contatos (
                                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(180) NOT NULL,
    mensagem TEXT NOT NULL,
    lida BOOLEAN NOT NULL DEFAULT false,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS documentos (
                                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    titulo VARCHAR(180) NOT NULL,
    descricao VARCHAR(500),
    arquivo_url TEXT NOT NULL,
    tipo VARCHAR(80),
    visibilidade VARCHAR(50) NOT NULL DEFAULT 'obreiros',
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ
    );

CREATE TABLE IF NOT EXISTS ebo_participacoes (
                                                 id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    obreiro_id UUID NOT NULL,
    ano INTEGER NOT NULL,
    status VARCHAR(60) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    CONSTRAINT fk_ebo_obreiro FOREIGN KEY (obreiro_id) REFERENCES obreiros(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS logos_departamentos (
                                                   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome_departamento VARCHAR(120) NOT NULL,
    arquivo_url TEXT NOT NULL,
    formato VARCHAR(20),
    ativo BOOLEAN NOT NULL DEFAULT true,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ
    );

CREATE TABLE IF NOT EXISTS cultos_escalas (
                                              id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(180) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    arquivo_url TEXT,
    atual BOOLEAN NOT NULL DEFAULT false,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now()
    );

CREATE TABLE IF NOT EXISTS solicitacoes_obreiros (
                                                     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(180) NOT NULL,
    matricula VARCHAR(50) NOT NULL,
    senha_temp VARCHAR(255) NOT NULL,
    data_nascimento DATE,
    setor VARCHAR(120),
    congregacao VARCHAR(120),
    status VARCHAR(50) NOT NULL DEFAULT 'pendente',
    motivo_rejeicao VARCHAR(500),
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ
    );

CREATE TABLE IF NOT EXISTS logs_acesso (
                                           id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID,
    acao VARCHAR(150) NOT NULL,
    detalhes JSONB,
    ip_address VARCHAR(60),
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    CONSTRAINT fk_logs_profile FOREIGN KEY (user_id) REFERENCES profiles(id) ON DELETE SET NULL
    );

CREATE INDEX IF NOT EXISTS idx_profiles_email ON profiles(email);
CREATE INDEX IF NOT EXISTS idx_user_roles_user_id ON user_roles(user_id);
CREATE INDEX IF NOT EXISTS idx_obreiros_user_id ON obreiros(user_id);
CREATE INDEX IF NOT EXISTS idx_obreiros_matricula ON obreiros(matricula);
CREATE INDEX IF NOT EXISTS idx_noticias_publicada ON noticias(publicada);
CREATE INDEX IF NOT EXISTS idx_ebo_participacoes_obreiro_id ON ebo_participacoes(obreiro_id);
CREATE INDEX IF NOT EXISTS idx_logs_acesso_user_id ON logs_acesso(user_id);
CREATE INDEX IF NOT EXISTS idx_solicitacoes_status ON solicitacoes_obreiros(status);