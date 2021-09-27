package au.edu.jcu.cp3406.cp3405_blanko;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    AccountDatabaseHelper accountDatabaseHelper;

    public EditText firstName, lastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        Button signInButton = findViewById(R.id.signIn);
        Button createAccountButton = findViewById(R.id.createAccount);

        accountDatabaseHelper = new AccountDatabaseHelper(this);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstNameText = firstName.getText().toString();
                String lastNameText = lastName.getText().toString();
                boolean userExists = accountDatabaseHelper.checkUserAccounts(firstNameText,lastNameText);
                if (userExists) {
                    Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                    startActivity(intent);
                }
                else {
                    popupMessage();
                }
            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }

    private void popupMessage() {
        Toast.makeText(this, "User doesn't exist. Please create an account.", Toast.LENGTH_SHORT).show();
    }
}