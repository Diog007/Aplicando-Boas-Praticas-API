# CURSO ALURA: Boas práticas de programação: melhore o código de uma API Java

Este repositório contém os códigos e documentação referentes ao curso de Testes Automatizados em Java.

## Módulo 1: Refatoração e Estruturação do Projeto
Na versão inicial do projeto, todas as operações relacionadas ao negócio estavam centralizadas na classe AdocaoController, o que poderia complicar a organização do código e dificultar sua manutenção. Para aprimorar a estrutura do projeto, optamos por transferir as regras de negócio para uma nova classe denominada AdocaoService, enquanto a lógica de envio de emails foi isolada em uma classe separada chamada EmailService. Essa abordagem ajuda a dividir as responsabilidades do código, tornando-o mais coeso e modular.

## Módulo 2: Utilização do Padrão DTO em APIs
No segundo módulo do curso, exploramos a importância de utilizar o padrão DTO (Data Transfer Object) e sua aplicabilidade em APIs. O uso do DTO é crucial para facilitar a transferência de dados entre distintas partes de uma aplicação, promovendo uma comunicação eficaz, flexível e segura, além de possibilitar o controle sobre os dados enviados e recebidos.

## Módulo 3: Aplicação dos Padrões Strategy e Chain of Responsibility
Neste módulo do curso, aprendi a aplicar os padrões Strategy e Chain of Responsibility para isolar as validações de regras de negócio da classe AdocaoService. Criamos a interface ValidacaoSolicitacaoAdocao, que define o contrato do método validar para executar as validações necessárias. Em seguida, implementamos diversas classes de validação, cada uma responsável por uma validação específica. E aplicamos o padrão de projeto Chain of Responsibility para percorrer a lista de validações de maneira automática.

## Módulo 4: Otimização da Camada de Persistência
No quarto módulo do curso, mergulhamos na otimização da camada de persistência em aplicações Java, utilizando as convenções da JPA de maneira eficiente. Exploramos as funcionalidades das convenções da JPA para mapear entidades de forma precisa e eficaz. Aprendemos a realizar consultas otimizadas ao banco de dados, evitando gargalos de performance na aplicação. Criamos consultas personalizadas utilizando métodos específicos em interfaces Repository, como existsBy, para verificar a existência de registros de forma eficiente sem ter que percorrer uma lista. Simplificamos o código das entidades, eliminando redundâncias e deixando-o mais enxuto e legível. Implementamos construtores para inicializar entidades de forma eficiente e métodos de regra de negócio para operações específicas, como marcação de aprovação ou reprovação.

## Módulo 5: Desafio de Implementação das Boas Práticas
No quinto e último módulo do curso, o professor Rodrigo propôs um desafio: aplicar todas as boas práticas ensinadas nos quatro módulos anteriores. E  consegui concluir a implementação dessas práticas em todos os Controllers, transferindo toda a lógica de persistência para o banco de dados e  busca para a classe de serviço. Além disso, utilizei DTOs para representar tanto as entradas quanto os retornos, garantindo assim uma implementação eficiente.
