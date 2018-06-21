package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int numberOfQuestionsCorrect = 0;

        //correct answers
    final int q1ans = R.id.c1;
    final String q3ans = "india";
    final int q4ans = R.id.c4;


        //checking correct answers
    private boolean checkQuestion1() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg1);

        if( rg.getCheckedRadioButtonId() == q1ans ) {
            return true;
        }

        return false;
    }

    private boolean checkQuestion4() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg4);

        if( rg.getCheckedRadioButtonId() == q4ans ) {
            return true;
        }

        return false;
    }

    private boolean checkQuestion3() {
        EditText et = (EditText)findViewById(R.id.edittext);

        return et.getText().toString().equalsIgnoreCase(q3ans);
    }

    private boolean checkQuestion2() {
        CheckBox c1 = (CheckBox) findViewById(R.id.a2);
        CheckBox c2 = (CheckBox) findViewById(R.id.b2);
        CheckBox c3 = (CheckBox) findViewById(R.id.c2);
        CheckBox c4 = (CheckBox) findViewById(R.id.d2);

        if (c1.isChecked() && c2.isChecked() && !c3.isChecked() && c4.isChecked()) {
            return true;
        }

        return false;
    }

    private boolean checkQuestion5() {
        CheckBox c1 = (CheckBox) findViewById(R.id.a5);
        CheckBox c2 = (CheckBox) findViewById(R.id.b5);
        CheckBox c3 = (CheckBox) findViewById(R.id.c5);
        CheckBox c4 = (CheckBox) findViewById(R.id.d5);

        if (c1.isChecked() && !c2.isChecked() && !c3.isChecked() && c4.isChecked()) {
            return true;
        }

        return false;
    }

        //checking total correct / incorrect
        public void checkQuiz(View v) {
            ArrayList<String> incorrectAnswersList = new ArrayList<String>();

            int numberOfQuestionsCorrect = 0;

            if (checkQuestion1()) {
                numberOfQuestionsCorrect++;
            } else {
                incorrectAnswersList.add("Question 1");
            }

            if (checkQuestion2()) {
                numberOfQuestionsCorrect++;
            } else {
                incorrectAnswersList.add("Question 2");
            }

            if (checkQuestion3()) {
                numberOfQuestionsCorrect++;
            } else {
                incorrectAnswersList.add("Question 3");
            }

            if (checkQuestion4()) {
                numberOfQuestionsCorrect++;
            } else {
                incorrectAnswersList.add("Question 4");
            }

            if (checkQuestion5()) {
                numberOfQuestionsCorrect++;
            } else {
                incorrectAnswersList.add("Question 5");
            }

            StringBuilder sb = new StringBuilder();
            for (String s : incorrectAnswersList)
            {
                sb.append(s);
                sb.append("\n");
            }

            Context context = getApplicationContext();
            CharSequence text = "You got " + numberOfQuestionsCorrect + "/5 answers right.\n\nRecheck the following:\n" + sb.toString();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
}
