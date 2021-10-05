package au.edu.jcu.cp3406.cp3405_blanko;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {

    private Button addAccountButton;
    private EditText firstNameInput, lastNameInput, questionInput, answerInput;
    private AccountDatabaseHelper accountDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        addAccountButton = findViewById(R.id.addAccountButton);
        firstNameInput = findViewById(R.id.firstNameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        questionInput = findViewById(R.id.questionInput);
        answerInput = findViewById(R.id.answerInput);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        addAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = "", lastName = "", question = "", answer = "";

                firstName = firstNameInput.getText().toString();
                lastName = lastNameInput.getText().toString();
                question = questionInput.getText().toString();
                answer = answerInput.getText().toString();

                if (firstName.isEmpty() || lastName.isEmpty() || question.isEmpty() || answer.isEmpty()) {
                    popupMessage();
                } else {
                    accountDatabaseHelper.addUserAccount(firstName, lastName, question, answer);
                    Log.i("tag", "Account Added");
                }
            }
        });
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

    private void popupMessage() {
        Toast.makeText(this, "Please fill out all fields.", Toast.LENGTH_SHORT).show();
    }


}