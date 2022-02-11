package com.example.re_contactroom2.Util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.re_contactroom2.Data.ContactDao;
import com.example.re_contactroom2.Model.Contact;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
@Database(entities = {Contact.class}, version =1,exportSchema = false)
public abstract class Contact_RoomDatabase<No_of_Threads> extends RoomDatabase {


    private static Contact_RoomDatabase INSTANCE;
    public static final int No_of_Threads = 4;

    public abstract ContactDao contactDao();

    public static final Executor databaseWriteExceutor = Executors.newFixedThreadPool(No_of_Threads);

    public static Contact_RoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Contact_RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Contact_RoomDatabase.class, "contact_Database")
                            .addCallback(sRoomDataBaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static final RoomDatabase.Callback sRoomDataBaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);

                    databaseWriteExceutor.execute(() -> {

                        ContactDao contactDao = INSTANCE.contactDao();
                        contactDao.deleteAll();

                        Contact contact = new Contact("shubham", "android Developer");
                        contactDao.insert(contact);

                        Contact contact1 = new Contact("Yash", " web Developer");
                        contactDao.insert(contact1);

                    });

                }

            };


}
