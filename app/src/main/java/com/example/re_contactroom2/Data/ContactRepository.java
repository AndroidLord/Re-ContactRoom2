package com.example.re_contactroom2.Data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.re_contactroom2.Model.Contact;
import com.example.re_contactroom2.Util.Contact_RoomDatabase;

import java.util.List;

public class ContactRepository {

    private ContactDao contactDao;

    private LiveData<List<Contact>> allContact;

    public ContactRepository(Application application) {

        Contact_RoomDatabase db = Contact_RoomDatabase.getDatabase(application);
        contactDao = db.contactDao();

        allContact = contactDao.getAllContact();
    }
    public LiveData<List<Contact>> getAllContact(){ return allContact;}

    public void insert(Contact contact){
        Contact_RoomDatabase.databaseWriteExceutor.execute(()->{
            contactDao.insert(contact);
        });
    }

}
