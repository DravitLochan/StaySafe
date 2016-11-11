package nd.com.staysafe;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;



public class Panic extends Fragment {
    Button panic;
    String message="I am in danger. I need help!";
    String phoneNo="9910290567";
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    public Panic() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_panic, container, false);
        UI(v);
        return v;
    }

    private void UI(View v) {
        panic = (Button) v.findViewById(R.id.panic);
        panic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"PANIC button pressed",Toast.LENGTH_SHORT).show();
                sendSMSMessage();
            }
        });

    }

    protected void sendSMSMessage() {
        //phoneNo = txtphoneNo.getText().toString();  /* get the contact numbers from shared pref */
        

        if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.SEND_SMS)) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) getApplicationContext(),
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions((Activity) getApplicationContext(),
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }

    public Context getApplicationContext() {
        //return applicationContext;
        return getActivity();
    }
}
