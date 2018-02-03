package com.davidlopes.quizcitycountrymouse;
// 02-02-2018 - 8:59
// TODO LIMPAR o não usado
// TODO fazer com inputs e outputs ?
// todo icone da app
// TODO STRINGS.XML
// TODO view in land

// TODO Resolver problema ao rodar
// VER ESTA FORMA DE CHEKAR AS RADIOBUTTONS
// https://gist.github.com/IbhayiEP/0c329bd8310783da5bd63614eb60a334#file-java
// VARIAS ACTIVITIES... https://github.com/Hany90/TarantinoQuiz
// https://github.com/HassanMihai/ArtHistoryQuiz
//METODOS PARA CHECK--- FUNCOES
//https://github.com/Selver/GradedReaderQuiz/blob/master/app/src/main/java/com/example/android/gradedreaderquiz/QuizActivity.java

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 *
 */
public class MainActivity extends AppCompatActivity {
    private final static int totalQuestions = 10;
    private final static String correctAnswer2 = "cousin";
    private final Context context = this;
    private final static String correctAnswer6 = "people";
    private final static String teacherMail = "algarvi0@gmail.com";

    private int scoreTotal = 0;
    private int totalQueryAnsweredQuestions=0;
    private int totalQueryNotAnsweredQuestions=0;
    private int numSelectedRadionButton = 0; // Number of selected RadionButton
    private int numCheckedCheckBox = 0; // initialize the number of selected check boxes in quiz.
    private int numFieldTextFields = 0; //initialize the number of filled text fields in quiz.
    //RadioGroups
    RadioGroup radioGroupAnswer1;
    RadioGroup radioGroupAnswer3;
    RadioGroup radioGroupAnswer4;
    RadioGroup radioGroupAnswer5;
    RadioGroup radioGroupAnswer7;
    RadioGroup radioGroupAnswer9;
    RadioGroup radioGroupAnswer10;
    // Buttons
    Button submitButton, resetButton;
    String strAnswer1, strAnswer2, strAnswer3, strAnswer4, strAnswer5, strAnswer6, strAnswer7, strAnswer8, strAnswer9, strAnswer10;
    String Answer8a = "", Answer8b = "", Answer8c = "";
    //Booleans
    boolean showMessages; // To use to see control messages.
    //RadioButton
    private RadioButton radioButtonAnswer1a, radioButtonAnswer1b;
    private RadioButton radioButtonAnswer3a, radioButtonAnswer3b, radioButtonAnswer3c;
    private RadioButton radioButtonAnswer4a, radioButtonAnswer4b, radioButtonAnswer4c;
    private RadioButton radioButtonAnswer5a, radioButtonAnswer5b, radioButtonAnswer5c;
    private RadioButton radioButtonAnswer7a, radioButtonAnswer7b, radioButtonAnswer7c;
    private RadioButton radioButtonAnswer9a, radioButtonAnswer9b, radioButtonAnswer9c;
    private RadioButton radioButtonAnswer10a, radioButtonAnswer10b, radioButtonAnswer10c;
    // CheckBoxes
    private CheckBox CheckBox8a, CheckBox8b, CheckBox8c;

    //Edit Text
    private EditText answer2_editText;
    private EditText answer6_editText;
    private EditText insertNameEditText;

    //Strings
    private String answersString; // To store all answers values and use in mail intent.
    private String userName;

    static final String SCORE_ACT_VALUE = "score";

    static final String NUMSELECTEDRADIONBUTTON_VALUE = "numSelectedRadionButton";
    static final String NUMCHECKEDCHECKBOX_VALUE = "numCheckedCheckBox";
    static final String NUMFIELDTEXTFIELDS_VALUE = "numFieldTextFields";

    static final String RADIOBUTTONANSWER1AENABLED_VALUE = "radioButtonAnswer1aEnabled";
    static final String RADIOBUTTONANSWER1BENABLED_VALUE = "radioButtonAnswer1bEnabled";

    static final String RADIOBUTTONANSWER3AENABLED_VALUE = "radioButtonAnswer3aEnabled";
    static final String RADIOBUTTONANSWER3BENABLED_VALUE = "radioButtonAnswer3bEnabled";
    static final String RADIOBUTTONANSWER3CENABLED_VALUE = "radioButtonAnswer3cEnabled";

    static final String RADIOBUTTONANSWER4AENABLED_VALUE = "radioButtonAnswer4aEnabled";
    static final String RADIOBUTTONANSWER4BENABLED_VALUE = "radioButtonAnswer4bEnabled";
    static final String RADIOBUTTONANSWER4CENABLED_VALUE = "radioButtonAnswer4cEnabled";

    static final String RADIOBUTTONANSWER5AENABLED_VALUE = "radioButtonAnswer5aEnabled";
    static final String RADIOBUTTONANSWER5BENABLED_VALUE = "radioButtonAnswer5bEnabled";
    static final String RADIOBUTTONANSWER5CENABLED_VALUE = "radioButtonAnswer5cEnabled";

