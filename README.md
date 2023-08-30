# boh :rice_cracker:
**requerimentos**: Docker, Makefile(Opcional) e Java/Maven

#### Como?

    # Makefile:
    $ make run

#### O que?
> CRUD da classe Fornecedor com hibernate e H2  
> e uma **API**zinha com `jakartaee-web-api`

  

#### Endpoints :city_sunset: :
#### Listar Fornecedores:

    Método: GET
    Método Java: findAll()
    URL: http://localhost:8080/boh/fornecedores

#### Obter um Fornecedor por ID:

    Método: GET
    Método Java: findOneById(@PathParam("id") Long id)
    URL: http://localhost:8080/boh/fornecedores/{id}

#### Criar um Fornecedor:

    Método: POST
    Método Java: create(Fornecedor fornecedor)
    URL: http://localhost:8080/boh/fornecedores

#### Atualizar um Fornecedor:

    Método: PUT
    Método Java: update(@PathParam("id") Long id, Fornecedor fornecedor)
    URL: http://localhost:8080/boh/fornecedores/{id}

#### Excluir um Fornecedor:

    Método: DELETE
    Método Java: delete(@PathParam("id") Long id)
    URL: http://localhost:8080/boh/fornecedores/{id}

