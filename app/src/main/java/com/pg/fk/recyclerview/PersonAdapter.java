package com.pg.fk.recyclerview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;
    ItemClick activity;

    public interface ItemClick{
        void onItemClicked(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list){
        people = list;
        activity = (ItemClick) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivPref;
        TextView tvName, tvSurname;

        public ViewHolder(final View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);
            ivPref = itemView.findViewById(R.id.ivPref);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(people.indexOf((Person) v.getTag()));
                }
            });

        }
    }

    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonAdapter.ViewHolder viewHolder, int position) {

        viewHolder.itemView.setTag(people.get(position));
        viewHolder.tvName.setText(people.get(position).getName());
        viewHolder.tvSurname.setText(people.get(position).getSurname());

        if(people.get(position).getPreference().equals("bus")){
            viewHolder.ivPref.setImageResource(R.drawable.bus);
        }else{
            viewHolder.ivPref.setImageResource(R.drawable.plane);
        }

    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
