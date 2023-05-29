# Projeto Módulo 2
Este é um projeto de exemplo que consiste em um sistema para gerenciar categorias e receitas. O projeto foi desenvolvido utilizando a linguagem de programação Java e o framework Spring Boot.

# Informações do Projeto
* Linguagem de programação: Java (versão 17).
* Framework: Spring Boot (versão 3.0.7).
* Banco de Dados: PostgreSQL.
* Gerenciador de Dependências: Maven.

# Funcionalidades
O projeto possui as seguintes funcionalidades:

* Cadastro de categorias: Permite cadastrar uma nova categoria com nome e descrição.
* Listagem de categorias: Retorna a lista de todas as categorias cadastradas.
* Exclusão de categorias: Permite excluir uma categoria existente, desde que não possua receitas cadastradas.
* Cadastro de receitas: Permite cadastrar uma nova receita, associada a uma categoria. A receita contém nome, ingredientes, preparo e restrições.
* Atualização de receitas: Permite atualizar os dados de uma receita existente.
* Exclusão de receitas: Permite excluir uma receita existente.
* Listagem de receitas por categoria: Retorna a lista de todas as receitas associadas a uma determinada categoria.
* Listagem de receitas com restrições: Retorna a lista de todas as receitas que possuem restrições.
* Listagem de receitas sem restrições: Retorna a lista de todas as receitas que não possuem restrições.

# Estrutura do projeto

O projeto está dividido em pacotes que representam diferentes camadas da aplicação:

* com.senai.projetomodulo2.controller: Contém os controladores responsáveis por receber as requisições HTTP e chamar os serviços correspondentes.
* com.senai.projetomodulo2.model: Contém as classes que representam as entidades do domínio, ou seja, as categorias e receitas.
* com.senai.projetomodulo2.repository: Contém as interfaces que definem os repositórios responsáveis por realizar operações de persistência no banco de dados.
* com.senai.projetomodulo2.service: Contém os serviços responsáveis por implementar a lógica de negócio da aplicação.
* com.senai.projetomodulo2: Contém a classe principal do projeto, responsável por iniciar a aplicação.
Além disso, o projeto utiliza as anotações do framework Spring Boot, como @RestController, @RequestMapping, @Autowired, entre outras, para configurar e facilitar o desenvolvimento das funcionalidades.

# Configuração do banco de dados

O projeto utiliza um banco de dados relacional para armazenar as categorias e receitas. A configuração do banco de dados é realizada no arquivo application.properties ou application.yml, onde é possível definir o tipo de banco de dados, URL de conexão, usuário, senha, entre outras propriedades.

Por padrão, o projeto está configurado para utilizar o banco de dados H2, um banco de dados em memória que não requer instalação. Caso queira utilizar um banco de dados diferente, é necessário ajustar as configurações de acordo com o banco de dados desejado.

# Executando o projeto

1. Clone o repositório: Abra o terminal ou prompt de comando e navegue até o diretório em que você deseja clonar o projeto. Em seguida, execute o comando git clone <URL_DO_REPOSITÓRIO>, substituindo <URL_DO_REPOSITÓRIO> pela URL do repositório Git que contém o código do projeto Spring Boot.

2. Importe o projeto: Após clonar o repositório, você pode importar o projeto em sua IDE de desenvolvimento. As etapas específicas podem variar dependendo da IDE que você está usando.

3. Verifique as dependências: Certifique-se de que você tem as dependências necessárias especificadas no arquivo pom.xml do projeto. O Maven será responsável por baixar as dependências automaticamente com base nas configurações do arquivo pom.xml. Se você estiver usando o IntelliJ IDEA ou outra IDE com suporte ao Maven, as dependências serão baixadas automaticamente.

4. Execute o projeto: Agora você pode executar o projeto Spring Boot. Normalmente, você pode clicar com o botão direito no arquivo principal (geralmente uma classe com a anotação @SpringBootApplication) e selecionar a opção "Run" ou "Run As" na sua IDE. Se você preferir usar o Maven na linha de comando, pode executar o comando mvn spring-boot:run no diretório raiz do projeto.

Após seguir esses passos, o projeto Spring Boot deve ser iniciado e estará disponível para acesso localmente. Você pode acessar o aplicativo por meio da URL http://localhost:8080 (a menos que seja especificada uma porta diferente).

# API REST

A API REST do projeto pode ser utilizada através das seguintes rotas:

## Categorias

* POST /categoria: Cadastrar uma nova categoria.
* GET /categoria: Listar todas as categorias cadastradas.
* DELETE /categoria/{id}: Excluir uma categoria pelo ID.

## Receitas

* POST /receita: Cadastrar uma nova receita.
* PUT /receita/atualizar/{id}: Atualizar os dados de uma receita pelo ID.
* DELETE /receita/{id}: Excluir uma receita pelo ID.
* GET /receita/por-categoria/{categoriaId}: Listar todas as receitas de uma determinada categoria.
* GET /receita/com-restricoes: Listar todas as receitas com restrições.
* GET /receita/sem-restricoes: Listar todas as receitas sem restrições.
