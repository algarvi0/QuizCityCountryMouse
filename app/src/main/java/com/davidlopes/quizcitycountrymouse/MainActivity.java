package com.davidlopes.quizcitycountrymouse;

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
import android.widget.Toast;

/**
 * IN ENGLISH
 * Country Mouse and City Mouse
  * This application was made for the third project of the Google Developer Challenge Scholarship course: Android Basics
  * Available at https://github.com/algarvi0/QuizCityCountryMouse
  *
  * It was created for my wife (English teacher) to use in class with her students, after reading the story.
  *
  * It's composed by
  * 7 Radio Buttons
  * 2 Text
  * 1 Check Marks
  *
  * When the user enters the application the name is requested.
  * After answering the questions you can submit the answers through the SUBMIT QUIZ button that will evaluate the answers.
  * The APP evaluates the answers and gives the message of how many are correct, out of a total of 10, and suggest that they be sent by mail to the teacher.
  * As you answer the questions, they become deactivated (so you can not change them). If we want we can always do
  * RESET (Clears all given answers and starts APP).
  *
  * If the user runs the screen the APP keeps the answers given.
  *
  * Checks made during APP
  *> When you press the SUBMIT button QUIZ:
  * - Ask if you want to submit the QUIZ.
  * If you press YES
  * Verify that ALL questions are answered, give messages if they are missing, do not submit the QUIZ and let continue to respond
  * If you press NO
  * Cancel and let continue to respond.
  *> Pressing RESET button QUIZ
  * - Ask if you really want to delete ALL the given answers and start new QUIZ.
  *
  * In terms of programming I used all the recommendations of https://review.udacity.com/#!/rubrics/158/view and everything that ap
  * It was quite challenging.
  *
  * I hope you enjoy looking forward to feedback.
  *
  * David Lopes
 * ------------------------------------------------------------------------------------------------------------------------------------------------
 * EM PORTUGUÊS
 * Country Mouse and City Mouse
 * Esta aplicação foi feita para terceiro projecto do curso Google Developer Challenge Scholarship: Android Basics
 * Está disponivel em https://github.com/algarvi0/QuizCityCountryMouse
 *
 * Foi criada para a minha esposa (professora de inglês) usar nas aulas com os seus alunos, depois de lerem a história.
 *
 * É composta por
 * 7 Radio Buttons
 * 2 Text
 * 1 Check Marks
 *
 * Quando o utilizador entra na aplicação é solicitado o nome.
 * Depois de responder Às questões pode submeter as respostas através do botão SUBMIT QUIZ que irá avaliar as respostas.
 * A APP avalia as respostas e dá a mensagem de quantas estão certas, de um total de 10, e sugerir que sejam enviadas por mail para a professora.
 * À medida que se vão respondendo às questões elas vai ficando desativadas (para não se poder alterar). Se quisermos podemos sempre fazer
 * RESET (Limpa todas as respostas dadas e inicia a APP).
 *
 * Se o utilizador roda o ecran a APP mantem as respostas dadas.
 *
 * Verificações feitas ao longo da APP
 * > Ao pressionar o botão SUBMIT QUIZ:
 *  - Questiona se quer mesmo submeter o QUIZ.
 *      Se pressionar SIM
 *          Irá verificar se TODAS as questões estão respondidas, dá mensagem se faltarem algumas,não submete o QUIZ e deixa continuar a responder
 *      Se pressionar NÃO
 *          Cancela e deixa continuar a responder.
 *  > Ao pressionar o botão RESET QUIZ
 *   - Questiona se quer mesmo apagar TODAS as respostas dadas e iniciar novo QUIZ.
 *
 *  Em termos de programação usei todas as recomendações de https://review.udacity.com/#!/rubrics/158/view e tudo o que ap
 *  Foi bastante desafiante.
 *
 *  Espero que gostem aguardo feedback.
 *
 * David Lopes
 *
 */
