# 🏛️ Sistema de Gestão de Projetos de Arquitetura

Um sistema CRUD completo desenvolvido em Java para gerenciar escritórios de arquitetura, permitindo o cadastro de Arquitetos, Clientes e o vínculo entre eles em Projetos.

## 💻 Sobre o Projeto
Este projeto foi desenvolvido com foco na aplicação prática de **Programação Orientada a Objetos** e **Persistência de Dados** em bancos relacionais. O objetivo foi simular um cenário real onde o sistema garante a integridade dos dados, impedindo, por exemplo, que um projeto seja criado sem um arquiteto responsável válido (Foreign Keys).

## 🛠️ Tecnologias Utilizadas
* **Java 17:** Linguagem base.
* **Maven:** Gerenciamento de dependências e build.
* **PostgreSQL:** Banco de dados relacional.
* **JDBC (Java Database Connectivity):** Conexão de baixo nível com o banco.
* **IntelliJ IDEA:** IDE de desenvolvimento.

## 🚀 Arquitetura e Padrões
O projeto segue a arquitetura em camadas para garantir a separação de responsabilidades:
* **App (View):** Interface via console interativa com Menu para o usuário.
* **Model:** Classes representando as entidades (`Arquiteto`, `Cliente`, `Projeto`) com uso de Herança (`Pessoa`).
* **Repository (DAO):** Padrão **Data Access Object** para isolar as regras de negócio dos comandos SQL. Uso de `PreparedStatement` para segurança contra SQL Injection.

## ⚙️ Funcionalidades
- [x] Conexão segura com banco de dados PostgreSQL.
- [x] **CRUD** (Create, Read, Update, Delete) de Arquitetos e Clientes.
- [x] Cadastro de Projetos com validação de chaves estrangeiras (IDs).
- [x] Listagem de projetos convertendo IDs do banco de volta para Objetos Java.
- [x] Menu interativo via console.

## 🎓 Aprendizados
Durante o desenvolvimento, aprofundei conhecimentos em:
* Mapeamento Objeto-Relacional manual (como transformar um `ResultSet` em Objetos).
* Tratamento de Exceções (`try-with-resources`).
* Estruturação de projetos profissionais com Maven.
* Conexão de Banco de Dados PostgreSQL via JDBC

---
Desenvolvido por Luiz Conde