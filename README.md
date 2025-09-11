# 🧱 Java-Block-Drop

Um mini-game de turnos, baseado na lógica do jogo de blocos Tetris, que está sendo desenvolvido em linguagem Java para ser executado diretamente no terminal.
O padrão de aarquitetura é o MVC, tendo como parte gráfica o próprio terminal, as regras de negócio pertencentes aos modelos (peça, tabuleiro, posições do tabuleiro, gerador de peças) e um controlador para interpretar as entradas do usuário.

## Tecnologias Utilizadas

- **Linguagem**: Java (com maven)
- **Arquitetura**: MVC (Model-View-Controller)
- **Ambiente**: Execução via linha de comando (CLI)

## COMO ESTÁ O PROJETO?

Possui as seguintes finalidades:

- Geração do tabuleiro no terminal.
- Criação de peças aleatórias no topo do tabuleiro.
- Menu inicial para o jogador decidir começar.
- Menu de instrução de comandos.
- Mofimentação de peças para esquerda, direita e para baixo.

Pendências:
- Lógica de rotação da peça (sentido horário e anti-horário).
- Limpeza de linhas completas e sistema de pontuação.

-> confira em: [Relatório de Alterações do Projeto (CHANGELOG)](https://github.com/gabriellatcc/Java-Block-Drop/blob/main/CHANGELOG.md)
## DESCOBERTAS:

Fazendo teste de mesa percebi que há um cálculo para rotacionar mais complexo que o de mover peças e é nele em que pretendo trabalhar, além de revisar e remover anotações do código. :D

### MEU OBJETIVO!!

A finalidade aqui é treinar programação lendo a documentação para entender a manipulação de dados desta linguagem, seja uma String, um objeto, classe ou pilar da linguagem Java. Fugindo primordialmente do uso de IA e aderindo ler blogs de desenvolvedores que relatam e artigos que explicam a utlização de estruturas ou comandos específicos em seus projetos (como em: [Stack Overflow](https://stackoverflow.com/questions),
[W3Schools](https://www.w3schools.com/java/default.asp) ou
[Baeldung](https://www.baeldung.com/java-generating-random-numbers-in-range)).
