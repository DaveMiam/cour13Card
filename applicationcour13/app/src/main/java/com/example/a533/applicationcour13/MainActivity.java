package com.example.a533.applicationcour13;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final Context context = this;
    List<TODO> todoList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
        
        recyclerView = findViewById(R.id.recyclerView_TODO);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TodoRecycleAdapter(todoList);
        recyclerView.setAdapter(adapter);
    }

    private void setListener(){
        findViewById(R.id.btn_dialog).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.create_dialog);
                Button dialogButtonAdd = dialog.findViewById(R.id.btn_addTODO);

                dialogButtonAdd.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        EditText editTextTittle = dialog.findViewById(R.id.plaintText);
                        EditText editTextDescription = dialog.findViewById(R.id.editText2);
                        TODO todoAdd = new TODO(new Date(),editTextTittle.getText().toString(),editTextDescription.getText().toString());
                        todoList.add(todoAdd);
                        adapter.notifyDataSetChanged();
                        //
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }

        });
    }
}
