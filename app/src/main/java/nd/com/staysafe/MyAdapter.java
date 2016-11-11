package nd.com.staysafe;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Naman on 11-11-2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.sViewHolder> {
    List<Detail> dataset;
    public MyAdapter(List<Detail> dataset) {
        this.dataset=dataset;
    }

    @Override
    public sViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trusted_contacts_row, parent, false);
        sViewHolder vh = new sViewHolder(v);
        return vh;
    }


    public void onBindViewHolder(sViewHolder holder, int position) {
        //Log.d("staysafe", position+" ");
        holder.phonetv.setText(dataset.get(position).phone);
        //holder.email.setText(dataset.get(position).email);
    }

    @Override
    public int getItemCount() {
        //Log.d("staysafe", dataset.size()+" ");
        return dataset.size();
    }

    public static class sViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView phonetv;
        public sViewHolder(View v) {
            super(v);
            phonetv = (TextView)v.findViewById(R.id.phonetv);

        }
    }
}
