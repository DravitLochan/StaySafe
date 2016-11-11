package nd.com.staysafe;

import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class TrustedContacts extends DialogFragment  {

    private RecyclerView mRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    static List<Detail> dataset;
    FloatingActionButton fab;
    SharedPreferences mPrefs;
    static SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=  inflater.inflate(R.layout.fragment_trusted_contacts, container, false);

        fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogBox db= new DialogBox();
                db.show(getFragmentManager(),"fragment1");
            }
        });
        mPrefs = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        dataset = new ArrayList<Detail>(10);


        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(v.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(dataset);
        mRecyclerView.setAdapter(mAdapter);
        loadpreviousdata();
        return v;
    }

    private void loadpreviousdata() {
        boolean changed=false;
        int size = mPrefs.getInt("size",0);
        Log.d("safety", "Received size= " + size + " ");
        for(int i=0; i<size; i++) {
            changed=true;
            String phone = mPrefs.getString(Integer.toString(i), null);
            dataset.add(new Detail(phone));
        }
        if(changed)
            mAdapter.notifyDataSetChanged();
        editor = mPrefs.edit();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(editor!=null) {
            Log.d("safety", "Stored size= " + dataset.size() + " ");
            editor.putInt("size", dataset.size()).apply();
        }
    }

    public static void  adder(String phone)
    {

        dataset.add(new Detail(phone));
        editor.putString(Integer.toString(dataset.size()-1), phone).apply();
        mAdapter.notifyDataSetChanged();
    }
}
