package nd.com.staysafe;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class TrustedContacts extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<Detail> dataset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_trusted_contacts, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(v.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        dataset = new ArrayList<Detail>(10);
        mAdapter = new MyAdapter(dataset);
        mRecyclerView.setAdapter(mAdapter);
        populateData();
        return v;
    }

    private void populateData() {

        dataset.add(new Detail("abcd","efg@fds.com"));
        dataset.add(new Detail("alpha","beta"));
        dataset.add(new Detail("gamma","beta"));
        mAdapter.notifyDataSetChanged();
    }


}
