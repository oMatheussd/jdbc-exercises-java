# JDBC Exercises

Projeto desenvolvido durante os estudos de JDBC no curso de Java do professor Nélio Alves.

## Objetivo

Praticar as operações básicas de acesso a banco de dados utilizando JDBC e MySQL, implementando um sistema simples de gerenciamento de departamentos.

## Tecnologias

- Java
- JDBC
- MySQL
- Eclipse IDE

## Funcionalidades

- ✅ Inserir departamento
- ✅ Buscar departamento por ID
- ✅ Atualizar departamento
- ✅ Excluir departamento
- ✅ Menu interativo no console

## Estrutura

```
src
├── application
│   └── Program.java
└── db
    ├── DB.java
    ├── DbException.java
    └── DbIntegrityException.java
```

## Conceitos praticados

- Conexão com banco de dados
- PreparedStatement
- ResultSet
- executeQuery()
- executeUpdate()
- RETURN_GENERATED_KEYS
- CRUD completo
- Estrutura de menus
- Organização do código em métodos
- Tratamento de exceções