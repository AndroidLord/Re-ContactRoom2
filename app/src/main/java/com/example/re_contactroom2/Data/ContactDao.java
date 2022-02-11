package com.example.re_contactroom2.Data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.re_contactroom2.Model.Contact;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    void insert(Contact contact);

    @Query("DELETE FROM Contact_table")
    void deleteAll();

    @Query("SELECT * FROM contact_table ORDER BY NAME ASC")
    LiveData<List<Contact>> getAllContact();

}
