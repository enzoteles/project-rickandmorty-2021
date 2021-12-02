# project-rickandmorty-2021

## [MVVM](https://developer.android.com/jetpack/guide?gclid=Cj0KCQiA-qGNBhD3ARIsAO_o7yk-55Xlrz8C0W9wKMYLckOfr6-8ljTX6alFJH0bz7d6UyjcnUBIwJMaAk2UEALw_wcB&gclsrc=aw.ds)
Aqui usamos a arquitetura MVVM

<img width="908" alt="Screen Shot 2021-11-12 at 21 14 13" src="https://user-images.githubusercontent.com/5742609/141597565-fb276346-346a-4a08-a731-bbf9f0db890f.png">

## [Clean Architecture](https://engsoftmoderna.info/artigos/arquitetura-limpa.html)
Arquitetura Limpa (Clean Architecture) é um padrão arquitetural proposto por Robert Martin – mais conhecido como Uncle Bob – com o objetivo de promover a implementação de sistemas que favorecem reusabilidade de código, coesão, independência de tecnologia e testabilidade

<img width="769" alt="Screen Shot 2021-12-02 at 16 48 27" src="https://user-images.githubusercontent.com/5742609/144495433-f441ad8b-de1b-4677-8980-d871d73152c7.png">

## [Navigation](https://developer.android.com/guide/navigation?gclid=CjwKCAiAvriMBhAuEiwA8Cs5lRKFs-Da1EV3vC3g_4wwykqHVqPaMpW3mNWgP4zQFWjVUus3E4M8lxoCWRsQAvD_BwE&gclsrc=aw.ds)
A navegação se refere às interações que permitem aos usuários navegar, entrar e sair de diferentes partes do conteúdo no aplicativo. O componente de navegação do Android Jetpack ajuda você a implementar a navegação, desde simples cliques em botões até padrões mais complexos, como barras de aplicativos e a gaveta de navegação. Esse componente também garante uma experiência do usuário consistente e previsível por meio da adesão a um conjunto de princípios estabelecido.

## [View Binding](https://developer.android.com/topic/libraries/view-binding)
A vinculação de visualizações é um recurso que facilita a programação de códigos que interagem com visualizações. Quando a vinculação de visualizações é ativada em um módulo, ela gera uma classe de vinculação para cada arquivo de layout XML presente nesse módulo. A instância de uma classe de vinculação contém referências diretas a todas as visualizações que têm um código no layout correspondente.
Na maioria dos casos, a vinculação de visualizações substitui findViewById.

## [View Model](https://developer.android.com/topic/libraries/architecture/viewmodel?gclid=CjwKCAiAvriMBhAuEiwA8Cs5lY-JDt6C1uh2Nr4r-1Q65tvKIkZJv8EA7kVkIyE0_UokpQYpw89IchoC4uoQAvD_BwE&gclsrc=aw.ds)
A classe ViewModel foi projetada para armazenar e gerenciar dados relacionados à IU considerando o ciclo de vida. A classe ViewModel permite que os dados sobrevivam às mudanças de configuração, como a rotação da tela.

## [JetPack Compose](https://developer.android.com/jetpack/compose?hl=pt-br)
O Jetpack Compose é um kit de ferramentas moderno do Android para criar IUs nativas. Ele simplifica e acelera o desenvolvimento da IU no Android. Dê vida ao seu app rapidamente com menos código, ferramentas eficientes e APIs Kotlin intuitivas.

## [State and JetPack Compose](https://developer.android.google.cn/jetpack/compose/state?hl=en)
O estado em um app é qualquer valor que pode mudar ao longo do tempo. Essa é uma definição muito ampla e abrange tudo, de um banco de dados da Room até a variável em uma classe.

## [SavedStateHandle](https://developer.android.com/topic/libraries/architecture/viewmodel-savedstate)
Conforme mencionado em Como salvar estados de IU, os objetos ViewModel podem processar mudanças de configuração, então você não precisa se preocupar com o estado em rotações ou outros casos. No entanto, se você precisar lidar com a interrupção do processo iniciada pelo sistema, é recomendável usar onSaveInstanceState() como backup.

## [Corrotinas do Kotlin no Android](https://developer.android.com/kotlin/coroutines?gclid=CjwKCAiAvriMBhAuEiwA8Cs5lQzJ-3Eiv2px-E23Iq12uadkReNe2n_N2OGrnHSjp8wU1sJT4oDzpRoCb_sQAvD_BwE&gclsrc=aw.ds)
Uma corrotina é um padrão de projeto de simultaneidade que você pode usar no Android para simplificar o código que é executado de forma assíncrona. Corrotinas foram adicionadas ao Kotlin na versão 1.3 e são baseadas em conceitos estabelecidos de outras linguagens (link em inglês).
No Android, as corrotinas ajudam a gerenciar tarefas de longa duração que podem bloquear a linha de execução principal e fazer com que seu app pare de responder. Mais de 50% dos desenvolvedores profissionais que usam corrotinas notaram um aumento na produtividade. Este tópico descreve como você pode usar corrotinas do Kotlin para resolver esses problemas, permitindo criar um código de app mais simples e conciso.

## [Retrofit](https://square.github.io/retrofit/)
O retrofit torna nossa HTTP API em interface java

## [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android?hl=pt-br)
O Hilt é uma biblioteca de injeção de dependência para Android que reduz a injeção manual de código de texto clichê no projeto. A injeção de dependências manual exige que você construa todas as classes e dependências manualmente e use contêineres para reutilizar e gerenciar dependências.

## [Paging](https://developer.android.com/topic/libraries/architecture/paging?gclid=CjwKCAiAv_KMBhAzEiwAs-rX1ItQu1qirTI6C6Wnle8xWY8RSDqzjwag1AxaRg-W3mFMbpqr5FxdHxoCQacQAvD_BwE&gclsrc=aw.ds)
A biblioteca Paging ajuda a carregar e exibir pequenos blocos de dados por vez. O carregamento de dados parciais sob demanda reduz o uso da largura de banda da rede e dos recursos do sistema.

## [Unit Test](https://developer.android.com/training/testing/unit-testing/local-unit-tests)
É possível avaliar a lógica do app por meio de testes de unidade locais quando você precisa executar testes com mais rapidez e não requer a fidelidade e a confiança associadas à execução de testes em um dispositivo real.

## [Integration Test](https://developer.android.com/jetpack/compose/testing)
O teste de IUs ou de telas é usado para verificar o comportamento correto do código do Compose, melhorando a qualidade do app ao detectar erros no início do processo de desenvolvimento.



