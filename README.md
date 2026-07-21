# JDBC Exercises

Repositório criado para registrar minha evolução nos estudos de JDBC com Java, seguindo o curso do professor Nélio Alves.

Cada exercício é desenvolvido de forma incremental, praticando os principais recursos da API JDBC antes da implementação do padrão DAO.

## Objetivos

- Praticar a conexão com banco de dados utilizando JDBC.
- Aprender a executar comandos SQL com Java.
- Compreender o uso de `Connection`, `PreparedStatement`, `ResultSet` e transações.
- Consolidar os conceitos antes da implementação do padrão DAO.

## Tecnologias

- Java
- JDBC
- MySQL
- Eclipse IDE

## Exercícios

| Nº | Exercício | Status |
|----|-----------|--------|
| 01 | Inserir um departamento e recuperar o ID gerado | ✅ |
| 02 | Buscar departamento por ID | ✅ |
| 03 | Atualizar um departamento | ✅ |
| 04 | Excluir um departamento | ⏳ |
| 05 | ... | ⏳ |

## Estrutura do projeto

```
src
├── application
│   └── Program.java
└── db
    ├── DB.java
    ├── DbException.java
    └── DbIntegrityException.java
```

## Observações

Este repositório possui finalidade exclusivamente educacional e acompanha minha evolução no estudo de JDBC e integração entre Java e MySQL.