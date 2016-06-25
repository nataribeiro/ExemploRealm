package br.com.natanaelribeiro.www.exemplorealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import io.realm.Realm;

public class AddTaskActivity extends AppCompatActivity {
    private Task task;
    private EditText editNome;
    private EditText editDescricao;
    private EditText editLocal;
    private EditText editTermino;
    private CheckBox checkBoxIniciada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editNome = (EditText)findViewById(R.id.editNome);
        editDescricao = (EditText)findViewById(R.id.editDescricao);
        editLocal = (EditText)findViewById(R.id.editLocal);
        editTermino = (EditText)findViewById(R.id.editTermino);
        checkBoxIniciada = (CheckBox)findViewById(R.id.checkBoxIniciada);
    }

    public void onClickAddTask(View v){
        task = new Task();
        task.nome = editNome.getText().toString();
        task.descricao = editDescricao.getText().toString();
        task.local = editLocal.getText().toString();
        task.termino = System.currentTimeMillis();
        task.iniciada = checkBoxIniciada.isChecked();


        ((CoreApplication)getApplication()).realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                bgRealm.copyToRealmOrUpdate(task);
            }
        }, new Realm.Transaction.OnSuccess() {
            public void onSuccess() {
                finish();
            }
        }, new Realm.Transaction.OnError() {
            public void onError(Throwable error) {}
        });

    }
}
