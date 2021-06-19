package com.example.TokoBaju;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rv_history;
    Button Delete;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_kuuf,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent=null;
        switch (item.getItemId()) {
            case R.id.Menu_Home :
                Toast.makeText(getApplicationContext(), "Home!",Toast.LENGTH_SHORT).show();
                intent= new Intent(HomeActivity.this,HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.Menu_Profile :
                Toast.makeText(getApplicationContext(), "Profile!",Toast.LENGTH_SHORT).show();
                intent= new Intent(HomeActivity.this,ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.Menu_LogOut :
                Toast.makeText(getApplicationContext(), "LogOut!",Toast.LENGTH_SHORT).show();
                intent= new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rv_history = findViewById(R.id.rv_transactionhistory);

        String[] Name = {"Baju hitam","Baju merah","Baju putih","Baju hijau"};
        String[] Date = {"6/7/2021","1/2/2021","3/4/2021","8/12/2021"};
        int[]   Price = {100000,200000,80000,130000};

        //Adapter
        TransactionHistoryAdapter Transaction_adapter = new TransactionHistoryAdapter();
        Transaction_adapter.SetData(Name,Date,Price);

        rv_history.setAdapter(Transaction_adapter);
        rv_history.setLayoutManager(new LinearLayoutManager(this));
    }
}