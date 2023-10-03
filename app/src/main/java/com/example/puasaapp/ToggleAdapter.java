//package com.example.puasaapp;
//
//import android.view.LayoutInflater;
//import android.view.ViewGroup;
//import android.widget.ToggleButton;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.firebase.database.core.view.View;
//
//import java.util.List;
//
//public class ToggleAdapter extends RecyclerView.Adapter<ToggleAdapter.ToggleViewHolder> {
//
//    private List<Boolean> toggles;
//
//    public ToggleAdapter(List<Boolean> toggles) {
//        this.toggles = toggles;
//    }
//
//
//    @Override
//    public ToggleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        android.view.View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.toggle_button_item, parent, false);
//        return new ToggleViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder( ToggleViewHolder holder, int position) {
//        boolean checked = toggles.get(position);
//        holder.toggleButton.setChecked(checked);
//    }
//
//    @Override
//    public int getItemCount() {
//        return toggles.size();
//    }
//
////    static class ToggleViewHolder extends RecyclerView.ViewHolder {
////
////        ToggleButton toggleButton;
////
////        public ToggleViewHolder( View itemView) {
////            super(itemView);
////            toggleButton = itemView.findViewById(R.id.toggle_button);
////        }
//    }
//}
