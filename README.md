# Projeto Sistema Automotiva

## Um projeto elaborado pelos professores da faculdade UniSociesc visando treinar as lições aprendidas em Java

## Objetivos
* Criar um diagrama entidade-relacionamento para entender como serão criadas as tabelas no banco de dados.
* Criar as tabelas no banco de dados.
* Criar as interfaces gráficas e implementar as funcionalidades de cada uma.
---

## Proposta
Problema: Sistema Integrado de Controle de Estoque e Ordem de Serviço Automotiva. Você é responsável por desenvolver um sistema integrado de controle de estoque de peças automotivas e ordens de serviço para uma oficina mecânica. O sistema deve permitir o cadastro de peças, consulta de estoque, solicitação de baixa de estoque, criação de pedidos de compras, cadastro de clientes, abertura de ordens de serviço e controle do faturamento.

# Requisitos Funcionais:
* Cadastro de peças no estoque: O sistema deve permitir o cadastro de novas peças, incluindo as informações de código da peça, nome da peça, descrição, etc.
* Consulta de Estoque: Deve ser possível visualizar o estoque atual de todas as peças cadastradas, incluindo a quantidade disponível de cada uma.
* Solicitação de Baixa de Estoque: Os usuários devem poder solicitar a baixa de estoque de uma determinada peça, informando a quantidade a ser removida do estoque (isto não caracteriza que a peça foi vendida, por exemplo: peças com defeito).
* Criação de Pedido de Compras: Deve ser possível criar um pedido de compras para nosso estoque, selecionando as peças desejadas e suas respectivas quantidades. Ao efetuar um pedido de compras, o sistema deve atualizar o estoque SOMENTE quando o pedido de compra for setado para CONCLUÍDO, aumentando assim a quantidade das peças incluídas no pedido. Logo, você precisará ter uma opção para listar todos os pedidos de compras que foram concluídos e os que não foram concluídos ainda.
* Cadastro de Clientes: Deve ser possível cadastrar novos clientes da oficina, incluindo informações como nome, endereço, telefone, etc.
* Abertura de Ordem de Serviço (OS): Os usuários devem poder abrir uma OS, associando-a a um cliente e incluindo uma descrição do serviço a ser realizado.
* Controle do Faturamento: O sistema deve permitir o registro do faturamento de cada ordem de serviço que for CONCLUÍDA, incluindo o valor do serviço realizado e o valor das peças utilizadas. Após o registro do faturamento, o sistema deve atualizar o estoque das peças utilizadas na ordem de serviço (somente se a OS for concluída).

# Requisitos Não Funcionais:
* O sistema deve ser desenvolvido em Java, utilizando o banco de dados MySQL para armazenamento dos dados.
* Deve ser implementada uma interface gráfica intuitiva para facilitar a interação dos usuários com o sistema.
* Todas as operações de CRUD (Create, Read, Update, Delete) devem ser implementadas de forma segura e eficiente.
---

## Passos criados para ajudar na organização do projeto.

### Primeiro passo
Após a leitura da proposta optei por criar uma tabela resumindo os **Requisitos Funcionais** e **Requisitos não Funcionais**. Também adicionei algumas funcionalidades que julguei boas para esse exercício.

| **REQUISITOS FUNCIONAIS**  | **Descrição**           |
|:---:|---|
|  **RF 01**  | Login para funcionários da empresa |
|  **RF 02**  | Cadastro de funcionários |
|  **RF 03**  | Cadastro de peças no estoque |
|  **RF 04**  | Cadastro de fornecedores |
|  **RF 05**  | Cadastro de clientes |
|  **RF 06**  | Consulta e baixa de estoque |
|  **RF 07**  | Criação de pedidos de compras de peças |
|  **RF 08**  | Abertura de Ordem de Serviços |
|  **RF 09**  | Controle de faturamento |

| **REQUISITOS NÃO FUNCIONAIS**  | **Descrição**       |
|:---:|---|
| **RnF 01** | Desenvolver em Java |
| **RnF 02** | Utilizar Banco de dados MySQL |
| **RnF 03** | Interface gráfica intuitiva e de fácil usabilidade para os usuários |
| **RnF 04** | CRUD implementados de forma segura e eficiente |
---

### Segundo passo

Também formulei algumas perguntas pra tentar entender como funcionaria o fluxo de trabalho do sistema.

* Quem irá utilizar o sistema?  - O sistema deve ser utilizado por todos os funcionários cadastrados. Deverá ter níveis de acesso para as funcionalidades do sistema, dependendo do cargo do funcionário. Os 2 níveis definidos são ***Administrativo*** e ***Comum***.
* Quem poderá cadastrar funcionários, clientes, peças, fornecedores? - Todos os cadastros poderão serem feitos por funcionários com acesso ***Administrativo***. Funcionários com acesso ***Comum*** poderão apenas cadastrar clientes.
* Como será definido o tipo de acesso do funcionário? No cadastro dele.
* Quem terá permissão pra dar baixa de estoque? Qualquer usuário.
* Quem poderá abrir e fechar as Ordens de Serviços? Qualquer usuário.
* Quem fará o controle de faturamento? Usuários ***Administrativos***.

### Terceiro passo

Definindo as Stacks que serão utilizadas.
1. O diagrama ER será feito no site da **LucidChart**.
2. As interfaces gráficas serão criadas no **NetBeans** utilizando **JavaSwing**.
3. A conexão com o **MySQL** será feito através da API JDBC(Java DataBase Connection).

### Quarto passo

Criei um diagrama Entidade-Relacionamento a partir dos requisitos funcionais para entender como o DataBase será estruturado.

### Quinto passo

Criei uma DataBase e as Tables, no **MySQL**, usando o diagrama do **quarto passo** como base.

### Sexto passo

Conectar o **NetBeans** com o Banco de Dados através da API JDBC.

### Sétimo passo

Criei as respectivas *classes modelos* para cada entidade criada no Banco de Dados, onde os atributos das classes representam os campos das tabelas.

# O que falta?

- Criar as *classes DAO(Data Access Object)* que terão os métodos de consulta SQL, *CRUD(CREATE, READ, UPDATE and DELETE)*, que quando executadas, irão enviar e salvar os dados no Banco de Dados.
- Criar as interfaces gráficas necessárias.
- Implementar as ações/funcionalidades para cada uma das interfaces.
- Testar o sistema.

--README ainda sendo atualizado.