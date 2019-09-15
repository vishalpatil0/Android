package com.example.vishalpatil.bluetooth;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button on,off,visible,list;
    BluetoothAdapter BA;
    ListView lv;
    Set<BluetoothDevice>pairedDevices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BA=BluetoothAdapter.getDefaultAdapter();
        on=(Button)findViewById(R.id.on);
        off=(Button)findViewById(R.id.off);
        visible=(Button)findViewById(R.id.visible);
        list=(Button)findViewById(R.id.list);

        lv=(ListView)findViewById(R.id.lv);

    }
    public void on(View view)
    {
        if(!BA.isEnabled())
        {
            Intent turnon=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnon,0);
            Toast.makeText(getApplicationContext(),"Turned on",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Already on",Toast.LENGTH_SHORT).show();
        }
    }
    public void off(View view)
    {
        BA.disable();
        Toast.makeText(getApplicationContext(),"Turning off",Toast.LENGTH_SHORT).show();
    }
    public void visible(View view)
    {
        Intent visible=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(visible,0);
    }
    public void list(View view)
    {
        pairedDevices=BA.getBondedDevices();
        ArrayList list=new ArrayList();
        for(BluetoothDevice bt: pairedDevices)
        {
            list.add(bt.getName());
        }
        Toast.makeText(getApplicationContext(),"Showing available devices",Toast.LENGTH_SHORT).show();
        final ArrayAdapter adapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,list);
        lv.setAdapter(adapter);
    }
}
