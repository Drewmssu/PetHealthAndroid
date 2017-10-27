package pe.edu.upc.pethealth.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import java.util.List;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.activities.MyTipDetailActivity;
import pe.edu.upc.pethealth.models.MyTip;

/**
 * Created by genob on 28/09/2017.
 */

public class MyTipAdapters extends RecyclerView.Adapter<MyTipAdapters.ViewHolder> {

    private List<MyTip> myTips;

    public MyTipAdapters() {
    }

    public MyTipAdapters(List<MyTip> myTips) {
        this.myTips = myTips;
    }

    public List<MyTip> getMyTips() {
        return myTips;
    }

    public MyTipAdapters setMyTips(List<MyTip> myTips) {
        this.myTips = myTips;
        return this;
    }

    @Override
    public MyTipAdapters.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tips,parent,false));
    }

    @Override
    public void onBindViewHolder(MyTipAdapters.ViewHolder holder, int position) {

        final MyTip myTip = myTips.get(position);
        holder.tittleTextView.setText(myTip.getTittle());
        holder.descriptionTextView.setText(myTip.getDescription());
        holder.tipANImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        holder.tipANImageView.setErrorImageResId(R.mipmap.ic_launcher);
        holder.tipANImageView.setImageUrl(myTip.getImage().toString());
        holder.tipANImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, MyTipDetailActivity.class);
                intent.putExtras(myTip.toBundle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myTips.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ANImageView tipANImageView;
        TextView tittleTextView;
        TextView descriptionTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            tipANImageView = (ANImageView) itemView.findViewById(R.id.tipImageView);
            tittleTextView = (TextView) itemView.findViewById(R.id.tipTittleTextView);
            descriptionTextView = (TextView) itemView.findViewById(R.id.tipDescriptionTextView);
        }
    }
}
