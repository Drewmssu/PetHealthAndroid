package pe.edu.upc.pethealth.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.activities.MyPetDescriptionActivity;
import pe.edu.upc.pethealth.models.MyPet;

/**
 * Created by genob on 18/09/2017.
 */

public class MyPetAdapters extends RecyclerView.Adapter<MyPetAdapters.ViewHolder>{

    private List<MyPet> myPets;

    public MyPetAdapters(List<MyPet> myPets) {
        this.myPets = myPets;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pets,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyPet myPet = myPets.get(position);
        holder.petNameTextView.setText(myPets.get(position).getName());
        holder.petDescriptionTextView.setText(myPets.get(position).getDescription());
        holder.petImageView.setImageResource(myPets.get(position).getImage());
        holder.moreTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, MyPetDescriptionActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myPets.size();
    }

    public List<MyPet> getMyPets() {
        return myPets;
    }

    public MyPetAdapters setMyPets(List<MyPet> myPets) {
        this.myPets = myPets;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView petNameTextView;
        ImageView petImageView;
        TextView petDescriptionTextView;
        TextView moreTextView;
        ImageButton clinicHystoryImageButton;

        public ViewHolder(View itemView) {
            super(itemView);
            petNameTextView = (TextView) itemView.findViewById(R.id.petNameTextView);
            petImageView = (ImageView) itemView.findViewById(R.id.myPetImageView);
            petDescriptionTextView = (TextView) itemView.findViewById(R.id.myPetDescriptionTextView);
            moreTextView = (TextView) itemView.findViewById(R.id.moreTextView);
            clinicHystoryImageButton = (ImageButton) itemView.findViewById(R.id.historyClinicImageButton);
        }
    }
}
