package br.com.senaijandira.marcadordetruco;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        TextView txtPontuacao;

        // A Variavel VM é ViewModel
        PontuacaoViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //Instancia ViewModel
        vm = ViewModelProviders.of(this).get(PontuacaoViewModel.class);


        txtPontuacao = findViewById(R.id.txtPontuacao);

        if (vm.pontuacao.getValue() == null)
            vm.pontuacao.setValue(0);

        vm.pontuacao.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer valor) {
                //Update UI
                txtPontuacao.setText(valor.toString());
            }
        });

    }

    public void Adicionar1(View view) {

        vm.pontuacao.setValue(vm.pontuacao.getValue() +1);




    }

    public void Adicionar3(View view) {


        vm.pontuacao.setValue(vm.pontuacao.getValue() +3);

    }

    public void Adicionar6(View view) {

        vm.pontuacao.setValue(vm.pontuacao.getValue() +6);


    }

    public void Adicionar9(View view) {
        vm.pontuacao.setValue(vm.pontuacao.getValue() +9);
    }

    public void Adicionar12(View view) {
        vm.pontuacao.setValue(vm.pontuacao.getValue() +12);
    }
}
