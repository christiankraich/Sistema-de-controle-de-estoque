# Projeto Sistema Automotiva

## Um projeto elaborado pelos professores da faculdade UniSociesc visando treinar as lições aprendidas em Java

## Objetivos
* Criar um diagrama entidade-relacionamento para entender como serão criadas as tabelas no banco de dados.
* Criar as tabelas no banco de dados.
* Criar as interfaces gráficas e implementar as funcionalidades de cada uma.
---

## Proposta
Problema: Sistema Integrado de Controle de Estoque e Ordem de Serviço AutomotivaVocê é responsável por desenvolver um sistema integrado de controle de estoque de peçasautomotivas e ordens de serviço para uma oficina mecânica. O sistema deve permitir ocadastro de peças, consulta de estoque, solicitação de baixa de estoque, criação de pedidosde compras, cadastro de clientes, abertura de ordens de serviço e controle do faturamento.

# Requisitos Funcionais:
* Cadastro de peças no estoque: O sistema deve permitir o cadastro de novas peças, incluindo as informações de código dapeça, nome da peça, descrição, etc.
* Consulta de Estoque: Deve ser possível visualizar o estoque atual de todas as peças cadastradas, incluindo aquantidade disponível de cada uma.
* Solicitação de Baixa de Estoque: Os usuários devem poder solicitar a baixa de estoque de uma determinada peça, informandoa quantidade a ser removida do estoque (isto não caracteriza que a peça foi vendida, porexemplo: peças com defeito).
* Criação de Pedido de Compras:Deve ser possível criar um pedido de compras para nosso estoque, selecionando as peçasdesejadas e suas respectivas quantidades. Ao efetuar um pedido de compras, o sistema deveatualizar o estoque SOMENTE quando o pedido de compra for setado para CONCLUÍDO, aumentando assim a quantidade das peças incluídas no pedido. Logo, você precisará teruma opção para listar todos os pedidos de compras que foram concluídos e os que não foramconcluídos ainda.
* Cadastro de Clientes: Deve ser possível cadastrar novos clientes da oficina, incluindo informações como nome,endereço, telefone, etc.
* Abertura de Ordem de Serviço (OS): Os usuários devem poder abrir uma OS, associando-a a um cliente e incluindo uma descriçãodo serviço a ser realizado.
* Controle do Faturamento: O sistema deve permitir o registro do faturamento de cada ordem de serviço que for CONCLUÍDA, incluindo o valor do serviço realizado e o valor das peças utilizadas. Após oregistro do faturamento, o sistema deve atualizar o estoque das peças utilizadas na ordem deserviço (somente se a OS for concluída).

# Requisitos Não Funcionais:
* O sistema deve ser desenvolvido em Java, utilizando o banco de dados MySQL paraarmazenamento dos dados.
* Deve ser implementada uma interface gráfica intuitiva para facilitar a interação dos usuárioscom o sistema.
* Todas as operações de CRUD (Create, Read, Update, Delete) devem ser implementadas deforma segura e eficiente.
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

Conectar o **NetBeans** com o Banco de Dados.

--README ainda sendo atualizado
