-- Tabela de Usuários
CREATE TABLE usuarios (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(150) UNIQUE NOT NULL,
                          senha VARCHAR(255) NOT NULL,
                          data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de Perfis
CREATE TABLE perfis (
                        id SERIAL PRIMARY KEY,
                        descricao VARCHAR(50) NOT NULL
);

-- Relacionamento N:N entre Usuarios e Perfis
CREATE TABLE usuario_perfil (
                                id_usuario INT NOT NULL,
                                id_perfil INT NOT NULL,
                                PRIMARY KEY (id_usuario, id_perfil),
                                FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
                                FOREIGN KEY (id_perfil) REFERENCES perfis(id)
);

-- Tabela de Produtos
CREATE TABLE produtos (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          descricao TEXT,
                          preco DECIMAL(10,2) NOT NULL,
                          quantidade_estoque INT NOT NULL,
                          data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de Pedidos
CREATE TABLE pedidos (
                         id SERIAL PRIMARY KEY,
                         id_usuario INT NOT NULL,
                         data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         valor_total DECIMAL(10,2) NOT NULL,

                         status VARCHAR(50) DEFAULT 'PENDENTE',
                         FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

-- Tabela de Itens do Pedido
CREATE TABLE itens_pedido (
                              id SERIAL PRIMARY KEY,
                              id_pedido INT NOT NULL,
                              id_produto INT NOT NULL,
                              quantidade INT NOT NULL,
                              preco_unitario DECIMAL(10,2) NOT NULL,
                              FOREIGN KEY (id_pedido) REFERENCES pedidos(id),
                              FOREIGN KEY (id_produto) REFERENCES produtos(id)
);

-- Tabela de Pagamentos
CREATE TABLE pagamentos (
                            id SERIAL PRIMARY KEY,
                            id_pedido INT NOT NULL,
                            valor_pago DECIMAL(10,2) NOT NULL,
                            metodo_pagamento VARCHAR(50) NOT NULL,
                            data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            FOREIGN KEY (id_pedido) REFERENCES pedidos(id)
);