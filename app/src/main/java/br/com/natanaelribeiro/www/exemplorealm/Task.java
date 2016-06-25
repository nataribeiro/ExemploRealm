package br.com.natanaelribeiro.www.exemplorealm;

import android.text.format.DateFormat;
import java.util.Calendar;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by 631610277 on 25/06/16.
 */
public class Task extends RealmObject {
    @PrimaryKey
    public String nome;
    public String descricao;
    public long termino;
    public String local;
    public boolean iniciada;

    @Override
    public String toString() {

        String dateString = DateFormat.format("dd/MM/yyyy", new Date(termino)).toString();

        return "Nome: " + nome + "\nDescrição: " + descricao + "\nTérmino: " +
                dateString;
    }
}

