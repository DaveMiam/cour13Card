package com.example.a533.applicationcour13;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TodoRecycleAdapter extends RecyclerView.Adapter<TodoRecycleAdapter.MyViewHolder>{
    List<TODO> todoList;

    public TodoRecycleAdapter(List<TODO> todoList){
        this.todoList = todoList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titre;
        TextView description;
        TextView date;
        public MyViewHolder(View itemView){
            super(itemView);
            titre= itemView.findViewById(R.id.txt_Title);
            description= itemView.findViewById(R.id.txt_description);
            date= itemView.findViewById(R.id.txt_date);
        }
    }

    @NonNull
    @Override
    public TodoRecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_card,parent, false);
       MyViewHolder vh = new MyViewHolder(v);
       return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TodoRecycleAdapter.MyViewHolder holder, int position) {
TODO todoToDisplay =  todoList.get(position);
        holder.titre.setText(todoToDisplay.getTitle());
        holder.description.setText(todoToDisplay.getDescription());
        holder.date.setText(todoToDisplay.getDateAdded().toString());

    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

}