    static final String RADIOBUTTONANSWER7AENABLED_VALUE = "radioButtonAnswer7aEnabled";
    static final String RADIOBUTTONANSWER7BENABLED_VALUE = "radioButtonAnswer7bEnabled";
    static final String RADIOBUTTONANSWER7CENABLED_VALUE = "radioButtonAnswer7cEnabled";

    static final String CHECKBUTTONANSWER8AENABLED_VALUE = "checkButtonAnswer8aEnabled";
    static final String CHECKBUTTONANSWER8BENABLED_VALUE = "checkButtonAnswer8bEnabled";
    static final String CHECKBUTTONANSWER8CENABLED_VALUE = "checkButtonAnswer8cEnabled";

    static final String RADIOBUTTONANSWER9AENABLED_VALUE = "radioButtonAnswer9aEnabled";
    static final String RADIOBUTTONANSWER9BENABLED_VALUE = "radioButtonAnswer9bEnabled";
    static final String RADIOBUTTONANSWER9CENABLED_VALUE = "radioButtonAnswer9cEnabled";

    static final String RADIOBUTTONANSWER10AENABLED_VALUE = "radioButtonAnswer10aEnabled";
    static final String RADIOBUTTONANSWER10BENABLED_VALUE = "radioButtonAnswer10bEnabled";
    static final String RADIOBUTTONANSWER10CENABLED_VALUE = "radioButtonAnswer10cEnabled";

    static final String STRANSWERQ1_VALUE = "strAnswerQ1";
    static final String STRANSWERQ2_VALUE = "strAnswerQ2";
    static final String STRANSWERQ3_VALUE = "strAnswerQ3";
    static final String STRANSWERQ4_VALUE = "strAnswerQ4";
    static final String STRANSWERQ5_VALUE = "strAnswerQ5";
    static final String STRANSWERQ6_VALUE = "strAnswerQ6";
    static final String STRANSWERQ7_VALUE = "strAnswerQ7";
    static final String STRANSWERQ8_VALUE = "strAnswerQ8";
    static final String STRANSWERQ9_VALUE = "strAnswerQ9";
    static final String STRANSWERQ10_VALUE = "strAnswerQ10";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTotal=0;
        numSelectedRadionButton = 0; // Number of selected RadionButton
        numCheckedCheckBox = 0; // initialize the number of selected check boxes in quiz.
        numFieldTextFields = 0; //initialize the number of filled text fields in quiz.

        insertNameEditText = findViewById(R.id.insert_user_name);
        // RESET ALL BUTTON
        //TODO SET VISIBITY ON AND OFF BUTTONS
        resetButton = findViewById(R.id.button_reset);
        //resetButton.setVisibility(View.GONE); // Button Visible

        //SUBMIT Button
        submitButton = findViewById(R.id.id_button_score);
        submitButton.setActivated(true); // for debug TODO set Invisible after ...

        showMessages = false; //Set to False don't see messages. True see control messages

        // RADIO GROUPS
        radioGroupAnswer1 = findViewById(R.id.id_radio_group_answer1);
        radioGroupAnswer3 = findViewById(R.id.id_radio_group_answer3);
        radioGroupAnswer4 = findViewById(R.id.id_radio_group_answer4);
        radioGroupAnswer5 = findViewById(R.id.id_radio_group_answer5);
        radioGroupAnswer7 = findViewById(R.id.id_radio_group_answer7);
        radioGroupAnswer9 = findViewById(R.id.id_radio_group_answer9);
        radioGroupAnswer10 = findViewById(R.id.id_radio_group_answer10);
        //RADIO BUTTONS
        // 1
        radioButtonAnswer1a = findViewById(R.id.id_radioButton_answer1a);
        radioButtonAnswer1b = findViewById(R.id.id_radioButton_answer1b);
        //2
        answer2_editText = findViewById(R.id.editText_q2);
        strAnswer2 = "";
        //3
        radioButtonAnswer3a = findViewById(R.id.id_radioButton_answer3a);
        radioButtonAnswer3b = findViewById(R.id.id_radioButton_answer3b);
        radioButtonAnswer3c = findViewById(R.id.id_radioButton_answer3c);
        //4
        radioButtonAnswer4a = findViewById(R.id.id_radioButton_answer4a);
        radioButtonAnswer4b = findViewById(R.id.id_radioButton_answer4b);
        radioButtonAnswer4c = findViewById(R.id.id_radioButton_answer4c);
        //5
        radioButtonAnswer5a = findViewById(R.id.id_radioButton_answer5a);
        radioButtonAnswer5b = findViewById(R.id.id_radioButton_answer5b);
        radioButtonAnswer5c = findViewById(R.id.id_radioButton_answer5c);
        //6
        answer6_editText = findViewById(R.id.editText_q6);
        strAnswer6 = "";
        //7
        radioButtonAnswer7a = findViewById(R.id.id_radioButton_answer7a);
        radioButtonAnswer7b = findViewById(R.id.id_radioButton_answer7b);
        radioButtonAnswer7c = findViewById(R.id.id_radioButton_answer7c);
        //8
        CheckBox8a = findViewById(R.id.id_checkBox_answer8a);
        CheckBox8b = findViewById(R.id.id_checkBox_answer8b);
        CheckBox8c = findViewById(R.id.id_checkBox_answer8c);
        //9
        radioButtonAnswer9a = findViewById(R.id.id_radioButton_answer9a);
        radioButtonAnswer9b = findViewById(R.id.id_radioButton_answer9b);
        radioButtonAnswer9c = findViewById(R.id.id_radioButton_answer9c);
        //10
        radioButtonAnswer10a = findViewById(R.id.id_radioButton_answer10a);
        radioButtonAnswer10b = findViewById(R.id.id_radioButton_answer10b);
        radioButtonAnswer10c = findViewById(R.id.id_radioButton_answer10c);
        // Other TEXT's
        // Gets username from insertNameEditText textView
        userName = insertNameEditText.getText().toString();
        // Gets all answers values plus userName and compose the string to use in mail intent.
        answersString = userName + getString(R.string.messsageYouAnswered);
        strAnswer1 = "";
		strAnswer2 = "";
		strAnswer3 = "";
		strAnswer4 = "";
		strAnswer5 = "";
		strAnswer6 = "";
		strAnswer7 = "";
		strAnswer8 = "";
		strAnswer9 = "";
		strAnswer10 = "";

