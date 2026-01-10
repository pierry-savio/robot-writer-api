
# ‍🤖 ROBOT WRITER

## 🔎 O que é o Robot?

A classe java.awt.Robot é usada para pegar o **controle do mouse e do teclado.** Uma vez que você obtém o controle, você pode fazer qualquer tipo de operação relacionada com o mouse e com o teclado através de seu código java.

Ou seja, com a classe Robot você consegue criar aplicações em Java que podem literalmente **realizar ações** com seu **teclado** e **mouse**.

_Interessante, não?_

Esta classe é usada geralmente para a automatização de testes.

---


## 🔨 Funções da classe

Quando o assunto é manipular o mouse, a classe é excelente: você consegue mover o mouse por toda a tela, quase que de forma instantânea, clicar e rolar a tela tranquilamente. Por exemplo, a função mouseMove(x, y) que recebe uma posição x e y como argumento e move o mouse para as coordenadas passadas:

    mouseMove(x, y);

Porém, não pode-se dizer o mesmo para o teclado: a classe disponibiliza funções para manusear o teclado, como a função keyPress(keycode), que recebe um keycode (um código único que representa cada tecla) como argumento e pressiona a tecla especificada:

    keyPress(keycode);

E a função keyRelease(keycode), que solta a tecla especificada:

    keyRelease(keycode);

O código para pressionar e soltar a tecla A, por exemplo, seria:

    keyPress(KeyEvent.VK_A);
    keyRelease(KeyEvent.VK_A);

- Neste exemplo, o KeyEvent retorna um int com o keycode da tecla A.

---

## ❗ A problemática

O real problema aparece quando é preciso digitar frases ou até mesmo textos. Pelo fato de a classe não possuir um método "WriteString()" que digite uma variável String e só ser possível digitar uma tecla de cada vez, esse seria o código para digitar a frase "Hello World":

    try{

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);

        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);
        robot.keyPress(KeyEvent.VK_R);
        robot.keyRelease(KeyEvent.VK_R);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);

    } catch (Exception e){
        System.out.println(e.getMessage());
    }

Grande, repetitivo e nada prático. Além de ter que digitar letra por letra, ainda é preciso dar um "release" após cada uma para soltá-las, o que dobra o tamanho do código. Para textos muito grandes, ou quando o texto é um input do usuário esta abordagem se torna inviável.

E é aí que a **Robot Writer API** aparece.

---

## ✅ A Solução

Utilizando a Robot Writer API é possível obter-se o mesmo resultado com muito menos esforço e muita elegância. Compare o código antigo de escrita da frase "Hello World" com a solução utilizando a API:

    StringWriter sw = new StringWriter();
    sw.write("Hello World");

_E pronto! Simples, não?_

Uma função simples, mas capaz de transformar **extensas linhas de código** em **apenas uma**.

---



## ⚙ Como usar

Há certos sites ou programas que impossibilitam o usuário de colar (o famoso CTRL + C e CTRL + V) textos. Com a Robot Writer isso é possível.

Para começar a utilizar, aqui está tudo que você precisa:
- JDK (Java Development Kit)
- CMD (Ou um prompt de comando de sua preferência)
- robot-writer.jar (download disponível na pasta releases deste projeto)

---

## 👣 Passo a passo

1. Baixe o arquivo `robot-writer.jar` da pasta `releases` deste projeto.
2. Abra o seu prompt de comando e digite o código a seguir com o diretório do arquivo baixado anteriormente em seguida (você pode simplesmente arrastar e soltar o arquivo que o diretório será colocado automaticamente):
        
        java -jar [diretório\do\arquivo.jar]
3. Pressione enter.

- Agora basta preencher os campos de input pedidos pelo programa no terminal que tudo funcionará corretamente.

---
## ⚠ Importante

_Por enquanto a API está operando apenas no layout padrão utilizado no Brasil, que segue as normas impostas pela Associação Brasileira de Normas Técnicas (ABNT). Dessa forma, a aplicação funcionará corretamente para o padrão ABNT 2, podendo apresentar erros em outros tipos de layouts._

---
## 🧩 Casos de Uso

Há diversas possibilidades de uso para a API, mas dentre elas destacam-se estas três:

1. Automatizar preenchimento de formulários
2. Inserir texto em programas/sites que bloqueiam CTRL+V
3. Testes automatizados simples

---

## ✉ Licença

Esse projeto está sob a Licença MIT. Veja [LICENÇA](https://choosealicense.com/licenses/mit/) para mais informações.
