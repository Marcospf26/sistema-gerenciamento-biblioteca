# 📚 Sistema de Gerenciamento de Biblioteca

Projeto desenvolvido em Java com integração ao PostgreSQL, utilizando JDBC para persistência e manipulação de dados.

O sistema permite realizar operações de gerenciamento de livros, incluindo cadastro, consulta, atualização e exclusão de registros.

## 🚀 Tecnologias utilizadas

- Java
- Maven
- JDBC
- PostgreSQL
- Git e GitHub

## ⚙️ Funcionalidades

- [x] Cadastrar livros
- [x] Listar livros cadastrados
- [x] Atualizar informações de livros
- [x] Excluir livros
- [x] Verificar duplicidade de ISBN
- [x] Persistir dados em banco de dados PostgreSQL
- [x] Utilizar PreparedStatement nas consultas SQL
- [x] Gerenciar recursos com try-with-resources
- [x] Separar responsabilidades utilizando DAO e Service

## 🏗️ Estrutura do projeto

```text
src/
└── main/
    └── java/
        └── br/com/marcos/biblioteca/
            ├── dao/
            │   └── LivroDAO.java
            ├── database/
            │   └── Conexao.java
            ├── enums/
            │   └── ResultadoOperacao.java
            ├── model/
            │   └── Livro.java
            ├── service/
            │   └── LivroService.java
            └── Main.java
```

## 🗄️ Banco de dados

O projeto utiliza PostgreSQL.

Crie um banco de dados chamado `Desafio_3_BD` e execute o seguinte comando para criar a tabela:

```sql
CREATE TABLE livros (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    isbn VARCHAR(50) UNIQUE NOT NULL,
    quantidade_exemplares INTEGER NOT NULL
        CHECK (quantidade_exemplares >= 0)
);
```

## 🔧 Configuração

Para executar o projeto, configure as seguintes variáveis de ambiente na sua IDE ou no sistema operacional:

| Variável | Descrição |
|---|---|
| `DB_URL` | URL de conexão com PostgreSQL |
| `DB_USER` | Usuário do banco de dados |
| `DB_PASSWORD` | Senha do banco de dados |

Exemplo:

```text
DB_URL=jdbc:postgresql://localhost:5432/Desafio_3_BD
DB_USER=postgres
DB_PASSWORD=sua_senha
```

**Importante:** não compartilhe suas credenciais nem publique senhas no GitHub.

## ▶️ Como executar

1. Clone o repositório:

```bash
git clone https://github.com/Marcospf26/sistema-gerenciamento-biblioteca.git
```

2. Abra o projeto na sua IDE.

3. Configure as variáveis de ambiente necessárias.

4. Certifique-se de que o PostgreSQL esteja em execução e que o banco de dados esteja criado.

5. Execute a classe `Main`.

## 👨‍💻 Autor

**Marcos Pedron Fagundes**

- GitHub: [@Marcospf26](https://github.com/Marcospf26)
- Estudante de Engenharia de Software na UTFPR.