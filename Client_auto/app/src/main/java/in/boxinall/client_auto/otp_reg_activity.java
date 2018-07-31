package in.boxinall.client_auto;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;

import java.util.Random;


public class otp_reg_activity extends AppCompatActivity {

    //Context context = getApplicationContext();
    EditText otp_editText;
    TextView countdown_text;
    Button resend_button;
    SwipeButton swipe;
    long time_mili= 600000;
    private CountDownTimer countDownTimer;
    FloatingActionButton otp;
    String text, verification_of_otp;
    Random password = new Random();
    boolean delete = false, timerrunning;
    ProgressBar progress_status;
    int progress = 100;
    //ImageButton one, two, three, four, five, six, seven, eight, nine, zero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_otp_reg_activity);
        otp=(FloatingActionButton)findViewById(R.id.floating_otp);


        //one=(ImageButton)findViewById(R.id.button_1);
        otp_editText = (EditText) findViewById(R.id.editText);
        progress_status = (ProgressBar) findViewById(R.id.progressbar);


        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor( getApplication(),R.color.child_floating));


        /*progressbar.setOnProgressListener(new ProgressBar.OnProgressListener() {
            @Override
            public void progressToComplete() {

                Toast.makeText(getApplicationContext(),"Completed", Toast.LENGTH_SHORT).show();

            }
        });*/

        resend_button = (Button)findViewById(R.id.resend_button);
        countdown_text= (TextView)findViewById(R.id.countdown_text);
        swipe=(SwipeButton)findViewById(R.id.swipe);

        start_timer();
        update_time();

        text = otp_editText.getText().toString();


       otp_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                text = otp_editText.getText().toString();
                if (count > after)
                    delete = true;

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                StringBuilder sb = new StringBuilder(s.toString());
                int replacePosition = otp_editText.getSelectionEnd();

                if (s.length() != 4) {
                    if (!delete) {
                        if (replacePosition < s.length())
                            sb.deleteCharAt(replacePosition);
                    } else {
                        sb.insert(replacePosition, '-');
                    }

                    if (replacePosition < s.length() || delete) {
                        otp_editText.setText(sb.toString());
                        otp_editText.setSelection(replacePosition);
                    } else {
                        otp_editText.setText(text);
                        otp_editText.setSelection(replacePosition - 1);
                    }
                }

                delete = false;

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        swipe.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {

                Intent terms = new Intent (getApplicationContext(), home_activity.class);
                startActivity(terms);

            }
        });

    }

    public void start_timer(){

        countDownTimer = new CountDownTimer(time_mili, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

             time_mili= millisUntilFinished;
                update_time();

            }

            @Override
            public void onFinish() {

            }
        }.start();

    }

    public void update_time(){

        int min= (int) time_mili/ 60000;
        int sec = (int) time_mili % 60000/ 1000;

        String time_left;

        time_left= ""+ min;

        time_left+= ":";
        if(sec<10){

            time_left+= "0";
        }

        time_left+= "" + sec;

        countdown_text.setText(time_left);
        if(progress==0){
            //resend_button.setEnabled(true);
            //resend_button.setTextColor(Color.parseColor("#FFFFFF"));
        }
        progress= progress- 1;
        progress_status.setProgress(progress);

    }


}
