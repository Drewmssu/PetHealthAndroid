package pe.edu.upc.pethealth.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import java.util.List;

import pe.edu.upc.pethealth.R;
import pe.edu.upc.pethealth.fragments.AboutVeterinaryFragment;
import pe.edu.upc.pethealth.activities.MainActivity;
import pe.edu.upc.pethealth.models.Veterinary;

/**
 * Created by genob on 26/10/2017.
 */

public class SearchAdapters extends RecyclerView.Adapter<SearchAdapters.ViewHolder> {

    private List<Veterinary> veterinaries;

    public SearchAdapters() {
    }

    public SearchAdapters(List<Veterinary> veterinaries) {
        this.veterinaries = veterinaries;
    }

    public List<Veterinary> getVeterinaries() {
        return veterinaries;
    }

    public SearchAdapters setVeterinaries(List<Veterinary> veterinaries) {
        this.veterinaries = veterinaries;
        return this;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_search,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Veterinary veterinary = veterinaries.get(position);
        holder.vetANImageView.setDefaultImageResId(R.mipmap.ic_launcher_round);
        holder.vetANImageView.setErrorImageResId(R.mipmap.ic_launcher);
        holder.vetANImageView.setImageUrl(veterinary.getPreVideo());
        holder.nameTextView.setText(veterinary.getName());
        holder.startsRatingBar.setRating(3);
        holder.locationTextView.setText("Jesus Maria");
        holder.forwardImageutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity context = (MainActivity) view.getContext();
                AboutVeterinaryFragment newFragment = new AboutVeterinaryFragment();
                newFragment.setArguments(veterinary.toBundle());
                context.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content, newFragment)
                        .addToBackStack(null)
                        .commit();
                /*Intent intent = new Intent(context, AboutVeterinaryFragment.class);
                context.startActivity(intent);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return veterinaries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ANImageView vetANImageView;
        TextView nameTextView;
        RatingBar startsRatingBar;
        TextView locationTextView;
        ImageButton forwardImageutton;
        public ViewHolder(View itemView) {
            super(itemView);
            vetANImageView = (ANImageView) itemView.findViewById(R.id.vetANImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            startsRatingBar = (RatingBar) itemView.findViewById(R.id.rateRatingBar);
            locationTextView = (TextView) itemView.findViewById(R.id.locationTextView);
            forwardImageutton = (ImageButton) itemView.findViewById(R.id.fordwardImageButton);
        }
    }
}
