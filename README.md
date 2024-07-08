# Crud - APIContatos
Criação de CRUD para com 2 objetos criados em tabela sendo pessoa e contato.

Uma pessoa pode ter multiplos contatos, mas um contato pode estar apenas vinculados a uma pessoa. 

Há também um DTO que exibe apenas o nome + contatos somados em apenas uma string e separados por hífens. 

## Configurações:
O banco de dados foi criado utilizando h2 então para configura-lo basta apenas pegar o código "jdbc" e inseri-lo em JDBC URL [este link](localhost:8081/h2-console/) exemplo de código jdbc:'jdbc:h2:mem:f5b1a8e3-4325-48e3-b621-6a2119ea1030'

Para acessar o OpenAPI (swagger) basta apenas acessar [este link](localhost:8081/swagger-ui/index.html).

OBS: Quando for feita a utilização do swagger, ao trocar de pessoa para contato é recomendavel atualizar a página para que o Swagger entregue o Example Value/Request Body corretamente.


