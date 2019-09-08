### Questionamento

* __Q2__. Reconstrua o sistema da questão anterior e faça as devidas mudanças para utilizar gRPC de forma assíncrona e ao final descreva a diferença entre as duas tecnologias para produzir o mesmo resultado.


##### Resposta

O RPC é baseado em C e, como tal, possui uma semântica de programação estruturada, ele é procedural; por outro lado, o RMI é uma tecnologia baseada em Java e é orientada a objetos. O RMI usa um paradigma orientado a objetos, no qual o usuário precisa conhecer o objeto e o método do objeto que precisa invocar. O RPC não lida com objetos. Em vez disso, ele chama sub-rotinas específicas que já estão estabelecidas (métodos). Com o RPC, é possível receber uma chamada de procedimento que se parece muito com uma chamada local. RPC manipula as complexidades envolvidas com a passagem da chamada do local para o computador remoto. O RMI faz a mesma coisa, mas o RMI passa uma referência ao objeto e ao método que está sendo chamado. 

A utilização de um RPC facilita o desenvolvimento de sistemas distribuídos pois permite a utilização de semânticas bem claras e diretas, o que torna fácil transferir o gasto computacional para os servidores, ou até mesmo possibilitando a utilização de procedimentos que não poderiam funcionar localmente. 

Utilizando gRPC é possível promover a comunicação poliglota (processos se comunicando em diferentes linguagens de programação) caso o domínio da aplicação envolva mais de um idioma em comum. Coisa não possível utilizando RMI. Como em muitos sistemas RPC, o gRPC baseia-se na idéia de definir um serviço, especificando os métodos que podem ser chamados remotamente com seus parâmetros e tipos de retorno. No lado do servidor, o servidor implementa essa interface e executa um servidor gRPC para manipular chamadas de clientes. No lado do cliente, o cliente possui um stub (referido como apenas um cliente em alguns idiomas) que fornece os mesmos métodos que o servidor. Os clientes e servidores gRPC podem executar e conversar entre si em diversos ambientes - desde servidores dentro do Google até sua própria área de trabalho - e podem ser escritos em qualquer um dos idiomas suportados pela gRPC. Por padrão, o gRPC usa buffers de protocolo, o mecanismo de código aberto maduro do Google para serializar dados estruturados (embora possa ser usado com outros formatos de dados, como JSON). 

Utilizando RMI o programador pode usar todo o poder expressivo da programação orientada a objetos no desenvolvimento de software de sistemas distribuídos, incluindo o uso de
objetos, classes e herança, e também pode empregar metodologias de projeto orientado a objetos relacionadas e ferramentas associadas. Complementando o conceito de identidade de objeto dos sistemas orientados a objetos, em um sistema baseado em RMI, todos os objetos têm referências exclusivas (sejam locais ou remotos) e tais referências também podem ser passadas como parâmetros, oferecendo, assim, uma semântica de passagem de parâmetros significativamente mais rica do que na RPC.

Porem o gRPC tem mais alto desempenho em se tratando de velocidade em relação ao RMI.

Na solução passada (com RMI) se é utilizado a tecnica de polling para recuperar resltados das mensagens, entre os dois primeiros nós (clienteApp e sender) tem-se uma comunicação nao bloqueante, porem, entre receiver e server temos uma comunicação bloqueante. Ultizando gRPC conseguimos deixar com facilidade a comunicação em ambos os casos assyncrona.
Por se assyncrono, nao eh bloqueante e as mensagens nao preciam esperar resposta de outras para serrem enviadas.

Na forma síncrona de comunicação, os processos origem e destino são sincronizados a cada mensagem. Nesse caso, receiver e server são operações que causam bloqueio. Quando um envio (receiver) é feito, o processo origem (ou thread) é bloqueado até que a recepção (server) correspondente seja realizada. Quando uma recepção é executada, o processo (ou thread) é bloqueado enquanto a mensagem não chegar.

Na forma assíncrona de comunicação, o uso da operação send é não bloqueante, no sentido de que o processo origem pode prosseguir assim que a mensagem tenha sido
copiada para um buffer local, e a transmissão da mensagem ocorre em paralelo com o
processo origem. A operação receive pode ter variantes com e sem bloqueio. Na variante
não bloqueante, o processo destino prossegue sua execução após ter realizado a operação
receive, a qual fornece um buffer para ser preenchido em background. Nesse caso, o pro-
cesso deve receber separadamente uma notificação de que seu buffer possui dados a serem
lidos.

Falta falar como ocorre a recuperação ia polling e como o gRPC resolve issso
GRP avho qu eh com pub/sub

