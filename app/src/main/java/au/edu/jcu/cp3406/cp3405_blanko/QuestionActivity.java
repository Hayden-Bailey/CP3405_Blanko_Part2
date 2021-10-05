package au.edu.jcu.cp3406.cp3405_blanko;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    private TextView userName, questionDisplay;
    private String firstName, lastName;
    private AccountDatabaseHelper accountDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            firstName = extras.getString("firstName");
            lastName = extras.getString("lastName");
        }

        accountDatabaseHelper = new AccountDatabaseHelper(this);

        userName = findViewById(R.id.userName);
        questionDisplay = findViewById(R.id.questionDisplay);

        String fullName = firstName + " " + lastName;
        userName.setText(fullName);

        questionDisplay.setText(accountDatabaseHelper.getQuestion(firstName, lastName));

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Respond to the action bar's Up/Home button
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}