CREATE DATABASE  IF NOT EXISTS `sistema automotivo`;
USE `sistema automotivo`;

DROP TABLE IF EXISTS `cargos`;
CREATE TABLE `cargos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `salario` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

LOCK TABLES `cargos` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `cpf` varchar(14) NOT NULL,
  `telefone` varchar(16) NOT NULL,
  `cep` varchar(9) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `numero` smallint(6) unsigned DEFAULT NULL,
  `complemento` varchar(17) DEFAULT NULL,
  `bairro` varchar(20) DEFAULT NULL,
  `cidade` varchar(25) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

LOCK TABLES `clientes` WRITE;
INSERT INTO `clientes` VALUES (1,'alles gut','1990-12-12','allesgut@yahoo.com.br','654.646.654-65','(47) 9 9558-1447','69852-211','rua dos alfinetes',3000,'casa 04','crimlho','sabatina','ES'),(4,'Jão Lima','2005-05-05','jaolima@hotmail.com','696.014.725-66','(47) 9 8896-5566','85274-247','Rua getulio vargas',111,'casa','guanabara','florianopolis','SC'),(5,'Arthur Zannetti','2001-11-11','arthurzan@gmail.com','124.555.555-55','(12) 9 6744-7744','12885-588','Rua dos imigrantes',122,'casa','Boemia','Recife','PE'),(6,'Mateus Boas Dores','1985-06-30','mboasdores@hotmail.com','222.222.222-22','(99) 9 6588-5690','69885-101','Rua dos colonos',2,'casa','boqueirao','Curitiba','PR'),(9,'jonata gamoes rodrigues','2002-12-22','jonatagr@','232.323.232-32','(22) 2 2222-2333','22222-233','rua da vitoria',2,'casa','Madureira','Rio de Janeiro','RJ'),(10,'Felipe Farias','2000-10-10','fefa@yahoo.com.br','352.114.205-55','(59) 9 9585-2112','80555-154','rua padre kolb',209,'apartamento 101','cubatao','sao paulo','SP');
UNLOCK TABLES;

DROP TABLE IF EXISTS `faturamento`;
CREATE TABLE `faturamento` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_os` int(10) unsigned NOT NULL,
  `data` date NOT NULL,
  `valor_servico` decimal(8,2) NOT NULL,
  `valor_pecas` decimal(8,2) NOT NULL,
  `valor_liquido` decimal(9,2) GENERATED ALWAYS AS (`valor_servico` + `valor_pecas`) STORED,
  PRIMARY KEY (`id`),
  KEY `id_os` (`id_os`),
  CONSTRAINT `faturamento_ibfk_1` FOREIGN KEY (`id_os`) REFERENCES `ordem_de_servico` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

LOCK TABLES `faturamento` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `fornecedores`;
CREATE TABLE `fornecedores` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `cnpj` varchar(18) NOT NULL,
  `telefone` varchar(16) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `numero` smallint(5) unsigned NOT NULL,
  `complemento` varchar(25) DEFAULT NULL,
  `bairro` varchar(20) NOT NULL,
  `cidade` varchar(25) NOT NULL,
  `estado` varchar(19) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `cnpj` (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

LOCK TABLES `fornecedores` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `funcionarios`;
CREATE TABLE `funcionarios` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_cargo` int(11) unsigned NOT NULL,
  `nome` varchar(50) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `cpf` varchar(14) NOT NULL,
  `telefone` varchar(16) NOT NULL,
  `cep` varchar(9) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `numero` smallint(5) unsigned DEFAULT NULL,
  `complemento` varchar(17) DEFAULT NULL,
  `bairro` varchar(20) DEFAULT NULL,
  `cidade` varchar(25) DEFAULT NULL,
  `estado` varchar(19) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  `nivel_acesso` enum('Administrador','Comum') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `email` (`email`),
  KEY `funcionarios_ibfk_1` (`id_cargo`),
  CONSTRAINT `funcionarios_ibfk_1` FOREIGN KEY (`id_cargo`) REFERENCES `cargos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

LOCK TABLES `funcionarios` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `ordem_de_servico`;
CREATE TABLE `ordem_de_servico` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_cliente` int(10) unsigned NOT NULL,
  `id_funcionario` int(10) unsigned NOT NULL,
  `data_abertura` date NOT NULL,
  `data_concluido` date DEFAULT NULL,
  `descricao` text DEFAULT NULL,
  `status` enum('Concluída','Pendente') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_funcionario` (`id_funcionario`),
  CONSTRAINT `ordem_de_servico_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`),
  CONSTRAINT `ordem_de_servico_ibfk_2` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

LOCK TABLES `ordem_de_servico` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `pecas`;
CREATE TABLE `pecas` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_fornecedor` int(10) unsigned NOT NULL,
  `nome` varchar(30) NOT NULL,
  `descricao` text DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valor_unidade_fornecedor` decimal(8,2) DEFAULT NULL,
  `valor_unidade_cliente` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_fornecedor` (`id_fornecedor`),
  CONSTRAINT `pecas_ibfk_1` FOREIGN KEY (`id_fornecedor`) REFERENCES `fornecedores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

LOCK TABLES `pecas` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `pecas_os`;
CREATE TABLE `pecas_os` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_peca` int(10) unsigned NOT NULL,
  `id_os` int(10) unsigned NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_os` (`id_os`),
  KEY `id_peca` (`id_peca`),
  CONSTRAINT `pecas_os_ibfk_2` FOREIGN KEY (`id_os`) REFERENCES `ordem_de_servico` (`id`),
  CONSTRAINT `pecas_os_ibfk_3` FOREIGN KEY (`id_peca`) REFERENCES `pecas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

LOCK TABLES `pecas_os` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `pecas_pedidos`;
CREATE TABLE `pecas_pedidos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_peca` int(10) unsigned NOT NULL,
  `id_pedido` int(10) unsigned NOT NULL,
  `quantidade` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pedido` (`id_pedido`),
  KEY `id_peca` (`id_peca`),
  CONSTRAINT `pecas_pedidos_ibfk_2` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id`),
  CONSTRAINT `pecas_pedidos_ibfk_3` FOREIGN KEY (`id_peca`) REFERENCES `pecas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

LOCK TABLES `pecas_pedidos` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE `pedidos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_fornecedor` int(10) unsigned NOT NULL,
  `data` date DEFAULT NULL,
  `valor_total` decimal(9,2) DEFAULT NULL,
  `status` enum('Concluído','Pendente') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_fornecedor` (`id_fornecedor`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`id_fornecedor`) REFERENCES `fornecedores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

LOCK TABLES `pedidos` WRITE;
UNLOCK TABLES;