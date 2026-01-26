# BootcampJava

Repositório criado para armazenar os **códigos desenvolvidos durante o Bootcamp de Java**.  
Os conteúdos estão organizados por aula, acompanhando a evolução do aprendizado.

---

## 📚 Conteúdo do Repositório

- **Aula 1 – Fundamentos de Java**
    - Sintaxe básica
    - Condicionais (`if / else`)
    - Laços de repetição (`for`, `while`)
    - Introdução à Programação Orientada a Objetos (POO)

- **Aula 2 – CRUD em Java**
    - Criação de CRUD básico
    - Cadastro, leitura, atualização e remoção de dados
    - Organização de código
    - Uso de listas/arrays

- **Aula 3 – Programação Orientada a Objetos**
    - POO na prática
    - Separação de responsabilidades (Model + Service)
    - Menus interativos no console
    - Exercícios:
        - Pessoa
        - Jogador
        - Elevador

- **Aula 4 – Gerenciador de Tarefas Web**
    - Sistema web para criar, concluir, reabrir e excluir tarefas
    - Front-end com HTML, CSS, JavaScript e Bootstrap
    - Armazenamento local via **LocalStorage**
    - Funcionalidades:
        - Criar tarefa
        - Concluir/Reabrir tarefa
        - Excluir tarefa
        - Filtros (Todas / Pendentes / Concluídas)
        - Modo escuro
        - Salvamento automático
    - Estrutura do projeto:
        ```
        Aula4/
        ├── index.html
        ├── styles.css
        └── script.js
        ```
    - Conceitos aplicados: DOM, eventos, template literals, variáveis CSS, grid system e cards do Bootstrap

- **Aula 5 – Cadastro de Produtos — Spring Boot API**
    - API REST para cadastro, consulta e gerenciamento de produtos
    - Tecnologias:
        - Java / POO
        - Spring Boot
        - JPA / Hibernate
        - Banco de dados H2 em memória
    - Funcionalidades:
        - Criar, listar, buscar por ID, buscar por preço ou quantidade, atualizar e excluir produtos
    - Estrutura do projeto:
        ```
        Controller → Service → Repository → Entity → Banco
        ```
    - Conceitos aplicados: Controllers REST, injeção de dependência, queries JPA, endpoints HTTP, JSON, Postman
    - Limitações: banco em memória, sem autenticação, sem front-end integrado
    - Melhorias futuras: DTOs, validações avançadas, paginação, upload de imagens, documentação Swagger

---

## 📂 Estrutura Geral

BootcampJava/
├── Aula1/
├── Aula2/
├── Aula3/
├── Aula4/
└── Aula5/

---

## 🎯 Objetivo

- Consolidar a base em **Java**
- Evoluir do básico até estruturas mais organizadas
- Criar um histórico de aprendizado no GitHub
- Servir como material de estudo e portfólio

---

## ▶️ Como Executar

### Aula 1 a 3 (Java puro)
1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/BootcampJava.git
