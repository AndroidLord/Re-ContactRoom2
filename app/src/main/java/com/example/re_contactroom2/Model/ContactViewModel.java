package com.example.re_contactroom2.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.re_contactroom2.Data.ContactRepository;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {

    private static ContactRepository repository;

    private final LiveData<List<Contact>> allContact;

    public ContactViewModel(@NonNull Application application){
     super(application);

        repository = new ContactRepository(application);
        allContact = repository.getAllContact();
    }

    public LiveData<List<Contact>> getAllContact(){return allContact;}

    public static void insert(Contact contact){
        repository.insert(contact);
    }
}
