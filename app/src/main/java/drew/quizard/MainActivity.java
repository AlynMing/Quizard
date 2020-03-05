package drew.quizard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.flashcard_one_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_one_answer_one).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_one_question).setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.flashcard_one_answer_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_one_answer_one).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcard_one_question).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.add_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 1);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && data != null && resultCode == -1) {
            String question = data.getExtras().getString("Question");
            String answer = data.getExtras().getString("Answer");

            ((TextView) findViewById(R.id.flashcard_one_question)).setText(question);
            ((TextView) findViewById(R.id.flashcard_one_answer_one)).setText(answer);

        }
    }
}