public class MainActivity extends AppCompatActivity {
    private static final String SCORE_ACT_VALUE = "score";
    private static final String NUMSELECTEDRADIONBUTTON_VALUE = "numSelectedRadionButton";
    private static final String NUMCHECKEDCHECKBOX_VALUE = "numCheckedCheckBox";
    private static final String NUMFIELDTEXTFIELDS_VALUE = "numFieldTextFields";
    private static final String RADIOBUTTONANSWER1AENABLED_VALUE = "radioButtonAnswer1aEnabled";
    private static final String RADIOBUTTONANSWER1BENABLED_VALUE = "radioButtonAnswer1bEnabled";
    private static final String RADIOBUTTONANSWER3AENABLED_VALUE = "radioButtonAnswer3aEnabled";
    private static final String RADIOBUTTONANSWER3BENABLED_VALUE = "radioButtonAnswer3bEnabled";
    private static final String RADIOBUTTONANSWER3CENABLED_VALUE = "radioButtonAnswer3cEnabled";
    private static final String RADIOBUTTONANSWER4AENABLED_VALUE = "radioButtonAnswer4aEnabled";
    private static final String RADIOBUTTONANSWER4BENABLED_VALUE = "radioButtonAnswer4bEnabled";
    private static final String RADIOBUTTONANSWER4CENABLED_VALUE = "radioButtonAnswer4cEnabled";
    private static final String RADIOBUTTONANSWER5AENABLED_VALUE = "radioButtonAnswer5aEnabled";
    private static final String RADIOBUTTONANSWER5BENABLED_VALUE = "radioButtonAnswer5bEnabled";
    private static final String RADIOBUTTONANSWER5CENABLED_VALUE = "radioButtonAnswer5cEnabled";
    private static final String RADIOBUTTONANSWER7AENABLED_VALUE = "radioButtonAnswer7aEnabled";
    private static final String RADIOBUTTONANSWER7BENABLED_VALUE = "radioButtonAnswer7bEnabled";
    private static final String RADIOBUTTONANSWER7CENABLED_VALUE = "radioButtonAnswer7cEnabled";
    private static final String CHECKBUTTONANSWER8AENABLED_VALUE = "checkButtonAnswer8aEnabled";
    private static final String CHECKBUTTONANSWER8BENABLED_VALUE = "checkButtonAnswer8bEnabled";
    private static final String CHECKBUTTONANSWER8CENABLED_VALUE = "checkButtonAnswer8cEnabled";
    private static final String RADIOBUTTONANSWER9AENABLED_VALUE = "radioButtonAnswer9aEnabled";
    private static final String RADIOBUTTONANSWER9BENABLED_VALUE = "radioButtonAnswer9bEnabled";
    private static final String RADIOBUTTONANSWER9CENABLED_VALUE = "radioButtonAnswer9cEnabled";
    private static final String RADIOBUTTONANSWER10AENABLED_VALUE = "radioButtonAnswer10aEnabled";
    private static final String RADIOBUTTONANSWER10BENABLED_VALUE = "radioButtonAnswer10bEnabled";
    private static final String RADIOBUTTONANSWER10CENABLED_VALUE = "radioButtonAnswer10cEnabled";
    private static final String STRANSWERQ1_VALUE = "strAnswerQ1";
    private static final String STRANSWERQ2_VALUE = "strAnswerQ2";
    private static final String STRANSWERQ3_VALUE = "strAnswerQ3";
    private static final String STRANSWERQ4_VALUE = "strAnswerQ4";
    private static final String STRANSWERQ5_VALUE = "strAnswerQ5";
    private static final String STRANSWERQ6_VALUE = "strAnswerQ6";
    private static final String STRANSWERQ7_VALUE = "strAnswerQ7";
    private static final String STRANSWERQ8_VALUE = "strAnswerQ8";
    private static final String STRANSWERQ9_VALUE = "strAnswerQ9";
    private static final String STRANSWERQ10_VALUE = "strAnswerQ10";
    private final static int totalQuestions = 10;
    private final static String correctAnswer2 = "cousin";
    private final static String correctAnswer6 = "people";
    private final static String teacherMail = "algarvi0@gmail.com";
    private final Context context = this;
    // Buttons
    private Button submitButton;
    private Button resetButton;
    private String strAnswer1;
    private String strAnswer2;
    private String strAnswer3;
    private String strAnswer4;
    private String strAnswer5;
    private String strAnswer6;
    private String strAnswer7;
    private String strAnswer8;
    private String strAnswer9;
    private String strAnswer10;
    private String Answer8a = "";
    private String Answer8b = "";
    private String Answer8c = "";
    //Booleans
    private boolean showMessages; // To use to see control messages.
    private int scoreTotal = 0;
    private int totalQueryAnsweredQuestions = 0;
    private int totalQueryNotAnsweredQuestions = 0;
    private int numSelectedRadionButton = 0; // Number of selected RadionButton
    private int numCheckedCheckBox = 0; // initialize the number of selected check boxes in quiz.
    private int numFieldTextFields = 0; //initialize the number of filled text fields in quiz.
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
        resetButton = findViewById(R.id.button_reset);
        //SUBMIT Button
        submitButton = findViewById(R.id.id_button_score);
        showMessages = false; //Set to False don't see messages. True see control messages
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
        //  add submit button listener
        submitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                // set title
                alertDialogBuilder.setTitle(getString(R.string.submit_dialog_title));
                // set dialog message
                alertDialogBuilder
                        .setMessage(getString(R.string.submit_dialog_question))
                        .setCancelable(false)
                        .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked use sendResults method
                                sendResults(MainActivity.this.submitButton);
                            }
                        })
                        .setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
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
                alertDialogBuilder.setTitle(getString(R.string.reset_dialog_title));
                // set dialog message
                alertDialogBuilder.setMessage(getString(R.string.reset_dialog_question));
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked call reset quiz to start over
                        resetQuiz(MainActivity.this.resetButton);
                    }
                });
                alertDialogBuilder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
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
        // store all necessary in bundle
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
                               + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
                    }
                    strAnswer1 = radionButton_text;
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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
                    }
                    strAnswer1 = radionButton_text;
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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
					}
                    strAnswer3 = radionButton_text;
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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
					}
                    strAnswer3 = radionButton_text;
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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
					}
                    strAnswer4 = radionButton_text;
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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
					}
                    strAnswer4 = radionButton_text;
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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
					}
                    strAnswer5 = radionButton_text;
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
                                + getString(R.string.wrong) + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
					}
                    strAnswer5 = radionButton_text;
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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
					}
                    strAnswer7 = radionButton_text;
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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
					}
                    strAnswer7 = radionButton_text;
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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
					}
                    strAnswer9 = radionButton_text;
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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
					}
                    strAnswer9 = radionButton_text;
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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
					}
                    strAnswer10 = radionButton_text;

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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
						}
                    strAnswer10 = radionButton_text;
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
        // TODO Dá problemas de contagens quando escolho a e b, por exemplo. DEGUB STEP BY STEP.
        //If Answer8a its checked then save text to use in string and disable the option
        if (checkBoxAnswer8a_checked) {
            Answer8a = (String) CheckBox8a.getText();
            CheckBox8a.setEnabled(false);
        }
        //If Answer8b its checked then save text to use in string and disable the option
        if (checkBoxAnswer8b_checked) {
            Answer8b = (String) CheckBox8b.getText();
            CheckBox8b.setEnabled(false);
        }
        //If Answer8c its checked then save text to use in string and disable the option
        if (checkBoxAnswer8c_checked) {
            Answer8c = (String) CheckBox8c.getText();
                CheckBox8c.setEnabled(false);
        }
        // If A or B or C its checked,
        if ((checkBoxAnswer8a_checked) || (checkBoxAnswer8b_checked) || (checkBoxAnswer8c_checked)) {
            numCheckedCheckBox=1;
            strAnswer8 = Answer8a + " " + Answer8b + " " + Answer8c;
        }
        // If a its not checked but b and c are checked add scoreTotal;
        if ((!checkBoxAnswer8a_checked) && (checkBoxAnswer8b_checked) && (checkBoxAnswer8c_checked)) {
            scoreTotal++;
            if (showMessages)
                Toast.makeText(this, getString(R.string.question8) + strAnswer8 + getString(R.string.right) + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
        }
    }
    /**
     * Method to check Question2 .
     **/
    private void checkQuestion2TextField() {
        //Checks answer for Question Nr.2
        String answeredQ2 = answer2_editText.getText().toString();
        //If its NOT empty
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
                            + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
					}
            }
        }
    }
    /**
     * Method to check Question2 .
     **/
    private void checkQuestion6TextField() {
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
                                + getString(R.string.actual_score) + scoreTotal, Toast.LENGTH_LONG).show();
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
            Toast.makeText(this, getString(R.string.enter_your_name), Toast.LENGTH_LONG).show();
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
                viewCounters("SEND RESULTS", "score");
                //Send mail with answers.
                sendEmail();
                // Reset all Quiz
                resetQuiz(MainActivity.this.resetButton);
            } else //If NO, missing some anwsers...
                {
                    //If some questions to answer (including user name) send toast message ...
                    if ((totalQueryAnsweredQuestions < totalQuestions) && (!userName.isEmpty())) {
                        Toast.makeText(this, userName
                                        + ", "
                                        + totalQueryNotAnsweredQuestions
                                        + " of " + totalQuestions
                                        + " missing ! \n Please answer ALL questions !",
                                Toast.LENGTH_LONG).show();
                    }
                }
    }

    /*
    * Method to send mail with answers to the teacher mail.
     */
    private void sendEmail(){
        composeAnswersMessage(); // Get Answers composed string
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + teacherMail));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail_subject) + userName);
        emailIntent.putExtra(Intent.EXTRA_TEXT, answersString);
        try {
            startActivity(Intent.createChooser(emailIntent, getString(R.string.send_mail_using)));
            } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, getString(R.string.no_mail_clients), Toast.LENGTH_LONG).show();
            }
        }
    /**
     * Reset When Reset button is clicked
     */
    private void resetQuiz(View view)
    {
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
        finish();
        startActivity(getIntent());
    }
    /*
    * Method to get a toast message
    * @param aditional to set an aditional string in message
     * @param counters to choose what to see
     */
    private void viewCounters(String aditional, String counters) {
        switch (counters) {
            case "all": {
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
                //if scoreTotal = 10 then
                String message = ScoreMessage();
                Toast toast2 = Toast.makeText(this, message, Toast.LENGTH_LONG);
                toast2.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                toast2.show();
            }
            break;
        }
    }

    /**
     * creates score  message.
     *
     * @return Score Message
     */
    private String ScoreMessage() {
        String strScoreMessage = userName + getString(R.string.score_is) + scoreTotal + " of " + totalQuestions + "\n";
        if (scoreTotal <= 5) {
            strScoreMessage += getString(R.string.score_msg_less_5);
        } else if (scoreTotal <= 9) {
            strScoreMessage += getString(R.string.score_msg_less_9);
        } else {
            strScoreMessage += getString(R.string.score_msg_full_score) + "\n";
        }
        strScoreMessage += getString(R.string.send_answers_by_mail);
        return strScoreMessage;
    }

    /**
     * Composes the Answers Message to use in Toast or Mail message.
     */
    private void composeAnswersMessage() {
        answersString = getString(R.string.i_scored) + scoreTotal + " of " + totalQuestions + "."
                + getString(R.string.my_answers) + strAnswer1 + "\n"
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

    /**
     * disables a button, if necessary.
     */
    private void disableButton(int buttonID) {
        Button button = findViewById(buttonID);
        button.setEnabled(false);
    }

} //MAIN
// TODO Next improvements:
