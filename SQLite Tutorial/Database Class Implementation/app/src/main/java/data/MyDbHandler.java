package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import model.Contact;
import param.Params;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context)
    {
        super(context, Params.DB_NAME,null,Params.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create="CREATE TABLE "+Params.TABLE_NAME+"("+Params.KEY_ID+" INTEGER PRIMARY KEY,"+Params.KEY_NAME+" TEXT,"+Params.KEY_PHONE+" TEXT"+")";
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void onAdd(Contact contact)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Params.KEY_NAME,contact.getName());
        contentValues.put(Params.KEY_PHONE,contact.getPhoneNumber());

        db.insert(Params.TABLE_NAME,null,contentValues);
        db.close();
    }

    public List<Contact> getAllContacts(){
        List<Contact> contactList=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();

        //Generate a query to fetch data from databse.
        String query="Select * from "+Params.TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do {
                Contact contact=new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        return contactList;
    }
    public int updateContact(Contact contact)
    {
        SQLiteDatabase db=getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Params.KEY_NAME,contact.getName());
        values.put(Params.KEY_PHONE,contact.getPhoneNumber());

        //Lets update the table
        return db.update(Params.TABLE_NAME,values,Params.KEY_ID+"=?",new String[]{String.valueOf(contact.getID())});
    }
    public void updateContact_SimpleMethod(Contact contact)
    {
        if(contact!=null) {
            SQLiteDatabase db = getWritableDatabase();
            Log.d("Creation","object got created");
            String query = "update "+Params.TABLE_NAME+" set name= \"PikachuNamrata\" where id=" + contact.getID();
            db.execSQL(query);
            Log.d("Execution","String got executed");
            db.close();
        }
        else
        {
            Log.d("Contact Erro","Contact object is null");
        }
    }
    public void deleteContact(Contact contact)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.delete(Params.TABLE_NAME,Params.KEY_ID+"=?",new String[]{String.valueOf(contact.getID())});
        db.close();
    }
}
