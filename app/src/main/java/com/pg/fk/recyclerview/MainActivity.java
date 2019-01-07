package com.pg.fk.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClick{

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Button btnAdd;

    private ArrayList<Person> people;

    PersonAdapter.ItemClick activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        //mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //mLayoutManager = new GridLayoutManager(this,2, GridLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);


        people = new ArrayList<>();
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Edward", "Norton", "plane"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Edward", "Norton", "plane"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Edward", "Norton", "plane"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("John", "Rambo", "bus"));
        people.add(new Person("Edward", "Norton", "plane"));
        people.add(new Person("Chuck", "Norris", "bus"));
        people.add(new Person("Tom", "Cruise", "plane"));
        people.add(new Person("John", "Rambo", "bus"));

        mAdapter = new PersonAdapter(this , people);

        mRecyclerView.setAdapter(mAdapter);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("Susan", "Peters", "plane"));
                mAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Surname " + people.get(index).getSurname(), Toast.LENGTH_SHORT).show();
    }
}
