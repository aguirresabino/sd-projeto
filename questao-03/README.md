# Questão 3
---

Analise o código da última questão (2) e avalie o que problemas podem ocorrer e quais soluções podem ser adotadas para resolver o problema e que implicações podem levar esta solução.

- o servidor cai durante o processamento de uma mensagem
- o cliente cai antes de receber uma resposta
- adotar a técnica de recuperação de mensagem push notification ao invés de pulling

### Resposta

Na segunda questão, o sistema foi reconstruído utilizando gRPC com chamadas assíncronas, de forma que, o nó que envia uma requisição não fica bloqueado aguardando uma resposta, assim como o nó que recebe uma requisição também não fica bloqueado enquanto processa a mensagem.

Em um cenário ideal, com todos os nós em execução, o sistema irá funcionar normalmente. No entanto, a partir do momento em que um dos nós forem desligados, seja enquanto estava realizando algum processamento de uma requisição ou no instante em que uma mensagem é disparada para ele, esta informação será perdida e o sistema não conseguirá recupera-lá.

Dessa forma, e tendo como requisito o uso da técnica push/notification, uma possível solução é apresentada na figura abaixo:

![Imgur](https://i.imgur.com/tNUhCO3.png)

Na arquitetura, foram adicionadas bases de dados em cada nós, para garantir a entrega da mensagem mesmo após o desligamento de um deles. Outro novo componente da arquitetura, é o Push Server, adicionado para implementar a técnica de push/notification.

Em um sistema de push/notification, um cliente realiza o seu registro no servidor de push, que irá gerar o seu ID ou token. Este identificador será utilizado pelo servidor de push para que ele consiga definir a quem enviará uma notificação e/ou mensagem gerada por um servidor publicador. 

Nesta solução, toda comunicação existente entre os nós é feita no formato requisição-resposta assíncrona, além disso, cada mensagem enviada e recebida por um nó será persistida para que seja implementada a garantia de entrega.

Para entender o funcionamento desta arquitetura, veja o que podem ser pontos críticos:

 - __O servidor cai antes de receber uma requisição enviada pelo cliente__

 Ao enviar uma mensagem para o próximo nó, essa também é persistida no nó remetente, no qual é definida uma rotina para verificar se existe alguma requisição que ainda não recebeu confirmação de resposta e caso exista, o cliente enviará novamente esta requisição para o servidor. Isto irá garantir que, caso o servidor seja desligado antes de receber a requisição, ela não será perdida e em outro momento, quando o servidor estiver em execução, o mesmo receberá a requisição para ser processada. 
 
 Assim que a requisição for recebida no destinatário, ele enviará uma resposta ao remetente confirmando o recebimento e este irá atualizar o status da requisição, pois ela não precisa ser enviada novamente.

  - __O servidor cai após receber uma requisição, mas não consegue enviar a confirmação__
  
Assim como a requisição, a resposta retornada por cada nó da arquitetura será persistida. E da mesma forma, também será definida uma rotina para verificar se existem respostas de confirmação que não foram entregues. Neste caso, o cliente como não recebeu a confirmação, ficará tentando enviar a requisição novamente e isto poderá gerar repetições  no servidor. Dessa forma, ele precisará negar requisições já recebidas, verificando sua base de dados.

- __O cliente envia uma requisição, o servidor receber e envia a confirmação, mas o cliente cai antes de receber__

Neste cenário, o servidro já enviou a resposta, logo ele não executará nenhuma rotina sobre a mesma para enviá-la novamente. No entanto, como o cliente não recebeu a confirmação, o mesmo irá enviar novas requisições com a mesma mensagem, neste momento, o servidor deve verificar se existe alguma resposta para esta requisição e enviá-la.