package com.uniso.lpdm.meumensageiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.uniso.lpdm.meumensageiro.R;

public class ReceberMensagemActivity extends AppCompatActivity {

    /*Para informar a chave que iremos esperar quando uma outra atividade enviar uma mensagem
    * para a atividade ReceberMensagemActivity utilizaremos uma constante, assim se precisarmos
    * mudar futuramente o nome da chave, precisamos mudar apenas em um lugar*/
    public static final String MENSAGEM_EXTRA = "mensagem";

    /*Quando essa atividade for iniciada e apresentada na tela queremos que o usuário já veja a
    * mensagem enviada pela outra atividade. Então iremos fazer esse processamento no método/função
    * onCreate. Esse método/função sempre é executado quando a atividade é criada pelo android, mas
    * antes do android exibir o layout. Isso está associado ao ciclo de vida das atividades e veremos
    * mais a frente*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Os comandos que estão em todas atividades*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receber_mensagem);
        /*Precisamos recuperar a intenção enviada pelo android*/
        Intent intent = getIntent();
        /*Recuperamos a mensagem enviada como extra dentro da própria intenção. Como é uma string
        * precisamos utilizar o método/função apropriado. Para cada tipo de dado básico temos uma
        * função*/
        String textoMensagem = intent.getStringExtra(MENSAGEM_EXTRA);
        /*Recueperamos o TextView para poder alterar seu conteúdo. Com tudo isso feito, o método
        * onCreate termina e o android exibe o layout já com o texto*/
        TextView viewMensagem = (TextView) findViewById(R.id.txtMensagemRecebida);
        viewMensagem.setText(textoMensagem);
    }
}