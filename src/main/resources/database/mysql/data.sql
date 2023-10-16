# QUERY PARA CRIAÇÃO DA TABELA DE MATERIAL

*************************************************************************************************

    # QUERY PARA ADICIONAR MATERIAIS NA TABELA DE ESTOQUE

    INSERT INTO ESTOQUE (sigla, tipo, nome, descricao, unidade_de_medida, quantidade, adicionado_por, atualizado_por, adicionado_em, ativo)
    VALUES
    ('Sigla1', 'ELETRICO', 'Nome1', 'Descrição 1', 'M', 100.0, 'Usuário1', '', NOW(), true),
    ('Sigla2', 'CIVIL', 'Nome2', 'Descrição 2', 'M2', 150.0, 'Usuário2', '', NOW(), true),
    ('Sigla3', 'HIDRAULICO', 'Nome3', 'Descrição 3', 'UND', 200.0, 'Usuário3', '', NOW(), true),
    ('Sigla4', 'VESTIMENTA', 'Nome4', 'Descrição 4', 'UND', 50.0, 'Usuário4', '', NOW(), true),
    ('Sigla5', 'EPI', 'Nome5', 'Descrição 5', 'UND', 30.0, 'Usuário5', '', NOW(), true),
    ('Sigla6', 'EPC', 'Nome6', 'Descrição 6', 'UND', 70.0, 'Usuário6', '', NOW(), true),
    ('Sigla7', 'FERRAMENTA', 'Nome7', 'Descrição 7', 'UND', 90.0, 'Usuário7', '', NOW(), true),
    ('Sigla8', 'ELETRICO', 'Nome8', 'Descrição 8', 'M', 120.0, 'Usuário8', '', NOW(), true),
    ('Sigla9', 'CIVIL', 'Nome9', 'Descrição 9', 'M2', 180.0, 'Usuário9', '', NOW(), true),
    ('Sigla10', 'HIDRAULICO', 'Nome10', 'Descrição 10', 'M3', 220.0, 'Usuário10', '', NOW(), true),
    ('Sigla11', 'ELETRICO', 'Nome11', 'Descrição 11', 'M', 100.0, 'Usuário1', '', NOW(), true),
    ('Sigla12', 'CIVIL', 'Nome12', 'Descrição 12', 'M2', 150.0, 'Usuário2', '', NOW(), true),
    ('Sigla13', 'HIDRAULICO', 'Nome13', 'Descrição 13', 'UND', 200.0, 'Usuário3', '', NOW(), true),
    ('Sigla14', 'VESTIMENTA', 'Nome14', 'Descrição 14', 'UND', 50.0, 'Usuário4', '', NOW(), true),
    ('Sigla15', 'EPI', 'Nome15', 'Descrição 15', 'UND', 30.0, 'Usuário5', '', NOW(), true),
    ('Sigla16', 'EPC', 'Nome16', 'Descrição 16', 'UND', 70.0, 'Usuário6', '', NOW(), true),
    ('Sigla17', 'FERRAMENTA', 'Nome17', 'Descrição 17', 'UND', 90.0, 'Usuário7', '', NOW(), true),
    ('Sigla18', 'ELETRICO', 'Nome18', 'Descrição 18', 'M', 120.0, 'Usuário8', '', NOW(), true),
    ('Sigla19', 'CIVIL', 'Nome19', 'Descrição 19', 'M2', 180.0, 'Usuário9', '', NOW(), true),
    ('Sigla20', 'HIDRAULICO', 'Nome20', 'Descrição 20', 'M3', 220.0, 'Usuário10', '', NOW(), true),
    ('Sigla21', 'ELETRICO', 'Nome21', 'Descrição 21', 'M', 100.0, 'Usuário1', '', NOW(), true),
    ('Sigla22', 'CIVIL', 'Nome22', 'Descrição 22', 'M2', 150.0, 'Usuário2', '', NOW(), true),
    ('Sigla23', 'HIDRAULICO', 'Nome23', 'Descrição 23', 'UND', 200.0, 'Usuário3', '', NOW(), true),
    ('Sigla24', 'VESTIMENTA', 'Nome24', 'Descrição 24', 'UND', 50.0, 'Usuário4', '', NOW(), true),
    ('Sigla25', 'EPI', 'Nome25', 'Descrição 25', 'UND', 30.0, 'Usuário5', '', NOW(), true),
    ('Sigla26', 'EPC', 'Nome26', 'Descrição 26', 'UND', 70.0, 'Usuário6', '', NOW(), true),
    ('Sigla27', 'FERRAMENTA', 'Nome27', 'Descrição 27', 'UND', 90.0, 'Usuário7', '', NOW(), true),
    ('Sigla28', 'ELETRICO', 'Nome28', 'Descrição 28', 'M', 120.0, 'Usuário8', '', NOW(), true),
    ('Sigla29', 'CIVIL', 'Nome29', 'Descrição 29', 'M2', 180.0, 'Usuário9', '', NOW(), true),
    ('Sigla30', 'HIDRAULICO', 'Nome30', 'Descrição 30', 'M3', 220.0, 'Usuário10', '', NOW(), true),
    ('Sigla31', 'ELETRICO', 'Nome31', 'Descrição 31', 'M', 100.0, 'Usuário1', '', NOW(), true),
    ('Sigla32', 'CIVIL', 'Nome32', 'Descrição 32', 'M2', 150.0, 'Usuário2', '', NOW(), true),
    ('Sigla33', 'HIDRAULICO', 'Nome33', 'Descrição 33', 'UND', 200.0, 'Usuário3', '', NOW(), true),
    ('Sigla34', 'VESTIMENTA', 'Nome34', 'Descrição 34', 'UND', 50.0, 'Usuário4', '', NOW(), true),
    ('Sigla35', 'EPI', 'Nome35', 'Descrição 35', 'UND', 30.0, 'Usuário5', '', NOW(), true),
    ('Sigla36', 'EPC', 'Nome36', 'Descrição 36', 'UND', 70.0, 'Usuário6', '', NOW(), true),
    ('Sigla37', 'FERRAMENTA', 'Nome37', 'Descrição 37', 'UND', 90.0, 'Usuário7', '', NOW(), true),
    ('Sigla38', 'ELETRICO', 'Nome38', 'Descrição 38', 'M', 120.0, 'Usuário8', '', NOW(), true),
    ('Sigla39', 'CIVIL', 'Nome39', 'Descrição 39', 'M2', 180.0, 'Usuário9', '', NOW(), true),
    ('Sigla40', 'HIDRAULICO', 'Nome40', 'Descrição 40', 'M3', 220.0, 'Usuário10', '', NOW(), true),
    ('Sigla41', 'ELETRICO', 'Nome41', 'Descrição 41', 'M', 100.0, 'Usuário1', '', NOW(), true),
    ('Sigla42', 'CIVIL', 'Nome42', 'Descrição 42', 'M2', 150.0, 'Usuário2', '', NOW(), true),
    ('Sigla43', 'HIDRAULICO', 'Nome43', 'Descrição 43', 'UND', 200.0, 'Usuário3', '', NOW(), true),
    ('Sigla44', 'VESTIMENTA', 'Nome44', 'Descrição 44', 'UND', 50.0, 'Usuário4', '', NOW(), true),
    ('Sigla45', 'EPI', 'Nome45', 'Descrição 45', 'UND', 30.0, 'Usuário5', '', NOW(), true),
    ('Sigla46', 'EPC', 'Nome46', 'Descrição 46', 'UND', 70.0, 'Usuário6', '', NOW(), true),
    ('Sigla47', 'FERRAMENTA', 'Nome47', 'Descrição 47', 'UND', 90.0, 'Usuário7', '', NOW(), true),
    ('Sigla48', 'ELETRICO', 'Nome48', 'Descrição 48', 'M', 120.0, 'Usuário8', '', NOW(), true),
    ('Sigla49', 'CIVIL', 'Nome49', 'Descrição 49', 'M2', 180.0, 'Usuário9', '', NOW(), true),
    ('Sigla50', 'HIDRAULICO', 'Nome50', 'Descrição 50', 'M3', 220.0, 'Usuário10', '', NOW(), true);



    
    
    