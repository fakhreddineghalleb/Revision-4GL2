package tn.esprit.revision4glcs.utils;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import tn.esprit.revision4glcs.dao.VoitureDao;
import tn.esprit.revision4glcs.models.Voiture;

@Database(entities = {Voiture.class} ,version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;

    public abstract VoitureDao voitureDao();

    public static AppDataBase getInstance(Context mContext){

        if (instance == null){
            instance = Room.databaseBuilder(mContext, AppDataBase.class, "4gl2")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

}
