package nd.com.staysafe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Naman on 11-11-2016.
 */
public class DialogBox extends DialogFragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.dialogbox, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Create new contact: ");
        builder.setView(dialogView);
        builder.setPositiveButton("Set", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String phone= ((EditText)dialogView.findViewById(R.id.phone)).getText().toString();
                //String email = ((EditText)dialogView.findViewById(R.id.email)).getText().toString();
                TrustedContacts.adder(phone);

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DialogBox.this.getDialog().cancel();
            }
        });
        return builder.create();
    }
}