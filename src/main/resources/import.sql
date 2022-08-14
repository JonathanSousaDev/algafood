insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Coco bambu', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Labareda', 12, 2);

insert into forma_pagamento (descricao) values ('Espécie');
insert into forma_pagamento (descricao) values ('Débito');
insert into forma_pagamento (descricao) values ('Crédito');

insert into estado (nome) values ('Piauí');
insert into estado (nome) values ('Amapá');
insert into estado (nome) values ('São Paulo');

insert into cidade (nome, estado_id) values ('Água Branca', 1);
insert into cidade (nome, estado_id) values ('Santana', 2);
insert into cidade (nome, estado_id) values ('Mauá', 3);

insert into permissao (nome, descricao) values ('consulta-cozinhas', 'Permite consultar a página de cozinhas');
insert into permissao (nome, descricao) values ('consulta-restaurantes', 'Permite consultar a página de restaurantes');