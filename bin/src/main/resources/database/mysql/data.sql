# QUERY PARA CRIAÇÃO DA TABELA DE MATERIAL

CREATE TABLE IF NOT EXISTS ESTOQUE.MATERIAL (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    sigla VARCHAR(255) NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    unidade_de_medida ENUM('und', 'm', 'm_2', 'm_3') NOT NULL,
    quantidade DECIMAL(10, 2) NOT NULL,
    adicionado_por VARCHAR(255) NOT NULL,
    atualizado_por VARCHAR(255) NOT NULL,
    adicionado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

*************************************************************************************************

# QUERY PARA ADICIONAR VALORES NA TABELA DE MATERIAIS

INSERT INTO material (sigla, tipo, nome, descricao, unidade_de_medida)
VALUES 
    ('MAT001', 'Construção Civil', 'Tijolo', 'Tijolo de construção', 'und'),
    ('MAT002', 'Construção Civil', 'Cimento', 'Cimento Portland', 'und'),
    ('MAT003', 'Construção Civil', 'Telha', 'Telha cerâmica', 'und'),
    ('MAT004', 'Construção Civil', 'Aço', 'Barra de aço', 'm'),
    ('MAT005', 'Elétrico', 'Fio elétrico', 'Fio de cobre para eletricidade', 'm'),
    ('MAT006', 'Elétrico', 'Interruptor', 'Interruptor de luz', 'und'),
    ('MAT007', 'Construção Civil', 'Areia', 'Areia fina para construção', 'm_3'),
    ('MAT008', 'Elétrico', 'Tomada', 'Tomada elétrica padrão', 'und'),
    ('MAT009', 'Construção Civil', 'Tinta', 'Tinta acrílica para parede', 'm_2'),
    ('MAT010', 'Elétrico', 'Lâmpada', 'Lâmpada LED', 'und');
    
    
    
    
    