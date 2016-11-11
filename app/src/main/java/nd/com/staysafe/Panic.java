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

public class Panic extends Fragment {
    Button panic;

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
            }
        });

    }

}
