# Sistema de Controle Financeiro (Java)

Projeto simples em Java para controle financeiro pessoal, com registro de receitas e despesas, leitura e escrita em arquivo CSV.

## Funcionalidades

- Adicionar receitas
- Adicionar despesas
- Consultar saldo atual
- Listar transações salvas

## Estrutura

- `Main.java`: ponto de entrada, contém o menu e interações com o usuário.
- `Transacao.java`: representa uma transação com tipo, valor, descrição e data.
- `GerenciadorFinanceiro.java`: lida com escrita no arquivo `financas.csv`.

## Tecnologias

- Java puro (sem frameworks externos)
- Manipulação de arquivos `.csv`
- Programação orientada a objetos

## Como executar

1. Execute o programa:

java application.Main


2. Siga o menu no terminal para adicionar receitas, despesas e consultar dados.

## Arquivo de dados

As transações são salvas no arquivo `financas.csv` na raiz do projeto.

## Observação

Este projeto é um exercício educacional para praticar Java básico e POO. Melhorias como validação de data, filtros e persistência mais robusta podem ser adicionadas futuramente.
