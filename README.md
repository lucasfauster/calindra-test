### Desafio Calindra

Essa é uma aplicação API Rest que contém um endpoint com path `/calindra/distance` e método GET. 
Esse endpoint recebe um valor em JSON no corpo da requisição com o campo `addresses` contendo uma lista de três ou mais endereços.
O endpoint retorna um valor em JSON com o campo `distances` que contém uma matriz `NxN`, onde N é o tamanho da lista de endereços.
Essa matriz contém as distâncias de todos os endereços entre si, onde por exemplo, a distância do endereço 1 ao 2 está armazenado na linha 1 e coluna 2 da matriz.

O campo `closest` contém uma lista de dois endereços que possuem a menor distância dentre as distâncias calculadas entre todos os endereços.

O campo `farthest` contém uma lista de dois endereços que possuem a maior distância dentre as distâncias calculadas entre todos os endereços.

Um exemplo de requisição ao endpoint utilizando a ferramenta `Postman` pode ser encontrado no arquivo `distances.postman_collection.json`.

O framework de API utilizado nesse projeto foi o Spring Boot. O serviço geocoding utilizado no projeto foi o Geoapify. O projeto foi desenvolvido na linguagem Java.
