package com.frichti.parisevents.mainscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.frichti.parisevents.R;
import com.frichti.parisevents.entity.Record;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Event List adapter
 *
 * @author Mohamed Essid on 07/02/2017.
 */

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {

    private List<Record> mDataset = new ArrayList<>();
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {
        View container;
        ImageView icon;
        TextView title;
        TextView date;

        public ViewHolder(View v) {
            super(v);
            container = v.findViewById(R.id.event_container);
            icon = (ImageView) v.findViewById(R.id.event_image);
            title = (TextView) v.findViewById(R.id.event_title);
            date = (TextView) v.findViewById(R.id.event_date);
        }
    }

    public void add(int position, Record item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public EventListAdapter(Context context, List<Record> dataSet) {
        mDataset = dataSet;
        this.mContext = context;
    }

    @Override
    public EventListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Record event = mDataset.get(position);

        String imageUrl = event.getFields().getImage();
        if (imageUrl != null) {
            //load event image using picasso
            Picasso.with(mContext)
                    .load(imageUrl).fit().into(holder.icon);
        }

        holder.title.setText(event.getFields().getTitle());
        holder.date.setText(String.format("%s to %s", event.getFields().getDateStart(), event.getFields().getDateEnd()));
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink(mContext, event.getFields().getLink());
            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    /**
     * clears data set
     */
    public void clear() {
        mDataset = new ArrayList<>();
        notifyDataSetChanged();
    }


    /**
     * opens event link in web browser
     *
     * @param context
     * @param link
     */
    private void openLink(final Context context, final String link) {
        if (TextUtils.isEmpty(link)) {
            Toast.makeText(context, context.getString(R.string.no_link), Toast.LENGTH_SHORT).show();
        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage(context.getString(R.string.msg_open_in_browser))
                    .setTitle(R.string.external_link)
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                            context.startActivity(browserIntent);
                        }
                    })
                    .setNegativeButton(android.R.string.cancel, null)
                    .create()
                    .show();
        }
    }

}
