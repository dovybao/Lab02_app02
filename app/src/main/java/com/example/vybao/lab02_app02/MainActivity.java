package com.example.vybao.lab02_app02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtTen;
    TextView txtSelected;
    ListView lv;
    Button btn;
    ArrayList<String>arrList = null;
    ArrayAdapter<String>adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTen = (EditText)findViewById(R.id.txtInputTen);
        txtSelected = (TextView)findViewById(R.id.txtSelected);
        lv = (ListView)findViewById(R.id.lvPerson);

        arrList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrList);
        lv.setAdapter(adapter);
        //Event click btnNhap
        btn = (Button)findViewById(R.id.btnInput);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                arrList.add(txtTen.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });
        //Event click Listview items
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtSelected.setText("position: "+ position+"; value: "+ arrList.get(position));
                arrList.set(position,"do vy bao");
                adapter.notifyDataSetChanged();
            }
        });
        //event long click items
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });


    }
}
