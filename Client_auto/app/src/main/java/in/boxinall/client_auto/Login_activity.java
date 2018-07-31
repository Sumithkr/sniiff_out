package in.boxinall.client_auto;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.internal.s;


public class Login_activity extends AppCompatActivity {

    FloatingActionButton register;
    TextView user_login, term_condition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        final register_activity register_class= new register_activity();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor( getApplication(),R.color.child_floating));

        user_login= (TextView) findViewById(R.id.view2);
        term_condition=(TextView)findViewById(R.id.textView_terms);

        register = (FloatingActionButton) findViewById(R.id.floating_register);
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //showDiag();

                Intent register= new Intent(Login_activity.this, register_activity.class);
                startActivity(register);

            }
        });

        term_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //showDiag();
                Intent terms = new Intent (getApplicationContext(), terms_conditon.class);
                startActivity(terms);

            }
        });


        user_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Write the code for login.

            }
        });



    }


    /*private void showDiag() {

        final View dialogView = View.inflate(this,R.layout.activity_terms_conditon,null);

        final Dialog dialog = new Dialog(this,R.style.MyAlertDialogStyle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(dialogView);

        ImageView imageView = (ImageView)dialog.findViewById(R.id.closing_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                revealShow(dialogView, false, dialog);

            }
        });


        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                revealShow(dialogView, true, null);

            }
        });

        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {


            @Override
            public boolean onKey(DialogInterface dialog, int i, KeyEvent event) {
                if (i == KeyEvent.KEYCODE_BACK){

                    revealShow(dialogView, false, (Dialog) dialog);
                    return true;
                }

                return false;
            }

        });



        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));



        //dialog.show();
    }




    private void revealShow(View dialogView, boolean b, final Dialog dialog) {

        final View view = dialogView.findViewById(R.id.dialog);

        int width = view.getWidth();
        int height = view.getHeight();

        int endRadius = (int) Math.hypot(width, height);

        int x_axis = (int) (term.getX() + (terms_condition.getWidth() / 2));
        int y_axis = (int) (terms_condition.getY()) + terms_condition.getHeight() + 56;


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

    public void toast(){

        Toast.makeText(getApplicationContext(),"Completed", Toast.LENGTH_SHORT).show();
    }*/

}