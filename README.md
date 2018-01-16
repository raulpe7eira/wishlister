# Wishlister (vlab for [http://jaya.tech//](http://jaya.tech/))

Um pequeno projeto para testar minhas habilidades.

![frontend-scshot](../master/scshot/frontend-scshot.png)

## Desafio

> ...
>
> Construir uma aplicação para ver os últimos locais visitados pelos amigos do usuário logado no [Foursquare](https://developer.foursquare.com/) e permitir que o usuário adicione ou remova estes locais em sua lista de desejos.
>
> - [X] Efetuar o login na aplicação com a [autenticação](https://developer.foursquare.com/docs/api/configuration/authentication) do [Foursquare](https://developer.foursquare.com/).
> - [X] Informar na página principal os [dados](https://developer.foursquare.com/docs/api/users/details) do usuário logado.
> - [ ] Informar na página principal a [lista de desejos](https://developer.foursquare.com/docs/api/users/details) do usuário logado.
> - [X] Informar na página principal os [últimos locais visitados](https://developer.foursquare.com/docs/api/checkins/recent) pelos amigos do usuário logado.
> - [ ] Permitir que o usuário logado adicione os locais visitados em sua lista de desejos.
> - [ ] Permitir que o usuário logado remova os locais cadastrados na lista de desejos.
> - [X] Desenvolver a aplicação usando [Kotlin](kotlinlang.org), [Java](https://java.com/) ou [Grails](https://grails.org/).
>
> ...

## Instalação

### Pré-requisitos

Ter instalado localmente (apenas p/ Desenvolvimento e Teste):
- [Git](https://git-scm.com/)
- [Java](https://java.com/)
- [Gradle](https://gradle.org/)

### Instalando dependências

```bash
$ git clone git@github.com:raulpe7eira/wishlister.git
$ cd wishlister
```

## Subir & Rodar

### Ambiente de desenvolvimento

```bash
$ gradlew bootRun
```
![dsv-scshot](../master/scshot/dsv-scshot.png)

### Ambiente de teste

`Nenhum teste foi escrito para esta aplicação` :disappointed_relieved:

### Ambiente de produção

`A aplicação não esta madura suficiente para estar em produção` :disappointed_relieved:

## Considerações

### Plataforma

**[Kotlin](kotlinlang.org)**: Das 3 opções essa era a que não tinha afinidade alguma, justamente por isso escolhi para fazer do desafio um momento de aprendizado, avaliação até o momento é super satisfatória, certamente passará a fazer parte dos meus planos futuros.
 
**[Spring Boot](https://projects.spring.io/spring-boot/)**: Maneira mais prática e rápida para subir uma aplicação web em java atualmente, como teria apenas o final de semana para desenvolver a aplicação esta foi a escolha mais acertada, além de já possuir a integração necessária com [Kotlin](kotlinlang.org).
 
**[Thymeleaf](http://thymeleaf.org)**: Para não ter um projeto backend e outro frontend com linguagens distintas, procurei uma engina de criação de templates e esbarrei nessa que oferecia o suficiente para o desafio em questão.

**[Retrofit](http://square.github.io/retrofit/)**: Foi o cliente HTTP escolhido para consumir os endpoints fornecidos pelo [Foursquare](https://developer.foursquare.com/).

### Serviço

**[Foursquare](https://developer.foursquare.com/)**: Já era requisito da aplicação, foi necessário criar o ID de autorização de acesso da aplicação, notei que para usar a conta gratuita não seria possível cogitar um teste de carga no futuro devido ao númuero pequeno de requisições diárias.

### Testes

`Como informado anteriormente nenhum teste foi efetuado, o foco foi aprender a linguagem, sua sintaxe e funcionamento, sem deixar de apresentar o máximo de codificação possível para a equipe que irá analisar o código possa ter uma boa base de crítica` :disappointed_relieved:

## Conclusão

Foi bem desafiador aprender uma nova linguagem e desenvolver um teste em apenas 3 dias (sábado, domingo e segunda). Inicialmente perdi bastante tempo tentando utilizar o [Spring Social](https://projects.spring.io/spring-social/) com um provider desenvolvido pela comunidade, apesar de tentar configurar o ambiente para utilizá-lo, acabei desistindo de utilizá-lo e efetuar todo processo de login manualmente.

Após toda essa demora para efetuar a autenticação, o restante até que fluiu bem, só não finalizei todos os itens almejados pelo desafio pela falta de tempo mesmo, fica como débito técnico, configurar a autenticação para usar o [Spring Social](https://projects.spring.io/spring-social/), conforme foi inicialmente almejado, configurar a aplicação para usar [Spring Security](https://projects.spring.io/spring-security/), efetuar a cobertura de todos os serviços com testes, retirar toda parte de frontend do backend e usar [React](https://reactjs.org/) ou [Vue.js](https://vuejs.org/) nessa camada.

Espero que tenham gostando, pois meu desejo é fazer parte desse time e somar!

**AVANTE!** :muscle:
