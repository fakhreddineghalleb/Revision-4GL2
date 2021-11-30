package tn.esprit.revision4glcs.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import tn.esprit.revision4glcs.models.Voiture;

@Dao
public interface VoitureDao {

    @Insert
    void insert(Voiture v);

    @Delete
    void delete(Voiture v);

    @Query("SELECT * FROM voiture")
    List<Voiture> getAll();
}
