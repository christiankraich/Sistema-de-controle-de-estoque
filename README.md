# Projeto de Controle de Estoque para Oficina Mecânica
  Este é um sistema desktop desenvolvido em **Java (Swing)** com conexão a um banco de dados **MySQL**, utilizando **XAMPP** como ambiente local de desenvolvimento.

## Ferramentas
 - NetBeans IDE
 - JavaSwing
 - MySQL Workbench
 - JDBC
 - XAMPP

## Funcionalidades
 - Tela de Login
 - Tela de Area de Tabalho
 - Cadastro de Clientes
 - Cadastro de Cargos
 - Cadastro de Funcionários
 - Cadastro de Fornecedores
 - Cadastro de Peças
 - Tela de Controle de Estoque

 ## Requisitos
 - [XAMPP](https://www.apachefriends.org/pt_br/index.html) instalado e rodando (Apache + MySQL).
 - Java JDK instalado.
 - NetBeans IDE.
 - [Driver JDBC](https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.4.0/) para MySQL.
 - [Dotenv-java](https://repo1.maven.org/maven2/io/github/cdimascio/dotenv-java/3.0.0/) se quiser usar um `.env` para armazenar as credenciais de conexão. (Opcional)

 ## Configuração do Banco de Dados
 1. Faça o download do XAMPP.
 2. Inicie o XAMPP e ative **Apache** e **MySQL**.
 3. Acesse o **phpMyAdmin**.
 4. Copie e cole código encontrado no arquivo `.sql` do repositório.

 ## Configurando a Conexão
 Se optou por usar `.env`:
 Crie um arquivo .env colocando-o na **pasta raiz** do projeto, e insira o as linhas:
<pre lang="markdown">
DB_URL=jdbc:mysql://localhost:3306/nome-do-banco-de-dados
DB_USER=root
DB_PASSWORD=
</pre>

Se não usar `.env`, edite a classe `MySQLConnection`:
<pre lang="java">
package jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MySQLConnection {
        
    private static final String URL = "jdbc:mysql://localhost/sistema%20automotiva";
    private static final String USER = "root";
    private static final String SENHA = ""; // por padrão a senha é vazia no XAMPP
    
    // faz a conexão com o banco de dados MySQL
    public  Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, SENHA);            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o Banco de Dados! " + e.getMessage());
            return null;
        }
    }
    
}
</pre>

**ATENÇÃO**  
-- Projeto em andamento.  
-- README ainda sendo atualizado conforme updates.
