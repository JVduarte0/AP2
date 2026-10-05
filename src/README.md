# AP2 - Estruturas de Dados

## 1. Identificação

**Aluno:** João Vitor Duarte  
**Disciplina:** Estruturas de Dados  
**Trabalho:** AP2 - Pilhas, Filas e Listas Ligadas

---

## 2. Introdução

Este trabalho teve como objetivo colocar em prática os conceitos de estruturas de dados por meio da implementação manual de pilhas, filas e listas ligadas em Java.

A implementação dessas estruturas sem utilizar classes prontas da linguagem permite compreender melhor como os dados são armazenados e organizados, além de demonstrar o funcionamento dos nós e das referências utilizadas para conectar os elementos.

Durante o desenvolvimento foram utilizadas uma lista simplesmente ligada para implementar uma fila e uma pilha de pedidos de uma cafeteria, além de uma lista duplamente ligada para implementar um sistema de gerenciamento de músicas.

---

## 3. Implementação

### 3.1 Sistema da Cafeteria

O primeiro sistema desenvolvido representa o gerenciamento de pedidos de uma cafeteria.

Foram implementadas duas estruturas:

- Fila de pedidos pendentes;
- Pilha de pedidos cancelados.

As duas estruturas foram desenvolvidas manualmente utilizando uma lista simplesmente ligada.

### Estrutura do Pedido

Cada pedido possui:

- ID;
- Descrição.

A classe `Pedido` é responsável por armazenar essas informações.

### Estrutura do Nó

A classe `NoPedido` representa cada elemento da lista simplesmente ligada.

Cada nó possui:

- Um objeto `Pedido`;
- Uma referência para o próximo nó.

Dessa forma, os pedidos ficam conectados uns aos outros.

### Fila de Pedidos

A classe `FilaPedidos` utiliza duas referências principais:

- `inicio`: representa o primeiro pedido da fila;
- `fim`: representa o último pedido da fila.

Os novos pedidos são inseridos no final da fila através do método `enqueue()`.

Quando um pedido é atendido ou cancelado, ele é removido do início através do método `dequeue()`.

Esse funcionamento segue o conceito **FIFO (First In, First Out)**, ou seja, o primeiro pedido inserido é o primeiro a ser removido.

### Pilha de Pedidos Cancelados

A classe `PilhaCancelados` utiliza a referência `topo`, responsável por indicar o último pedido cancelado.

O método `push()` adiciona um novo pedido ao topo da pilha.

O método `pop()` remove o pedido localizado no topo.

Esse funcionamento segue o conceito **LIFO (Last In, First Out)**, ou seja, o último elemento inserido é o primeiro a ser removido.

Quando um pedido é restaurado, ele é retirado da pilha de pedidos cancelados e inserido novamente no final da fila de pedidos pendentes.

---

### 3.2 Gerenciador de Playlist

O segundo sistema desenvolvido representa um gerenciador de músicas utilizando uma lista duplamente ligada.

Cada música possui as seguintes informações:

- Título;
- Artista;
- Álbum;
- Duração em segundos.

### Estrutura do Nó

A classe `NoMusica` possui:

- Um objeto `Musica`;
- Uma referência para o próximo nó;
- Uma referência para o nó anterior.

A existência das duas referências permite navegar pela playlist nos dois sentidos.

Exemplo:

`Música 1 <-> Música 2 <-> Música 3`

A classe `Playlist` mantém três referências principais:

- `inicio`: primeira música da playlist;
- `fim`: última música da playlist;
- `atual`: música selecionada atualmente.

### Inserção de Músicas

O sistema permite adicionar músicas:

- No início da playlist;
- No final da playlist;
- Em uma posição específica.

Durante a inserção, as referências `anterior` e `proximo` são atualizadas para manter corretamente as conexões entre os nós.

### Remoção de Músicas

A remoção pode ser realizada através do título da música.

O programa procura o nó correspondente e atualiza as referências dos elementos vizinhos.

Foram considerados diferentes casos de remoção:

- Lista vazia;
- Único elemento;
- Primeiro elemento;
- Último elemento;
- Elemento localizado no meio da lista.

### Navegação

A referência `atual` indica qual música está selecionada.

A operação de próxima música utiliza a referência `proximo`, enquanto a operação de música anterior utiliza a referência `anterior`.

Isso demonstra uma das principais características de uma lista duplamente ligada: a possibilidade de percorrer os elementos nos dois sentidos.

### Ordenação

A playlist pode ser ordenada por:

