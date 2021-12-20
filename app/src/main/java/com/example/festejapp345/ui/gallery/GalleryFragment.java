package com.example.festejapp345.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.festejapp345.R;
import com.example.festejapp345.databinding.FragmentGalleryBinding;
import com.example.festejapp345.datos.DBHelper;
import com.example.festejapp345.modelo.Sucursal;
import com.example.festejapp345.modelo.SucursalAdapter;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private GridView gridView;
    private DBHelper dbHelper;
    private ArrayList<Sucursal> sucursales = new ArrayList<>();





    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        try{
            gridView = (GridView) root.findViewById(R.id.gridViewSucursales);
            SucursalAdapter sucursalAdapter = new SucursalAdapter(root.getContext(), sucursales);
            gridView.setAdapter(sucursalAdapter);

        }catch (Exception e){
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }






        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}





