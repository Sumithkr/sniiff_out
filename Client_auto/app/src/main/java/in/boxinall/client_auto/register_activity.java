package in.boxinall.client_auto;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;

import java.util.Random;

import co.ceryle.segmentedbutton.SegmentedButtonGroup;

public class register_activity extends AppCompatActivity {

    TextView register;
    EditText phone_number;
    String verification_of_otp;
    Random password = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_layout);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor( getApplication(),R.color.colorAccent));


        SegmentedButtonGroup sbg = (SegmentedButtonGroup)findViewById(R.id.select_vehicle_type);

        phone_number = (EditText)findViewById(R.id.phone_editext);

        register= (TextView) findViewById(R.id.register_submit);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*verification_of_otp = String.valueOf(password.nextInt(10000));
                String number = phone_number.getText().toString();
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(number, null, verification_of_otp, null, null);*/


                AlertDialog.Builder alert_builder  = new AlertDialog.Builder(register_activity.this);
                View alert_view = getLayoutInflater().inflate(R.layout.otp_reg_driver, null);
                SwipeButton swipe_driver= (SwipeButton) alert_view.findViewById(R.id.swipe_driver);

                swipe_driver.setOnStateChangeListener(new OnStateChangeListener() {
                    @Override
                    public void onStateChange(boolean active) {

                        Intent terms = new Intent (getApplicationContext(), home_activity.class);
                        startActivity(terms);

                    }
                });

                alert_builder.setView(alert_view);
                AlertDialog dialog= alert_builder.create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });


        sbg.setOnClickedButtonPosition(new SegmentedButtonGroup.OnClickedButtonPosition() {
            @Override
            public void onClickedButtonPosition(int position) {

                if(position==0)
                    Toast.makeText(getApplicationContext(),"Auto", Toast.LENGTH_SHORT).show();

                else if(position==1)
                    Toast.makeText(getApplicationContext(),"E_Rick", Toast.LENGTH_SHORT).show();
                    /*Snackbar.make(getApplicationContext(), "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();*/

                else if(position==2)
                    Toast.makeText(getApplicationContext(),"Cargo", Toast.LENGTH_SHORT).show();


            }
        });

    }

}


