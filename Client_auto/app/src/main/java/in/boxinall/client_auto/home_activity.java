package in.boxinall.client_auto;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class home_activity extends AppCompatActivity {



    FloatingActionButton main, login, otp, setting_floating;

    TextView otp_text, user_text, setting_text;
    Animation floating_close;
    Animation floating_open;
    Animation floatingrotate_open;
    Animation floatingrotate_close;
    boolean open=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        main=(FloatingActionButton)findViewById(R.id.floating_main);
        login=(FloatingActionButton)findViewById(R.id.floating_login);
        otp=(FloatingActionButton)findViewById(R.id.floating_otp);
        setting_floating=(FloatingActionButton)findViewById(R.id.setting_floating);


        floating_close= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.floatingaction_close);
        floating_open= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.floatingaction_open);
        floatingrotate_close= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.floatingrotate_close);
        floatingrotate_open= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.floatingrotate_open);

        otp_text=(TextView)findViewById(R.id.otp_textview);
        user_text=(TextView)findViewById(R.id.user_textview);
        setting_text=(TextView)findViewById(R.id.setting_textview);



        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(open){

                    login.startAnimation(floating_close);
                    otp.startAnimation(floating_close);
                    setting_floating.startAnimation(floating_close);
                    main.startAnimation(floatingrotate_close);
                    login.setClickable(false);
                    user_text.setVisibility(View.INVISIBLE);
                    otp_text.setVisibility(View.INVISIBLE);
                    setting_text.setVisibility(View.INVISIBLE);
                    otp.setClickable(false);
                    open=false;

                }

                else{

                    login.startAnimation(floating_open);
                    otp.startAnimation(floating_open);
                    setting_floating.startAnimation(floating_open);
                    main.startAnimation(floatingrotate_open);
                    login.setClickable(true);
                    user_text.setVisibility(View.VISIBLE);
                    otp_text.setVisibility(View.VISIBLE);
                    setting_text.setVisibility(View.VISIBLE);
                    otp.setClickable(true);
                    open=true;


                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //showDiag_login();

                Intent login_opening=new Intent(getApplicationContext(),Login_activity.class);
                startActivity(login_opening);


            }
        });

        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent otp_opening=new Intent(getApplicationContext(), otp_reg_activity.class);
                startActivity(otp_opening);
                //showDiag_otp();

                //otp_reg_activity.showDialog_otp();
            }
        });

        setting_floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //showDiag_login();


            }
        });

    }


    private void showDiag_otp() {



        Context otp_context= getApplicationContext();


        final View dialogView_otp = View.inflate(this,R.layout.layout_otp_reg_activity,null);

        final Dialog dialog_otp = new Dialog(this,R.style.MyAlertDialogStyle_user);
        dialog_otp.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_otp.setContentView(dialogView_otp);

        ImageView imageView = (ImageView)dialog_otp.findViewById(R.id.closing_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                revealShow_otp(dialogView_otp, false, dialog_otp);

            }
        });


        dialog_otp.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                //Intent in= new Intent(home_activity.this, otp_reg_activity.class);
                //startActivity(in);
                revealShow_otp(dialogView_otp, true, null);

            }
        });


        dialog_otp.setOnKeyListener(new DialogInterface.OnKeyListener() {


            @Override
            public boolean onKey(DialogInterface dialog, int i, KeyEvent event) {
                if (i == KeyEvent.KEYCODE_BACK){

                    revealShow_otp(dialogView_otp, false, (Dialog) dialog);
                    return true;
                }



                return false;
            }

        });



        dialog_otp.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        dialog_otp.show();
    }




    private void revealShow_otp(View dialogView, boolean b, final Dialog dialog) {

        final View view = dialogView.findViewById(R.id.dialog_otp);


        int width = view.getWidth();
        int height = view.getHeight();

        int endRadius = (int) Math.hypot(width, height);

        int x_axis = (int) (otp.getX() + (otp.getWidth() / 2));
        int y_axis = (int) (otp.getY()) + otp.getHeight() + 1600;


        if (b) {
            Animator revealAnimator = ViewAnimationUtils.createCircularReveal(view, x_axis, y_axis, 0, endRadius);

            view.setVisibility(View.VISIBLE);
            revealAnimator.setDuration(700);
            revealAnimator.start();

        } else {

            Animator anim = ViewAnimationUtils.createCircularReveal(view, x_axis, y_axis, endRadius, 0);

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    dialog.dismiss();
                    view.setVisibility(View.INVISIBLE);

                }
            });
            anim.setDuration(700);
            anim.start();
        }

    }

    private void showDiag_login() {

        final View dialogView_login = View.inflate(this,R.layout.activity_login_layout,null);

        final Dialog dialog_login = new Dialog(this,R.style.MyAlertDialogStyle);
        dialog_login.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_login.setContentView(dialogView_login);

        ImageView imageView = (ImageView)dialog_login.findViewById(R.id.closing_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                revealShow_login(dialogView_login, false, dialog_login);

            }
        });


        dialog_login.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                revealShow_login(dialogView_login, true, null);

            }
        });

        dialog_login.setOnKeyListener(new DialogInterface.OnKeyListener() {


            @Override
            public boolean onKey(DialogInterface dialog, int i, KeyEvent event) {
                if (i == KeyEvent.KEYCODE_BACK){

                    revealShow_login(dialogView_login, false, (Dialog) dialog);
                    return true;
                }



                return false;
            }

        });



        dialog_login.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


        //Intent register= new Intent(Login_activity.this, register_activity.class);

        //startActivity(register);
        dialog_login.show();
    }




    private void revealShow_login(View dialogView, boolean b, final Dialog dialog) {

        final View view = dialogView.findViewById(R.id.dialog_login);

        int width = view.getWidth();
        int height = view.getHeight();

        int endRadius = (int) Math.hypot(width, height);

        int x_axis = (int) (otp.getX() + (otp.getWidth() / 2));
        int y_axis = (int) (otp.getY()) + otp.getHeight() + 1600;


        if (b) {
            Animator revealAnimator = ViewAnimationUtils.createCircularReveal(view, x_axis, y_axis, 0, endRadius);

            view.setVisibility(View.VISIBLE);
            revealAnimator.setDuration(700);
            revealAnimator.start();

        } else {

            Animator anim = ViewAnimationUtils.createCircularReveal(view, x_axis, y_axis, endRadius, 0);

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    dialog.dismiss();
                    view.setVisibility(View.INVISIBLE);

                }
            });
            anim.setDuration(700);
            anim.start();
        }

    }


}
