package com.example.festejapp345.modelo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.festejapp345.R;

import java.util.ArrayList;

public class SucursalAdapter extends BaseAdapter {

    Context context;
    ArrayList<Sucursal> sucursales;
    LayoutInflater inflater;

    public SucursalAdapter(Context context, ArrayList<Sucursal> sucursales) {
        this.context = context;
        this.sucursales = sucursales;
    }

    @Override
    public int getCount() {
        return sucursales.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null){
         convertView = inflater.inflate(R.layout.sucursal_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView tvId = convertView.findViewById(R.id.tv_id_item);
        TextView tvName = convertView.findViewById(R.id.tv_name_item);
        TextView tvLocalization = convertView.findViewById(R.id.tv_local_item);

        Sucursal sucursal = sucursales.get(position);

        byte[] image = sucursal.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);

        imageView.setImageBitmap(bitmap);
        tvId.setText(sucursal.getId());
        tvName.setText(sucursal.getName());
        tvLocalization.setText(sucursal.getLocalization());



        return convertView;
    }
}
