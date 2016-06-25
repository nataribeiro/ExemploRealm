package br.com.natanaelribeiro.www.exemplorealm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by 631610277 on 25/06/16.
 */
public class CoreApplication extends Application {

    public Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfig);
        realm = Realm.getDefaultInstance();
    }
}