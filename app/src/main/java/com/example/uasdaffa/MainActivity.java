package com.example.uasdaffa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button event, merch, member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button event = (Button) findViewById(R.id.event);
        event.setOnClickListener(this);
        Button merch = (Button) findViewById(R.id.merch);
        merch.setOnClickListener(this);
        Button member = (Button) findViewById(R.id.member);
        member.setOnClickListener(this);
        Button oprek = (Button) findViewById(R.id.oprek);
        oprek.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.event:
                startActivity(new Intent(this, Event.class));
                break;
            case R.id.merch:
                startActivity(new Intent(this, Mercha.class));
                break;
            case R.id.member:
                startActivity(new Intent(this, Member.class));
                break;
            case R.id.oprek:
                startActivity(new Intent(this, Oprek.class));
                break;
        }
    }
}
