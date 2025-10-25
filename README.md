# 🏦 FinanceCore

Um sistema financeiro modular desenvolvido em **Spring Boot**, com autenticação JWT, controle de usuários, contas e transações seguras.

---
## 📁 Estrutura de Pastas

```
financecore/
├── user/
│   ├── User.java                      # Entidade JPA do usuário
│   ├── UserType.java                  # Enum (CLIENTE, LOJISTA)
│   ├── UserRepository.java            # Interface Spring Data JPA
│   ├── UserService.java               # Lógica de negócio dos usuários
│   ├── UserController.java            # Endpoints REST para usuários
│   └── dto/
│       ├── CreateUserDTO.java         # DTO para criação de usuário
│       └── UserResponseDTO.java       # DTO para retorno de dados do usuário
│
├── account/
├── Account.java                   # Entidade JPA da conta
├── AccountRepository.java          # Repositório (interface JPA)
├── AccountService.java             # Lógica de negócio (depósitos, saques, etc)
├── AccountController.java          # Endpoints REST da conta (opcional, se houver API própria)
├── dto/
│   ├── CreateAccountDTO.java       # DTO para criação de conta
│   ├── AccountResponseDTO.java     # DTO para retorno de informações da conta
│   └── UpdateBalanceDTO.java       # DTO para alterar saldo (opcional)
├── mapper/
│    └── AccountMapper.java          # Classe utilitária para converter entre entidade e DTO
│
├── transaction/
│   ├── Transaction.java               # Entidade JPA da transação
│   ├── TransactionRepository.java     # Repositório da transação
│   ├── TransactionService.java        # Lógica principal de transações
│   ├── TransactionController.java     # Endpoints REST para transações
│   └── dto/
│       └── CreateTransactionDTO.java  # DTO para realizar uma transação
│
├── security/
│   ├── SecurityConfig.java            # Configuração do Spring Security
│   ├── TokenService.java              # Serviço para geração e validação JWT
│   ├── SecurityFilter.java            # Filtro que valida o token em requisições
│   ├── AuthenticationService.java     # Serviço de autenticação de usuários
│   ├── AuthenticationController.java  # Endpoint de login
│   └── dto/
│       └── LoginDTO.java              # DTO para autenticação
│
├── notification/
│   └── NotificationService.java       # Serviço simulado para envio de notificações
│
├── authorization/
│   └── AuthorizationService.java      # Serviço simulado para autorização de transações
│
├── exception/
│   ├── GlobalExceptionHandler.java    # Tratador global de exceções (@RestControllerAdvice)
│   └── custom/
│       ├── InsufficientBalanceException.java
│       └── TransactionNotAuthorizedException.java
│
└── FinanceCoreApplication.java        # Classe principal da aplicação
```

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **Spring Security (JWT)**
- **H2 / PostgreSQL**
- **Lombok**
- **Maven**

---

## ⚙️ Funcionalidades

✅ Cadastro e autenticação de usuários (JWT)  
✅ Tipos de usuário: **Cliente** e **Lojista**  
✅ Criação e consulta de contas  
✅ Transações com validação de saldo e autorização externa  
✅ Envio de notificações simuladas  
✅ Tratamento global de exceções

---

## 🧠 Estrutura Modular

| Módulo | Responsabilidade |
|:--|:--|
| **user** | Gerenciamento de usuários e autenticação |
| **account** | Criação e controle de contas |
| **transaction** | Lógica de transferência e validação de transações |
| **security** | Configuração de segurança e autenticação JWT |
| **authorization** | Serviço externo simulado para autorizações |
| **notification** | Serviço de notificações |
| **exception** | Tratamento centralizado de erros |

---

## 🧩 Padrões e Boas Práticas

- Arquitetura em **camadas** (Controller → Service → Repository)
- Uso de **DTOs** para isolamento entre camadas
- **Injeção de dependências** com Spring
- **Tratamento global de exceções**
- **Testabilidade** e separação de responsabilidades

---

## 💻 Como Executar o Projeto

```bash
# Clonar o repositório
git clone https://github.com/seuusuario/financecore.git

# Entrar no diretório
cd financecore

# Executar o projeto
mvn spring-boot:run
```

O servidor será iniciado em:  
👉 **http://localhost:8080**

---

## 📡 Endpoints Principais

### 🔐 Autenticação
| Método | Endpoint | Descrição |
|:--|:--|:--|
| `POST` | `/auth/login` | Realiza o login e retorna o token JWT |

### 👤 Usuários
| Método | Endpoint | Descrição |
|:--|:--|:--|
| `POST` | `/users` | Cria um novo usuário |
| `GET` | `/users/{id}` | Busca usuário pelo ID |

### 💳 Contas
| Método | Endpoint | Descrição |
|:--|:--|:--|
| `GET` | `/accounts/{id}` | Consulta dados de uma conta |

### 💸 Transações
| Método | Endpoint | Descrição |
|:--|:--|:--|
| `POST` | `/transactions` | Cria uma nova transação |
| `GET` | `/transactions/{id}` | Consulta detalhes da transação |

---

## 📬 Autor

**Pedro Peixoto**  
💼 Desenvolvedor Java | Engenheiro de Software  
🌐 [LinkedIn](https://www.linkedin.com/in/Peixotim) | 💻 [GitHub](https://github.com/Peixotim)

---