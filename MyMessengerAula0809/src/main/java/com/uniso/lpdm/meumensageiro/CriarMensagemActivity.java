package com.uniso.lpdm.meumensageiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.uniso.lpdm.meumensageiro.R;

public class CriarMensagemActivity extends AppCompatActivity {

    /*Toda atividade implementa esse método/função. É aqui que onfiguramos qual o layout que essa
    * atividade está relacionada. As demais informações veremos com mais detalhe no decorrer do curso*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Com esse comendo informamos o android qual o layout associado a essa atividade*/
        setContentView(R.layout.activity_criar_mensagem);
    }

    /* Criamos o método/função que será executado qundo o usuário clicar no botão do layout.
    *  Precisamos dizer que ele é publico (public), ou seja, pode ser chamado por qualquer elemento
    * do nosso projeto. Ele também não pode ter retorno algum (void).
    *
    * O nome pode ser o que quisermos segundo as regras padrão (não começar com numero, não ter
    * caractere especial, etc) mas o ideal é que seja descritivo do que o método/função faz,
    * para facilitar a leitura do código.
    *
    * Em java utilizamos para nomear métodos/funções o padrão camelCase, que consiste em: a primeira
    * palavra que for compor o nome começa com letra minuscula, as demais palavras terão a inicial
    * maiuscula
    *
    * A última parte que precisamos colocar para que o android saiba que isso é uma ação que será
    * executada quando um evento no layout ocorrer é o parametro. Lembremos que quem vai chamar
    * esse método, ou, chamar essa função, é o próprio android. Ou seja, em algum momento na execução
    * da nossa aplicação o android runtime vai executar algo equivalente com:    *
    *
    *   CriarMensagemActivity criarMensagemActivity = new CriarMensagemActivity();
    *   criarMensagemActivity.onEnviarMensagem(view);
    *
    * Como é algo automatizado dentro do android, ele está preparado para sempre passar um parametro
    * contendo o elemento visual que disparou a ação. Lembrem-se, todos os elementos visuais possuem
    * também uma classe associada, uma forma de moniupularmos e interagirmos no código. Por isso
    * precisamos fazer com que nossa
    *
    * */

    //Primeira versão - comunicação com outra atividade dentro da aplicação - Inteção Explicita
    public void onEnviarMensagemPrimeiraVersao(View view){
        // Log.d (existem outras opções alem do d) podemos usar para enviar mensagem para o console
        // de execução.
        Log.d("view","Classe daquilo que está sendo passado " + view.getClass());

        /*Precisamos recupaerar o EditText para conseguirmos recuperar a mensagem digitada
        * pelo usuário*/
        EditText viewMensagem = (EditText) findViewById(R.id.txtMensagemEnviada);
        String textoMensagem = viewMensagem.getText().toString();
        /*Criamos a intenção. Intenções são as formas como nos comunicamos com outras atividades,
        * dentro e fora da nossa aplicação. Nos informamos na intenção quem está criando a intenção
        * e para qual atividade ela será enviada. Assim quando a intenção chegar na outra atividade
        * ela sabe quem foi que enviou para ela a intenção.
        *
        * A intenção funciona como uma carta, ou um pacote. Nela colocamos todas as informações
        * que precisamos que a outra atividade processe. Porém, enviamos esse pacote para o android.
        * Ele vai ler os dois parametros que enviamos e vai saber qual a outra atividade que
        * vai ter que processar aquela mensagem. Nós nunca nos comunicamos diretamente com outras
        * atividades, sempre temos o android como intermediário, por isso precisamos das intenções
        * para ele saber exatemente como tratar a informação que estamos enviando*/
        Intent intent = new Intent(this, ReceberMensagemActivity.class);
        /*Para passarmos informações entre atividades, precisamos colocar informações na própria
        * intenção. Para isso usamos o método/função da intenção chamado putExtra*/
        intent.putExtra(ReceberMensagemActivity.MENSAGEM_EXTRA, textoMensagem);
        /*Aqui usamos o comando para iniciar a outra intenção. Mas na verdade, é aqui que informamos
        * o android que queremos nos comunicar com outra atividade, por isso enviamos nossa intenção
        * como parametro, assim ele saberá para onde enviar nossas informações*/
        startActivity(intent);
    }

    /*Segunda versão - se comunicando com intenções fora da aplicação - intenção implicita
    *
    * Nessa segunda versão queremos que o usuário escolha uma aplicação pela qual a mensagem digitada
    * será enviada. Por exemplo, ele digita mensagem e depois enviamos a mensagem para o aplicativo
    * de email ou o whatasap, que efetivamente enviará a mensagem. Não temos como saber se o usuário
    * irá ter essas aplicações em seu equipamento. Então não temos como criar uma intenção que
    * inicialize as atividades nessas aplicações. Nem savemos os nomes de classes e outras informações
    * para fazer essa comunicação direta. O que fazemos é criar uma intenção onde informamos o tipo
    * de ação que esperamos que a outra atividade possua para poder tratar nossa informação.
    * O android então abre uma tela para o usuário escolher, dentre as aplicações com atividades
    * que tratam aquele tipo de ação, e então ele seleciona qual utilizar
    *
    * Em nosso exemplo utilizaremos a ação ACTION_SEND, mas existem outras, que estão na documentação
    * do android, e podem ser encontradas na parte que fala sobre intenções (a classe Intent).
    * Segue a URL: https://developer.android.com/reference/android/content/Intent.html
    *
    * OBS: acessado em 05/09/2020*/
    public void onEnviarMensagemSegundaVersao(View view){
        // Log.d (existem outras opções alem do d) podemos usar para enviar mensagem para o console
        // de execução.
        Log.d("view","Classe daquilo que está sendo passado " + view.getClass());

        /*Precisamos recupaerar o EditText para conseguirmos recuperar a mensagem digitada
         * pelo usuário*/
        EditText viewMensagem = (EditText) findViewById(R.id.txtMensagemEnviada);
        String textoMensagem = viewMensagem.getText().toString();
        /*Aqui informamos apenas na intenção qual a ação que a atividade que será iniciada deverá
        * ser capaz de tratar, para que o android possa analisar as aplicações instaladas e abrir
        * para o usuário a listagem com os aplicativos possíveis*/
        Intent intent = new Intent(Intent.ACTION_SEND);
        /*Além de informarmos o tipo de ação que a atividade de destino deve ser capaz de tratar,
        * também é necessário que ela seja capaz de tratar o tipo de dado que estamos enviando.
        * Então adicionamos essa informação na intenção. O tipo de dado que enviamos é texto puro.*/
        intent.setType("text/plain");
        /*Para passarmos informações utilizando intenções implicitas, precisamos saber os nomes
        * das chaves que as aplicações que tratam a ação ACTION_SEND estarão esperando. Essa informação
        * pode ser achada também na documentação. A classe intent contém essas constantes, similiarmente
        * ao que fizemos na nossa própria atividade na primeira versão. O atributo que vamos utilizar
        * é o EXTRA_TEXT. Existem outros, poderiamos usar o Intent.EXTRA_SUBJECT, que teria um texto
        * para armazenar o assunto da mensagem. Nem todos so aplicativos que tratam o ACION_SEND
        * tratam todos os tipos de extras. Por exemplo, se enviarmos o assunto para o app de email
        * ele saberá o que fazer com a informação, mas o whatasap não. Se enviarmos para o whatasap
        * não teremos um erro, os extras enviados que a atividade/aplicação não souber tratar são
        * simplesmente ignorados*/
        intent.putExtra(Intent.EXTRA_TEXT, textoMensagem);
        /*Aqui usamos o comando para iniciar a outra intenção. Mas na verdade, é aqui que informamos
         * o android que queremos nos comunicar com outra atividade, por isso enviamos nossa intenção
         * como parametro, assim ele saberá para onde enviar nossas informações*/
        startActivity(intent);
    }
}