        //viewCounters("AO ABRIR \n","all");

        //  add submit button listener
        submitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                // set title
                // Todo Strings Out to strings.xml
                alertDialogBuilder.setTitle("SCORE THE QUIZ !");
                // set dialog message
                alertDialogBuilder
                        .setMessage("Are you sure you want to score the QUIZ ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked use sendResults method
                                sendResults(MainActivity.this.submitButton);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if NO button is clicked, close the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
            }
        });
        //  add reset button listener
        resetButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                // set title
                alertDialogBuilder.setTitle("RESET QUIZ !");
                // set dialog message
                alertDialogBuilder.setMessage("Are you sure you want to RESET the Quiz ? All ANSWERS will be deleted !");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked call reset quiz to start over
                        resetQuiz(MainActivity.this.resetButton);
                    }
                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close the dialog box and do nothing
                        dialog.cancel();
                    }
                });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save Values into the bundle
       savedInstanceState.putInt(SCORE_ACT_VALUE, scoreTotal);// Save scoreTotal value into the bundle
//        savedInstanceState.putInt(totalQueryAnsweredQuestions_VALUE,totalQueryAnsweredQuestions);
//        savedInstanceState.putInt(totalQueryNotAnsweredQuestions_VALUE,totalQueryNotAnsweredQuestions);
        savedInstanceState.putInt(NUMSELECTEDRADIONBUTTON_VALUE, numSelectedRadionButton);
        savedInstanceState.putInt(NUMCHECKEDCHECKBOX_VALUE, numCheckedCheckBox);
        savedInstanceState.putInt(NUMFIELDTEXTFIELDS_VALUE, numFieldTextFields);

        savedInstanceState.putBoolean(RADIOBUTTONANSWER1AENABLED_VALUE, radioButtonAnswer1a.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER1BENABLED_VALUE, radioButtonAnswer1b.isEnabled());

        savedInstanceState.putBoolean(RADIOBUTTONANSWER3AENABLED_VALUE, radioButtonAnswer3a.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER3BENABLED_VALUE, radioButtonAnswer3b.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER3CENABLED_VALUE, radioButtonAnswer3c.isEnabled());

        savedInstanceState.putBoolean(RADIOBUTTONANSWER4AENABLED_VALUE, radioButtonAnswer4a.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER4BENABLED_VALUE, radioButtonAnswer4b.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER4CENABLED_VALUE, radioButtonAnswer4c.isEnabled());

        savedInstanceState.putBoolean(RADIOBUTTONANSWER5AENABLED_VALUE, radioButtonAnswer5a.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER5BENABLED_VALUE, radioButtonAnswer5b.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER5CENABLED_VALUE, radioButtonAnswer5c.isEnabled());

        savedInstanceState.putBoolean(RADIOBUTTONANSWER7AENABLED_VALUE, radioButtonAnswer7a.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER7BENABLED_VALUE, radioButtonAnswer7b.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER7CENABLED_VALUE, radioButtonAnswer7c.isEnabled());

        savedInstanceState.putBoolean(CHECKBUTTONANSWER8AENABLED_VALUE, CheckBox8a.isEnabled());
        savedInstanceState.putBoolean(CHECKBUTTONANSWER8BENABLED_VALUE, CheckBox8b.isEnabled());
        savedInstanceState.putBoolean(CHECKBUTTONANSWER8CENABLED_VALUE, CheckBox8c.isEnabled());

        savedInstanceState.putBoolean(RADIOBUTTONANSWER9AENABLED_VALUE, radioButtonAnswer9a.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER9BENABLED_VALUE, radioButtonAnswer9b.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER9CENABLED_VALUE, radioButtonAnswer9c.isEnabled());

        savedInstanceState.putBoolean(RADIOBUTTONANSWER10AENABLED_VALUE, radioButtonAnswer10a.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER10BENABLED_VALUE, radioButtonAnswer10b.isEnabled());
        savedInstanceState.putBoolean(RADIOBUTTONANSWER10CENABLED_VALUE, radioButtonAnswer10c.isEnabled());

        savedInstanceState.putString(STRANSWERQ1_VALUE, strAnswer1);
        savedInstanceState.putString(STRANSWERQ2_VALUE, strAnswer2);
        savedInstanceState.putString(STRANSWERQ3_VALUE, strAnswer3);
        savedInstanceState.putString(STRANSWERQ4_VALUE, strAnswer4);
        savedInstanceState.putString(STRANSWERQ5_VALUE, strAnswer5);
        savedInstanceState.putString(STRANSWERQ6_VALUE, strAnswer6);
        savedInstanceState.putString(STRANSWERQ7_VALUE, strAnswer7);
        savedInstanceState.putString(STRANSWERQ8_VALUE, strAnswer8);
        savedInstanceState.putString(STRANSWERQ9_VALUE, strAnswer9);
        savedInstanceState.putString(STRANSWERQ10_VALUE, strAnswer10);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTotal = savedInstanceState.getInt(SCORE_ACT_VALUE);
        numSelectedRadionButton = savedInstanceState.getInt(NUMSELECTEDRADIONBUTTON_VALUE);
        numCheckedCheckBox = savedInstanceState.getInt(NUMCHECKEDCHECKBOX_VALUE);
        numFieldTextFields = savedInstanceState.getInt(NUMFIELDTEXTFIELDS_VALUE);

        radioButtonAnswer1a.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER1AENABLED_VALUE));
        radioButtonAnswer1b.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER1BENABLED_VALUE));

        radioButtonAnswer3a.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER3AENABLED_VALUE));
        radioButtonAnswer3b.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER3BENABLED_VALUE));
        radioButtonAnswer3c.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER3CENABLED_VALUE));

        radioButtonAnswer4a.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER4AENABLED_VALUE));
        radioButtonAnswer4b.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER4BENABLED_VALUE));
        radioButtonAnswer4c.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER4CENABLED_VALUE));

        radioButtonAnswer5a.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER5AENABLED_VALUE));
        radioButtonAnswer5b.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER5BENABLED_VALUE));
        radioButtonAnswer5c.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER5CENABLED_VALUE));

        radioButtonAnswer7a.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER7AENABLED_VALUE));
        radioButtonAnswer7b.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER7BENABLED_VALUE));
        radioButtonAnswer7c.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER7CENABLED_VALUE));

        CheckBox8a.setEnabled(savedInstanceState.getBoolean(CHECKBUTTONANSWER8AENABLED_VALUE));
        CheckBox8b.setEnabled(savedInstanceState.getBoolean(CHECKBUTTONANSWER8BENABLED_VALUE));
        CheckBox8c.setEnabled(savedInstanceState.getBoolean(CHECKBUTTONANSWER8CENABLED_VALUE));

        radioButtonAnswer9a.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER9AENABLED_VALUE));
        radioButtonAnswer9b.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER9BENABLED_VALUE));
        radioButtonAnswer9c.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER9CENABLED_VALUE));

        radioButtonAnswer10a.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER10AENABLED_VALUE));
        radioButtonAnswer10b.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER10BENABLED_VALUE));
        radioButtonAnswer10c.setEnabled(savedInstanceState.getBoolean(RADIOBUTTONANSWER10CENABLED_VALUE));

        strAnswer1 = (savedInstanceState.getString(STRANSWERQ1_VALUE));
        strAnswer2 = (savedInstanceState.getString(STRANSWERQ2_VALUE));
        strAnswer3 = (savedInstanceState.getString(STRANSWERQ3_VALUE));
        strAnswer4 = (savedInstanceState.getString(STRANSWERQ4_VALUE));
        strAnswer5 = (savedInstanceState.getString(STRANSWERQ5_VALUE));
        strAnswer6 = (savedInstanceState.getString(STRANSWERQ6_VALUE));
        strAnswer7 = (savedInstanceState.getString(STRANSWERQ7_VALUE));
        strAnswer8 = (savedInstanceState.getString(STRANSWERQ8_VALUE));
        strAnswer9 = (savedInstanceState.getString(STRANSWERQ9_VALUE));
        strAnswer10 = (savedInstanceState.getString(STRANSWERQ10_VALUE));

    }
    /**
     * Method that checks correct answers for all RadioButton's;
     **/
    public void onRadioButtonClick(View view) {
        boolean radionButton_clicked = ((RadioButton) view).isChecked();
        String radionButton_text = ((RadioButton) view).getText().toString();
        // Checking which radioButton was clicked
        switch (view.getId()) {
            //Question 1
            // Question 1 - a - correct
            case R.id.id_radioButton_answer1a:
                if (radionButton_clicked) {
                    scoreTotal = scoreTotal + 1; // Add 1 to scoreTotal
                    radioButtonAnswer1a.setEnabled(false);
                    radioButtonAnswer1b.setEnabled(false);
                   // If showMessages its ON, show toast message.
                   if (showMessages) {
                       Toast.makeText(this, getString(R.string.question1) + radionButton_text
                               + getString(R.string.right)
                               + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
                    }
                    strAnswer1 = radionButton_text;
                  //  disableRadioGroup(radioGroupAnswer1);
             }
                break;
            // Question 1 - b - incorrect
            case R.id.id_radioButton_answer1b:
                if (radionButton_clicked) {
                    radioButtonAnswer1a.setEnabled(false);
                    radioButtonAnswer1b.setEnabled(false);
                    // If showMessages its ON, show toast message.
                    if (showMessages) {
                        Toast.makeText(this, getString(R.string.question1) + radionButton_text
                                + getString(R.string.wrong)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
                    }
                    strAnswer1 = radionButton_text;
                    //disableRadioGroup(radioGroupAnswer1);
                }
                break;
            // Question 3
            // Question 3 - a - correct - disable.
            case R.id.id_radioButton_answer3a:
                if (radionButton_clicked) {
                    scoreTotal = scoreTotal + 1;
                    radioButtonAnswer3a.setEnabled(false);
                    radioButtonAnswer3b.setEnabled(false);
                    radioButtonAnswer3c.setEnabled(false);
                    // If showMessages its ON, show toast message.
                    if (showMessages) {
                        Toast.makeText(this, getString(R.string.question3) + radionButton_text
                                + getString(R.string.right)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
                    strAnswer3 = radionButton_text;
                   // disableRadioGroup(radioGroupAnswer3);
                }
                break;
            // Question 3 - b and c - its incorrect - disable.
            case R.id.id_radioButton_answer3b:
            case R.id.id_radioButton_answer3c:
                if (radionButton_clicked) {
                    radioButtonAnswer3a.setEnabled(false);
                    radioButtonAnswer3b.setEnabled(false);
                    radioButtonAnswer3c.setEnabled(false);
                    // If showMessages its ON, show toast message.
                    if (showMessages) {
                        Toast.makeText(this, getString(R.string.question3) + radionButton_text
                                + getString(R.string.wrong)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
                    strAnswer3 = radionButton_text;
                   // disableRadioGroup(radioGroupAnswer3);
                }

                break;
            // Question 4
            // Question 4 - b correct - disable.
            case R.id.id_radioButton_answer4b:
                if (radionButton_clicked) {
                    scoreTotal = scoreTotal + 1;
                    radioButtonAnswer4a.setEnabled(false);
                    radioButtonAnswer4b.setEnabled(false);
                    radioButtonAnswer4c.setEnabled(false);
                    // If showMessages its ON, show toast message.
                    if (showMessages) {
                        Toast.makeText(this, getString(R.string.question4) + radionButton_text
                                + getString(R.string.right)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
                    strAnswer4 = radionButton_text;
                   // radioGroupAnswer4.setEnabled(false);
                }
                break;
            // Question 4 - b incorrect - disable.
            case R.id.id_radioButton_answer4a:
            case R.id.id_radioButton_answer4c:
                if (radionButton_clicked) {
                    radioButtonAnswer4a.setEnabled(false);
                    radioButtonAnswer4b.setEnabled(false);
                    radioButtonAnswer4c.setEnabled(false);
                    // If showMessages its ON, show toast message.
                    if (showMessages) {
                        Toast.makeText(this, getString(R.string.question4) + radionButton_text
                                + getString(R.string.wrong)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
                    strAnswer4 = radionButton_text;
                  //  radioGroupAnswer4.setEnabled(false);
                }
                break;
            // Question 5
            // Question 5 - b correct - disable.
            case R.id.id_radioButton_answer5a:
                if (radionButton_clicked) {
                    scoreTotal = scoreTotal + 1;
                    radioButtonAnswer5a.setEnabled(false);
                    radioButtonAnswer5b.setEnabled(false);
                    radioButtonAnswer5c.setEnabled(false);
                    // If showMessages its ON, show toast message.
                    if (showMessages) {
                        Toast.makeText(this, getString(R.string.question5) + radionButton_text
                                + getString(R.string.right)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
                    strAnswer5 = radionButton_text;
                    //disableRadioGroup(radioGroupAnswer5);
                }
                break;
            // QUESTION 5 - A and C - incorrect - disable
            case R.id.id_radioButton_answer5b:
            case R.id.id_radioButton_answer5c:
                if (radionButton_clicked) {
                    radioButtonAnswer5a.setEnabled(false);
                    radioButtonAnswer5b.setEnabled(false);
                    radioButtonAnswer5c.setEnabled(false);
                    // If showMessages its ON, show toast message.
                    if (showMessages) {
                        Toast.makeText(this, getString(R.string.question5) + radionButton_text
                                + getString(R.string.wrong) + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
                    strAnswer5 = radionButton_text;
                    //disableRadioGroup(radioGroupAnswer5);
                }
                break;
            // QUESTION 7 - A correct - disable
            case R.id.id_radioButton_answer7a:
                if (radionButton_clicked) {
                    scoreTotal = scoreTotal + 1;
                    radioButtonAnswer7a.setEnabled(false);
                    radioButtonAnswer7b.setEnabled(false);
                    radioButtonAnswer7c.setEnabled(false);
                    // If showMessages its ON, show toast message.
                    if (showMessages) {
                        Toast.makeText(this, getString(R.string.question7) + radionButton_text
                                + getString(R.string.right)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
                    strAnswer7 = radionButton_text;
                    //disableRadioGroup(radioGroupAnswer7);

                }
                break;
            // QUESTION 7 - b and C - incorrect - disable
            case R.id.id_radioButton_answer7b:
            case R.id.id_radioButton_answer7c:
                if (radionButton_clicked) {
                    radioButtonAnswer7a.setEnabled(false);
                    radioButtonAnswer7b.setEnabled(false);
                    radioButtonAnswer7c.setEnabled(false);
                    // If showMessages its ON, show toast message.
                    if (showMessages) {
                        Toast.makeText(this, getString(R.string.question7) + radionButton_text
                                + getString(R.string.wrong)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
                    strAnswer7 = radionButton_text;
                  //  disableRadioGroup(radioGroupAnswer7);
                }
                break;
            // QUESTION 9 - C - correct - disable
            case R.id.id_radioButton_answer9c:
                if (radionButton_clicked) {
                    scoreTotal = scoreTotal + 1;
                    radioButtonAnswer9a.setEnabled(false);
                    radioButtonAnswer9b.setEnabled(false);
                    radioButtonAnswer9c.setEnabled(false);
                    // If showMessages its ON, show toast message.
                    if (showMessages) {
                        Toast.makeText(this, getString(R.string.question9) + radionButton_text
                                + getString(R.string.right)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
                    strAnswer9 = radionButton_text;
                  //  disableRadioGroup(radioGroupAnswer9);

                }
                break;
            //  a - b -
            // QUESTION 9 - A and B - incorrect - disable
            case R.id.id_radioButton_answer9a:
            case R.id.id_radioButton_answer9b:
                if (radionButton_clicked) {
                    radioButtonAnswer9a.setEnabled(false);
                    radioButtonAnswer9b.setEnabled(false);
                    radioButtonAnswer9c.setEnabled(false);
                    // If showMessages its ON, show toast message.
                    if (showMessages) {
                        Toast.makeText(this, getString(R.string.question9) + radionButton_text
                                + getString(R.string.wrong)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
                    strAnswer9 = radionButton_text;
                   // disableRadioGroup(radioGroupAnswer9);

                }
                break;
            // QUESTION 10 - C - correct - disable
            case R.id.id_radioButton_answer10c:
                if (radionButton_clicked) {
                    scoreTotal = scoreTotal + 1;
                    radioButtonAnswer10a.setEnabled(false);
                    radioButtonAnswer10b.setEnabled(false);
                    radioButtonAnswer10c.setEnabled(false);
                    // If showMessages its ON, show toast message.
					if (showMessages) {
                        Toast.makeText(this, getString(R.string.question10) + radionButton_text
                                + getString(R.string.right)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
                    strAnswer10 = radionButton_text;
                   // disableRadioGroup(radioGroupAnswer10);
                }
                break;
            // QUESTION 10 - A and B - incorrect - disable
            case R.id.id_radioButton_answer10a:
            case R.id.id_radioButton_answer10b:
                if (radionButton_clicked) {
                    radioButtonAnswer10a.setEnabled(false);
                    radioButtonAnswer10b.setEnabled(false);
                    radioButtonAnswer10c.setEnabled(false);
                    // If showMessages its ON, show toast message.
                    if (showMessages){
                        Toast.makeText(this, getString(R.string.question10) + radionButton_text
                                + getString(R.string.wrong)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
						}
                    strAnswer10 = radionButton_text;
                    //disableRadioGroup(radioGroupAnswer10);
                }
                break;
            default:
                break;
        }
        // Add 1 in numSelectedRadionButton to control
        // to number of answered radio button questions
        numSelectedRadionButton++;
    }
    /**
     * Method that checks correct Checkbox Answers.
     **/
    public void onCheckBoxClick(View view) {
        Boolean checkBoxAnswer8a_checked = CheckBox8a.isChecked();
        Boolean checkBoxAnswer8b_checked = CheckBox8b.isChecked();
        Boolean checkBoxAnswer8c_checked = CheckBox8c.isChecked();

    int sizeAnswer8a,sizeAnswer8b,sizeAnswer8c;
    // TODO Dá problemas de contagens quando escolho a e b, por exemplo. DEGUB STEP BY STEP.

        if (checkBoxAnswer8a_checked) {
            Answer8a = (String) CheckBox8a.getText();
            CheckBox8a.setEnabled(false);
        }

        if (checkBoxAnswer8b_checked) {
            Answer8b = (String) CheckBox8b.getText();
            CheckBox8b.setEnabled(false);
        }

        if (checkBoxAnswer8c_checked) {
            Answer8c = (String) CheckBox8c.getText();
                CheckBox8c.setEnabled(false);
        }

        // If A OR B OR C its checked,
        if ((checkBoxAnswer8a_checked) || (checkBoxAnswer8b_checked) || (checkBoxAnswer8c_checked)) {
            numCheckedCheckBox=1;
            strAnswer8 = Answer8a + " " + Answer8b + " " + Answer8c;
        }

        // If a its not checked but b and c are checked, add scoreTotal;
        if ((!checkBoxAnswer8a_checked) && (checkBoxAnswer8b_checked) && (checkBoxAnswer8c_checked)) {
            scoreTotal++;
            if (showMessages)
                Toast.makeText(this, getString(R.string.question8) + strAnswer8 + getString(R.string.right) + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * Method to check Question2 .
     **/
    private void checkQuestion2TextField() {
        //Checks answer for Question Nr.2
        String answeredQ2 = answer2_editText.getText().toString();

        if (!answeredQ2.isEmpty()) {
            //STRING its NOT empty !!!
            numFieldTextFields++; //add 1 to numFieldTextFields counter
            strAnswer2 = answeredQ2; //store the value
            // Compare value with correctAnswer. If its correct add scoreTotal.
            if (answeredQ2.toLowerCase().equalsIgnoreCase(correctAnswer2)) {
                scoreTotal = scoreTotal + 1;
                // If showMessages its ON, show toast message.
                if (showMessages) {
                    Toast.makeText(this, getString(R.string.question2) + answeredQ2
                            + getString(R.string.right)
                            + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
            }
        }
    }

    /**
     * Method to check Question2 .
     **/
    public void checkQuestion6TextField() {
        //Checks answer for Question Nr.6
        String answeredQ6 = answer6_editText.getText().toString();
        //Check if string its NOT empty !!!
        if (!answeredQ6.isEmpty()) {
            numFieldTextFields++; //Add numFieldTextFields
            strAnswer6 = answeredQ6;
            if (answeredQ6.toLowerCase().equalsIgnoreCase(correctAnswer6)) {
                scoreTotal = scoreTotal + 1;
					if (showMessages) {
                        Toast.makeText(this, getString(R.string.question6) + answeredQ6
                                + getString(R.string.right)
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_SHORT).show();
					}
            }
        }

    }

    /**
     * Method to see results after clicking the "SEND" Button
     */
    public void sendResults(View view) {
        userName = insertNameEditText.getText().toString();

        totalQueryAnsweredQuestions = 0;
        totalQueryNotAnsweredQuestions = 0;

        if (userName.isEmpty()) {
            Toast.makeText(this, getString(R.string.enter_your_name), Toast.LENGTH_SHORT).show();
            insertNameEditText.requestFocus();

        } else {
            checkQuestion2TextField();
            checkQuestion6TextField();

            totalQueryAnsweredQuestions = (numSelectedRadionButton) + (numCheckedCheckBox) + (numFieldTextFields);

            totalQueryNotAnsweredQuestions = totalQuestions - totalQueryAnsweredQuestions;

            }
            // Check if All questions are Answered
            // IF all answers are Answered (= totalquestions)...
            if (totalQueryAnsweredQuestions == totalQuestions) {
                // If YES, message with result...
                viewCounters("SEND RESULTS","score");

                Toast.makeText(this, userName + getString(R.string.send_answers_by_mail), Toast.LENGTH_LONG).show();

                //Send mail with answers.
                sendEmail();
                // Reset all Quiz
                resetQuiz(MainActivity.this.resetButton); // TODO Opção de RESET ?
                } else //If NO, missing some anwsers...
                {
                    //If some questions to answer (including user name) send toast message ...
                    if ((totalQueryAnsweredQuestions < totalQuestions) && (!userName.isEmpty())) {
                        Toast.makeText(this, userName + ", " + totalQueryNotAnsweredQuestions +
                                " of " + totalQuestions + " missing ! \n Please answer ALL questions !", Toast.LENGTH_LONG).show();
                    }
                }
    }

    /*
    * Method to send mail with answers to the teacher mail.
     */
    private void sendEmail(){
        composeAnswersString(); // Get Answers composed string

        getString(R.string.messsageYouAnswered);
        
        
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + teacherMail));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "City and Country answers - from " + userName);
        emailIntent.putExtra(Intent.EXTRA_TEXT, answersString);
        try {
            startActivity(Intent.createChooser(emailIntent, "Send email using..."));
            } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "No email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }
    /**
     * Reset When Reset button is clicked
     */
    // Start new quiz
    private void resetQuiz(View view)
    {
//        viewCounters("AO ENTRAR NO RESET","all");
        scoreTotal = 0;
        totalQueryAnsweredQuestions=0;
        totalQueryNotAnsweredQuestions=0;
        numSelectedRadionButton = 0; // Number of selected RadionButton
        numCheckedCheckBox = 0; // initialize the number of selected check boxes in quiz.
        numFieldTextFields = 0; //initialize the number of filled text fields in quiz.
        userName = "";
		answersString = userName + getString(R.string.messsageYouAnswered);
		strAnswer1 = "";
		strAnswer2 = "";
		strAnswer3 = "";
		strAnswer4 = "";
		strAnswer5 = "";
		strAnswer6 = "";
		strAnswer7 = "";
		strAnswer8 = "";
		strAnswer9 = "";
		strAnswer10 = "";
//        viewCounters("AO SAIR DO RESET","all");
        finish();
        startActivity(getIntent());
    }

    /*
    * Method to get a toast message
    * @param aditional to set an aditional string in message
    * @param counters to choose
    *
    *
     */
    public void viewCounters(String aditional, String counters) {
        switch (counters) {
            case "all": { //TODO AD ALL COUNTERS
                Toast toast1 = Toast.makeText(this, aditional + userName + "\n " +getString(R.string.counters)+
                        "\n " + "ScoreTotal: " + scoreTotal +
                        "\n " + "TotalQuestions: " + totalQuestions +
                        "\n " + "SelectedRadionButton: " + numSelectedRadionButton +
                        "\n " + "minSelectedCheckBox: " + numCheckedCheckBox +
                        "\n " + "numFieldTextFields" + numFieldTextFields+
                        "\n " + "totalQueryAnsweredQuestions :"+ totalQueryAnsweredQuestions+
                        "\n " + "totalQueryNotAnsweredQuestions: "+"\n " + totalQueryNotAnsweredQuestions+
                        "\n " + "--------------------", Toast.LENGTH_LONG);
                toast1.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                toast1.show();
                answersString = userName + " " + getString(R.string.messsageYouAnswered);
                answersString = answersString + "\n"
                        + getString(R.string.question1) + strAnswer1 + "\n"
                        + getString(R.string.question2) + strAnswer2 + "\n"
                        + getString(R.string.question3) + strAnswer3 + "\n"
                        + getString(R.string.question4) + strAnswer4 + "\n"
                        + getString(R.string.question5) + strAnswer5 + "\n"
                        + getString(R.string.question6) + strAnswer6 + "\n"
                        + getString(R.string.question7) + strAnswer7 + "\n"
                        + getString(R.string.question8) + strAnswer8 + "\n"
                        + getString(R.string.question9) + strAnswer9 + "\n"
                        + getString(R.string.question10) + strAnswer10 + "\n"
                        + getString(R.string.total_score_statment) + scoreTotal + getString(R.string.slash)+ totalQuestions;
                Toast toast2 = Toast.makeText(this, userName + "\n" + answersString + getString(R.string.score_is) + scoreTotal, Toast.LENGTH_LONG);
                toast2.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                toast2.show();
            }

            break;
            case "score": { //Show Only the score
                Toast toast2 = Toast.makeText(this, userName + getString(R.string.score_is) + scoreTotal + " of " + totalQuestions, Toast.LENGTH_LONG);
                toast2.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                toast2.show();
            }
            break;
        }
    }
    
    private void composeAnswersString() {
        answersString = "Hi teacher, i scored " + scoreTotal + " of " + totalQuestions + "."+
                "\n MY ANSWERS: \n" + "----------------------------- \n"
                + getString(R.string.question1) + strAnswer1 + "\n"
                + getString(R.string.question2) + strAnswer2 + "\n"
                + getString(R.string.question3) + strAnswer3 + "\n"
                + getString(R.string.question4) + strAnswer4 + "\n"
                + getString(R.string.question5) + strAnswer5 + "\n"
                + getString(R.string.question6) + strAnswer6 + "\n"
                + getString(R.string.question7) + strAnswer7 + "\n"
                + getString(R.string.question8) + strAnswer8 + "\n"
                + getString(R.string.question9) + strAnswer9 + "\n"
                + getString(R.string.question10) + strAnswer10 + "\n"
                + getString(R.string.total_score_statment) + scoreTotal + getString(R.string.slash) + totalQuestions;
    }
} //MAIN


// TODO Next improvements:
