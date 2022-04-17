package com.example.databaseclassimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import data.MyDbHandler;
import model.Contact;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDbHandler myDbHandler=new MyDbHandler(MainActivity.this);

        /*
        //Adding a contact to the database
        Contact vishal=new Contact("Vishal Patil","7410760563");
        myDbHandler.onAdd(vishal);
        Log.d("Check","Contact inserted succesfully for "+vishal.getName());

        //adding 2nd contact
        Contact namrata=new Contact("Namrata Badge","8080376413");
        myDbHandler.onAdd(namrata);
        Log.d("Check","Contact inserted succesfully for "+namrata.getName());

        //adding 3rd contact
        Contact eren=new Contact("Eren Yeager","1234567890");
        myDbHandler.onAdd(eren);
        Log.d("Check","Contact inserted succesfully for "+eren.getName());


        //fetching the data from database
        List<Contact> contactList=myDbHandler.getAllContacts();
        for(Contact contact:contactList)
        {
            Log.d("Contacts :",contact.getName());
        }

        //updating the row
        namrata.setName("Namu");
        namrata.setPhoneNumber("1234567790");
        namrata.setID(2);
        int affectedRows=myDbHandler.updateContact(namrata);
        Log.d("Updating Values","Number of rows affected are : "+affectedRows);

        //Fetching data
        displayRecords();
        //updating using simple method
        List<Contact> contactList=myDbHandler.getAllContacts();
        Contact namrataTemp=null;
        for(Contact contact:contactList)
        {
            String tempData=contact.getName();
            Log.d("searching function",tempData);
            String link="Namu";
            if(tempData.equals(link))
            {
                Log.d("Found it ","namu object located");
                namrataTemp=contact;
                break;
            }
        }
        Log.d("Calling","succefully instantiated");
        myDbHandler.updateContact_SimpleMethod(namrataTemp);

*/
        //Records before delete
//        displayRecords();
//        List<Contact> contactList=myDbHandler.getAllContacts();
//        Contact vishalTemp=null;
//        for(Contact contact:contactList)
//        {
//            String tempData=contact.getName();
//            Log.d("searching function",tempData);
//            String link="Vishal Patil";
//            if(tempData.equals(link))
//            {
//                Log.d("Found it ","namu object located");
//                vishalTemp=contact;
//                break;
//            }
//        }
//        myDbHandler.deleteContact(vishalTemp);
//        //after delete dispalying
//        displayRecords();
        ArrayList<String>contacts=new ArrayList<>();
        List<Contact> contactList=myDbHandler.getAllContacts();
        for(Contact contact:contactList)
        {
            contacts.add(contact.getName()+" "+contact.getPhoneNumber());
        }
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,contacts);
        listView=findViewById(R.id.listview);
        listView.setAdapter(arrayAdapter);
}

    public void displayRecords()
    {
        MyDbHandler myDbHandler=new MyDbHandler(MainActivity.this);
        List<Contact> contactList=myDbHandler.getAllContacts();
        for(Contact contact:contactList)
        {
            Log.d("Contacts :",contact.getName());
        }
    }
}