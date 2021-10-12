package au.edu.jcu.cp3406.cp3405_blanko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import au.edu.jcu.cp3406.cp3405_blanko.apps.CalendarActivity;
import au.edu.jcu.cp3406.cp3405_blanko.apps.ContactsActivity;
import au.edu.jcu.cp3406.cp3405_blanko.apps.MessagesActivity;
import au.edu.jcu.cp3406.cp3405_blanko.apps.EmailActivity;
import au.edu.jcu.cp3406.cp3405_blanko.apps.CallActivity;
import au.edu.jcu.cp3406.cp3405_blanko.apps.EventsActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        findViewById(R.id.Calendar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.Contacts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, ContactsActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.Messages).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MessagesActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.Email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, EmailActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.Call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, CallActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.Events).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, EventsActivity.class);
                startActivity(intent);
            }
        });
    }
}