- Título;
- Artista.

A ordenação foi implementada manualmente, comparando os dados das músicas e realizando as trocas necessárias.

### Busca

Também foi implementada uma funcionalidade adicional de busca.

O usuário pode procurar uma música utilizando:

- Título;
- Artista;
- Álbum.

O sistema percorre a lista e exibe os elementos que correspondem ao termo informado.

---

## 3.3 Casos Críticos

Durante a implementação foi necessário tratar situações que poderiam causar erros durante a execução.

### Remoção em estrutura vazia

Antes de realizar operações de remoção, o programa verifica se a estrutura está vazia.

Caso não existam elementos, a operação não é realizada e uma mensagem é apresentada ao usuário.

### Atualização do início e do fim

Na fila, quando o último pedido é removido, tanto `inicio` quanto `fim` passam a apontar para `null`.

Na playlist, quando uma música localizada no início ou no final é removida, as referências são atualizadas para manter a lista corretamente conectada.

### Remoção da música atual

Caso a música removida seja a música atualmente selecionada, o sistema altera a referência `atual` para outra música disponível.

### Playlist vazia

As operações de tocar, avançar, voltar, remover e listar verificam se existem músicas antes de realizar a operação.

---

## 4. Evidências de Execução

Nesta seção são apresentadas evidências da execução dos sistemas desenvolvidos.

### 4.1 Cafeteria

Foram adicionados diferentes pedidos para testar o funcionamento da fila de pedidos pendentes.

#### Pedidos Pendentes

A imagem abaixo demonstra os pedidos armazenados na fila e sua ordem de atendimento.

<img width="938" height="952" alt="pedido pendentes" src="https://github.com/user-attachments/assets/af9b4e82-5e57-4644-90b9-03995bbcf115" />



#### Cancelamento de Pedido

A operação de cancelamento remove o pedido mais antigo da fila e adiciona o mesmo ao topo da pilha de pedidos cancelados.

<img width="911" height="968" alt="pedido cancelado" src="https://github.com/user-attachments/assets/7fed7913-899e-4154-b508-35c97bd03756" />


#### Restauração de Pedido

O último pedido cancelado pode ser retirado da pilha e inserido novamente na fila de pedidos pendentes.

<img width="911" height="968" alt="pedido cancelado" src="https://github.com/user-attachments/assets/3eebb00b-dd93-4cbf-8a36-b602e345fb90" />


---

### 4.2 Playlist

Foram adicionadas diferentes músicas para testar o funcionamento da lista duplamente ligada.

#### Listagem das Músicas

A imagem abaixo demonstra as músicas armazenadas na playlist.

<img width="948" height="362" alt="playlist" src="https://github.com/user-attachments/assets/97e3095b-4c8a-49f4-bb29-3c1938027be6" />


#### Próxima Música

A navegação para a próxima música utiliza a referência para o próximo nó da lista.

<img width="948" height="362" alt="playlist" src="https://github.com/user-attachments/assets/bfe58ef6-8197-4980-a0b4-474d74e7a53c" />


#### Música Anterior

Também é possível retornar para a música anterior através da referência para o nó anterior.

<img width="948" height="362" alt="playlist" src="https://github.com/user-attachments/assets/87bff0be-9319-4e9e-9e49-20c70cb8efa2" />


#### Ordenação da Playlist

A playlist também pode ser ordenada de acordo com os critérios disponíveis no sistema.

<img width="947" height="347" alt="ordenado" src="https://github.com/user-attachments/assets/5a3c6acd-80f8-4caa-9a6d-50a623464dee" />


---

## 5. Conclusão

O desenvolvimento deste trabalho permitiu compreender melhor o funcionamento das principais estruturas de dados estudadas na disciplina.

Uma das principais dificuldades foi realizar corretamente a atualização das referências dos nós, principalmente na lista duplamente ligada, pois cada elemento possui uma referência para o próximo e para o anterior. Também foi necessário tratar situações especiais, como estruturas vazias e remoções realizadas no início ou no final das listas.

A implementação manual da fila permitiu compreender na prática o funcionamento do conceito FIFO, enquanto a pilha demonstrou o funcionamento do conceito LIFO.

Já a implementação da playlist possibilitou entender melhor o funcionamento de uma lista duplamente ligada e como as referências permitem navegar pelos elementos nos dois sentidos.

Com isso, o trabalho contribuiu para uma compreensão mais prática sobre organização de dados, manipulação de nós e funcionamento de estruturas encadeadas.
