# Relatório de Alterações do Projeto

Todas as mudanças notáveis neste projeto serão documentadas neste arquivo.
O formato é baseado em [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).

---
## [0.6.1] - 2025-09-13

### Added
- Lógica para rotação horária e anti-horaria da peça L.
- Pré plementação de método estrutura rotação de peças que utilizam a interface IPoliVariacao.
- Pré estrutura para marcação de pontos da partida cada vez que uma linha é eliminada.
- A cada linha eliminada, as peças a cima dela se deslocam 1 para baixo ou até encostarem na base

### Changed
- Possibidade de passar o turno para que a peça não precise se movimentar e desloque para baixo.

<img width="300" height="350" alt="image" src="https://github.com/user-attachments/assets/b392b1ca-d9fb-4ac6-89e9-9654d32ad9e9" />
<img width="290" height="350" alt="image" src="https://github.com/user-attachments/assets/74d0919d-371f-4af8-9f17-14b95288e1f0" />

---
## [0.6.0] - 2025-09-11

### Added
- Lógica para rotação das peças que utilizam a interface IDuplaVariacao (peças S, Z, I)

---
## [0.5.0] - 2025-09-11

### Added
- Lógica para deslocamento automatico para baixo a cada turno
- Lógica para movimentar para esquerda e direita as peças
(funcionando a base de limpeza das casas em que a peça estava alocada e definição das novas casas se não ocupadas)
![Demonstração](https://github.com/user-attachments/assets/59585fc0-476e-4bac-b4ba-469eefa9c7de)

---

## [0.4.11] - 2025-09-10

### Changed
- Correção do nome de subclasses para refletir suas identidades
- Realocação das interfaces para uma pasta separada dos modelos

---
## [0.4.1] - 2025-09-10

### Changed
- Lógica de herança e interface para diferentes peças (isso se fez necessário porque todas as peças tem caracteristicas e metodos padrões, ao mesmo tempo que possuem capacidades diferentes)

### Removed
- Utilização da classe APecaMultivariavel que serviria como subclasse e seria um galho de acesso de metodos e atributos para demais peças

---
## [0.4.0] - 2025-09-08

### Added
- Lógica de Heranca para criação de peças.
- Polimorfismo para realizar movimentos de peças diferentes.
- Documentação das classes e métodos para melhor entendimento.

### Changed
- Organização lógica da criação de peças.
- Posições do tabuleiro que são reconhecidas como casas que contém um valor para coordenada.

### Removed
- Classe geradora de peças.
- Classe responsável pelas coordenadas do tabuleiro.

---
## [0.3.1] - 2025-08-31

### Changed
- Mudança na lógica de leitura de dados com `if-else` para `swich case` para legibilidade e eficiência.
- Substituição da regra de armazenamento de jogadas com a interface `Map` para uma lista simples que suporta objetos do tipo Jogada.

### Removed
- interface `Map` para armazenamento de movimentos e quantidade de vezes em uma jogada.

---
## [0.3.0] - 2025-08-31

### Added
- Leitura de comandos do jogador 
- Lógica para o dado que entra como String e é armazenada em um array para ser averiguado.
<img width="204" height="224" alt="image" src="https://github.com/user-attachments/assets/176b53a8-70d7-412f-a0d3-6bf4cc5750b5" />

---

## [0.2.0] - 2025-08-27

### Added
- Suporte para códigos de sequência ANSI para renderização de cores no tabuleiro.
- Módulo de gerenciamento de paleta de cores para peças e posições.

### Changed
- Refatorado o método de renderização do tabuleiro para incorporar a lógica de cores.
<img width="390" height="230" alt="image" src="https://github.com/user-attachments/assets/b975eb8a-5bd6-4387-8c1a-296884c9fdd3" />

---

## [0.1.1] - 2025-08-20

### Changed
- Simplificação da criação de peças para utilizar menos linhas e passar 100% da tarefa para outra classe que recebe as posições.

---

## [0.1.0] - 2025-08-19

### Added
- Estrutura inicial do tabuleiro de jogo e de objetos.
- Instruções para o jogador.

<img width="390" height="300" alt="Screenshot 2025-08-14 223319" src="https://github.com/user-attachments/assets/9a974028-7abb-4fb2-8f2f-de3cdb249270" />

